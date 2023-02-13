package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;



public class DBUtil {
	
	public ArrayList<Integer> getSugerLevelFasting () {
		
		ResultSet rset =	this.getSugerLevelFastingListsFromDB();
		
		
		ArrayList<Integer> sugerLevelValListFasting = new ArrayList<>();
		try {
			
			while (rset.next()) {
				sugerLevelValListFasting.add(rset.getInt("normal_p"));
			}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	
		return sugerLevelValListFasting;
	}

	private ResultSet getSugerLevelFastingListsFromDB() {
		// 定数
		final String URL = "jdbc:mysql://localhost:3306/";
		
		final String USER = "root";
		final String PASS = "1905pass";
		
		//SQLを構築
		String SQLpre = "select * from otsuki.sl_fasting;";
		
		StringBuilder strb = new StringBuilder();
		strb.append(SQLpre);
		
		String SQL = strb.toString();		
		//返り値、Suger Level Fasting
		ResultSet rset = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			
			System.out.println("success 接続");
			
			Statement stmt = conn.createStatement();
			
			
			rset = stmt.executeQuery(SQL);	
					
				
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rset;
	}

}