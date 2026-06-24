import java.util.Objects;
public class CelestialObject {
    public static final double KM_IN_ONE_AU = 150000000;
    private double x;
    private double y;
    private double z;
    private String name;

    public CelestialObject() {
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(
            CelestialObject obj1,
            CelestialObject obj2) {
        double dx = obj2.getX() - obj1.getX();
        double dy = obj2.getY() - obj1.getY();
        double dz = obj2.getZ() - obj1.getZ();

        double sum = (Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));

        return Math.sqrt(sum);
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        return getDistanceBetween(obj1, obj2) * KM_IN_ONE_AU;
    }


    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (!(object instanceof CelestialObject)) {
            return false;
        }

        CelestialObject other = (CelestialObject) object;

        return x == other.x && y == other.y && z == other.z && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }
}

