package model;

import jakarta.persistence.*;

@Entity(name = "features")
public class Feature {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "feature_id", nullable = false)
    private int featureId;

    @Column(name = "name", length = 100 , unique = true, nullable = false)
    private String name;

    public Feature() {
    }

    public Feature(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
