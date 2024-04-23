package FieldGuide.util;

import FieldGuide.model.User;

import java.io.File;
import java.io.IOException;

public class UserUtil {

    private static final String DATA_DIR = "src/main/resources/data";

    public static void signup(String username, String password) throws IOException {
        doesDataDirectoryExist();

        File userFile = new File(DATA_DIR, username + ".ser");
        if (userFile.exists()) {
            throw new IOException("User already exists");
        } else {
            User newUser = new User(username, password);
            SerializationUtil.serializeUser(newUser, userFile.getPath());
        }
    }

    private static void doesDataDirectoryExist() {
        File dataDir = new File(DATA_DIR);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }

    public static boolean login(String username, String password) {
        File userFile = new File(DATA_DIR, username + ".ser");
        if (!userFile.exists()) {
            System.out.println("User not found");
            return false;
        }
        try {
            User user = SerializationUtil.deserializeUser(userFile.getPath());
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Invalid password");
                return false;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
    }    
}