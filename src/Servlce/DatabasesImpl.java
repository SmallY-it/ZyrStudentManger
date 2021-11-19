package Servlce;

import Model.StdentInfo;
import Model.Teacher;
import Utile.JdbcUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabasesImpl implements DatabasesInterface{
    @Override
    public List getdata(String TeacherName) throws SQLException {
        JdbcUtil jdbcUtil= new JdbcUtil();
        Connection conn=jdbcUtil.GetConn();
        Statement statement=jdbcUtil.statement(conn);
        String sql="select * from t_user;";
        List<StdentInfo> list=new ArrayList<StdentInfo>();
        if (conn!=null){
            ResultSet rs=jdbcUtil.SelectresultSet(conn,statement,sql);
            /**
             * @author Ysz
             * @date 2021/11/15 9:38
             * @return: java.util.List
             * 进行伪删除操作，在数据库中设置sign标志位，为1为删除。
             **/
            while (rs.next()){
                int sign=rs.getInt("sign");
                String T_name=rs.getString("TeacherName");
                if (sign==0&&T_name.equals(TeacherName)){
                    int id= rs.getInt("id");
                    String username=rs.getString("username");
                    String sex=rs.getString("sex");
                    String city=rs.getString("city");
                    String experience=rs.getString("experience");
                    String score=rs.getString("score");
                    String classify=rs.getString("classify");
                    StdentInfo stdentInfo=new StdentInfo(id,username,sex,city,experience,score,classify,T_name);
                    list.add(stdentInfo);
                }else {
                    continue;
                }
            }
            jdbcUtil.closeLink(conn,rs);
            return list;
        }
        return null;
    }

    @Override
    public Teacher TeacherLogin(String T_id, String T_pwd) throws SQLException {
        JdbcUtil jdbcUtil= new JdbcUtil();
        Connection conn=jdbcUtil.GetConn();
        Statement statement=jdbcUtil.statement(conn);
        String sql="select * from Teacher_Info where Teacher_Info.Teacher_Id=\""+T_id+"\" AND Teacher_Info.Teacher_Pwd=\""+T_pwd+"\";";
        ResultSet rs=jdbcUtil.SelectresultSet(conn,statement,sql);
        Teacher teacher=new Teacher();
        if (conn==null){
            return null;
        }
        while (rs.next()){
            int id = rs.getInt("id");
            String name=rs.getString("TeacherName");
            String t_id=rs.getString("Teacher_Id");
            String pwd=rs.getString("Teacher_Pwd");
            String Image_addr=rs.getString("Images_add");
            teacher.setId(id);
            teacher.setName(name);
            teacher.setT_id(t_id);
            teacher.setPwd(pwd);
            teacher.setImage_addr(Image_addr);
        }
        jdbcUtil.closeLink(conn,rs);
        return  teacher;
    }

    @Override
    public boolean delete(String id, String username, String experience) throws SQLException {
        JdbcUtil jdbcUtil= new JdbcUtil();
        Connection conn=jdbcUtil.GetConn();
        Statement statement=jdbcUtil.statement(conn);
        String sql = "UPDATE t_user SET sign=1 WHERE id=\""+id+"\" AND username=\""+username+"\" AND experience=\""+experience+"\";";
        boolean rs = jdbcUtil.UpdataDb(conn, statement, sql);
        if (rs) {
            conn.close();
            statement.close();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addstudeninfo(String id,String username,String sex,String city,String experience,String score,String classify,String  TeacherName) throws SQLException {
        JdbcUtil jdbcUtil= new JdbcUtil();
        Connection conn=jdbcUtil.GetConn();
        Statement statement=jdbcUtil.statement(conn);
        String sql="INSERT INTO t_user VALUES (\""+id+"\", \""+username+"\", \""+sex+"\", \""+city+"\", \""+experience+"\", \""+score+"\", \""+classify+"\", \""+TeacherName+"\", 0);";
        boolean rs = jdbcUtil.UpdataDb(conn, statement, sql);
        if (rs) {
            conn.close();
            statement.close();
            return true;
        } else {
            return false;
        }
    }
}
