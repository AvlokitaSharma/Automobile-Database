package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "packages")
public class Package {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @OneToMany
    @Column(name = "package_id")
    private int packageId;
    
    @ManyToMany
    @JoinTable(
        name = "packageFeatures",
        joinColumns = @JoinColumn(name = "package_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "feature_id", nullable = false)
    )
    private Set<Feature> packageFeature;

    @Column(name = "package_name", length = 100, nullable = false)
    private String packageName;

    @OneToMany(mappedBy = "packages")
    private Set<AvailablePackage> availablePackage;

    public Package() {
    }

    public Package(Set<Feature> packageFeature, String packageName) {
        this.packageFeature = packageFeature;
        this.packageName = packageName;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Set<Feature> getPackageFeature() {
        return packageFeature;
    }

    public void setPackageFeature(Set<Feature> packageFeature) {
        this.packageFeature = packageFeature;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Set<AvailablePackage> getAvailablePackage() {
        return availablePackage;
    }

    public void setAvailablePackage(Set<AvailablePackage> availablePackage) {
        this.availablePackage = availablePackage;
    }

    @Override
    public String toString() {
        return "Package [availablePackage=" + availablePackage + ", packageFeature=" + packageFeature + ", packageId="
                + packageId + ", packageName=" + packageName + "]";
    }
}
