/**
 * 
 */
package com.quanta.bean;

/**
 * @author QuanTA5
 *
 */
public class MatchDB {
	private int matchID;
	private int team1ID;
	private int team2ID;
	private int team1Result;
	private int team2Result;
	private String table;
	private String round;
	
	public MatchDB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatchDB(int matchID, int team1id, int team2id, int team1Result,
			int team2Result, String table, String round) {
		super();
		this.matchID = matchID;
		team1ID = team1id;
		team2ID = team2id;
		this.team1Result = team1Result;
		this.team2Result = team2Result;
		this.table = table;
		this.round = round;
	}
	public int getMatchID() {
		return matchID;
	}
	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}
	public int getTeam1ID() {
		return team1ID;
	}
	public void setTeam1ID(int team1id) {
		team1ID = team1id;
	}
	public int getTeam2ID() {
		return team2ID;
	}
	public void setTeam2ID(int team2id) {
		team2ID = team2id;
	}
	public int getTeam1Result() {
		return team1Result;
	}
	public void setTeam1Result(int team1Result) {
		this.team1Result = team1Result;
	}
	public int getTeam2Result() {
		return team2Result;
	}
	public void setTeam2Result(int team2Result) {
		this.team2Result = team2Result;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	
	
}
