package main;

import system.EventBookingSystem;
import exception.InvalidBookingException;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventBookingSystem system = new EventBookingSystem();
        Scanner scanner = new Scanner(System.in);

       
        Attendee a1 = new Attendee("45","Alice");
        Organizer o1 = new Organizer("86","Bob");
        Event e1 = new Event("Concert", 5);
        Event e2 = new Event("Comedy Show", 3);

        system.registerUser(a1);
        system.registerUser(o1);
        system.addEvent(e1);
        system.addEvent(e2);

        
        while (true) {
            System.out.println("\n1. Show Events\n2. Book Ticket\n3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            try {
                switch (choice) {
                    case 1:
                        system.showEvents();
                        break;
                    case 2:
                        System.out.print("Enter attendee name: ");
                        String name = scanner.nextLine();
                        Attendee attendee = system.findAttendeeByName(name);
                        if (attendee == null) {
                            System.out.println("Attendee not found.");
                            break;
                        }
                        System.out.print("Enter event title: ");
                        String title = scanner.nextLine();
                        system.bookTicket(attendee, title);
                        break;
                    case 3:
                        System.out.println("closing");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Wrong choice");
                }
            } catch (InvalidBookingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
