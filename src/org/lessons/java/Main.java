package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many events do you want to add? ");
        int addEvent = Integer.parseInt(scanner.nextLine());

        Event[] eventsList = new Event[addEvent];

        for (int i = 0; i < eventsList.length; i++) {
            System.out.println("Insert event " + (i + 1));

            try {
                System.out.print("Enter the title: ");
                String title = scanner.nextLine();
                System.out.print("Enter the date(YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter the places for the event: ");
                int totalPlace = Integer.parseInt(scanner.nextLine());

                Event event = new Event(title, date, totalPlace);
                eventsList[i] = event;

                boolean quit = false;
                while (!quit){
                    System.out.println("\n");
                    System.out.println("Event: " + event.getTitle() + " " +  event.getDate());
                    System.out.println("Reserved placed: " + event.getReservedPlaces());
                    System.out.println("Places available: " + event.getTotalPlaces());
                    System.out.println("\n");
                    System.out.println("What do you want to do?");
                    System.out.println("1 - Reserve places");
                    System.out.println("2 - Exit");
                    String choice = scanner.nextLine();

                    switch (choice){
                        case "1":
                            try{
                                System.out.println("How many places do you want to reserve?");
                                int reservedPlaces = Integer.parseInt(scanner.nextLine());

                                System.out.println("You want to cancel your reservation(s) yes/no?");
                                String answer = scanner.nextLine().toLowerCase();
                                if (answer.equals("yes") || answer.equals("si")) {
                                    System.out.println("How many places do you want to cancel?");
                                    int canceledPlaces = Integer.parseInt(scanner.nextLine());
                                    // Somma dei posti prenotati con quelli aggiunti
                                    int totalReserved = event.getReservedPlaces() + reservedPlaces;
                                    event.cancelPlaces(canceledPlaces, totalReserved); // Cancella i posti
                                } else {
                                    event.addPlaces(reservedPlaces); // Prenota i posti
                                }

                            }catch (IllegalArgumentException e){
                                System.out.println("Invalid error: " + e.getMessage());
                            }
                            break;
                        case "2":
                            quit = true; // Esci dal ciclo
                            System.out.println(
                                "\n" +
                                "Thank you and good day" +
                                "\n"
                            );
                            break;
                        default: System.out.println("I'm sorry, the action failed, please try again");
                    }
                }

            }catch (IllegalArgumentException e){
                System.out.println("Invalid error: " + e.getMessage());
                i--;
                continue;
            }
        }

        for (Event totalEvents : eventsList) {
            System.out.println(totalEvents);
            System.out.println("Reserved places: " + totalEvents.getReservedPlaces());
            System.out.println("Available places: " + totalEvents.getTotalPlaces());
        }

        scanner.close();

    }
}
