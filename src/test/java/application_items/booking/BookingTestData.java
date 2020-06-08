package application_items.booking;

public class BookingTestData {
    public String city;
    public int dayBeforeStartDate;
    public int dayOfStay;
    public int adults;
    public int children;
    public int rooms;

    public BookingTestData() {
    }

    public BookingTestData(String city, int dayBeforeStartDate, int dayOfStay, int adults, int children, int rooms) {
        this.city = city;
        this.dayBeforeStartDate = dayBeforeStartDate;
        this.dayOfStay = dayOfStay;
        this.adults = adults;
        this.children = children;
        this.rooms = rooms;
    }

    public String getCity() {
        return city;
    }

    public int getDayBeforeStartDate() {
        return dayBeforeStartDate;
    }

    public int getDayOfStay() {
        return dayOfStay;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public int getRooms() {
        return rooms;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDayBeforeStartDate(int dayBeforeStartDate) {
        this.dayBeforeStartDate = dayBeforeStartDate;
    }

    public void setDayOfStay(int dayOfStay) {
        this.dayOfStay = dayOfStay;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
