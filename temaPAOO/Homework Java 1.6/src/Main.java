//Proiectați diagramele UML si scrieți cod/eventual metode stub pentru Clasele
//Persoană, Adresă, Profesor, Student, Curs și următoarele metode: addStudentToCourse,
//removeStudentFromCourse, addTeacherToCourse, RemoveTeacherFromCourse,
//changeTeacherAddress, ChangeStudentAddress, createNewCourse from list of students and teacher.

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

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
        System.out.println(name + " și-a schimbat adresa la: " + newAddress);
    }
}

// Clasa Student
class Student extends Person {
    private int studentId;

    public Student(String name, int age, Address address, int studentId) {
        super(name, age, address);
        this.studentId = studentId;
    }
}

// Clasa Professor
class Professor extends Person {
    private int teacherId;

    public Professor(String name, int age, Address address, int teacherId) {
        super(name, age, address);
        this.teacherId = teacherId;
    }
}

// Clasa Course
class Course {
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name, Professor professor, List<Student> students) {
        this.name = name;
        this.professor = professor;
        this.students = new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Studentul " + student.name + " a fost adăugat la cursul " + name);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        System.out.println("Studentul " + student.name + " a fost eliminat din cursul " + name);
    }

    public void addTeacher(Professor professor) {
        this.professor = professor;
        System.out.println("Profesorul " + professor.name + " predă acum cursul " + name);
    }

    public void removeTeacher() {
        System.out.println("Profesorul " + professor.name + " a fost eliminat din cursul " + name);
        this.professor = null;
    }

    public static Course createNewCourse(String name, Professor professor, List<Student> students) {
        return new Course(name, professor, students);
    }
}

// Clasa principală cu metoda main()
public class Main {
    public static void main(String[] args) {
        // Creăm adrese
        Address addr1 = new Address("Strada Victoriei", "București", 10010);
        Address addr2 = new Address("Strada Universității", "Cluj", 40020);

        // Creăm un profesor
        Professor prof = new Professor("Dr. Popescu", 45, addr1, 101);

        // Creăm studenți
        Student s1 = new Student("Maria Ionescu", 20, addr2, 1001);
        Student s2 = new Student("Andrei Radu", 22, addr2, 1002);

        // Creăm o listă de studenți
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        // Creăm un curs
        Course javaCourse = Course.createNewCourse("Java Programming", prof, studentList);

        // Adăugăm și eliminăm studenți
        Student s3 = new Student("Elena Mihai", 21, addr2, 1003);
        javaCourse.addStudent(s3);
        javaCourse.removeStudent(s1);

        // Schimbăm adresa unui student
        Address newAddress = new Address("Strada Nouă", "Iași", 70030);
        s2.changeAddress(newAddress);

        // Schimbăm profesorul cursului
        Address profNewAddress = new Address("Strada Profesorilor", "Timișoara", 30040);
        prof.changeAddress(profNewAddress);

        // Eliminăm profesorul
        javaCourse.removeTeacher();
    }
}