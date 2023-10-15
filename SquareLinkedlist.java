import java.util.Date;

class Square {
    private double side;
    private Date creationDateTime;

    public Square() {
        this.side = 1.0;
        this.creationDateTime = new Date();
    }

    public Square(double side) {
        this.side = side;
        this.creationDateTime = new Date();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    @Override
    public String toString() {
        return "Square { " +
               "Side: " + side +
               ", Area: " + getArea() +
               ", Created on: " + creationDateTime +
               " }";
    }
}

class Node {
    Square data;
    Node next;

    public Node(Square square) {
        this.data = square;
        this.next = null;
    }
}

class SquareLinkedList {
    private Node head;
    private int size;

    public SquareLinkedList() {
        head = null;
        size = 0;
    }

    public void addSquare(Square square) {
        Node newNode = new Node(square);
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
        StringBuilder result = new StringBuilder("SquareLinkedList { ");
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
        Square square1 = new Square(5.0);
        Square square2 = new Square(7.0);
        Square square3 = new Square(3.0);

        SquareLinkedList squareList = new SquareLinkedList();
        squareList.addSquare(square1);
        squareList.addSquare(square2);
        squareList.addSquare(square3);

        System.out.println("Square List:");
        System.out.println(squareList);

        System.out.println("Total number of squares in the list: " + squareList.getSize());
    }
}
