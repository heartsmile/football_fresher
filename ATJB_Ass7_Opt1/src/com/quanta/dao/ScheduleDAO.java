/**
 * 
 */
package com.quanta.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.quanta.bean.FootballTeamDB;
import com.quanta.bean.Match;
import com.quanta.bean.MatchDB;

/**
 * @author QuanTA5
 *
 */
public class ScheduleDAO {
	private DBConnection conn = new DBConnection();

	public boolean checkHadSchedule() {

		try {
			Statement stmt = conn.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ma_td FROM tran_dau");
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean makeSchedule(FootballTeamDB team1, FootballTeamDB team2,
			String table, String round) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"INSERT INTO tran_dau(ma_db_1, ma_db_2, bang_dau, vong) VALUES (?, ?, ?, ?)");
			stmt.setInt(1, team1.getTeamID());
			stmt.setInt(2, team2.getTeamID());
			stmt.setString(3, table);
			stmt.setString(4, round);
			boolean rs = stmt.execute();
			if (rs) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateRatio(int matchID, int resultTeam1, int resultTeam2) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"UPDATE tran_dau SET kq_db_1 = ?, kq_db_2 = ? WHERE `ma_td` = ?");
			stmt.setInt(1, resultTeam1);
			stmt.setInt(2, resultTeam2);
			stmt.setInt(3, matchID);
			boolean rs = stmt.execute();
			if (rs) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Match> getSchedule() {
		ArrayList<Match> rsArray = new ArrayList<Match>();
		String sqlGetSchedule = " SELECT td1.ma_td, ten_db_1, ten_db_2, td1.bang_dau, vong, kq_db_1, kq_db_2 "
				+ " FROM"
				+ "	(SELECT ma_td, ten_db ten_db_1, tran_dau.bang_dau, vong, kq_db_1, kq_db_2 "
				+ "	FROM tran_dau, doi_bong"
				+ "	WHERE ma_db = ma_db_1) td1"
				+ " JOIN "
				+ "	(SELECT ma_td, ten_db ten_db_2 "
				+ "	FROM tran_dau, doi_bong"
				+ "	WHERE ma_db = ma_db_2) td2"
				+ " ON td1.ma_td = td2.ma_td"
				+ " ORDER BY td1.bang_dau";
		try {
			Statement stmt = conn.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlGetSchedule);
			Match matchObj;
			while (rs.next()) {
				matchObj = new Match();
				matchObj.setMatchID(rs.getInt(1));
				matchObj.setTeam1Name(rs.getString(2));
				matchObj.setTeam2Name(rs.getString(3));
				matchObj.setTable(rs.getString(4));
				matchObj.setRound(rs.getString(5));
				matchObj.setTeam1Result(rs.getInt(6));
				matchObj.setTeam2Result(rs.getInt(7));
				
				rsArray.add(matchObj);
			}
			
			return rsArray;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//false: mean not end
	//true: mean ended
	public boolean checkIfTableRoundIsEnd() {
		String sqlGetSchedule = " SELECT kq_db_1, kq_db_2, vong FROM tran_dau";
		try {
			Statement stmt = conn.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlGetSchedule);
			while (rs.next()) {
				if((rs.getString(1) == null || rs.getString(2) == null)
						&& "Bang".equals(rs.getString(3)) ){
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean increaseNumOfMatch(int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT so_tran_dau FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int numOfMatch = rs.getInt(1);
				numOfMatch++;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET so_tran_dau = ? WHERE ma_db = ?");
				stmt.setInt(1, numOfMatch);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean increaseNumOfWin(int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT so_tran_thang FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int numOfMatch = rs.getInt(1);
				numOfMatch++;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET so_tran_thang = ? WHERE ma_db = ?");
				stmt.setInt(1, numOfMatch);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean increaseNumOfEqual(int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT so_tran_hoa FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int numOfMatch = rs.getInt(1);
				numOfMatch++;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET so_tran_hoa = ? WHERE ma_db = ?");
				stmt.setInt(1, numOfMatch);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean increaseNumOfLose(int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT so_tran_thua FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int numOfMatch = rs.getInt(1);
				numOfMatch++;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET so_tran_thua = ? WHERE ma_db = ?");
				stmt.setInt(1, numOfMatch);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean increaseScore(int numOfScore, int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT diem_so FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int score = rs.getInt(1);
				score += numOfScore;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET diem_so = ? WHERE ma_db = ?");
				stmt.setInt(1, score);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean setStage(int stage, int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"UPDATE doi_bong SET hang = ? WHERE ma_db = ?");
			stmt.setInt(1, stage);
			stmt.setInt(2, teamID);
			return stmt.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean increaseWinGoal(int numOfGoal, int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT ban_thang FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int goal = rs.getInt(1);
				goal += numOfGoal;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET ban_thang = ? WHERE ma_db = ?");
				stmt.setInt(1, goal);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean increaseLoseGoal(int numOfGoal, int teamID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT ban_thua FROM doi_bong WHERE ma_db = ?");
			stmt.setInt(1, teamID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int goal = rs.getInt(1);
				goal += numOfGoal;
				stmt = conn
						.getConnection()
						.prepareStatement(
								"UPDATE doi_bong SET ban_thua = ? WHERE ma_db = ?");
				stmt.setInt(1, goal);
				stmt.setInt(2, teamID);
				boolean result = stmt.execute();
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public MatchDB getTeamIdByMatchId(int matchID) {

		try {
			PreparedStatement stmt = conn
					.getConnection()
					.prepareStatement(
							"SELECT ma_db_1, ma_db_2 FROM tran_dau WHERE ma_td = ?");
			stmt.setInt(1, matchID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				MatchDB match = new MatchDB();
				match.setTeam1ID(rs.getInt(1));
				match.setTeam2ID(rs.getInt(2));
				
				return match;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
