package com.chunfeng.commonService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//import com.cfrj.sppm.cfesf.dao.impl.NewImageDaoImpl;
//import com.cfrj.sppm.cfesf.dao.impl.OldImageDaoImpl;


@Stateless
@Path("upload")
public class UploadService {

	public static final int NEW_INDEX = 0;
	public static final int OLD_INDEX = 1;
//	private static final OldImageDaoImpl  oldImageDao = new OldImageDaoImpl();
//	private static final NewImageDaoImpl  newImageDao = new NewImageDaoImpl();
	
	/**
	 * 上传新房图片
	 * @param request
	 * @return
	 * @throws IOException
	 */
//	@POST  
//    @Path("uploadNewHouseImage")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Object uploadNewHouseImage(@Context HttpServletRequest request,@Context ServletContext application) throws IOException{
//        return upload(request,application,NEW_INDEX);
//	}
	
	/**
	 * 上传二手房图片
	 * @param request
	 * @return
	 * @throws IOException
	 */
//	@POST  
//	@Path("uploadOldHouseImage")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Object uploadOldHouseImage(@Context HttpServletRequest request,@Context ServletContext application) throws IOException{
//		return upload(request,application,OLD_INDEX);
//	}
	
	/**
	 * 通过REST上传文件
	 * @param request
	 * @return
	 * @throws IOException
	 */
    public Object upload(@Context HttpServletRequest request,@Context ServletContext application,int imgType) throws IOException{
		String fileName = "";
		String folderName = null;
		if(imgType == NEW_INDEX){
			folderName = "/newImgs";
		}else if(imgType == OLD_INDEX){
			folderName = "/oldImgs";
		}
		String realPath = application.getRealPath(folderName);
		List<String> list = new ArrayList<String>();
		request.setCharacterEncoding("utf-8");
        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                if (items != null) {
                    Iterator<FileItem> iter = items.iterator();
                    int index = 0;
                    String houseId = "";
                    String path = null;
                    String fileString = null;
                    while (iter.hasNext()) {
                        FileItem item = iter.next();
//                        ReflectCopy.printObject(item, "item");
                        
                        fileString = item.getFieldName();
                        System.out.println(index + " item.getFieldName() = " + item.getFieldName());
//                        System.out.println("item.getString(\"client\") = " + item.getString("client"));
                        houseId = fileString.substring(fileString.indexOf("=") + 1,fileString.indexOf(",", 0));
                        System.out.println("houseId = " + houseId);
                        if (!item.isFormField() && item.getSize() > 0) {
                            fileName = processFileName(item.getName());
                            try {
                            	System.out.println("realPath = " + realPath);
                            	System.out.println("File.separator = " + File.separator);
                            	path = realPath + File.separator + fileName;
                                item.write(new File(path));
                                list.add(fileName);
                                System.out.println("保存图片 fileName = " + fileName + ",houseId = " + Integer.parseInt(houseId));
                                
//                                if(imgType == NEW_INDEX){
//                                	newImageDao.saveImage(fileName, Integer.parseInt(houseId));
//                                }else if(imgType == OLD_INDEX){
//                                	oldImageDao.saveImage(fileName, Integer.parseInt(houseId));
//                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        index ++;
                    }
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
	}
	
	@SuppressWarnings("unchecked")
	private String toCodeName(){
		String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",  
				  "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
				  "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
				  "W", "X", "Y", "Z","a","b","c","d","e","f","g","h","i","j",
				  "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};  
	     List list = Arrays.asList(beforeShuffle);  
	     Collections.shuffle(list);  
	     StringBuilder sb = new StringBuilder();  
	     for (int i = 0; i < list.size(); i++) {  
	         sb.append(list.get(i));  
	     }  
	     String afterShuffle = sb.toString();  
	     String result = afterShuffle.substring(5, 20);  
	     return result;
	}
	
	private String processFileName(String fileNameInput) {
		System.out.println(fileNameInput);
		String exeName = fileNameInput.substring(fileNameInput.lastIndexOf("."));
		String fileNameOutput = null;
		fileNameOutput = new Date().getTime() + "_" + toCodeName()+exeName;
		return fileNameOutput;
	}
}
