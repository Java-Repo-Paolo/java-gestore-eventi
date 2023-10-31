package org.lessons.java;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event {
    //ATTRIBUTI
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedPlaces = 0;


    //COSTRUTTORI
    public Event(String title, LocalDate date, int totalPlaces) throws IllegalArgumentException {
        titleException(title);
        dateException(date);
        validateTotalPlace(totalPlaces);
        this.title = title;
        this.date = date;
        this.totalPlaces = totalPlaces;
    }

    //METODI

    //GETTER
    public String getTitle() {
        return title;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
    
    public int getTotalPlaces() {
        return totalPlaces;
    }
    
    public int getReservedPlaces() {
        return reservedPlaces;
    }

    private void validateReservedPlaces() {
        if (reservedPlaces <= 0){
            throw new IllegalArgumentException("You cannot enter negative numbers");
        }
    }

    private LocalDate dateNow(){
        LocalDate today = LocalDate.now();
        return today;
    }

    //SETTER
    public void setTitle(String title) {
        titleException(title);
        this.title = title;
    }

    public void setDate(LocalDate date) {
        dateException(date);
        this.date = date;
    }

    public void setTotalPlaces(int totalPlaces) {
        validateTotalPlace(totalPlaces);
        this.totalPlaces = totalPlaces;
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


    //EXCEPTION
    private void titleException(String title) throws IllegalArgumentException{
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("The title is missing");
        }
    }

    private void dateException(LocalDate date) throws IllegalArgumentException{
        if (date == null) {
            throw new IllegalArgumentException("The date is not available");
        }
        if (date.isBefore(dateNow())){
            throw new IllegalArgumentException("The date is invalid");
        }
    }

    private void validateTotalPlace(int totalPlaces) throws IllegalArgumentException{
        if (totalPlaces <= 0){
            throw new IllegalArgumentException("You cannot enter negative numbers");
        }
        this.totalPlaces = totalPlaces;
    }


    @Override
    public String toString() {
        return "Event{" +
                "title = '" + title + '\'' +
                ", date = '" + date + '\'' +
                '}';
    }
}
