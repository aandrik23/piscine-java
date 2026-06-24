import java.util.Objects;

public class Star extends CelestialObject{
    private double magnitude;

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public Star(
            String name,
            double x,
            double y,
            double z,
            double magnitude
    ) {
        super(name, x, y, z);
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        if (!(object instanceof Star)) {
            return false;
        }

        Star other = (Star) object;

        return magnitude == other.magnitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getName(),
                getX(),
                getY(),
                getZ(),
                magnitude
        );
    }

}