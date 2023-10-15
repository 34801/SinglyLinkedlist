import java.util.Date;

// Abstract Shape class with a draw method
abstract class Shape {
    private Date creationDateTime;

    public Shape() {
        this.creationDateTime = new Date();
    }

    public abstract double getArea();
    public abstract String draw();

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    @Override
    public String toString() {
        return "Created on: " + creationDateTime;
    }
}

// Square class
class Square extends Shape {
    private double side;

    public Square() {
        this.side = 1.0;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String draw() {
        return "Drawing a square";
    }

    @Override
    public String toString() {
        return "Square { " +
               "Side: " + side +
               ", Area: " + getArea() +
               ", " + super.toString() +
               " }";
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 2.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String draw() {
        return "Drawing a rectangle";
    }

    @Override
    public String toString() {
        return "Rectangle { " +
               "Width: " + width +
               ", Height: " + height +
               ", Area: " + getArea() +
               ", " + super.toString() +
               " }";
    }
}

// Triangle class
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle() {
        this.base = 2.0;
        this.height = 1.0;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String draw() {
        return "Drawing a triangle";
    }

    @Override
    public String toString() {
        return "Triangle { " +
               "Base: " + base +
               ", Height: " + height +
               ", Area: " + getArea() +
               ", " + super.toString() +
               " }";
    }
}

class Node {
    Shape data;
    Node next;

    public Node(Shape shape) {
        this.data = shape;
        this.next = null;
    }
}

class ShapeLinkedList {
    private Node head;
    private int size;

    public ShapeLinkedList() {
        head = null;
        size = 0;
    }

    public void addShape(Shape shape) {
        Node newNode = new Node(shape);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ShapeLinkedList { ");
        Node current = head;
        while (current != null) {
            result.append(current.data.toString());
            if (current.next != null) {
                result.append(" -> ");
            }
            current = current.next;
        }
        result.append(" }");
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeLinkedList shapeList = new ShapeLinkedList();

        for (int i = 0; i < 100; i++) {
            int rand = (int)(Math.random() * 3);
            Shape shape;

            if (rand == 0) {
                shape = new Square(Math.random() * 10);
            } else if (rand == 1) {
                shape = new Rectangle(Math.random() * 10, Math.random() * 10);
            } else {
                shape = new Triangle(Math.random() * 10, Math.random() * 10);
            }

            shapeList.addShape(shape);
        }

        System.out.println("Shape List:");
        System.out.println(shapeList);

        System.out.println("Total number of shapes in the list: " + shapeList.getSize());
    }
}
