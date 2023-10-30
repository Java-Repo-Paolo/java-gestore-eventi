package org.lessons.java;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Event {
    //ATTRIBUTI
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedPlaces = 0;


    //COSTRUTTORI
    public Event(String title, LocalDate date, int totalPlaces) throws IllegalArgumentException, DateTimeParseException {
        this.title = title;
        this.date = date;
        this.totalPlaces = totalPlaces;
    }

    //METODI

    //GETTER
    public String getTitle() {
        titleException();
        return title;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateException();
        return date.format(formatter);
    }



    public int getTotalPlaces() {
        if (totalPlaces <= 0){
            throw new IllegalArgumentException("You cannot enter negative numbers");
        }
        return totalPlaces;
    }

    public int getReservedPlaces() {
        if (reservedPlaces <= 0){
            throw new IllegalArgumentException("You cannot enter negative numbers");
        }
        return reservedPlaces;
    }

    private LocalDate dateNow(){
        LocalDate today = LocalDate.now();
        return today;
    }

    //SETTER
    public void setTitle(String title) {
        this.title = title;
    }

    public void addPlaces(int addPlaces) {
        if (reservedPlaces > totalPlaces || (this.reservedPlaces + addPlaces) > totalPlaces){
            throw new IllegalArgumentException("Your number of reservations exceeds the maximum capacity");
        }
        this.reservedPlaces += addPlaces;
    }

    public void cancelPlaces(int canceledPlaces, int totalReserved) {
        if (this.reservedPlaces < canceledPlaces) {
            throw new IllegalArgumentException("The number of canceled seats exceeds the number booked");
        }
        this.reservedPlaces = totalReserved - canceledPlaces;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //EXCEPTION
    private void titleException(){
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("The title is missing");
        }
    }

    private void dateException(){
        if (date == null) {
            throw new IllegalArgumentException("The date is not available");
        }
        if (date.isBefore(dateNow())){
            throw new IllegalArgumentException("The date is invalid");
        }
    }



    @Override
    public String toString() {
        return "Event{" +
                "title = '" + title + '\'' +
                ", date = '" + date + '\'' +
                '}';
    }
}
