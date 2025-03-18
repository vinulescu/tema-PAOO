//Implementați diagramă UML Figure
//1. 5 Clasa Robot. Folosiți metode stub. Instanțiați clasa
//Robot și investigați apelarea tuturor metodele.

// Interfața Device
interface Device {
    void on();
    void off();
}

// Interfața Computer
interface Computer {
    void boot();
}

// Interfața Mechanism
interface Mechanism {
    void move();
}

// Clasa Robot care implementează toate interfețele
class Robot implements Device, Computer, Mechanism {

    @Override
    public void on() {
        System.out.println("Robot powered ON.");
    }

    @Override
    public void off() {
        System.out.println("Robot shutting OFF.");
    }

    @Override
    public void boot() {
        System.out.println("Robot booting up.");
    }

    @Override
    public void move() {
        System.out.println("Robot is moving.");
    }
}

// Clasa Main pentru testare
public class Main {
    public static void main(String[] args) {
        // Instanțierea unui robot
        Robot r1 = new Robot();

        // Apelarea metodelor
        r1.on();
        r1.boot();
        r1.move();
        r1.off();
    }
}
