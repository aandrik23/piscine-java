public class CelestialObject {
    public static final double KM_IN_ONE_AU = 150000000;
    private double x;
    private double y;
    private double z;
    public static double getDistanceBetween(
            CelestialObject obj1,
            CelestialObject obj2)
        {
            double dx = obj2.getX() - obj1.getX();
            double dy = obj2.getY() - obj1.getY();
            double dz = obj2.getZ() - obj1.getZ();

            double sum = (Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));

            return Math.sqrt(sum);
        }



