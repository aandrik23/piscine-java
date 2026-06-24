import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Star getCenterStar(){
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(
            String name,
            double x,
            double y,
            double z,
            Star centerStar
    ) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    @Override
    public String toString() {
        double distance = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distance);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        if (!(object instanceof Planet)) {
            return false;
        }

        Planet other = (Planet) object;

        return centerStar.equals(other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getName(),
                getX(),
                getY(),
                getZ(),
                centerStar
        );
    }

}