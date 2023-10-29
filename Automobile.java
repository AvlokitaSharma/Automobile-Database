package model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.*;

@Entity(name = "automobiles")
public class Automobile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "auto_id", nullable = false)
    private int autoId;

    @Column(name = "vin", length = 100, unique = true, nullable = false)
    private String vin;

    @ManyToMany
    @JoinTable(
        name = "chosenPackages",
        joinColumns = @JoinColumn(name = "auto_id", nullable = false), 
        inverseJoinColumns = @JoinColumn(name = "available_id", nullable = false))
    private Set<AvailablePackage> chosenPackages;

    // The bidirectional link back to the parent Museum.
    @ManyToOne
    @JoinColumn(name = "trim_id", nullable = false)
    private Trim trim;

    public Automobile() {
    }

    public Automobile(String vin, Trim trim, Set<AvailablePackage> chosenPackages) {
        this.vin = vin;
        this.trim = trim;
        this.chosenPackages = chosenPackages;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Set<AvailablePackage> getChosenPackage() {
        return chosenPackages;
    }

    public void setChosenPackage(Set<AvailablePackage> chosenPackage) {
        this.chosenPackages = chosenPackage;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Set<Feature> getFeature()
    {
        Model model = getTrim().getModel();

        Set<Feature> f = new HashSet<Feature>();
        f.addAll(model.getModelFeature());
        f.addAll(getTrim().getTrimFeature());
        Set<Package> np = new HashSet<Package>();
        for (AvailablePackage ap : chosenPackages)
        {
            np.add(ap.getPackages());
        }
        Set<Feature> nf = new HashSet<Feature>();
        for(Package p : np)
        {
            nf.addAll(p.getPackageFeature());
        }

        f.addAll(nf);
        return f;
    }

    public double getStickerPrice()
    {
        double sticker_price;
        double total_package_cost = 0;
        for(AvailablePackage a : chosenPackages)
        {
            total_package_cost = total_package_cost + a.getCost();
        }
        sticker_price = trim.getCost() + total_package_cost;

        return sticker_price;
    }

    @Override
    public String toString() {
        Model model = getTrim().getModel();
        String features = "";
        for(Feature f : getFeature())
        {
            features += f + "\n";
        }

        return "\n" +model.getYear() + " " + model.getModelName()+ " " + getTrim().getTrimName() + "\n" + getStickerPrice() + "\nFeatures: \n" + features;
    }
}
