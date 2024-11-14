public class Main {
    public static void main(String[] args) {
        Point center = new Point(0, 0);
        
        Square square = new Square(center, 4, "red");
        System.out.println(square);

        square.stretch(2);
        System.out.println("После растяжения: " + square);

        square.compress(0.5);
        System.out.println("После сжатия: " + square);

        square.rotate(Math.PI / 2);

        square.changeColor("blue");
        System.out.println("После изменения цвета: " + square);
    }
}

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    @Override
    public String toString() {
        return "Segment{" + "start=" + start + ", end=" + end + '}';
    }
}

public class Square {
    private Point center;  // Центр квадрата
    private double side;   // Длина стороны квадрата
    private String color;  // Цвет квадрата

    public Square(Point center, double side, String color) {
        this.center = center;
        this.side = side;
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void stretch(double factor) {
        if (factor > 0) {
            this.side *= factor;
        }
    }

    public void compress(double factor) {
        if (factor > 0 && factor < 1) {
            this.side *= factor;
        }
    }

    public void rotate(double angle) {
        System.out.println("Квадрат повернут на угол " + Math.toDegrees(angle) + " градусов.");
    }

    public void changeColor(String newColor) {
        this.color = newColor;
    }

    @Override
    public String toString() {
        return "Square{" +
                "center=" + center +
                ", side=" + side +
                ", color='" + color + '\'' +
                '}';
    }
}
