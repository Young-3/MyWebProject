package com.young.servlet;

import com.young.entity.User;
import com.young.service.IUserLoginService;
import com.young.service.Impl.UserLoginServiceImpl;
import sun.security.krb5.internal.tools.Klist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginCheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		int u_id = Integer.parseInt(request.getParameter("id"));
		String u_pwd = request.getParameter("password");
		String u_type = request.getParameter("type");
		User user = new User(u_id,u_pwd);

		System.out.println("进行判断权限");
		if(u_type.equals("student")){//调用方法
			//面向接口编程
			IUserLoginService stuLoginService =  new UserLoginServiceImpl();
			List list = stuLoginService.stuLogin(user);
			System.out.println("stu—servlet—login返回"+list);
			if(list!=null && !list.isEmpty()){
				//代码处理
				request.setAttribute("list", list);
				request.getRequestDispatcher("student_success.jsp").forward(request,response);
				System.out.println("账户密码正确，学生登录成功");
			}else{
				//List对象为空的异常记录处理
				System.out.println("用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}

		if(u_type.equals("teacher")){//调用方法
			//面向接口编程
			IUserLoginService teaLoginService =  new UserLoginServiceImpl();
			List list = teaLoginService.teaLogin(user);
			System.out.println("tea-servlet—login返回"+list);
			if(list!=null && !list.isEmpty()){
				//代码处理
				request.setAttribute("list", list);
				request.getRequestDispatcher("teacher_success.jsp").forward(request,response);
				System.out.println("账户密码正确，教师登录成功");
			}else{
				//List对象为空的异常记录处理
				System.out.println("用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}






	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}
}
