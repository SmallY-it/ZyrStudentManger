package Model;


import java.util.ArrayList;
import java.util.List;

public class StudentMainInfo {
    private int code;
    private String msg;
    private int count;
    private List<StdentInfo> list =new ArrayList<StdentInfo>();
    public List<StdentInfo> getList() {
        return list;
    }

    public void setList(List<StdentInfo> list) {
        this.list = list;
    }


    public StudentMainInfo(int code, String msg, int count, List<StdentInfo> list) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.list = list;
    }

    public int  getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        StdentInfo stdentInfo=new StdentInfo(10086,"杨绍张","男","云南保山","533022111101110123","2020","计算机科学与技术");
        //Head head=new Head(,"",100,stdentInfo);
        //System.out.println(head.toString());
    }
}
