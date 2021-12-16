package Model;

public class StdentInfo {
    private int id;
    private String username;
    private String sex;
    private String city;
    private String experience;
    private String score;
    private String classify;
    private String TeacherName;

    public StdentInfo() {
        super();
    }

    public StdentInfo(int id, String username, String sex, String city, String experience, String score, String classify,String TeacherName) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.city = city;
        this.experience = experience;
        this.score = score;
        this.TeacherName=TeacherName;
        this.classify = classify;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", username:" + username +
                ", sex:" + sex +
                ", city:" + city +
                ", experience:" + experience +
                ", score:" + score +
                ", classify:" + classify +
                "},";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
}

