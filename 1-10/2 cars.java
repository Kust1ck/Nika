Класс Car
public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String brand, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public Car() {
        this.id = 0;
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.color = "Unknown";
        this.price = 0.0;
        this.registrationNumber = "Unknown";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}

Основной класс
import java.util.ArrayList;
import java.util.List;

public class CarManager {

    public static void main(String[] args) {
        Car[] cars = {
            new Car(1, "Toyota", "Corolla", 2015, "White", 8000, "ABC123"),
            new Car(2, "Honda", "Civic", 2010, "Black", 6000, "DEF456"),
            new Car(3, "Ford", "Focus", 2018, "Blue", 10000, "GHI789"),
            new Car(4, "Toyota", "Camry", 2010, "Red", 9000, "JKL012"),
            new Car(5, "Honda", "Accord", 2012, "Silver", 8500, "MNO345")
        };

        String brand = "Toyota";
        System.out.println("Автомобили марки " + brand + ":");
        printCarsByBrand(cars, brand);

        String model = "Civic";
        int n = 10;
        System.out.println("\nАвтомобили модели " + model + ", которые эксплуатируются больше " + n + " лет:");
        printCarsByModelAndAge(cars, model, n);

        int year = 2010;
        double price = 7000;
        System.out.println("\nАвтомобили года выпуска " + year + ", цена которых больше " + price + ":");
        printCarsByYearAndPrice(cars, year, price);
    }

    public static void printCarsByBrand(Car[] cars, String brand) {
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
            }
        }
    }

    public static void printCarsByModelAndAge(Car[] cars, String model, int n) {
        int currentYear = java.time.Year.now().getValue();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear()) > n) {
                System.out.println(car);
            }
        }
    }

    public static void printCarsByYearAndPrice(Car[] cars, int year, double price) {
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                System.out.println(car);
            }
        }
    }
}
