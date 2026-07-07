public class PlaneDriver extends Driver {
    @Override
    public Transport cretaeTransport() {
        return TransportFactory.getTransport("Plane");
    }
}