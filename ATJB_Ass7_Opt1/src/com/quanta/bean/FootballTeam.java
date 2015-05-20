package com.quanta.bean;

public class FootballTeam {
	private int teamID;
	private String teamName;
	private String table;
	private int numOfMatch;
	private int numOfWin;
	private int numOfEqual;
	private int numOfLose;
	private int score;
	private String goalDiff;
	private int stage;
	private int winGoal;
	private int loseGoal;
	
	
	public FootballTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FootballTeam(int teamID, String teamName, String table,
			int numOfMatch, int numOfWin, int numOfEqual, int numOfLose,
			int score, String goalDiff, int stage, int winGoal, int loseGoal) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.table = table;
		this.numOfMatch = numOfMatch;
		this.numOfWin = numOfWin;
		this.numOfEqual = numOfEqual;
		this.numOfLose = numOfLose;
		this.score = score;
		this.goalDiff = goalDiff;
		this.stage = stage;
		this.winGoal = winGoal;
		this.loseGoal = loseGoal;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public int getNumOfMatch() {
		return numOfMatch;
	}
	public void setNumOfMatch(int numOfMatch) {
		this.numOfMatch = numOfMatch;
	}
	public int getNumOfWin() {
		return numOfWin;
	}
	public void setNumOfWin(int numOfWin) {
		this.numOfWin = numOfWin;
	}
	public int getNumOfEqual() {
		return numOfEqual;
	}
	public void setNumOfEqual(int numOfEqual) {
		this.numOfEqual = numOfEqual;
	}
	public int getNumOfLose() {
		return numOfLose;
	}
	public void setNumOfLose(int numOfLose) {
		this.numOfLose = numOfLose;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getGoalDiff() {
		return goalDiff;
	}
	public void setGoalDiff(String goalDiff) {
		this.goalDiff = goalDiff;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getWinGoal() {
		return winGoal;
	}
	public void setWinGoal(int winGoal) {
		this.winGoal = winGoal;
	}
	public int getLoseGoal() {
		return loseGoal;
	}
	public void setLoseGoal(int loseGoal) {
		this.loseGoal = loseGoal;
	}
	
}
