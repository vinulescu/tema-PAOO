// Clasa A - Clasa de bază
class A {
    protected int x;

    // Constructor
    public A(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void displayX() {
        System.out.println("Metoda din A - Valoarea lui x: " + x);
    }

    public void readX() {
        System.out.println("Citesc x: " + x);
    }
}

// Clasa B - Extinde A
class B extends A {
    protected String s;

    // Constructor
    public B(int x, String s) {
        super(x); // Apelăm constructorul lui A
        this.s = s;
    }

    public void readS() {
        System.out.println("Valoarea lui s: " + s);
    }

    @Override
    public void displayX() {
        super.displayX(); // Apelăm metoda originală din A
        System.out.println("Metodă suprascrisă displayX() în B. x: " + x);
    }
}

// Clasa C - Extinde B
class C extends B {
    protected float y;

    // Constructor
    public C(int x, String s, float y) {
        super(x, s); // Apelăm constructorul lui B
        this.y = y;
    }

    public void readY() {
        System.out.println("Citesc y: " + y);
    }

    public void displayXYS() {
        System.out.println("Afișez valorile:");
        displayX(); // Apelăm metoda suprascrisă displayX() din B
        System.out.println("Valoarea lui x prin getX(): " + getX()); // Folosim getX()
        readX();    // Apelăm readX() din A
        readS();    // Apelăm readS() din B
        readY();    // Apelăm readY() din C
    }
}

// Clasa principală cu metoda main()
public class Main {
    public static void main(String[] args) {
        // Creăm un obiect de tip C
        C obj = new C(10, "Salut", 5.5f);

        // Apelăm metodele din toate clasele
        obj.readY();      // Metoda din C
        obj.readS();      // Metoda din B
        obj.readX();      // Metoda din A
        obj.displayX();   // Apelăm metoda suprascrisă din B (care și apelează pe cea din A)
        obj.displayXYS(); // Apelăm metoda care le folosește pe toate
    }
}
