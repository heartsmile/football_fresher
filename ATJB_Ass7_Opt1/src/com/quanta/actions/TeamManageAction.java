package com.quanta.actions;


import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.quanta.bean.FootballTeam;
import com.quanta.dao.FootballTeamDAO;

@Action(value = "TeamManage", results = {
		@Result(name = "home", location = "/Views/TeamManage.jsp"),
		@Result(name = "SUCCESS", location = "/Welcome.jsp"),
		@Result(name = "ERROR", location = "/Error.jsp") })
@Namespaces(value = { @Namespace("/") })
public class TeamManageAction {
	
	private ArrayList<FootballTeam> listTeam;
	
	public String execute() {
		
		listTeam = getListTeamFromDB();
		System.out.println("quan ly doi bong");
		return "home";
	}
	
	private ArrayList<FootballTeam> getListTeamFromDB(){
		FootballTeamDAO ftDAO = new FootballTeamDAO();
		return ftDAO.getListFBTeam();
	}

	public ArrayList<FootballTeam> getListTeam() {
		return listTeam;
	}

	public void setListTeam(ArrayList<FootballTeam> listTeam) {
		this.listTeam = listTeam;
	}
	
	
}
