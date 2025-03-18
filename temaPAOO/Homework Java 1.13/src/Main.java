//Citiți un număr x dintr-un fișier și calculați valoarea 2*x. Pentru orice eroare
//posibilă, x are valoarea implicită 1. Afișati valoarea calculată. Organizați codul folosind excepții,
//metode, clase.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // Metodă pentru a citi un număr dintr-un fișier
    public static int citesteDinFisier(String numeFisier) {
        int x = 1; // Valoarea implicită în cazul unei erori
        try {
            BufferedReader br = new BufferedReader(new FileReader(numeFisier));
            String linie = br.readLine(); // Citește prima linie din fișier
            br.close();

            // Încercăm să convertim linia într-un număr întreg
            x = Integer.parseInt(linie);
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Eroare: Fișierul nu conține un număr valid. Folosim valoarea implicită.");
        }

        return x;
    }

    // Metodă pentru a calcula 2 * x
    public static int calculeaza2X(int x) {
        return 2 * x;
    }

    // Metoda principală pentru a organiza fluxul de execuție
    public static void main(String[] args) {
        String numeFisier = ".idea/numar.txt"; // Numele fișierului care conține numărul
        int x = citesteDinFisier(numeFisier); // Citim numărul din fișier
        int rezultat = calculeaza2X(x); // Calculăm 2 * x
        System.out.println("Valoarea calculată este: " + rezultat); // Afișăm rezultatul
    }
}