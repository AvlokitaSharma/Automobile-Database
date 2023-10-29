// import java.util.List;
// import java.util.Scanner;

import org.eclipse.persistence.jpa.rs.features.FeatureResponseBuilder;
import org.postgresql.fastpath.Fastpath;

import java.util.*;
import jakarta.persistence.*;
import model.*;
import model.Package;
public class App {
    // These demos show finding, creating, and updating individual objects.
    

    public static void main(String[] args) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("automobileDb");
        EntityManager em = factory.createEntityManager();
    
        boolean avi = true;
        while(avi){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the option: ");
            int i = input.nextInt();
            if(i == 1){
            
                em.getTransaction().begin();

                //Features data
                Feature f = new Feature("Leather Seats");
                em.persist(f);
                Feature f2 = new Feature("plug-in hybrid engine");
                em.persist(f2);
                Feature f3 = new Feature("power sliding doors");
                em.persist(f3);
                Feature f4 = new Feature("hands-free sliding doors");
                em.persist(f4);
                Feature f5 = new Feature("Amazon FireTV");
                em.persist(f5);
                Feature f6 = new Feature("rear-seat entertainment screens");
                em.persist(f6);
                Feature f7 = new Feature("all-wheel drive");
                em.persist(f7);
                Feature f8 = new Feature("adaptive cruise control");
                em.persist(f8);

                //Package data
                Set<Feature> s = new HashSet<Feature>();
                s.add(f6);
                Package p = new Package(s, "Theater Package");
                em.persist(p);
                Set<Feature> s2 = new HashSet<Feature>();
                s2.add(f6);
                s2.add(f5);
                Package p2 = new Package(s2,"Amazon Theater Package");
                em.persist(p2);
                Set<Feature> s3 = new HashSet<Feature>();
                s3.add(f8);
                Package p3 = new Package(s3, "Safety Package");
                em.persist(p3);

                //model data
                Set<Feature> s4 = new HashSet<Feature>();
                s4.add(f3);
                Model m = new Model(s4, "Pacifica", 2022);
                em.persist(m);
                Set<Feature> s5 = new HashSet<Feature>();
                s5.add(f3);
                s5.add(f4);
                Model m2 = new Model(s5, "Pacifica Hybrid", 2022);
                em.persist(m2);
                Set<Feature> s6 = new HashSet<Feature>();
                s6.add(f3);
                s6.add(f2);
                Model m3 = new Model(s6, "Pacifica Hybrid", 2021);
                em.persist(m3);

                //Trim data
                Set<Feature> s7 = new HashSet<Feature>();
                Trim t = new Trim(s7, m, "Touring", 30000);
                em.persist(t);
                Set<Feature> s8 = new HashSet<Feature>();
                s8.add(f);
                s8.add(f4);
                Trim t2 = new Trim(s8, m, "Limited", 34000);
                em.persist(t2);
                Set<Feature> s9 = new HashSet<Feature>();
                s9.add(f);
                s9.add(f4);
                s9.add(f6);
                s9.add(f5);
                s9.add(f7);
                Trim t3 = new Trim(s9, m, "Pinnacle", 42000);
                em.persist(t3);

                Set<Feature> s10 = new HashSet<Feature>();
                Trim t4 = new Trim(s10, m2, "Touring", 43000);
                em.persist(t4);
                Set<Feature> s11 = new HashSet<Feature>();
                s11.add(f);
                s11.add(f4);
                Trim t5 = new Trim(s11, m2, "Limited", 48000);
                em.persist(t5);
                Set<Feature> s12 = new HashSet<Feature>();
                s12.add(f);
                s12.add(f4);
                s12.add(f6);
                s12.add(f5);
                Trim t6 = new Trim(s12, m2, "Pinnacle", 54000);
                em.persist(t6);

                Set<Feature> s13 = new HashSet<Feature>();
                Trim t7 = new Trim(s13, m3, "Touring", 41000);
                em.persist(t7);
                Set<Feature> s14 = new HashSet<Feature>();
                s14.add(f);
                s14.add(f4);
                Trim t8 = new Trim(s14, m3, "Limited", 46000);
                em.persist(t8);
                Set<Feature> s15 = new HashSet<Feature>();
                s15.add(f);
                s15.add(f4);
                s15.add(f6);
                s15.add(f8);
                Trim t9 = new Trim(s15, m3, "Pinnacle", 52000);
                em.persist(t9);

                //available package data
                AvailablePackage ap = new AvailablePackage(3000, p3, t);
                em.persist(ap);
                AvailablePackage ap2 = new AvailablePackage(2500, p2, t2);
                em.persist(ap2);
                AvailablePackage ap3 = new AvailablePackage(2500, p2, t5);
                em.persist(ap3);
                AvailablePackage ap4 = new AvailablePackage(3000, p3, t7);
                em.persist(ap4);
                AvailablePackage ap5 = new AvailablePackage(2500, p, t8);
                em.persist(ap5);
                AvailablePackage ap6 = new AvailablePackage(2000, p3, t8);
                em.persist(ap6);

                //Automobile data
                Set<AvailablePackage> s16 = new HashSet<AvailablePackage>();
                s16.add(ap2);
                Automobile a = new Automobile("12345abcde", t2, s16);
                em.persist(a); 
                Set<AvailablePackage> s17 = new HashSet<AvailablePackage>();
                Automobile a2 = new Automobile("67890abcde", t6, s17);
                em.persist(a2);
                Set<AvailablePackage> s18 = new HashSet<AvailablePackage>();
                Automobile a3 = new Automobile("99999aaaaa", t9, s18);
                em.persist(a3);
                Set<AvailablePackage> s19 = new HashSet<AvailablePackage>();
                s19.add(ap4);
                Automobile a4 = new Automobile("aaaaa88888", t7, s19);
                em.persist(a4);
                Set<AvailablePackage> s20 = new HashSet<AvailablePackage>();
                s20.add(ap5);
                s20.add(ap6);
                Automobile a5 = new Automobile("bbbbb77777", t8, s20);
                em.persist(a5);
            
                em.getTransaction().commit();
                System.out.println("option 1 selected");
            }
            if(i == 2)
            {
                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the vin number of the automobile: ");
                String vin = input2.nextLine();
                var automobile = em.createQuery("SELECT a FROM automobiles a WHERE a.vin = ?1", Automobile.class);
                automobile.setParameter(1,vin);
                try{
                    Automobile requested = automobile.getSingleResult();
                    System.out.println("Your requested automobile: " + requested);
                }
                catch( NoResultException ex)
                {
                    System.out.println("Automobile with vin: " + vin + " not found");
                }
            }
            if(i == 3)
            {
                Scanner input3 = new Scanner(System.in);
                System.out.println("Enter the name of the feature: ");
                String f = input3.nextLine();

                var feature = em.createQuery("SELECT a FROM automobiles a JOIN a.trim t LEFT JOIN t.trimFeature tf JOIN t.model m LEFT JOIN m.modelFeature mf WHERE tf.name = ?1", Automobile.class);
                feature.setParameter(1,f);
                try{
                    List<Automobile> requested = feature.getResultList();
                    if(requested.size() == 0)
                    {
                        throw new NoResultException();
                    }
                    System.out.println("The VIN numbers of the automobiles with feature: " + f + " is: ");
                    for(Automobile a : requested)
                    {
                        System.out.println(a.getVin());
                    }
                }
                catch(NoResultException ex)
                {
                    System.out.println("There is no automobile with the feature: " + f);
                }
            }
            if(i == 4)
            {
                avi = false;
            }
        }
    }
}
