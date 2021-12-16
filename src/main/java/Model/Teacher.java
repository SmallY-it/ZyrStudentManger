package Model;

public class Teacher {
    private int id;
    private String name;
    private String t_id;
    private String pwd;
    private String Image_addr;

    public Teacher() {
        super();
    }

    public Teacher(int id, String name, String t_id, String pwd, String image_addr) {
        this.id = id;
        this.name = name;
        this.t_id = t_id;
        this.pwd = pwd;
        Image_addr = image_addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImage_addr() {
        return Image_addr;
    }

    public void setImage_addr(String image_addr) {
        Image_addr = image_addr;
    }
}
