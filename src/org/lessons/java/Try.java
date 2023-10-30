package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Try {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("How many events do you want to add? ");
        int addEvent = Integer.parseInt(scanner.nextLine());

        Event[] eventsList = new Event[addEvent];

        for (int i = 0; i < eventsList.length; i++) {
                try {
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the date(YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter the places for the event: ");
                    int totalPlace = Integer.parseInt(scanner.nextLine());

                    Event event = new Event(title, date, totalPlace);
                    eventsList[i] = event;
                }
                catch (IllegalArgumentException e){
                        System.out.println("Invalid error: " + e.getMessage());
                }
        }

            for (Event totalEvents : eventsList) {
                System.out.println("\n");
                System.out.println(totalEvents.getDate());
            }

        scanner.close();
    }
}
