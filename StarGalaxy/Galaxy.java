import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        celestialObjects.add(celestialObject);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> result = new LinkedHashMap<>();

        result.put("Star", 0);
        result.put("Planet", 0);
        result.put("Other", 0);

        for (CelestialObject object : celestialObjects) {
            if (object instanceof Star) {
                result.put("Star", result.get("Star") + object.getMass());
            } else if (object instanceof Planet) {
                result.put("Planet", result.get("Planet") + object.getMass());
            } else {
                result.put("Other", result.get("Other") + object.getMass());
            }
        }

        return result;
    }
}