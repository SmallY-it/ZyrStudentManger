package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Wxlogin", value = "/Wxlogin")
public class Wxlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String code=request.getParameter("code");
        getHttp gethttp=new getHttp();
        String appid="wxfac33e1eacc38408";
        String secret="eff68349f4a90d606f80c4a5a4b96bba";
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
       // String res=gethttp.get(url);


        //String str =res.substring(1, res.length() - 1);
        //str.substring(1,str.length-1);
//        //System.out.println(res);
//        Map<String,String> map = new HashMap<String,String>();
//        String[] str1 = str.split(",");
//        for (int i = 0; i < str1.length; i++) {
//            //根据":"截取字符串数组
//            String[] str2 = str1[i].split(":");
//            //str2[0]为KEY,str2[1]为值
//            String s1=str2[0].substring(1, res.length() - 1);
//            String s2=str2[1].substring(1, res.length() - 1);
//            map.put(s1,s2);
//            System.out.println(s1);
//            System.out.println(s2);
//        }
//        System.out.println(map);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
