import java.util.Scanner;

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double s = perimeter() / 2.0; // полупериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // формула Герона
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter width and height for rectangle:");
            double w = sc.nextDouble();
            double h = sc.nextDouble();
            Rectangle r = new Rectangle(w, h);
            System.out.println("Rectangle area: " + r.area() + ", perimeter: " + r.perimeter());

            System.out.println("Enter radius for circle:");
            double rad = sc.nextDouble();
            Circle c = new Circle(rad);
            System.out.println("Circle area: " + c.area() + ", perimeter: " + c.perimeter());

            System.out.println("Enter three sides for triangle:");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c1 = sc.nextDouble();
            Triangle t = new Triangle(a, b, c1);
            System.out.println("Triangle area: " + t.area() + ", perimeter: " + t.perimeter());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
