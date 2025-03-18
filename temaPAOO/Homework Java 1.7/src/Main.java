//Proiectați diagramele UML si scrieți cod/eventual metode stub pentru Clasele
//Persoană, Companie, Angajat, Adresă. Acțiuni: move Employee to another company. add employees
//to company. display addresses of all employees working for a company at certain address. find a
//company by name and list all employees

import java.util.ArrayList;
import java.util.List;

// Clasa Address
class Address {
    private String street;
    private String city;
    private int zipCode;

    public Address(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + " - " + zipCode;
    }
}

// Clasa abstractă Person
abstract class Person {
    protected String name;
    protected int age;
    protected Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }
}

// Clasa Employee
class Employee extends Person {
    private int employeeId;
    private Company company;

    public Employee(String name, int age, Address address, int employeeId, Company company) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.company = company;
    }

    public void moveToCompany(Company newCompany) {
        if (company != null) {
            company.removeEmployee(this);
        }
        newCompany.addEmployee(this);
        this.company = newCompany;
        System.out.println(name + " s-a mutat la compania " + newCompany.getName());
    }

    public Company getCompany() {
        return company;
    }
}

// Clasa Company
class Company {
    private String name;
    private Address address;
    private List<Employee> employees;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Angajatul " + employee.getName() + " a fost adăugat la " + name);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println("Angajatul " + employee.getName() + " a fost eliminat din " + name);
    }

    public void displayEmployeeAddresses() {
        System.out.println("Adresele angajaților de la " + name + ":");
        for (Employee e : employees) {
            System.out.println(e.getName() + " - " + e.address);
        }
    }

    public static Company findCompanyByName(List<Company> companies, String name) {
        for (Company c : companies) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void listAllEmployees() {
        System.out.println("Angajații companiei " + name + ":");
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
}

// Clasa principală pentru testare
public class Main {
    public static void main(String[] args) {
        // Creăm adrese
        Address addr1 = new Address("Strada Principală", "București", 10001);
        Address addr2 = new Address("Strada Secundară", "Cluj", 40010);

        // Creăm companii
        Company companyA = new Company("TechCorp", addr1);
        Company companyB = new Company("SoftDev", addr2);

        // Creăm angajați
        Employee emp1 = new Employee("Alex Popescu", 30, addr1, 101, companyA);
        Employee emp2 = new Employee("Elena Ionescu", 28, addr2, 102, companyB);

        // Adăugăm angajați în companii
        companyA.addEmployee(emp1);
        companyB.addEmployee(emp2);

        // Afișăm adresele angajaților companiei A
        companyA.displayEmployeeAddresses();

        // Mutăm un angajat la altă companie
        emp1.moveToCompany(companyB);

        // Căutăm o companie după nume
        List<Company> companies = new ArrayList<>();
        companies.add(companyA);
        companies.add(companyB);

        Company foundCompany = Company.findCompanyByName(companies, "SoftDev");
        if (foundCompany != null) {
            foundCompany.listAllEmployees();
        } else {
            System.out.println("Compania nu a fost găsită.");
        }
    }
}