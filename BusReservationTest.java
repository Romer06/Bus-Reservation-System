import java.util.Scanner;

public class BusReservationTest{
    public static void main(String[] args){
        ReservationSystem system=new ReservationSystem();
        Scanner sc=new Scanner(System.in);
        int choice;

System.out.println("\n---- Welcome to Bus Reservation System ----");
        
do{
    System.out.println("\n1.View All Buses");
    System.out.println("2. Book a Seat");
    System.out.println("3. Exit");
    System.out.print("Enter choice: ");
    choice = Integer.valueOf(sc.nextLine());

    switch(choice){
        case 1:
            for (Bus b : system.busList){
            System.out.println("\nBus ID: "+b.getBusId());   
                b.getBusDetails();
            }
            break;

        case 2:
          System.out.println("Enter Bus ID: ");
          int id=Integer.valueOf(sc.nextLine());
          boolean busFound = false;
          for(Bus b : system.busList){
            if(id == b.getBusId()){
                b.displayLayout();
                System.out.println("\nChoose one ");
                System.out.println("Select 1 for Lower Deck");
                System.out.println("Select 2 for Upper Deck");
                int deckChoice=Integer.valueOf(sc.nextLine());

                System.out.println("Enter the seat number:");
                int seatNum=Integer.valueOf(sc.nextLine());

                b.bookSeat(seatNum,deckChoice);
                busFound=true;
                break;
            }
        }
                if(!busFound){
                System.out.println("Bus not found :("); 
            }
          break;
          
          case 3:
            System.out.println("Thank you for using the system! :)");
            break;
    }

}while(choice!=3);
    }
}