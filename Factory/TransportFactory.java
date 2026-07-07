public class TransportFactory {

    public static Transport getTransport(String type) {

        if (type.equals("Car")) {
            return new Car();
        }

        if (type.equals("Plane")) {
            return new Plane();
        }
        return null;
    }
}