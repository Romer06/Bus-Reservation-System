import java.util.Scanner;

public class BusReservationTest {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\n---- Welcome to Bus Reservation System ----");

        do {
            System.out.println("\n1. View All Buses");
            System.out.println("2. Book a Seat");
            System.out.println("3. Search Ticket by ID");
            System.out.println("4. Cancel Ticket"); // NEW OPTION
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.valueOf(sc.nextLine());

            switch (choice) {
                case 1:
                    for (Bus b : system.busList) {
                        System.out.println("\nBus ID: " + b.getBusId());
                        b.getBusDetails();
                    }
                    break;

                case 2:
                    System.out.println("Enter Passenger Name: ");
                    String pName = sc.nextLine();
                    System.out.println("Enter passenger age: ");
                    int pAge = Integer.valueOf(sc.nextLine());
                    System.out.println("Enter Gender (Male/Female):");
                    String pGender = sc.nextLine();
                    System.out.println("Enter Bus ID: ");
                    int id = Integer.valueOf(sc.nextLine());
                    boolean busFound = false;
                    for (Bus b : system.busList) {
                        if (id == b.getBusId()) {
                            b.displayLayout();
                            System.out.println("\nChoose one: 1. Lower Deck  2. Upper Deck");
                            int deckChoice = Integer.valueOf(sc.nextLine());
                            System.out.println("Enter seat number:");
                            int seatNum = Integer.valueOf(sc.nextLine());
                            b.bookSeat(seatNum, deckChoice, pName, pAge, pGender);
                            busFound = true;
                            break;
                        }
                    }
                    if (!busFound) System.out.println("Bus not found :(");
                    break;

                case 3:
                    System.out.println("Enter the Ticket ID:");
                    String pId = sc.nextLine();
                    boolean globallyFound = false;
                    for (Bus b : system.busList) {
                        Passenger foundPerson = b.searchByTicketId(pId);
                        if (foundPerson != null) {
                            System.out.println("--- Ticket Found! ---");
                            System.out.println("Bus ID: " + b.getBusId());
                            foundPerson.getDetails();
                            globallyFound = true;
                            break;
                        }
                    }
                    if (!globallyFound) System.out.println("No passenger found with ID: " + pId);
                    break;

                case 4:
    System.out.println("Enter Ticket ID to cancel:");
    String cancelTicketId = sc.nextLine();
    boolean ticketFound = false;

    // We loop through every bus in the list
    for (Bus b : system.busList) {
        // We call the method that searches both decks for that ID
        if (b.cancelByOnlyId(cancelTicketId)) {
            ticketFound = true;
            break; // Stop searching other buses once the ticket is found and cleared
        }
    }

    if (!ticketFound) {
        System.out.println("No record found for Ticket ID: " + cancelTicketId);
    }
    break;

                case 5:
                    System.out.println("Thank you for using the system! :)");
                    break;
            }

        } while (choice != 5);
    }
}