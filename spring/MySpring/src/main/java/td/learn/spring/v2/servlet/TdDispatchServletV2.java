package td.learn.spring.v2.servlet;

import td.learn.spring.framework.core.TdApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TdDispatchServletV2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------------dopost方法---------------------");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化IOC容器
        TdApplicationContext tdApplicationContext=new TdApplicationContext(config.getInitParameter("configLocation"));
    }
}
