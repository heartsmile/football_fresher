package com.quanta.actions;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.quanta.bean.FootballTeamDB;
import com.quanta.dao.FootballTeamDAO;

@Namespaces(value = { @Namespace("/") })
public class TeamManageAction {

	private ArrayList<FootballTeamDB> listTeam;
	private FootballTeamDB teamObj;

	@Action(value = "TeamManage", results = {
			@Result(name = "home", location = "/Views/TeamManage.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String execute() {

		listTeam = getListTeamFromDB();
		System.out.println("quan ly doi bong");
		return "home";
	}

	@Action(value = "UpdateTeam", results = {
			@Result(name = "home", location = "/Views/UpdateTeam.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String UpdateTeam() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String teamID = request.getParameter("id");
		String teamName = request.getParameter("name");
		if (teamID != null) {
			teamObj = new FootballTeamDB();
			teamObj.setTeamID(Integer.parseInt(teamID));
			teamObj.setTeamName(teamName);
		}
		System.out.println("Update doi bong");
		return "home";
	}

	@Action(value = "SubmitUpdate", results = {
			@Result(name = "home", location = "/Views/TeamManage.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String ProcessUpdateTeam() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int teamID = Integer.parseInt((String) request.getParameter("teamID"));
		String teamName = request.getParameter("teamName");
		if (teamName != null) {
			FootballTeamDAO ftDAO = new FootballTeamDAO();
			ftDAO.updateFBTeam(teamID, teamName);
			listTeam = getListTeamFromDB();
		}
		System.out.println("Xu ly Update");
		return "home";
	}

	@Action(value = "GroupTable", results = {
			@Result(name = "home", location = "/Views/TeamManage.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String GroupTeamToTable() {
		listTeam = getListTeamFromDB();
		ArrayList<FootballTeamDB> listTeamHadTable = new ArrayList<FootballTeamDB>();
		FootballTeamDAO ftDAO = new FootballTeamDAO();
		Random rand = new Random();
		FootballTeamDB ftObj = new FootballTeamDB();
		int pos = 0;
		for (Character i = 'A'; i < 'E'; i++) {
			for (int j = 0; j < 4; j++) {
				pos = rand.nextInt(listTeam.size());
				ftObj = listTeam.get(pos);
				listTeam.remove(pos);
				ftObj.setTable(String.valueOf(i));
				listTeamHadTable.add(ftObj);
			}
		}
		for (FootballTeamDB team : listTeamHadTable) {
			ftDAO.updateTableOfTeam(team.getTeamID(), team.getTable());
		}
		listTeam = listTeamHadTable;
		System.out.println("Sap xep cac doi vao bang");
		return "home";
	}

	private ArrayList<FootballTeamDB> getListTeamFromDB() {
		FootballTeamDAO ftDAO = new FootballTeamDAO();
		return ftDAO.getListFBTeam();
	}

	public ArrayList<FootballTeamDB> getListTeam() {
		return listTeam;
	}

	public void setListTeam(ArrayList<FootballTeamDB> listTeam) {
		this.listTeam = listTeam;
	}

	public FootballTeamDB getTeamObj() {
		return teamObj;
	}

	public void setTeamObj(FootballTeamDB teamObj) {
		this.teamObj = teamObj;
	}
}
