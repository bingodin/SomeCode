package com.sinosoft;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class TestAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9025603028030108273L;
	private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
	
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().write("Hello");
		response.getWriter().flush();
		return super.execute();
	}
    
}