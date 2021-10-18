package lk.insteller.ems.dto;

public class LoginDTO {

    private int loginId;
    private String usertype;
    private String email;
    private String password;

    public LoginDTO(int loginId, String usertype, String email, String password) {
        this.loginId = loginId;
        this.usertype = usertype;
        this.email = email;
        this.password = password;
    }

    public LoginDTO() {
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
        return "LoginDTO{" +
                "loginId=" + loginId +
                ", usertype='" + usertype + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
