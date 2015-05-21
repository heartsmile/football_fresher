/**
 * 
 */
package com.quanta.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.quanta.bean.FootballTeamDB;
import com.quanta.bean.Match;
import com.quanta.bean.MatchDB;
import com.quanta.dao.FootballTeamDAO;
import com.quanta.dao.ScheduleDAO;

/**
 * @author QuanTA5
 *
 */
@Namespaces(value = { @Namespace("/") })
public class ScheduleManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FootballTeamDB> listTeam;
	private ArrayList<Match> listMatch;
	private ScheduleDAO schDAO = new ScheduleDAO();

	@Action(value = "TableRound", results = {
			@Result(name = "home", location = "/Views/ScheduleManage.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String execute() {
		FootballTeamDAO ftDAO = new FootballTeamDAO();

		// check if had any schedule?
		if (!schDAO.checkHadSchedule()) {
			FootballTeamDB[] tableA = new FootballTeamDB[4];
			FootballTeamDB[] tableB = new FootballTeamDB[4];
			FootballTeamDB[] tableC = new FootballTeamDB[4];
			FootballTeamDB[] tableD = new FootballTeamDB[4];
			// add football team to a schedule
			listTeam = ftDAO.getListFBTeam();
			for (int i = 0; i < 4;) {
				for (FootballTeamDB team : listTeam) {
					if ("A".equals(team.getTable())) {
						tableA[i] = team;
						i++;
						if (i > 3) {
							break;
						}
					}
				}
			}
			for (int i = 0; i < 4;) {
				for (FootballTeamDB team : listTeam) {
					if ("B".equals(team.getTable())) {
						tableB[i] = team;
						i++;
						if (i > 3) {
							break;
						}
					}
				}
			}
			for (int i = 0; i < 4;) {
				for (FootballTeamDB team : listTeam) {
					if ("C".equals(team.getTable())) {
						tableC[i] = team;
						i++;
						if (i > 3) {
							break;
						}
					}
				}
			}
			for (int i = 0; i < 4;) {
				for (FootballTeamDB team : listTeam) {
					if ("D".equals(team.getTable())) {
						tableD[i] = team;
						i++;
						if (i > 3) {
							break;
						}
					}
				}
			}
			// insert data to database
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					schDAO.makeSchedule(tableA[i], tableA[j], "A", "Bang");
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					schDAO.makeSchedule(tableB[i], tableB[j], "B", "Bang");
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					schDAO.makeSchedule(tableC[i], tableC[j], "C", "Bang");
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					schDAO.makeSchedule(tableD[i], tableD[j], "D", "Bang");
				}
			}
		}
		// get list of match
		listMatch = schDAO.getSchedule();

		System.out.println("Quan ly lich thi dau vong bang");
		return "home";
	}

	@Action(value = "SaveRatio", results = {
			@Result(name = "home", location = "/Views/ScheduleManage.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String SaveRatio() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			int matchID = Integer.parseInt(request.getParameter("matchID"));
			int resultTeam1 = Integer.parseInt(request.getParameter("num1"));
			int resultTeam2 = Integer.parseInt(request.getParameter("num2"));
				
			MatchDB match = schDAO.getTeamIdByMatchId(matchID);
			int team1ID = match.getTeam1ID();
			int team2ID = match.getTeam2ID();
			
			if (resultTeam1 >= 0 && resultTeam2 >= 0) {
				schDAO.updateRatio(matchID, resultTeam1, resultTeam2);
				schDAO.increaseNumOfMatch(team1ID);
				schDAO.increaseNumOfMatch(team2ID);
				
				if(resultTeam1 > resultTeam2){
					//update win for team1
					schDAO.increaseNumOfWin(team1ID);
					schDAO.increaseWinGoal(resultTeam1, team1ID);
					schDAO.increaseScore(3, team1ID);
					//update lose for team2
					schDAO.increaseNumOfLose(team2ID);
					schDAO.increaseLoseGoal(resultTeam2, team2ID);
				} else if(resultTeam1 < resultTeam2) {
					//update lose for team1
					schDAO.increaseNumOfLose(team1ID);
					schDAO.increaseLoseGoal(resultTeam1, team1ID);
					//update win for team2
					schDAO.increaseNumOfWin(team2ID);
					schDAO.increaseWinGoal(resultTeam2, team2ID);
					schDAO.increaseScore(3, team2ID);
				} else {
					//update equal for both teams
					schDAO.increaseNumOfEqual(team1ID);
					schDAO.increaseNumOfEqual(team2ID);
					schDAO.increaseScore(1, team1ID);
					schDAO.increaseScore(1, team2ID);
				}
			}

			// get list of match
			listMatch = schDAO.getSchedule();

		} catch (Exception ex) {
			return "ERROR";
		}
		return "home";
	}

	@Action(value = "KnockoutRound", results = {
			@Result(name = "home", location = "/Views/Knockout.jsp"),
			@Result(name = "SUCCESS", location = "/Welcome.jsp"),
			@Result(name = "ERROR", location = "/Error.jsp") })
	public String executeKnockout() {
		
		// check if the table round is end
		if(schDAO.checkIfTableRoundIsEnd()){
			
			//it's end, so compute the knockout round
			listMatch = schDAO.getSchedule();
			for(Match match : listMatch){
				
				
			}
		}
		return "home";
	}

	public ArrayList<FootballTeamDB> getListTeam() {
		return listTeam;
	}

	public void setListTeam(ArrayList<FootballTeamDB> listTeam) {
		this.listTeam = listTeam;
	}

	public ArrayList<Match> getListMatch() {
		return listMatch;
	}

	public void setListMatch(ArrayList<Match> listMatch) {
		this.listMatch = listMatch;
	}
}
