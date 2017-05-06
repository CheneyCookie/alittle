package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport{
	
	private String sname;
	private InputStream inputStream;
	
	
	public InputStream getInputStream() {
		return inputStream;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String check(){
		System.out.println("----check----");
		if(sname.equals("admin")){
			inputStream=new ByteArrayInputStream("false".getBytes());
		}else{
			inputStream=new ByteArrayInputStream("true".getBytes());

		}
		return "stream";
	}
}
