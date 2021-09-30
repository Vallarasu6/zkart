package z;

public class Register {
    private String email;
    private String name;
    private long mobile;
    private String password;

    public Register(String email, String name, long mobile, String password) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Register{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", password='" + password + '\'' +
                '}';
    }
}
