package WebServlet;

import Model.StdentInfo;
import Model.StudentMainInfo;
import Model.Teacher;
import Servlce.DatabasesImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "MainData", value = "/MainData")
public class StuEsseInfo extends HttpServlet {
    DatabasesImpl databasesimpl=new DatabasesImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        Gson gson=new Gson();
        Teacher teacher= (Teacher) request.getSession().getAttribute("teacher");
        List list=new ArrayList<StdentInfo>();

        try {
            list=databasesimpl.getdata(teacher.getName());
            StudentMainInfo studentmaininfo=new StudentMainInfo(0,"",100,list);
            String datas=gson.toJson(studentmaininfo);
            response.getWriter().print(datas);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // doGet(request, response);
        /**
         * @author Ysz
         * @date 2021/11/15 10:11
         * @return: void
         * 用于执行数据的增删该
         **/
        response.setHeader("Access-Control-Allow-Origin","*");
        request.setCharacterEncoding("utf-8");

//        String name =request.getParameter("name");
        Map<String ,String>updNava=new HashMap<String,String >();
        Enumeration <String> obj=request.getParameterNames();
        while (obj.hasMoreElements()) {
            //获取map的键
            String s=obj.nextElement();
            System.out.println(s);
            //获取map的值
            String sValue=request.getParameter(s);
            updNava.put(s,sValue);
        }
        System.out.println(updNava);
        String  id=updNava.get("id");
        String name=updNava.get("name");
        String experience=updNava.get("experience");
        System.out.println(id);
        boolean returbmvalue= false;
        try {
            returbmvalue = databasesimpl.delete(id,name,experience);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(returbmvalue);
        if (returbmvalue){
            response.setStatus(200);
        }else {
            response.setStatus(500);
        }
    }
}
