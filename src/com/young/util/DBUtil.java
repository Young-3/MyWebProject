package com.young.util;

import com.young.entity.User;

import javax.xml.transform.Result;
import java.sql.*;


/**
 * @author Young
 * @version1.0
 */

//通用的数据库操作方法
public class DBUtil {
	private static final String dbdriver = "com.mysql.jdbc.Driver";
	private static final String dburl = "jdbc:mysql://localhost:3306/mywebuser?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String dbname = "root";
	private static final String dbpassword = "10010.com";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;



	public static Connection getConnection() throws ClassNotFoundException,SQLException {//数据库连接

			Class.forName(dbdriver);
			return DriverManager.getConnection(dburl, dbname, dbpassword);
	}

	//提取pstmt PreparedStatement 预处理
	public static PreparedStatement createPstmt(String sql,Object[] params) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement(sql);//获取连接 传入sql语句
		if(params!=null){
			for (int i=0;i<params.length;i++){//遍历集合  传入值
				//setObject setInt setString
				pstmt.setObject(i+1,params[i]);
		}
	}
		return pstmt;//得到返回值
	}

	//关闭数据库方法
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection){
		try {
			if (rs!=null)rs.close();
			if (stmt!=null)stmt.close();
			if (connection!=null)connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

//通用增删改
	public static boolean executeUpdate(String sql,Object[] params) {//数据库连接
		try {
			pstmt = createPstmt(sql, params);
			int count = pstmt.executeUpdate();//executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）
			if (count > 0)
				return true;
			else
				return false;
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll(null,pstmt,connection);
		}

	}

	//通用查：返回值是集合
	public static ResultSet executeQuery(String sql, Object[] params) {//数据库连接



		try {
			pstmt = createPstmt(sql, params);

			rs = pstmt.executeQuery();//执行此 PreparedStatement对象中的SQL查询，并返回查询 PreparedStatement的 ResultSet对象。
			return rs;



		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//需要调用rs，不能关闭
				//DBUtil.closeAll(rs,pstmt,DBUtil.connection);

		}
	}




}
