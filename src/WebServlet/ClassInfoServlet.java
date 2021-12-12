package WebServlet;

import Model.*;
import Servlce.DatabasesImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClassInfoServlet", value = "/ClassInfoServlet")
public class ClassInfoServlet extends HttpServlet {
    DatabasesImpl databasesimpl=new DatabasesImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //系统奔溃
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        Gson gson=new Gson();
        List list=new ArrayList<StdentInfo>();
        Teacher teacher= (Teacher) request.getSession().getAttribute("teacher");
        try {
            list=databasesimpl.getclassinfo(teacher.getName());
            ClassMainInfo classMainInfo=new ClassMainInfo(0,"",100,list);
            String datas=gson.toJson(classMainInfo);
            response.getWriter().print(datas);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}
