package com.org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import com.org.entity.Course;
import com.org.service.CourseService;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CourseService courseService;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		int cid = Integer.parseInt(req.getParameter("cid"));
		String cname = req.getParameter("cname");	
		Course course = new Course(cid,cname);
		/*
		 * 将创建的对象存放在Application中
		 * 实现容器只创建一个对象，不会重复创建，提高性能
		 * 需要在XML中配置contextConfigLocation,路径是Spring主配置文件的路径
		 * 
		 */
		ApplicationContext api = (ApplicationContext) this.getServletContext().
				getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		courseService =(CourseService) api.getBean("ProxyService");
		System.out.println(api);
		//执行插入方法
		courseService.addCourse(course);
		//插入成功后跳转的界面
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
