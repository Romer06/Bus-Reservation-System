public class Bus{
    private int busId;
    private int totalCapacity;
    private int availableSeats;
    private int[] lowerDeck;
    private int[] upperDeck;
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
    this.lowerDeck = new int[half];
    this.upperDeck = new int[half];
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
        if(lowerDeck[i] ==0){
            System.out.print("[" + (i+1) + "] ");
        }else{
            System.out.print("[Sold] ");
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
        if(upperDeck[i]==0){
            System.out.print("[" + (i+1) + "] ");
        }else{
            System.out.print("[Sold] ");
        }

        if((i+1)%2==0){
            System.out.println();
        }
    }
}

public void bookSeat(int seatNumber , int deckChoice){
    int index = seatNumber -1;
    if(deckChoice==1){
    if(index<0 || index >= lowerDeck.length){
        System.out.println("Invalid seat number!  :(");
    }else if(lowerDeck[index]==1){
        System.out.println("Seat already booked  :(");
        System.out.println("Try booking other seats");

    }else{
        lowerDeck[index]=1;
        availableSeats--;
        System.out.println("Seat "+seatNumber+ " booked successfully! :)");
    }
    
}else{
      if(index<0 || index >= upperDeck.length){
        System.out.println("Invalid seat number!  :(");
    }else if(upperDeck[index]==1){
        System.out.println("Seat already booked  :(");
        System.out.println("Try booking other seats");

    }else{
        upperDeck[index]=1;
        availableSeats--;
        System.out.println("Seat "+seatNumber+ " booked successfully! :)");
    }

}

}
}