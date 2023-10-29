package model;

import java.util.Set;
import jakarta.persistence.*;

@Entity(name = "trims")

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"model_id", "trim_name"})})
public class Trim {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JoinColumn(name = "trim_id")
    @OneToMany
    private int trimId;

    @ManyToMany
    @JoinTable(
        name = "trimFeatures",
        joinColumns = @JoinColumn(name = "trim_id", nullable = false), 
        inverseJoinColumns = @JoinColumn(name = "feature_id", nullable = false))
    private Set<Feature> trimFeature;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @OneToMany(mappedBy = "trim")
    private Set<AvailablePackage> availablePackage;

    @Column(name = "trim_name", length = 100, nullable = false)
    private String trimName;

    @Column(name = "cost", nullable = false)
    private int cost;

    public Trim() {
    }

    public Trim(Set<Feature> trimFeature, Model model, String trimName, int cost) {
        this.trimFeature = trimFeature;
        this.model = model;
        this.trimName = trimName;
        this.cost = cost;
    }

    public int getTrimId() {
        return trimId;
    }

    public void setTrimId(int trimId) {
        this.trimId = trimId;
    }

    public Set<Feature> getTrimFeature() {
        return trimFeature;
    }

    public void setTrimFeature(Set<Feature> trimFeature) {
        this.trimFeature = trimFeature;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Set<AvailablePackage> getAvailablePackage() {
        return availablePackage;
    }

    public void setAvailablePackage(Set<AvailablePackage> availablePackage) {
        this.availablePackage = availablePackage;
    }

    public String getTrimName() {
        return trimName;
    }

    public void setTrimName(String trimName) {
        this.trimName = trimName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Trim [availablePackage=" + availablePackage + ", cost=" + cost + ", model=" + model + ", trimFeature="
                + trimFeature + ", trimId=" + trimId + ", trimName=" + trimName + "]";
    }
}
