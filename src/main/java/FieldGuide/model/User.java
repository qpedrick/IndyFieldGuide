package FieldGuide.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private List<Species> discoveredSpecies;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.discoveredSpecies = new ArrayList<>();
    };

    public String getUsername() {
        return username;
    };

    public void setUsername(String username) {
        this.username = username;
    };

    public String getPassword() {
        return password;
    };

    public void setPassword(String password) {
        this.password = password;
    };

    public List<Species> getDiscoveredSpecies() {
        return discoveredSpecies;
    };

    public void addDiscoveredSpecies(Species species) {
        if (!discoveredSpecies.contains(species)) {
            discoveredSpecies.add(species);
        }
    }
}