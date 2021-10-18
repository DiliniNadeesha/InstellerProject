package lk.insteller.ems.entity;

// According To Java BeanSpec:
public class Login implements SuperEntity {

    private int loginId;
    private String usertype;
    private String email;
    private String password;

    public Login(int loginId, String usertype, String email, String password) {
        this.loginId = loginId;
        this.usertype = usertype;
        this.email = email;
        this.password = password;
    }

    public Login() {
    }

    public int getLoginId() { return loginId; }

    public void setLoginId(int loginId) { this.loginId = loginId; }

    public String getUsertype() { return usertype; }

    public void setUsertype(String usertype) { this.usertype = usertype; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", usertype='" + usertype + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
