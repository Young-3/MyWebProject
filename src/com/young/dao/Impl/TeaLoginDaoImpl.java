package com.young.dao.Impl;

import com.young.dao.IUserDao;
import com.young.entity.User;
import com.young.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Young
 * @version1.0
 */
public class TeaLoginDaoImpl implements IUserDao {
	public List<User> checkLogin(User user){
		System.out.println("TeaLoginDaoImpl.checkLogin");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		System.out.println("进行查询");


		List<User> list = new ArrayList<>();
		Object[] params ={user.getU_id(),user.getU_pwd()};

		System.out.println("取得结果rs:"+rs);
		try {

			String sql = "select tea_id,tea_name from teacher where tea_id=? and tea_password=?";
			rs = DBUtil.executeQuery(sql,params);//执行DBUtil的executQuery方法 rs为数据库返回的数据
			System.out.println("取得结果rs.next():");
/*			System.out.println("stu_id"+rs.getString(1));
//			System.out.println("111"+rs.next());
			System.out.println("stu_name"+rs.getString(2));*/


			while(rs.next()) {//rs.next(),需要先遍历 不然会报错  rs肯定不会为null，注意，是rs对象不会为null，而不是其包含的result

				int tea_id = Integer.parseInt(rs.getString(1));//rs.getString(n) 获取上面sql语句中"select * from"的列数据
				String tea_name = rs.getString(2);
				System.out.println("id是："+tea_id );
				System.out.println("name"+tea_name);
				User tea = new User(tea_id,tea_name);//实例化一个User对象，传入属性
				tea.setU_id(rs.getInt(1));
				tea.setU_name(rs.getString(2));
				list.add(tea);//将stu放进集合当中
				System.out.println("stu");


			}

		}catch (NullPointerException e){
			e.printStackTrace();

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs,pstmt,connection);//关闭数据库连接
			System.out.println("DB.close");

		}
		System.out.println("list返回："+list);
		return list;//返回一个集合

	}

}
