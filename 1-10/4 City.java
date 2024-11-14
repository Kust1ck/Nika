import java.util.ArrayList;
import java.util.List;

public class City {

    private List<Location> locations;

    public City() {
        this.locations = new ArrayList<>();
    }

    public void addLocation(String name, LocationType type) {
        Location location = new Location(name, type);
        locations.add(location);
    }

    public void displayLocations() {
        if (locations.isEmpty()) {
            System.out.println("Город не содержит информации о местах.");
        } else {
            for (Location location : locations) {
                System.out.println(location);
            }
        }
    }

    public class Location {
        private String name;      // Название улицы, проспекта или площади
        private LocationType type; // Тип места (Улица, Проспект, Площадь)

        public Location(String name, LocationType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocationType getType() {
            return type;
        }

        public void setType(LocationType type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Место: " + name + ", Тип: " + type;
        }
    }

    public enum LocationType {
        STREET, AVENUE, SQUARE
    }

    public static void main(String[] args) {
        City city = new City();

        city.addLocation("Невский проспект", LocationType.AVENUE);
        city.addLocation("Ленинская улица", LocationType.STREET);
        city.addLocation("Дворцовая площадь", LocationType.SQUARE);

        city.displayLocations();
    }
}
