package WebServlet;

import Model.Teacher;
import Servlce.DatabasesImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TearLoginCheck", value = "/TearLoginCheck")
public class TearLoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端返回数据
        request.setCharacterEncoding("utf-8");
        String Tearid=request.getParameter("username");
        String Tpwd= request.getParameter("password");
        String cheackcode=request.getParameter("cheackcode");
        DatabasesImpl databasesimpl=new DatabasesImpl();
        try {
            Teacher teacher= databasesimpl.TeacherLogin(Tearid,Tpwd);
            if (teacher==null){
                response.getWriter().println("用户名密码不存在！");
            }else {
                if (Tearid.equals(teacher.getT_id())){
                    System.out.println("工号");
                    if (Tpwd.equals(teacher.getPwd())){
                        System.out.println("密码");
                        ServletContext context=this.getServletContext();
                        String CkeackCode= (String) context.getAttribute("checkcode");
                        System.out.println("收到验证码："+CkeackCode);
                        System.out.println(CkeackCode);
                        if (cheackcode.equals(CkeackCode)){
                            response.getWriter().println("suecc!");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
