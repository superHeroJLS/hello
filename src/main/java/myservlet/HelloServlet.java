package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServlet注解表示这是一个Servlet，并映射到地址 /first
@WebServlet(urlPatterns = {"/first", "/"})
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 6396466975211802789L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // print application context path
        String contextPath = req.getContextPath();
        
	    // 设置响应类型:
        resp.setContentType("text/html");
        // 获取输出流:
        PrintWriter pw = resp.getWriter();
        
        String param = req.getParameter("name");
        // 写入响应:
        pw.write("<h1>Hello, " + param + "</h1>");
        pw.write("<h1>application context path: " + contextPath + "</h1>");
        // 最后不要忘记flush强制输出:
        pw.flush();
    }
}
