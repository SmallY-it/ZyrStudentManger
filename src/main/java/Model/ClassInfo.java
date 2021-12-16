package Model;

public class ClassInfo {
    private int Id;
    private String ClassName;
    private String ClassTeacher;
    private String ClassYer;
    private int Class_size;

    public ClassInfo() {

    }
    public ClassInfo(int id, String className, String classTeacher, String classYer, int class_size) {
        Id = id;
        ClassName = className;
        ClassTeacher = classTeacher;
        ClassYer = classYer;
        Class_size = class_size;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getClassTeacher() {
        return ClassTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        ClassTeacher = classTeacher;
    }

    public String getClassYer() {
        return ClassYer;
    }

    public void setClassYer(String classYer) {
        ClassYer = classYer;
    }

    public int getClass_size() {
        return Class_size;
    }

    public void setClass_size(int class_size) {
        Class_size = class_size;
    }
}
