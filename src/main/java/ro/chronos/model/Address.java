package ro.chronos.model;

public class Address {
    private String streetName;
    private int streetNumber;
    private String city;
    private String country;

    public Address(String streetName, int streetNumber, String city,
            String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
