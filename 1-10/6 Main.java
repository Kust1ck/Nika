
Class Main
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем квадрат с корректными данными
            Point center = new Point(0, 0);
            Square square = new Square(center, 4, "red");
            System.out.println("Изначальный квадрат: " + square);

            // Попытка растяжения с недопустимым фактором
            try {
                square.stretch(-2);
            } catch (InvalidFactorException e) {
                System.err.println(e.getMessage());
            }

            // Попытка сжатия с недопустимым фактором
            try {
                square.compress(2);
            } catch (InvalidFactorException e) {
                System.err.println(e.getMessage());
            }

            // Изменение цвета и вывод
            square.changeColor("blue");
            System.out.println("После изменения цвета: " + square);

            // Сохранение в файл и чтение из файла
            square.saveToFile("square.txt");
            Square squareFromFile = Square.readFromFile("square.txt");
            System.out.println("Квадрат из файла: " + squareFromFile);

            // Обработка нехватки памяти
            Square.createLargeArray();

        } catch (InvalidSideException | IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}

Class Point
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

Class Square
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Square {
    private Point center;  // Центр квадрата
    private double side;   // Длина стороны квадрата
    private String color;  // Цвет квадрата

    public Square(Point center, double side, String color) throws InvalidSideException {
        if (side <= 0) {
            throw new InvalidSideException("Сторона квадрата должна быть больше нуля.");
        }
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

    public void setSide(double side) throws InvalidSideException {
        if (side <= 0) {
            throw new InvalidSideException("Сторона квадрата должна быть больше нуля.");
        }
        this.side = side;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Растяжение квадрата
    public void stretch(double factor) throws InvalidFactorException {
        if (factor <= 0) {
            throw new InvalidFactorException("Фактор растяжения должен быть больше нуля.");
        }
        this.side *= factor;
    }

    // Сжатие квадрата
    public void compress(double factor) throws InvalidFactorException {
        if (factor <= 0 || factor >= 1) {
            throw new InvalidFactorException("Фактор сжатия должен быть больше 0 и меньше 1.");
        }
        this.side *= factor;
    }

    // Поворот квадрата на угол (в радианах)
    public void rotate(double angle) {
        System.out.println("Квадрат повернут на угол " + Math.toDegrees(angle) + " градусов.");
    }

    // Изменение цвета квадрата
    public void changeColor(String newColor) {
        this.color = newColor;
    }

    // Запись данных о квадрате в файл
    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(center.getX() + "," + center.getY() + "," + side + "," + color);
        }
    }


    // Чтение данных о квадрате из файла
    public static Square readFromFile(String fileName) throws IOException, InvalidSideException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] data = reader.readLine().split(",");
            double x = Double.parseDouble(data[0]);  // Чтение координаты X центра
            double y = Double.parseDouble(data[1]);  // Чтение координаты Y центра
            double side = Double.parseDouble(data[2]);  // Чтение длины стороны
            String color = data[3];  // Чтение цвета
            Point center = new Point(x, y);  // Создание объекта Point
            return new Square(center, side, color);  // Возврат нового объекта Square
        }
    }


    @Override
    public String toString() {
        return "Square{" +
                "center=" + center +
                ", side=" + side +
                ", color='" + color + '\'' +
                '}';
    }

    // Обработка нехватки памяти
    public static void createLargeArray() {
        try {
            int[] largeArray = new int[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.err.println("Ошибка: недостаточно памяти для создания массива.");
        }
    }
}

Class Segment
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

Class TextCleaner
// Исключение для недопустимой стороны квадрата
class InvalidSideException extends Exception {
    public InvalidSideException(String message) {
        super(message);
    }
}

// Исключение для недопустимого фактора изменения размеров
class InvalidFactorException extends Exception {
    public InvalidFactorException(String message) {
        super(message);
    }
}
