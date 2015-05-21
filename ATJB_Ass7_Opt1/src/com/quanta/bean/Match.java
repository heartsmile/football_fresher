package com.quanta.bean;

public class Match {
	private int matchID;
	private String team1Name;
	private String team2Name;
	private int team1Result;
	private int team2Result;
	private String table;
	private String round;
	
	
	public int getMatchID() {
		return matchID;
	}
	public void setMatchID(int matchID) {
		this.matchID = matchID;
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
	public String getTeam1Name() {
		return team1Name;
	}
	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}
	public String getTeam2Name() {
		return team2Name;
	}
	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}
}
