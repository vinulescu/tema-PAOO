//(Opțional) Creați o clasă Car care are metodele: start(), accelerate(), stop(),
//getSpeed(), setSpeed(), startEngine(), stopEngine(). Care dintre ele sunt private/public/protected ?
//Care sunt atributele clasei ? Extindeți clasa Car la clasa MyCuteCar, adăugați-i acesteia un al doilea
//motor, de rachetă 😊 și o metodă startRocketEngine(). Investigați utilizarea metodelor din Car in
//clasa MyCuteCar. Investigați ce metode din clasa Car și MyCuteCar pot fi accesibile in main().

// Clasa de bază Car
class Car {
    private int speed;       // Viteza mașinii (privată)
    private boolean engineOn; // Motorul este pornit sau nu (privat)

    // Constructor
    public Car() {
        this.speed = 0;
        this.engineOn = false;
    }

    // Pornirea motorului
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("Motorul a fost pornit.");
        } else {
            System.out.println("Motorul este deja pornit.");
        }
    }

    // Oprirea motorului
    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            speed = 0; // Când oprim motorul, viteza devine 0
            System.out.println("Motorul a fost oprit.");
        } else {
            System.out.println("Motorul este deja oprit.");
        }
    }

    // Pornirea mașinii
    public void start() {
        if (engineOn) {
            System.out.println("Mașina a pornit.");
        } else {
            System.out.println("Trebuie să pornești motorul mai întâi!");
        }
    }

    // Accelerarea
    public void accelerate(int amount) {
        if (engineOn) {
            speed += amount;
            System.out.println("Mașina accelerează. Viteză actuală: " + speed + " km/h");
        } else {
            System.out.println("Nu poți accelera fără să pornești motorul.");
        }
    }

    // Oprirea mașinii
    public void stop() {
        speed = 0;
        System.out.println("Mașina s-a oprit.");
    }

    // Getter pentru viteză
    public int getSpeed() {
        return speed;
    }

    // Setter protejat pentru viteză (doar clasele derivate îl pot folosi)
    protected void setSpeed(int speed) {
        this.speed = speed;
    }
}

// Clasa derivată MyCuteCar
class MyCuteCar extends Car {
    private boolean rocketEngineOn; // Motorul de rachetă

    // Constructor
    public MyCuteCar() {
        super(); // Apelăm constructorul clasei de bază
        this.rocketEngineOn = false;
    }

    // Metodă pentru pornirea motorului de rachetă
    public void startRocketEngine() {
        if (!rocketEngineOn) {
            rocketEngineOn = true;
            setSpeed(500); // Setăm o viteză mare când motorul de rachetă e pornit
            System.out.println("Motorul de rachetă a fost pornit! Viteză actuală: " + getSpeed() + " km/h");
        } else {
            System.out.println("Motorul de rachetă este deja pornit.");
        }
    }
}

// Clasa principală cu metoda main()
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testăm clasa Car ===");
        Car myCar = new Car();
        myCar.startEngine();
        myCar.start();
        myCar.accelerate(30);
        System.out.println("Viteza actuală: " + myCar.getSpeed());
        myCar.stop();
        myCar.stopEngine();

        System.out.println("\n=== Testăm clasa MyCuteCar ===");
        MyCuteCar cuteCar = new MyCuteCar();
        cuteCar.startEngine();
        cuteCar.start();
        cuteCar.accelerate(50);
        cuteCar.startRocketEngine();
        System.out.println("Viteza finală: " + cuteCar.getSpeed());
        cuteCar.stop();
        cuteCar.stopEngine();
    }
}