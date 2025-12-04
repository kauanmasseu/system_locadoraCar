package application;

import entities.DataLocation;
import entities.NotePayment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {
            System.out.println("Enter rental data");
            System.out.print("Car model: ");
            String modelCar = sc.nextLine();
            System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
            LocalDateTime intialLocation = LocalDateTime.parse(sc.nextLine(), formato);
            System.out.print("Return (dd/MM/yyyy hh:mm): ");
            LocalDateTime returnLocation = LocalDateTime.parse(sc.nextLine(), formato);
            DataLocation data = new DataLocation(intialLocation, returnLocation, modelCar);
            System.out.print("Enter price per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Enter price per day: ");
            double valuePerDay = sc.nextDouble();
            NotePayment notePayment = new NotePayment(valuePerHour, valuePerDay, data);
            System.out.println("INVOICE:");
            System.out.println(notePayment);
        } catch (DateTimeParseException e) {
            System.out.println("Data digitada incorretamente.");
        } catch (InputMismatchException e) {
            System.out.println("Digite valores validos.");
        }
    }
}
