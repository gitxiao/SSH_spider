package com.cfrj.sppm.cfesf.utils;



import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;



/*功能：用于json转换日期时，设置自定义的格式�?
 *作�?：宁利广
 * 教训：与其在网上找答案，不如自己解决�?
 */
@Provider
public class CustomDateFormatProvider implements ContextResolver<ObjectMapper> {
	private static final String DF = "yyyy-MM-dd HH:mm:ss";
    final ObjectMapper defaultObjectMapper;


    public CustomDateFormatProvider() {
        defaultObjectMapper = createDefaultMapper();
       
    }

     public ObjectMapper getContext(Class<?> type) {
	   return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
    	SimpleDateFormat sdf = new SimpleDateFormat(DF);		
		ObjectMapper om = new ObjectMapper();	
		om.setDeserializationConfig(om.getDeserializationConfig().withDateFormat(sdf));
		om.setSerializationConfig(om.getSerializationConfig().withDateFormat(sdf));
		return om;
    }
}
