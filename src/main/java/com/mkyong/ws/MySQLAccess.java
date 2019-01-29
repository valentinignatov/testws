package com.mkyong.ws;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.koushik.javabrains.messenger.resources.Test;

public class MySQLAccess {
	
private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; //com.mysql.jdbc.Driver
private static final String DB_CONNECTION = "jdbc:mysql://localhost/MyDB?";                      
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "Dialog558226a";

public static void main(String[] argv) {

//	try {
//
//		selectRecordsFromTable(2);
//
//	} catch (SQLException e) {
//
//		System.out.println(e.getMessage());
//
//	}

}

public String selectRecordsFromTable(int id) throws SQLException {

	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;

	String selectSQL = "SELECT Carti FROM produse WHERE id = ?";

	Test test = new Test();
	
	try {
		dbConnection = getDBConnection();
		preparedStatement = dbConnection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, id);

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {

			 test.setCarti(rs.getString("carti"));
			
			

		}

	} catch (SQLException e) {

		System.out.println(e.getMessage());

	} finally {

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (dbConnection != null) {
			dbConnection.close();
		}

	}
	
	return test.toString();

}

private static Connection getDBConnection() {

	Connection dbConnection = null;

	try {

		Class.forName(DB_DRIVER);

	} catch (ClassNotFoundException e) {

		System.out.println(e.getMessage());

	}

	try {

		dbConnection = DriverManager.getConnection(
                         DB_CONNECTION, DB_USER,DB_PASSWORD);
		return dbConnection;

	} catch (SQLException e) {

		System.out.println(e.getMessage());

	}

	return dbConnection;

}

}
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;
//import org.koushik.javabrains.messenger.model.Message;
//
//public class MySQLAccess {
//	private Connection connect = null;
//    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;
////    public void readDataBase() throws Exception {
////        try {
////            // This will load the MySQL driver, each DB has its own driver
////            //Class.forName("com.mysql.jdbc.Driver");
////            // Setup the connection with the DB
////           
////            // Statements allow to issue SQL queries to the database
//////            statement = connect.createStatement();
//////            // Result set get the result of the SQL query
//////            resultSet = statement
//////                    .executeQuery("select * from Produse");
//////            writeResultSet(resultSet);
//////        	}
////        }catch (Exception e) {
////       throw e;
////   } finally {	
////        close();
////    }
////    }
//    
//   /* private void writeResultSet(ResultSet resultSet) throws SQLException {
//        // ResultSet is initially before the first data set
//        while (resultSet.next()) {
//        	 String id = resultSet.getString("id");
//        	 String Carti = resultSet.getString("Carti");
//        	 System.out.println("ID: " + id);
//        	 System.out.println("Cartea: " + Carti);
//        	 
//        	 String getResultByid(String ID){
//        		 preparedStatement = connect 
//        	            .prepareStatement("select Carti from produse where id = ?;");
//        	            preparedStatement.setString(1, "ID");
//        	            
//        	     id = resultSet.getString("id");
//        	     Carti = resultSet.getString("Carti");
//        	 }
//        }
//    }*/
//    
//    /*public String getResultByid(String ID){
//    	String id;
//		while (ID==id){
//    		id = resultSet.getString("id");
//       	 	String Carti = resultSet.getString("Carti");
//    	}
//    }*/
//    public String findById(int id) throws SQLException {
//
//        String sql = "SELECT carti FROM Produse WHERE id=?";
//        String numeleCartii = null;
//        ResultSet rs = null;
//     
//        try {
//        	 connect = DriverManager
//                     .getConnection("jdbc:mysql://localhost/MyDB?"
//                             + "user=sqluser&password=sqluserpw");
//            // Statements allow to issue SQL queries to the database
//           
//            preparedStatement = connect.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                numeleCartii = rs.getString("carti");
//               
//            }
//        } catch (SQLException ex) {
//        	System.out.println("Nu a fost gasit");
//        } finally {
//            try {
//            	preparedStatement.close();
//                rs.close();
//                connect.close();
//            } catch (SQLException ex) {
//
//            }
//
//           
//
//        }
//        return numeleCartii;
//    }
//    
//    // You need to close the resultSet
//    private void close() {
//        try {
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//            if (connect != null) {
//                connect.close();
//            }
//        } catch (Exception e) {
//
//        }
//    }
//}
