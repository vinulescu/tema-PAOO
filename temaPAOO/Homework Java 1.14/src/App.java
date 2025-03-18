//Modificați Exemplul 1.14 astfel încât utilizatorul să repete citirea unei valori
//numerice până aceasta este număr întreg.

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    // Metodă pentru a citi un număr întreg de la utilizator
    int readNumber() throws InputMismatchException {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    // Metoda principală
    public static void main(String[] args) {
        App app1 = new App();
        Integer nr, sum;
        sum = 0;

        // Citim primul număr cu validare
        nr = app1.getValidNumber();
        sum += nr;

        // Citim al doilea număr cu validare
        nr = app1.getValidNumber();
        sum += nr;

        System.out.println("Suma: " + sum);
    }

    // Metoda pentru a citi un număr întreg valid
    public int getValidNumber() {
        Scanner in = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        // Continuăm să cerem un număr valid până când utilizatorul introduce un număr întreg
        while (!validInput) {
            try {
                System.out.print("Introduceți un număr întreg: ");
                number = readNumber();  // Citim numărul
                validInput = true;  // Dacă nu s-a aruncat excepția, considerăm că inputul este valid
            } catch (InputMismatchException ex) {
                System.err.println("Valoare incorectă! Vă rugăm să introduceți un număr întreg.");
                in.next();  // Consumăm inputul invalid pentru a evita blocarea scanner-ului
            }
        }
        return number;
    }
}
