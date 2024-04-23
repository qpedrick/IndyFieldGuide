package FieldGuide.util;

import FieldGuide.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SeedData {
    private static final String DATA_PATH = "src/main/resources/data/locations.ser";
    private static List<Location> locations = new ArrayList<>();

    public static List<Location> getLocations() {
        if (locations.isEmpty()) {
            loadLocations();
        }
        return locations;
    }

    // Warning suppressed for locations = (List<Location>) ois.readObject();
    @SuppressWarnings("unchecked")
    private static void loadLocations() {
        File file = new File(DATA_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                // Throws error because of unchecked cast but it's safe because we know the object is of type List<Location>
                locations = (List<Location>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                initializeDefaultLocations();
            }
        } else {
            initializeDefaultLocations();
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

    public static List<Location> initializeDefaultLocations() {

        //? Eagle Creek Location
        List<Species> eagleCreekSpecies = new ArrayList<>();
        // Eagle Creek Osprey
        List<String> ospreyAnswers = new ArrayList<>();
        ospreyAnswers.add("Small mammals");
        ospreyAnswers.add("Insects");
        ospreyAnswers.add("Fish"); // Correct Answer
        ospreyAnswers.add("Berries");
        String ospreyCorrectAnswer = ospreyAnswers.get(2);
        eagleCreekSpecies.add(new AnimalSpecies("Osprey",
        "Often seen circling over water before diving for fish.",
        "What is the primary diet of the Osprey?",
        ospreyAnswers,
        ospreyCorrectAnswer,
        false,
        "Primarily piscivorous (fish-eating). Ospreys are known for their spectacular fishing technique; they dive towards the water and catch fish with their talons."));
        // Eagle Creek Northern Pike
        List<String> northernPikeAnswers = new ArrayList<>();
        northernPikeAnswers.add("Its sharp teeth"); // Correct answer
        northernPikeAnswers.add("Its bright orange scales");
        northernPikeAnswers.add("Its long dorsal fin");
        northernPikeAnswers.add("Its ability to walk on land");
        String northernPikeCorrectAnswer = northernPikeAnswers.get(0);
        eagleCreekSpecies.add(new AnimalSpecies("Northern Pike",
        "A predatory fish known for its aggressive nature.",
        "What is a distinguishing feature of the Northern Pike?",
        northernPikeAnswers,
        northernPikeCorrectAnswer,
        false,
        "Predominantly piscivorous but known to be opportunistic feeders. They can eat fish, amphibians, and sometimes small mammals or birds."));
        // Eagle Creek Cattail
        List<String> cattailAnswers = new ArrayList<>();
        cattailAnswers.add("Dry, sandy soils");
        cattailAnswers.add("Rocky cliffs");
        cattailAnswers.add("Deep forest floors");
        cattailAnswers.add("Near or in freshwater wetlands"); // Correct answer
        String cattailCorrectAnswer = cattailAnswers.get(3);
        eagleCreekSpecies.add(new PlantSpecies("Cattail",
        "Ubiquitous plant in wetlands, easily recognized by its brown, cigar-shaped head.",
        "Where are Cattails most commonly found?",
        cattailAnswers,
        cattailCorrectAnswer,
        false,
        "Typically found in freshwater wetlands, cattails are robust, erect perennial plants that can grow about 1.5 to 3 meters tall. They thrive in dense stands and spread predominantly through their rhizomatous root system."));
        // Add species to the location
        Location eagleCreek = new WaterLocation(
        "Eagle Creek Park",
        "Land/Water",
        eagleCreekSpecies);

        //? White River Location    
        List<Species> whiteRiverSpecies = new ArrayList<>();
        // White River North American River Otter
        List<String> riverOtterAnswers = new ArrayList<>();
        riverOtterAnswers.add("Flying short distances");
        riverOtterAnswers.add("Sliding on mud or snow"); // Correct answer
        riverOtterAnswers.add("Climbing trees");
        riverOtterAnswers.add("Burrowing underground");
        String riverOtterCorrectAnswer = riverOtterAnswers.get(1);
        whiteRiverSpecies.add(new AnimalSpecies("North American River Otter",
        "Playful creatures often seen sliding into rivers.",
        "What is a unique behavior of the North American River Otter?",
        riverOtterAnswers,
        riverOtterCorrectAnswer,
        false,
        "Carnivorous, feeding mainly on fish and shellfish, but also amphibians, turtles, and sometimes small mammals and birds."));
        // White River Great Blue Heron
        List<String> greatBlueHeronAnswers = new ArrayList<>();
        greatBlueHeronAnswers.add("Insects");
        greatBlueHeronAnswers.add("Seeds");
        greatBlueHeronAnswers.add("Fish"); // Correct answer
        greatBlueHeronAnswers.add("Berries");
        String greatBlueHeronCorrectAnswer = greatBlueHeronAnswers.get(0);
        whiteRiverSpecies.add(new AnimalSpecies("Great Blue Heron",
        "A large wading bird that fishes in rivers and ponds.",
        "What do Great Blue Herons primarily eat?",
        greatBlueHeronAnswers,
        greatBlueHeronCorrectAnswer,
        false,
        "Mostly piscivorous but also eats a wide range of wetland organisms, including insects, amphibians, reptiles, small mammals, and other birds."));
        // White River Eastern Cottonwood
        List<String> easternCottonwoodAnswers = new ArrayList<>();
        easternCottonwoodAnswers.add("Dry uplands");
        easternCottonwoodAnswers.add("Near rivers"); // Correct Answer
        easternCottonwoodAnswers.add("Rocky cliffs");
        easternCottonwoodAnswers.add("Deep forests");
        String easternCottonwoodCorrectAnswer = easternCottonwoodAnswers.get(1);
        whiteRiverSpecies.add(new PlantSpecies("Eastern Cottonwood",
        "A fast-growing tree found along water bodies.",
        "Where is the Eastern Cottonwood typically found?",
        easternCottonwoodAnswers,
        easternCottonwoodCorrectAnswer,
        false,
        "A fast-growing tree typically found along streams, rivers, and wetlands. Eastern cottonwoods have a towering growth form, often reaching 20 to 40 meters in height, characterized by their deeply furrowed bark and broad, open crown."));
        // Add species to the location
        Location whiteRiver = new WaterLocation("White River State Park",
        "Water",
        whiteRiverSpecies);

        //? Fort Harrison Location
        List<Species> fortHarrisonSpecies = new ArrayList<>();
        // Fort Harrison Eastern Chipmunk
        List<String> easternChipmunkAnswers = new ArrayList<>();
        easternChipmunkAnswers.add("Collects and stores small pebbles.");
        easternChipmunkAnswers.add("Stores large quantities of acorns.");
        easternChipmunkAnswers.add("Primarily hunts small insects.");
        easternChipmunkAnswers.add("Stores seeds and nuts in its cheek pouches.");
        String easternChipmunkCorrectAnswer = easternChipmunkAnswers.get(3);
        fortHarrisonSpecies.add(new AnimalSpecies("Eastern Chipmunk",
        "Small, striped rodents with cheek pouches for carrying food.",
        "What do Eastern Chipmunks primarily store in their cheek pouches?",
        easternChipmunkAnswers,
        easternChipmunkCorrectAnswer,
        false,
        "Omnivorous, with a diet consisting of fruits, nuts, seeds, insects, and occasionally small mammals and birds."));
        // Fort Harrison Tulip Tree
        List<String> tulipTreeAnswers = new ArrayList<>();
        tulipTreeAnswers.add("Oval");
        tulipTreeAnswers.add("Maple-like");
        tulipTreeAnswers.add("Tulip-shaped");
        tulipTreeAnswers.add("Needle-like");
        String tulipTreeCorrectAnswer = tulipTreeAnswers.get(2);
        fortHarrisonSpecies.add(new PlantSpecies("Tulip Tree",
        "Known for its distinctive leaf shape and yellow spring flowers.",
        "What shape are the leaves of the Tulip Tree?",
        tulipTreeAnswers,
        tulipTreeCorrectAnswer,
        false,
        "Known for its height and distinctive leaf shape, the tulip tree can grow to be quite large, typically reaching heights of 18 to 35 meters. It features a straight, tall trunk and a conical to oval crown."));
        // Fort Harrison Black Walnut
        List<String> blackWalnutAnswers = new ArrayList<>();
        blackWalnutAnswers.add("Edible nuts");
        blackWalnutAnswers.add("Poisonous leaves");
        blackWalnutAnswers.add("Beautiful flowers");
        blackWalnutAnswers.add("Being evergreen");
        String blackWalnutCorrectAnswer = blackWalnutAnswers.get(0);
        fortHarrisonSpecies.add(new PlantSpecies("Black Walnut",
        "Valuable for its dark-colored wood and edible nuts.",
        "What is the Black Walnut tree well-known for?",
        blackWalnutAnswers,
        blackWalnutCorrectAnswer,
        false,
        "This tree is notable for its valuable wood and nuts. It grows slowly, forming a rounded crown as high as 30 to 40 meters under favorable conditions. Prefers deep, fertile soils."));
        // Add species to the location
        Location fortHarrison = new LandLocation("Fort Harrison State Park", "Land", fortHarrisonSpecies);

        //? Holliday Park Location
        List<Species> hollidayParkSpecies = new ArrayList<>();
        // Holliday Park Cooper's Hawk
        List<String> cooperHawkAnswers = new ArrayList<>();
        cooperHawkAnswers.add("A medium-sized hawk that preys on birds and small mammals.");
        cooperHawkAnswers.add("A large, solitary cat primarily found in the Americas.");
        cooperHawkAnswers.add("A small, nimble bird often seen in gardens.");
        cooperHawkAnswers.add("A large bird known for its powerful build and keen eyesight.");
        String cooperHawkCorrectAnswer = cooperHawkAnswers.get(0);
        hollidayParkSpecies.add(new AnimalSpecies("Cooper's Hawk",
        "A medium-sized hawk that preys on birds and small mammals.",
        "What does the Cooper's Hawk primarily prey on?",
        cooperHawkAnswers,
        cooperHawkCorrectAnswer,
        false,
        "Carnivorous, mainly eating birds and small mammals, such as starlings, robins, and squirrels, typically caught in mid-air chases."));
        // Holliday Park Spicebush
        List<String> spicebushAnswers = new ArrayList<>();
        spicebushAnswers.add("A tree known for its beautiful spring blossoms.");
        spicebushAnswers.add("A shrub with aromatic leaves, often used by spicebush swallowtail butterflies.");
        spicebushAnswers.add("A small herb used for culinary purposes in Mediterranean cuisine.");
        spicebushAnswers.add("A type of fern that grows in dense, shady areas.");
        String spicebushCorrectAnswer = spicebushAnswers.get(1);
        hollidayParkSpecies.add(new PlantSpecies("Spicebush",
        "A shrub with aromatic leaves, important for local butterflies.",
        "For what are Spicebush leaves notably used?",
        spicebushAnswers,
        spicebushCorrectAnswer,
        false,
        "An understory shrub typically found in moist, deciduous woods, growing up to 3 to 5 meters tall. Known for its fragrant, light yellow flowers that bloom early in spring."));
        // Holliday Park Pawpaw
        List<String> pawpawAnswers = new ArrayList<>();
        pawpawAnswers.add("Produces large, green fruits that are America's largest native fruit.");
        pawpawAnswers.add("Known for its bright red berries that are toxic to humans.");
        pawpawAnswers.add("A type of cactus known for its large flowers.");
        pawpawAnswers.add("Produces small, blue berries used in pies and jams.");
        String pawpawCorrectAnswer = pawpawAnswers.get(0);
        hollidayParkSpecies.add(new PlantSpecies("Pawpaw",
        "Produces large, green fruits that are America's largest native fruit.",
        "What is notable about the fruit produced by the Pawpaw tree?",
        pawpawAnswers,
        pawpawCorrectAnswer,
        false,
        "Grows as a small tree or large shrub, reaching about 4.5 to 12 meters tall, typically found in shady, rich bottomlands. Notable for its large, broad leaves and fruit, the largest edible fruit native to the United States."));
        // Add species to the location
        Location hollidayPark = new LandLocation("Holliday Park", "Land", hollidayParkSpecies);
    
        // Add locations to the list
        locations.addAll(Arrays.asList(eagleCreek, whiteRiver, fortHarrison, hollidayPark));
    
        // Save locations to a file
        saveLocations();
        return locations;
    }
    
}