package Model;

public class wxview {
    private String session_key;
    private String session_key_text;
    private String openid;
    private String openid_text;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getSession_key_text() {
        return session_key_text;
    }

    public void setSession_key_text(String session_key_text) {
        this.session_key_text = session_key_text;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenid_text() {
        return openid_text;
    }

    public void setOpenid_text(String openid_text) {
        this.openid_text = openid_text;
    }

    @Override
    public String toString() {
        return "wxview{" +
                "session_key='" + session_key + '\'' +
                ", session_key_text='" + session_key_text + '\'' +
                ", openid='" + openid + '\'' +
                ", openid_text='" + openid_text + '\'' +
                '}';
    }

    public wxview(String session_key, String session_key_text, String openid, String openid_text) {
        this.session_key = session_key;
        this.session_key_text = session_key_text;
        this.openid = openid;
        this.openid_text = openid_text;
    }
}
