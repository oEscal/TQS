package geocoding;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Objects;

public class Address {

    final String houseNumber;
    final String road;
    final String city;
    final String state;
    final String zip;

    public Address(String houseNumber, String road, String city, String state, String zip) {
        this.houseNumber = houseNumber;
        this.road = road;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", road='" + road + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, road, city, state, zip);
    }

    @Override
    public boolean equals(Object other) {
        Address compare = (Address) other;

        return new EqualsBuilder()
                .append(compare.state, this.state)
                .append(compare.city, this.city)
                .append(compare.road, this.road)
                .append(compare.houseNumber, compare.houseNumber)
                .append(compare.zip, this.zip)
                .isEquals();
        //return (compare.state == null && this.state == null || compare.state.equals(this.state)) &&
        //        (compare.city == null && this.city == null || compare.city.equals(this.city)) &&
        //        (compare.road == null && this.road == null || compare.road.equals(this.road)) &&
        //        (compare.houseNumber == null && this.houseNumber == null || compare.houseNumber.equals(this.houseNumber)) &&
        //        (compare.zip == null && this.zip == null || compare.zip.equals(this.zip));
    }
}
