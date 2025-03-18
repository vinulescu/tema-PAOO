//Design classes to reflect relations between: Person, Tourist, Hotel, Address, City.
//Implement the following actions: change address for a Hotel/Person/Tourist, Tourist moves to
//another Hotel, get all hotels in a city, display all tourists in a city hotels, is a person accommodated in
//some city hotels ? display all persons and tourists

import java.util.ArrayList;
import java.util.List;

// Address class
class Address {
    private String street;
    private City city;
    private int zipCode;

    public Address(String street, City city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return street + ", " + city.getName() + " - " + zipCode;
    }
}

// City class
class City {
    private String name;
    private List<Hotel> hotels;

    public City(String name) {
        this.name = name;
        this.hotels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
}

// Abstract Person class
abstract class Person {
    protected String name;
    protected int age;
    protected Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
        System.out.println(name + " moved to " + newAddress);
    }
}

// Hotel class
class Hotel {
    private String name;
    private Address address;
    private List<Tourist> tourists;

    public Hotel(String name, Address address) {
        this.name = name;
        this.address = address;
        this.tourists = new ArrayList<>();
        address.getCity().addHotel(this);
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void addTourist(Tourist tourist) {
        tourists.add(tourist);
    }

    public void removeTourist(Tourist tourist) {
        tourists.remove(tourist);
    }

    public List<Tourist> getTourists() {
        return tourists;
    }
}

// Tourist class
class Tourist extends Person {
    private Hotel hotel;

    public Tourist(String name, int age, Address address, Hotel hotel) {
        super(name, age, address);
        this.hotel = hotel;
        hotel.addTourist(this);
    }

    public void moveToHotel(Hotel newHotel) {
        if (hotel != null) {
            hotel.removeTourist(this);
        }
        newHotel.addTourist(this);
        this.hotel = newHotel;
        System.out.println(name + " moved to " + newHotel.getName());
    }

    public boolean isAccommodatedInCity(City city) {
        return hotel.getAddress().getCity().equals(city);
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        // Create cities
        City bucharest = new City("Bucharest");
        City cluj = new City("Cluj");

        // Create addresses
        Address addr1 = new Address("Central Street", bucharest, 10001);
        Address addr2 = new Address("Green Avenue", cluj, 40010);

        // Create hotels
        Hotel grandHotel = new Hotel("Grand Hotel", addr1);
        Hotel luxuryHotel = new Hotel("Luxury Hotel", addr2);

        // Create tourists
        Tourist t1 = new Tourist("Alex", 30, addr1, grandHotel);
        Tourist t2 = new Tourist("Maria", 28, addr2, luxuryHotel);

        // Display hotels in a city
        System.out.println("Hotels in Bucharest:");
        for (Hotel h : bucharest.getHotels()) {
            System.out.println(h.getName());
        }

        // Display tourists in all hotels of a city
        System.out.println("Tourists in Bucharest hotels:");
        for (Hotel h : bucharest.getHotels()) {
            for (Tourist t : h.getTourists()) {
                System.out.println(t.name);
            }
        }

        // Move a tourist to another hotel
        t1.moveToHotel(luxuryHotel);

        // Check if a tourist is accommodated in a city's hotels
        System.out.println("Is Alex in Cluj hotels? " + t1.isAccommodatedInCity(cluj));
    }
}