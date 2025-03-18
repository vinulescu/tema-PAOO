//Scrieți codul aferent următoarelor
//clase și generați o diagramă UML corespunzătoare.
//Creați o interfață Shape (atribut culoare și metodă
//getPerimetru). Extindeți interfața la clasa abstractă
//Shape2D (metodă abstractă getAria) respectiv Shape3D
//(metodă abstractă getVolum). Implementați Shape în clasa segmentDeDreapta (un segment de
//dreaptă din geometrie). Extindeți Shape2D și Shape3D la pătrat, cerc respectiv sferă și cub. Efectuați
//modificările necesare elementelor claselor pentru a afișa:
//1. Lungimea segmentului de dreaptă
//2. Considerând o listă în care se află pătrate si cercuri, calculați perimetrul lor
//3. Considerând o listă în care se află pătrate si cercuri, sfere și cuburi, calculați aria lor
//4. Considerând o listă în care se află sfere și cuburi, calculați volumul lor

import java.util.List;

// Interfața Shape
interface Shape {
    String getCuloare();
    double getPerimetru();
}

// Clasa abstractă Shape2D (extinde Shape și adaugă metoda getAria)
abstract class Shape2D implements Shape {
    protected String culoare;

    public Shape2D(String culoare) {
        this.culoare = culoare;
    }

    public String getCuloare() {
        return culoare;
    }

    public abstract double getAria();
}

// Clasa abstractă Shape3D (extinde Shape și adaugă metoda getVolum)
abstract class Shape3D implements Shape {
    protected String culoare;

    public Shape3D(String culoare) {
        this.culoare = culoare;
    }

    public String getCuloare() {
        return culoare;
    }

    public abstract double getVolum();
}

// Clasa SegmentDeDreapta (extinde Shape)
class SegmentDeDreapta implements Shape {
    private double lungime;
    private String culoare;

    public SegmentDeDreapta(double lungime, String culoare) {
        this.lungime = lungime;
        this.culoare = culoare;
    }

    public String getCuloare() {
        return culoare;
    }

    public double getPerimetru() {
        return lungime;
    }

    public double getLungime() {
        return lungime;
    }
}

// Clasa Patrat (extinde Shape2D)
class Patrat extends Shape2D {
    private double latura;

    public Patrat(double latura, String culoare) {
        super(culoare);
        this.latura = latura;
    }

    public double getAria() {
        return latura * latura;
    }

    public double getPerimetru() {
        return 4 * latura;
    }
}

// Clasa Cerc (extinde Shape2D)
class Cerc extends Shape2D {
    private double raza;

    public Cerc(double raza, String culoare) {
        super(culoare);
        this.raza = raza;
    }

    public double getAria() {
        return Math.PI * raza * raza;
    }

    public double getPerimetru() {
        return 2 * Math.PI * raza;
    }
}

// Clasa Sfera (extinde Shape3D)
class Sfera extends Shape3D {
    private double raza;

    public Sfera(double raza, String culoare) {
        super(culoare);
        this.raza = raza;
    }

    public double getVolum() {
        return (4.0 / 3.0) * Math.PI * Math.pow(raza, 3);
    }

    public double getPerimetru() {
        return 2 * Math.PI * raza;
    }
}

// Clasa Cub (extinde Shape3D)
class Cub extends Shape3D {
    private double latura;

    public Cub(double latura, String culoare) {
        super(culoare);
        this.latura = latura;
    }

    public double getVolum() {
        return Math.pow(latura, 3);
    }

    public double getPerimetru() {
        return 12 * latura;
    }
}

// Clasa Main pentru calcule

public class Main {
    public static void main(String[] args) {
        // Crearea obiectelor
        SegmentDeDreapta segment = new SegmentDeDreapta(5, "Albastru");
        Patrat patrat = new Patrat(4, "Rosu");
        Cerc cerc = new Cerc(3, "Verde");
        Sfera sfera = new Sfera(2, "Galben");
        Cub cub = new Cub(3, "Portocaliu");

        // Exemplu pentru SegmentDeDreapta
        System.out.println("Lungimea segmentului de dreapta: " + segment.getLungime());

        // Exemplu pentru perimetrul formelor Shape
        List<Shape> forme = List.of(patrat, cerc, segment);
        double perimetruTotal = calculeazaPerimetru(forme);
        System.out.println("Perimetrul total al formelor (Patrat, Cerc, Segment): " + perimetruTotal);

        // Exemplu pentru aria formelor 2D (Shape2D)
        List<Shape2D> forme2D = List.of(patrat, cerc);
        double ariaTotala = calculeazaAria(forme2D);
        System.out.println("Aria totală a formelor 2D (Patrat, Cerc): " + ariaTotala);

        // Exemplu pentru volumul formelor 3D (Shape3D)
        List<Shape3D> forme3D = List.of(sfera, cub);
        double volumTotal = calculeazaVolum(forme3D);
        System.out.println("Volumul total al formelor 3D (Sfera, Cub): " + volumTotal);

        // Arătați detalii pentru fiecare formă
        System.out.println("\nDetalii formă:");
        System.out.println("Patrat - Culoare: " + patrat.getCuloare() + ", Latura: " + patrat.getAria() + ", Perimetru: " + patrat.getPerimetru());
        System.out.println("Cerc - Culoare: " + cerc.getCuloare() + ", Raza: " + cerc.getAria() + ", Perimetru: " + cerc.getPerimetru());
        System.out.println("Sfera - Culoare: " + sfera.getCuloare() + ", Raza: " + sfera.getVolum() + ", Volum: " + sfera.getVolum());
        System.out.println("Cub - Culoare: " + cub.getCuloare() + ", Latura: " + cub.getVolum() + ", Volum: " + cub.getVolum());
    }

    // Funcția care calculează perimetrul pentru formele de tip Shape
    public static double calculeazaPerimetru(List<Shape> forme) {
        double perimetruTotal = 0;
        for (Shape forma : forme) {
            perimetruTotal += forma.getPerimetru();
        }
        return perimetruTotal;
    }

    // Funcția care calculează aria pentru formele 2D (Shape2D)
    public static double calculeazaAria(List<Shape2D> forme2D) {
        double ariaTotala = 0;
        for (Shape2D forma : forme2D) {
            ariaTotala += forma.getAria();
        }
        return ariaTotala;
    }

    // Funcția care calculează volumul pentru formele 3D (Shape3D)
    public static double calculeazaVolum(List<Shape3D> forme3D) {
        double volumTotal = 0;
        for (Shape3D forma : forme3D) {
            volumTotal += forma.getVolum();
        }
        return volumTotal;
    }
}