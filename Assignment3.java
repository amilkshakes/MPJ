// Part 1: Constructor and Method Overloading
class Shapes {
    double area;

    // Constructor Overloading: Square
    Shapes(double side) {
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    // Constructor Overloading: Rectangle
    Shapes(double length, double width) {
        area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }

    // Method Overloading
    void findArea(double radius) {
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

// Part 2: Method Overriding
class Hillstations {
    void famousfood() { System.out.println("Local street food"); }
    void famousfor() { System.out.println("Natural Beauty"); }
}

class Manali extends Hillstations {
    @Override
    void famousfood() { System.out.println("Manali: Siddu and Trout"); }
    @Override
    void famousfor() { System.out.println("Manali: Snow and Adventure"); }
}

class Mussoorie extends Hillstations {
    @Override
    void famousfood() { System.out.println("Mussoorie: Aloo Ke Gutke"); }
    @Override
    void famousfor() { System.out.println("Mussoorie: The Mall Road"); }
}

public class Assignment3 {
    public static void main(String[] args) {
        // Polymorphism via Overloading
        new Shapes(5.0);
        new Shapes(4.0, 6.0);

        // Polymorphism via Overriding (Runtime Polymorphism)
        Hillstations place; 
        
        place = new Manali();
        place.famousfood(); // Calls Manali's version [cite: 8]
        
        place = new Mussoorie();
        place.famousfor(); // Calls Mussoorie's version [cite: 8]
    }
}