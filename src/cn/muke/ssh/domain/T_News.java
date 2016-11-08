package cn.muke.ssh.domain;

public class T_News {
	
	private Integer id;
	private String pname;
	private Double price;
	
	public T_News(){
		
	}
	
	public T_News(String pname, Double price) {
		super();
		this.pname = pname;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
