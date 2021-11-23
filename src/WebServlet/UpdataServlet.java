package WebServlet;
/**
 * @author Ysz
 * @date 2021/11/20 16:20
 * @return: 放弃
 * 
 **/

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "UpdataServlet", value = "/UpdataServlet")
public class UpdataServlet extends HttpServlet {
    Map<String,String> data=new HashMap<String,String>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Gson gson=new Gson();
        if (data.size()!=0){
            response.setStatus(200);
            String DataJson=gson.toJson(data);
            response.getWriter().print(DataJson);
        }else {
            response.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        Enumeration<String> enumeration=request.getParameterNames();
        while (enumeration.hasMoreElements()){
            //System.out.println(enumeration.nextElement());
            String key=enumeration.nextElement();
            String value=request.getParameter(key);
            data.put(key,value);
            System.out.println(data);
        }
    }
}
