//Rezolvați ecuația ax+b=0 în toate cazurile folosind clase, null, Exceptii, Excepții
//Custom. (Opțional) Folosiți Optional 😊

import java.util.Optional;
import java.util.Scanner;

// Excepția personalizată pentru cazurile când ecuația nu are soluție
class EcuațieFărăSoluțieException extends Exception {
    public EcuațieFărăSoluțieException(String mesaj) {
        super(mesaj);
    }
}

// Clasa care reprezintă ecuația ax + b = 0
class Ecuație {

    // Coeficientii a si b
    private double a;
    private double b;

    // Constructorul clasei
    public Ecuație(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Metodă pentru rezolvarea ecuației
    public Optional<Double> rezolva() throws EcuațieFărăSoluțieException {
        // Cazul 1: Dacă a este 0 și b este diferit de 0, ecuația nu are soluție
        if (a == 0 && b != 0) {
            throw new EcuațieFărăSoluțieException("Ecuația nu are soluție, deoarece a = 0 și b ≠ 0");
        }

        // Cazul 2: Dacă a este 0 și b este 0, ecuația are infinit de multe soluții
        if (a == 0 && b == 0) {
            System.out.println("Ecuația are infinit de multe soluții.");
            return Optional.empty(); // Nu există o soluție unică
        }

        // Cazul 3: Dacă a este diferit de 0, putem rezolva ecuația
        double solutie = -b / a;
        return Optional.of(solutie);
    }

    // Getteri pentru coeficienți
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}

// Clasa principală
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citim coeficientii a si b de la utilizator
        System.out.print("Introduceți coeficientul a: ");
        double a = scanner.nextDouble();
        System.out.print("Introduceți coeficientul b: ");
        double b = scanner.nextDouble();

        // Creăm instanța ecuației
        Ecuație ecuație = new Ecuație(a, b);

        try {
            // Încercăm să rezolvăm ecuația
            Optional<Double> solutie = ecuație.rezolva();

            // Verificăm dacă există soluție
            solutie.ifPresentOrElse(
                    s -> System.out.println("Soluția ecuației este: " + s),
                    () -> System.out.println("Nu există o soluție unică.")  // În caz de soluție neexistentă
            );
        } catch (EcuațieFărăSoluțieException ex) {
            System.err.println(ex.getMessage());
        }

        scanner.close();
    }
}
