/**
 * 
 */
package com.quanta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.quanta.bean.FootballTeam;


/**
 * @author QuanTA5
 *
 */
public class FootballTeamDAO {
	
	private DBConnection conn = new DBConnection();
	
	public ArrayList<FootballTeam> getListFBTeam(){
		
		ArrayList<FootballTeam> listRS = new ArrayList<FootballTeam>();
		try {
			Statement stmt = conn.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ma_db, ten_db FROM doi_bong");
			while(rs.next()) {
				FootballTeam fbTeam = new FootballTeam();
				fbTeam.setTeamID(rs.getInt(1));
				fbTeam.setTeamName(rs.getString(2));
				listRS.add(fbTeam);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listRS;
	}
}
