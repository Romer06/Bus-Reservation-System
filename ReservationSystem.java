import java.util.ArrayList;
public class ReservationSystem{
    public ArrayList<Bus> busList = new ArrayList<>();
    
    
    public ReservationSystem(){
    initializeBuses();
    }
   

private void initializeBuses(){
   Bus bus1=new Bus(101,"Chennai to Bangalore", 20,17000,20000);
   Bus bus2=new Bus(102,"Chennai to Coimbatore", 40,18000,22000);
   busList.add(bus1);
   busList.add(bus2);
}
}
