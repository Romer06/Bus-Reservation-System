public class Bus{
    private int busId;
    private int totalCapacity;
    private int availableSeats;
    private Passenger[] lowerDeck;
    private Passenger[] upperDeck;
    private double lowerPrice;
    private double upperPrice;
    private String destination; 

public Bus(int busId, String destination, int totalCapacity , double lowerPrice, double upperPrice){
    this.busId=busId;
    this.destination=destination;
    this.totalCapacity=totalCapacity;
    this.lowerPrice=lowerPrice;
    this.upperPrice=upperPrice;
    this.availableSeats=totalCapacity;
    int half=totalCapacity/2;
    this.lowerDeck = new Passenger[half];
    this.upperDeck = new Passenger[half];
}

public int getBusId(){
    return busId;
}
public void getBusDetails(){
    System.out.println("Route: "+ destination);
    System.out.println("Total Capacity: "+ totalCapacity);
    System.out.println("Seats Left: "+ availableSeats);


}

public void setBusId(int busId){
    this.busId = busId;
}

public void displayLayout() {
    //1.Show lower Deck
    System.out.println("\n--- LOWER DECK ---");
    System.out.println("Price: ₹" + lowerPrice);
    for(int i=0;i< lowerDeck.length;i++){
        if(lowerDeck[i] == null){
            System.out.print("[" + (i+1) + "] ");
        }else{
            String genderIcon = lowerDeck[i].getGender().equalsIgnoreCase("Male") ? "M" : "F";
            System.out.print("["+genderIcon+"-Sold] ");
        }

        //print a new line every 2 seats to look like a bus aisle
        if((i+1)%2==0){
            System.out.println();
        }
    }

    //2.Show Upper Deck
    System.out.println("\n--- UPPER DECK ---");
    System.out.println("Price: ₹"+upperPrice);
    for(int i=0;i<upperDeck.length;i++){
        if(upperDeck[i] == null){
            System.out.print("[" + (i+1) + "] ");
        }else{
            String genderIcon = upperDeck[i].getGender().equalsIgnoreCase("Male") ? "M" : "F";
            System.out.print("["+genderIcon+"-Sold] ");
        }

        if((i+1)%2==0){
            System.out.println();
        }
    }
}

public void bookSeat(int seatNumber , int deckChoice , String name, int age, String gender){
    int index = seatNumber -1;
    String tId= "TICK" + (int)(Math.random()*1000);
    Passenger p = new Passenger(name, age, gender, tId);


    if(deckChoice==1){
    if(index<0 || index >= lowerDeck.length){
        System.out.println("Invalid seat number!  :(");
    }else if(lowerDeck[index]!= null){
        System.out.println("Seat already booked  :(");
        System.out.println("Try booking other seats");

    }else{
        lowerDeck[index]=p;
        availableSeats--;
        System.out.println("Seat "+seatNumber+ " booked successfully! :)");
        System.out.println("Your Ticket ID is: "+ tId+", Bon voyage!");
    }
    
}else{
      if(index<0 || index >= upperDeck.length){
        System.out.println("Invalid seat number!  :(");
    }else if(upperDeck[index]!= null){
        System.out.println("Seat already booked  :(");
        System.out.println("Try booking other seats");

    }else{
        upperDeck[index]=p;
        availableSeats--;
        System.out.println("Seat "+seatNumber+ " booked successfully! :)");
        System.out.println("Your Ticket ID is: "+ tId+", Bon voyage!");
    }

}
}

public Passenger searchByTicketId(String ticketId){
    boolean ticketFound= false;

    for(int i=0;i<lowerDeck.length; i++){
        if(lowerDeck[i]!= null && lowerDeck[i].getTicketId().equalsIgnoreCase(ticketId)){
            System.out.println("\nLocation: Lower Deck ,Seat No: "+ (i+1));
            return lowerDeck[i];
        }
    }
        if(!ticketFound){
      for(int i=0;i<upperDeck.length; i++){
        if(upperDeck[i]!= null && upperDeck[i].getTicketId().equalsIgnoreCase(ticketId)){
            System.out.println("\nLocation: Upper Deck ,Seat No: " + (i+1));
            return upperDeck[i];
        }
    }
        }
        return null;

}

public boolean cancelByOnlyId(String ticketId) {
    // 1. Search Lower Deck
    for (int i = 0; i < lowerDeck.length; i++) {
        if (lowerDeck[i] != null && lowerDeck[i].getTicketId().equalsIgnoreCase(ticketId)) {
            System.out.println("Cancelling ticket for: " + lowerDeck[i].getName());
            lowerDeck[i] = null;
            availableSeats++;
            System.out.println("Ticket cancelled successfully! :)");
            return true; // Found and cancelled
        }
    }

    // 2. Search Upper Deck if not found in Lower
    for (int i = 0; i < upperDeck.length; i++) {
        if (upperDeck[i] != null && upperDeck[i].getTicketId().equalsIgnoreCase(ticketId)) {
            System.out.println("Cancelling ticket for: " + upperDeck[i].getName());
            upperDeck[i] = null;
            availableSeats++;
            System.out.println("Ticket cancelled successfully! :)");
            return true; // Found and cancelled
        }
    }

    return false; // Not found anywhere on this bus
}

}