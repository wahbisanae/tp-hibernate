package test;

import entities.Machine;
import entities.Salle;
import services.MachineService;
import services.SalleService;
import util.HibernateUtil;

import java.util.Date;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();

        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // Création et insertion de salles
        Salle salle1 = new Salle("A1");
        Salle salle2 = new Salle("B2");
        salleService.create(salle1); // Appel sur l'instance de salleService
        salleService.create(salle2);

        // Création et insertion de machines
        Machine machine1 = new Machine("M123", new Date(), salleService.findById(1));
        Machine machine2 = new Machine("M124", new Date(), salleService.findById(2));
        machineService.create(machine1); // Appel sur l'instance de machineService
        machineService.create(machine2);

        // Affichage des salles et leurs machines
        for (Salle salle : salleService.findAll()) {
            System.out.println("Salle: " + salle.getCode());
            for (Machine machine : salle.getMachines()) {
                System.out.println(" Machine: " + machine.getRef());
            }
        }

        // Utilisation de la méthode findBetweenDate (utilisation de Calendar pour les dates)
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.JANUARY, 1);
        Date d1 = calendar.getTime(); // 1er janvier 2010
        Date d2 = new Date(); // Date actuelle

        System.out.println("Machines achetées entre " + d1 + " et " + d2 + ":");
        for (Machine m : machineService.findBetweenDate(d1, d2)) {
            System.out.println(m.getRef() + " achetée le " + m.getDateAchat());
        }
    }
}