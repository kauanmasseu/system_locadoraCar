package application;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

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
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), formato);
            System.out.print("Return (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), formato);
            CarRental carRental = new CarRental(start, finish, new Vehicle(modelCar));

            System.out.print("Enter price per hour: ");
            double pricePerHour = sc.nextDouble();
            System.out.print("Enter price per day: ");
            double pricePerDay = sc.nextDouble();

            RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

            rentalService.processInvoice(carRental);

            System.out.println("INVOICE:");
            System.out.println(carRental.getInvoice());
        } catch (DateTimeParseException e) {
            System.out.println("Data digitada incorretamente.");
        } catch (InputMismatchException e) {
            System.out.println("Digite valores validos.");
        }
    }
}
