package data;

public class Establishment extends User{
    private String cityName;
    private String typeOfEstablishment;

    public Establishment(String name, String numberPhone, String email, String password, String cityName, String typeOfEstablishment) {
        super(name, numberPhone, email, password);
        this.cityName = cityName;
        this.typeOfEstablishment = typeOfEstablishment;
    }

    @Override
    public String toString() {
        return super.toString() + ", establishment, " +  cityName + ", " + typeOfEstablishment;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTypeOfEstablishment() {
        return typeOfEstablishment;
    }

    public void setTypeOfEstablishment(String typeOfEstablishment) {
        this.typeOfEstablishment = typeOfEstablishment;
    }
}
