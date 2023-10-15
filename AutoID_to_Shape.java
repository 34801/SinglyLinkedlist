import java.util.Date;

class Shape {
    private static int shapeIDCounter = 1;
    private int shapeID;
    private Date creationTime;

    public Shape() {
        this.shapeID = shapeIDCounter++;
        this.creationTime = new Date();
    }

    public Shape(int shapeID, Date creationTime) {
        this.shapeID = shapeID;
        this.creationTime = creationTime;
    }

    public int getShapeID() {
        return shapeID;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    // Overriding toString method to display shape details
    @Override
    public String toString() {
        return "Shape ID: " + shapeID + "\nCreation Time: " + creationTime;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width = width;
    }

    // Add setters and getters for Rectangle-specific properties
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Override toString method for Rectangle
    @Override
    public String toString() {
        return super.toString() + "\nType: Rectangle\nLength: " + length + "\nWidth: " + width;
    }
}

class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        super();
        this.sideLength = sideLength;
    }

    // Add setters and getters for Square-specific properties
    public double getSideLength() {
        return sideLength;
    }

    // Override toString method for Square
    @Override
    public String toString() {
        return super.toString() + "\nType: Square\nSide Length: " + sideLength;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }

    // Add setters and getters for Triangle-specific properties
    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    // Override toString method for Triangle
    @Override
    public String toString() {
        return super.toString() + "\nType: Triangle\nBase: " + base + "\nHeight: " + height;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create shapes
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        Square square = new Square(4.0);
        Triangle triangle = new Triangle(6.0, 4.0);

        // Display shape details
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
        System.out.println(triangle.toString());
    }
}
