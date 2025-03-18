//Folosiți codul de la Exemplul 1.11 într-o metodă care are ca parametru int x și
//returnează 10/x. Metoda trebuie sa returneze rezultatul operatiei si sa anunte situatia unei impartiti
//la 0. Apelați metoda. Metoda tratează excepția în corpul ei sau o aruncă, la declarare. Observați
//diferența de abordare. Care este mai flexibilă ?


class Exemplu {

    // Abordarea 1: Tratăm excepțiile în corpul metodei (cu try-catch)
    public static double imparteTratamentLocal(int x) {
        double b = 0; // Valoarea implicită a lui b

        try {
            b = 10 / x; // Împărțirea
        } catch (ArithmeticException e) {
            System.out.println("Impartire prin 0. b=0");
            b = 0; // Setăm b la 0 în caz de eroare
            e.printStackTrace(); // Detaliile excepției
        } catch (Exception e) {
            b = -1; // Valoare în caz de alt tip de excepție
            System.out.println("Eroare generala");
            e.printStackTrace(); // Detaliile excepției
        }

        return b; // Returnăm rezultatul final
    }

    // Abordarea 2: Aruncăm excepțiile la nivelul metodei (cu throws)
    public static double imparteAruncareExceptie(int x) throws ArithmeticException, Exception {
        if (x == 0) {
            throw new ArithmeticException("Impartire prin 0.");
        }
        return 10 / x; // Împărțirea
    }

    public static void main(String[] args) {
        // Testăm prima metodă cu tratarea excepțiilor în corpul metodei
        System.out.println("Rezultatul pentru x = 2 (tratament local): " + imparteTratamentLocal(2));  // Valid
        System.out.println("Rezultatul pentru x = 0 (tratament local): " + imparteTratamentLocal(0));  // Eroare împărțire la 0
        System.out.println("Rezultatul pentru x = 5 (tratament local): " + imparteTratamentLocal(5));  // Valid

        // Testăm a doua metodă cu aruncarea excepțiilor la nivelul metodei
        try {
            System.out.println("Rezultatul pentru x = 2 (aruncare exceptie): " + imparteAruncareExceptie(2));  // Valid
            System.out.println("Rezultatul pentru x = 0 (aruncare exceptie): " + imparteAruncareExceptie(0));  // Eroare împărțire la 0
            System.out.println("Rezultatul pentru x = 5 (aruncare exceptie): " + imparteAruncareExceptie(5));  // Valid
        } catch (ArithmeticException e) {
            System.out.println("Eroare: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Eroare generala: " + e.getMessage());
        }
    }
}