package com.quanta.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author QuanTA5
 *
 */
@Action(value = "/", results = {
		@Result(name = "home", location = "/Views/Homepage.jsp"),
		@Result(name = "SUCCESS", location = "/Welcome.jsp"),
		@Result(name = "ERROR", location = "/Error.jsp") })
@Namespaces(value = { @Namespace("/") })
public class HomepageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		System.out.println("sdfsdfsdf");
		
		return "home";
	}
}
