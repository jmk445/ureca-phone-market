package com.mycom.myapp.common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Connection 객체 종료 반납

public class DBManager {
	//Connection Pool(DataSource) 로 부터 객테를 직접 획득 x <= spring di

//    public static Connection getConnection() {
//        Connection con = null;
//        try {
//        	Context context = new InitialContext();
//        	//context.xml에 접속할 수 있는 약속
//        	DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/madangDB"); //이제 ds가 connection pool, java에서는 datasource라는 것으로 pool을 관리한다.
//            con = ds.getConnection();
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        
//        return con;     
//    }
    
    //ConnectionPool로 부터 얻는 Connection 객체의 close() 메소드는 overriding돼있다.
    //Connection을 끊지 않고 Connection Pool 에 반납되도록 	
    public static void releaseConnection(PreparedStatement pstmt, Connection con) {
        try {
            if( pstmt != null ) pstmt.close();
            if( con != null ) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if( rs != null ) rs.close();
            if( pstmt != null ) pstmt.close();
            if( con != null ) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}