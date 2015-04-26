package ro.chronos.model;

public class Borrower {
    private String fullName;
    private int age;
    private Address residenceAddress;

    public Borrower(String fullName, int age, Address residenceAddress) {
        this.fullName = fullName;
        this.age = age;
        this.residenceAddress = residenceAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return residenceAddress;
    }
}
