package FieldGuide.util;

import FieldGuide.model.User;

import java.io.*;

public class SerializationUtil {

    public static void serializeUser(User user, String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(user);
        }
    }

    public static User deserializeUser(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (User) in.readObject();
        }
    }
}
