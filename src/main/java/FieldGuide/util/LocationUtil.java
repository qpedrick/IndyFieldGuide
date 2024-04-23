package FieldGuide.util;

import FieldGuide.model.Location;
import java.util.List;
import java.io.*;

public class LocationUtil {
    private static final String DATA_PATH = "src/main/resources/data/locations.ser";
    private static List<Location> locations = null;

    public static List<Location> getLocations() {
        if (locations == null) {
            loadLocations();
        }
        return locations;
    }

    @SuppressWarnings("unchecked")
    private static void loadLocations() {
        File file = new File(DATA_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                locations = (List<Location>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                locations = SeedData.initializeDefaultLocations();
            }
        } else {
            locations = SeedData.initializeDefaultLocations();
            saveLocations();
        }
    }

    private static void saveLocations() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_PATH))) {
            oos.writeObject(locations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}