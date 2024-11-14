public class Address implements AutoCloseable {
    private String country;
    private String city;
    private String street;
    private String building;
    private String postalCode;

    // Конструктор
    public Address(String country, String city, String street, String building, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.postalCode = postalCode;
    }

    // Методы для изменения частей адреса
    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Методы для получения частей адреса
    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getPostalCode() {
        return postalCode;
    }

    // Метод для отображения полного адреса
    public String getFullAddress() {
        return String.format("%s, %s, %s, %s, %s", country, city, street, building, postalCode);
    }

    // Метод close() для "удаления" объекта вручную
    @Override
    public void close() {
        System.out.println("Объект удален.");
    }

    public static void main(String[] args) {

        try (Address address = new Address("Россия", "Москва", "Тверская", "1", "123456")) {
            System.out.println("Начальный адрес: " + address.getFullAddress());

            // Изменение частей адреса
            address.setCity("Санкт-Петербург");
            address.setStreet("Невский проспект");

            System.out.println("Обновленный адрес: " + address.getFullAddress());
        } 
    }
}
