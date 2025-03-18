//Suprascrieți toString() dintr-o clasă astfel încât să returneze toate atributele
//clasei, într-un format custom.

// Clasa Car
class Car {
    private String brand;
    private String model;
    private int year;
    private double speed;

    // Constructor
    public Car(String brand, String model, int year, double speed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = speed;
    }

    // Suprascrierea metodei toString()
    @Override
    public String toString() {
        return "Mașină: " + brand + " " + model + "\n" +
                "An fabricație: " + year + "\n" +
                "Viteză maximă: " + speed + " km/h";
    }

    public static void main(String[] args) {
        // Creăm un obiect Car
        Car myCar = new Car("Volkswagen", "Polo", 2018, 200.0);

        // Afișăm obiectul (se va apela automat toString())
        System.out.println(myCar);
    }
}