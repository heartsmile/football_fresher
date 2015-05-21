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

/**
 * @author QuanTA5
 *
 */
public class FootballTeamDAO {

	private DBConnection conn = new DBConnection();

	public ArrayList<FootballTeamDB> getListFBTeam() {

		ArrayList<FootballTeamDB> listRS = new ArrayList<FootballTeamDB>();
		try {
			Statement stmt = conn.getConnection().createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT ma_db, ten_db, bang_dau FROM doi_bong ORDER BY bang_dau");
			while (rs.next()) {
				FootballTeamDB fbTeam = new FootballTeamDB();
				fbTeam.setTeamID(rs.getInt(1));
				fbTeam.setTeamName(rs.getString(2));
				fbTeam.setTable(rs.getString(3));
				listRS.add(fbTeam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listRS;
	}

	public boolean updateFBTeam(int teamID, String teamName) {

		try {
			PreparedStatement stmt = conn.getConnection().prepareStatement(
					"UPDATE doi_bong SET ten_db = ? WHERE ma_db = ?");
			stmt.setString(1, teamName);
			stmt.setInt(2, teamID);
			boolean rs = stmt.execute();
			if (rs) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTableOfTeam(int teamID, String table) {

		try {
			PreparedStatement stmt = conn.getConnection().prepareStatement(
					"UPDATE doi_bong SET bang_dau = ? WHERE ma_db = ?");
			stmt.setString(1, table);
			stmt.setInt(2, teamID);
			boolean rs = stmt.execute();
			if (rs) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
