public class DriverFactory {

    public static Driver getDriver(String type) {

        if (type.equals("Car")) {
            return new CarDriver();
        }

        if (type.equals("Plane")) {
            return new PlaneDriver();
        }
        return null;
    }
}