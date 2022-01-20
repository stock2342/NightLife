package data;

public class User {
    protected String name;
    protected String numberPhone;
    protected String email;
    protected String password;

    public User(String name, String numberPhone, String email, String password) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyEmail(String email){
        return false;
        //TODO
    }
    public boolean verifyPassword(String password){
        return false;
        //TODO
    }
}
