package com.ikkat.los.utils;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaSql {
	private static final String MYDRIVER = "org.postgresql.Driver";
	
//	private static final String MYURL = "jdbc:postgresql://localhost:5432/creditscoring";
	private static final String MYURL = "jdbc:postgresql://10.102.25.242:5432/creditscoring";
	
	private static final String USER = "postgres";
	
//	private static final String PASSWORD = "password";
	private static final String PASSWORD = "iKKat.1!";
	
	public static boolean ExecuteAlterSql() {
		
        try {
			Class.forName(MYDRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			Connection conn = DriverManager.getConnection(MYURL, USER, PASSWORD);
			queryString(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	private static boolean queryString(Connection conn) throws SQLException {
//		boolean flagtable = false;
//		boolean flagcolumn = false;
//		conn.setAutoCommit(false);
//		Statement st = null;
//		try {
//			st = conn.createStatement();
//			
//			flagtable = checkTable(conn, "cities1");
//			if(flagtable) {
//				String query = "SELECT * FROM cities1 LIMIT 1 ";
//		        ResultSet rs = st.executeQuery(query);
//		        flagcolumn = checkColumn(rs, "nametes");
//		        if(!flagcolumn) {
//		        	query = " ALTER TABLE cities1 ADD column1 varchar(100) NOT NULL ";
//		        	st.addBatch(query);
//		        	int [] updateCounts = st.executeBatch();
//		        	conn.commit();
//		        }
//	        
//		}
//		}catch(BatchUpdateException b) {
////	        JDBCTutorialUtilities.printBatchUpdateException(b);
//	    } catch(SQLException ex) {
////	        JDBCTutorialUtilities.printSQLException(ex);
//	    } finally {
//	        if (st != null) { st.close(); }
//	        conn.setAutoCommit(true);
//	    }

		return false;
	}
	
	private static boolean checkTable(Connection conn, String table) throws SQLException {
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, table, null);
		if (tables.next()) {
			  // Table exists
				return true;
			}else {
			  // Table does not exist
				return false;
			}
	}
	
	private static boolean checkColumn(ResultSet rs, String column) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        for (int x = 1; x <= columns; x++) {
            if (column.equals(rsmd.getColumnName(x))) {
                return true;
            }
        }
        return false;
    }
}
