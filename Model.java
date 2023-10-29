package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "model")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "model_name", "year"}) })
public class Model {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "model_id")
    private int modelId;

    @ManyToMany
    @JoinTable(
        name = "modelFeatures", 
        joinColumns = @JoinColumn(name = "model_id"), 
        inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> modelFeature;

    @Column(name = "model_name",length = 100, nullable = false)
    private String modelName;

    @Column(name = "year", nullable = false)
    private int year;

    @OneToMany(mappedBy = "model")
    private Set<Trim> trims;
 
    public Model() {
    }

    public Model(Set<Feature> modelFeature, String modelName, int year) {
        this.modelFeature = modelFeature;
        this.modelName = modelName;
        this.year = year;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public Set<Feature> getModelFeature() {
        return modelFeature;
    }

    public void setModelFeature(Set<Feature> modelFeature) {
        this.modelFeature = modelFeature;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Trim> getTrims() {
        return trims;
    }

    public void setTrims(Set<Trim> trims) {
        this.trims = trims;
    }

    @Override
    public String toString() {
        return "Model [modelFeature=" + modelFeature + ", modelId=" + modelId + ", modelName=" + modelName + ", trims="
                + trims + ", year=" + year + "]";
    }
}
