package WebServlet;
/**
 * @author Ysz
 * @date 2021/11/20 16:20
 * @return:
 * 
 **/

import Servlce.DatabasesImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "UpdataServlet", value = "/UpdataServlet")
public class UpdataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabasesImpl databases=new DatabasesImpl();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
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
            boolean res= databases.updatestudeninfo(id.trim(),username.trim(),sex.trim(),city.trim(),experience.trim(),score.trim(),classify.trim(),TeacherName.trim());
            response.setStatus(200);
        } catch (SQLException e) {
            response.setStatus(500);
            e.printStackTrace();
        }
    }
}
