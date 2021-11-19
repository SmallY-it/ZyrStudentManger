package WebServlet;

import Model.StdentInfo;
import Servlce.DatabasesImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddStudentInfo", value = "/AddStudentInfo")
public class AddStudentInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        DatabasesImpl databases=new DatabasesImpl();
        //StdentInfo stdentInfo = new StdentInfo();
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String experience=request.getParameter("experience");
        String score=request.getParameter("score");
        String classify=request.getParameter("classify");
        String TeacherName=request.getParameter("TeacherName");
        String sex=request.getParameter("sex");
        //System.out.println(id + username + experience + score + classify + TeacherName + sex);
        /*
        * 获取省市县级详细地址
        * */
        String province=request.getParameter("province");
        String citys=request.getParameter("city");
        String county=request.getParameter("county");
        String xxadd=request.getParameter("xxadd");
        //System.out.println(province + citys + county + xxadd);
        String city=province+citys+county+xxadd;
        try {
            boolean res= databases.addstudeninfo(id.trim(),username.trim(),sex.trim(),city.trim(),experience.trim(),score.trim(),classify.trim(),TeacherName.trim());
            response.setStatus(200);
        } catch (SQLException e) {
            response.setStatus(500);
            e.printStackTrace();
        }

    }
}
