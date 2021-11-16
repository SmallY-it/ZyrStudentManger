package Servlce;

import Model.Teacher;
import java.sql.SQLException;
import java.util.List;

public interface DatabasesInterface {
     List getdata(String name) throws SQLException;
    Teacher TeacherLogin(String T_id,String T_pwd) throws SQLException;
    boolean delete(String id, String username ,String experience) throws SQLException;
}
