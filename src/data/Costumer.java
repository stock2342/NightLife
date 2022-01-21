package data;

import java.time.LocalDate;

public class Costumer extends User{
    private String userName;
    private LocalDate birthDate;
    private String idNumber;

    public Costumer(String name, String numberPhone, String email, String password, String userName, LocalDate birthDate, String idNumber) {
        super(name, numberPhone, email, password);
        this.userName = userName;
        this.birthDate = birthDate;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Costumer, " +  super.toString() + ", " + userName + ", " + birthDate + ", " + idNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean verifyAge(String age){
        return Integer.parseInt(age) >= 18;
    }
}
