package l3.jsonParser;

import java.util.Arrays;

public class Person {

    private String name;
    private String surname;
    private String[] phones;
    private String[] sites;
    private Address address;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String[] getPhones() {
        return phones;
    }
    public void setPhones(String[] phones) {
        this.phones = phones;
    }
    public String[] getSites() {
        return sites;
    }
    public void setSites(String[] sites) {
        this.sites = sites;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
                result.append("Query{" + "\n")
                        .append("name='" + name + "\n")
                        .append("surname='" + surname + "\n")
                        .append("phones=" + Arrays.toString(phones) + "\n")
                        .append("sites=" + Arrays.toString(sites) + "\n")
                        .append("address=" + address + "\n" + '}');
        return result.toString();

    }
}
