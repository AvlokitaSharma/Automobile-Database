package model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity(name = "availablePackage")
public class AvailablePackage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "available_id", nullable = false)
    private int avaialbeId;

    @ManyToOne
    @JoinColumn(name = "trim_id")
    private Trim trim;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private Package packages;

    @Column(name = "cost", nullable = false)
    private int cost;

    @ManyToMany(mappedBy = "chosenPackages")
    private Set<Automobile> chosenPackage;

    public AvailablePackage() {
    }

    public AvailablePackage(int cost, Package packages, Trim trim) {
        this.cost = cost;
        this.packages = packages;
        this.trim = trim;
    }

    public int getAvaialbeId() {
        return avaialbeId;
    }

    public void setAvaialbeId(int availableId) {
        this.avaialbeId = availableId;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Package getPackages() {
        return packages;
    }

    public void setPackages(Package packages) {
        this.packages = packages;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Set<Automobile> getChosenPackage() {
        return chosenPackage;
    }

    public void setChosenPackages(Set<Automobile> chosenPackage) {
        this.chosenPackage = chosenPackage;
    }

    @Override
    public String toString() {
        return "AvailablePackage [avaialbeId=" + avaialbeId + ", chosenPackages=" + chosenPackage + ", cost=" + cost
                + ", packages=" + packages + ", trim=" + trim + "]";
    }

}