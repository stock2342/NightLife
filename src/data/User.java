package data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public String toString() {
        return email + ", " + password  + ", " + name + ", " + numberPhone;
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
        String regex = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean verifyPassword(String password){
        if(password.length() < 8) return false;

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digits = false;
        boolean symbols = false;

        for(int i = 0; i<password.length(); i++){
            char car = password.charAt(i);
            if(Character.isWhitespace(car))
                return false;
            if(Character.isUpperCase(car))
                upperCase = true;
            if(Character.isLowerCase(car))
                lowerCase = true;
            if(Character.isDigit(car))
                digits = true;
            if(!Character.isDigit(car) && !Character.isLetter(car) && !Character.isWhitespace(car))
                symbols = true;
        }
        int conditions = 0;
        if(upperCase)
            conditions++;
        if(lowerCase)
            conditions++;
        if(digits)
            conditions++;
        if(symbols)
            conditions++;

        return conditions >= 3;
    }
}
