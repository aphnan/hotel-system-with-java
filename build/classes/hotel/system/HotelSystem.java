
package hotel.system;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class HotelSystem {

    
    
    public static void main(String[] args) {
        
        
        
        ArrayList<HotelBranch> hotelbranch = new <HotelBranch>ArrayList();
        
        ArrayList<Room> room = new <Room>ArrayList();
        char choice = '0';
        
        while(choice != '5'){
           
        
        System.out.println("----- Welcome to Hotel System-------");
        System.out.println("1. Add HotelBranch Details in the System");
        System.out.println("2. Add Booking");
        System.out.println("3. List all HotelBranch details");
        System.out.println("4. List all Bookings");
        System.out.println("5. Exit from the System");
        System.out.println("Enter Your Choice:");
        Scanner in = new Scanner(System.in);
        choice = in.next().charAt(0);
        
        switch(choice){
            //taking information of hotelbranchs to add
            
            case '1':
                try{
                int capacity,NoOfWaiters,NoOfOtherWorkers;
                System.out.print("Enter Id : ");
               
                int hotelbranchId = in.nextInt();
                System.out.print("Enter type(Luxury/Economy or other)  : ");
                 in.next();
                String type = in.nextLine();
                System.out.print("Enter  No. Of Rooms: ");
                capacity = in.nextInt();
                
                System.out.print("Enter No. Of Waiters : ");
                 NoOfWaiters = in.nextInt();
                
                System.out.print("Enter No. Of Other Workers : ");
                NoOfOtherWorkers = in.nextInt();
                
                
                //making hotelbranch class object
                HotelBranch ob = new HotelBranch(hotelbranchId,type,capacity,NoOfWaiters,NoOfOtherWorkers);
                //checking if hotelbranch limit  is already full
                if(ob.isFull() == false)
                    
                    System.out.println("Hotel Branch Limit Exceeds!");
                else{
                    //if hotelbranch limit is not full then adding hotelbranch to system
                hotelbranch.add(ob);
                System.out.println("Hotel Branch added with information : ");
                //print object to call toString() method of hotelbranch class
                System.out.println(ob);
                }
                }catch(Exception e){
                    System.out.println("Please Enter Correct Data!!!");
            }
                break;
                
                
                
             case '2':
                 Scanner Input = new Scanner(System.in);
                 String bdate, btime;
                        int RoomId,NoOfGuests;
                        double price;
                        try {
                            System.out.print("Enter Price : ");
                            price = Input.nextDouble();
                            
                            System.out.print("Enter Room Id : ");
                            RoomId = Input.nextInt();
                            
                            System.out.print("Enter Booking Date : ");
                            bdate = Input.next();
                            System.out.print("Enter Booking Time : ");
                            btime = Input.next();
                            System.out.print("Enter Number Of Guests : ");
                            NoOfGuests = Input.nextInt();
                            int ct = 0;
                            SingleBedRoom sRoom;
                            DoubleBedRoom dRoom;
                            while(true){
                            System.out.println("1.Single Bed Room");
                            System.out.println("2.Double Bed Room");
                            System.out.print("Enter your choice : ");
                            ct = Input.nextInt();
                            if(ct == 1){
                                sRoom = new SingleBedRoom(price, RoomId, bdate, btime,NoOfGuests);
                                 //room.add(car);
                             if(sRoom.isFull() == false)
                                            System.out.println("Hotel Limit Exceeds!");
                                        else{
                                            //Adding car data if car is not full
                                        room.add(sRoom);
                                        System.out.println("Hotel Added Successfully!");
                                        //print object to call toString() method of car class
                                        System.out.println(sRoom);
                                        }
                             break;
                            }
                            
                            else if(ct == 2){
                                dRoom = new DoubleBedRoom(price, RoomId, bdate, btime,NoOfGuests);
                                 if(dRoom.isFull() == false)
                                            System.out.println("Hotel Limit Exceeds!");
                                        else{
                                            
                                        room.add(dRoom);
                                        System.out.println("Hotel Added Successfully!");
                                        //print object to call toString() method of car class
                                        System.out.println(dRoom);
                                        }
                                 break;
                            
                            }
                            else{
                                System.out.println("Invalid Type choice");
                                continue;
                            }
                            }
                            
                           
                            
                        } catch (InputMismatchException e) {
                            Input.nextLine();
                            System.out.println("\n" + e + "\n,Enter Correct Data,Enter to Continue!!!");
                            Input.nextLine();
                        }
                   
                break;
                
                    
              case '3':
                  //checking if their exist any hotelbranch data
                   if(hotelbranch.size() > 0){
                   for(int i=0;i<hotelbranch.size();i++){
                       //displaying all hotelbranchs info in system
                       System.out.println("Branch :  "+(i+1));
                       System.out.println("**************************************************************");
                       System.out.println("Id/Name              : "+hotelbranch.get(i).id);
                       System.out.println("Type                : "+hotelbranch.get(i).getHotelType());
                       System.out.println("Capacity  : "+hotelbranch.get(i).getHotelCapacity());
                       System.out.println("NO. Of Waiters : "+hotelbranch.get(i).getNoOfWaiters());
                       System.out.println("NO. Of Other Workers   : "+hotelbranch.get(i).getNoOfOtherWorker());
                       System.out.println("**************************************************************");
                   }
                  
                   }
                    else{
                          System.out.println("No Hotel Branch added yet!"); 
                           }
                
                
                break;
                
               case '4':
                  if (room.isEmpty()) {
            System.out.println("No Hotel in System!!!");
        } else {
            for(int i=0;i<room.size();i++) {
                System.out.println("**************************************************************");
                System.out.println("Booking Id : " +room.get(i).id);
                System.out.println("PRICE      : " + room.get(i).getHotelPrice());
                System.out.println("Room Id    : " + room.get(i).getHotelRoomIds());
                System.out.println("Booking date : " + room.get(i).getHotelBookingDate());
                System.out.println("Booking time : " + room.get(i).getHotelBookingTime());
                System.out.println("Number of guests : " + room.get(i).getHotelNoGuests());
                System.out.println("**************************************************************");

            }
        }
                    
                break;
                
               case '5':
                   break;
                    
               
                default:
                    //exit from system
                    System.out.println("Invalid Choice");
                    
                    
        }
        
        }

        
    }
    
    
    
    
}

interface HotelMenu {
    
     
    public void addHotelBranch();
    public void addHotelBooking();
    public void displayHotel();
    public void displayHotelBooking();
    

}


abstract class HotelManagement implements HotelMenu{
   public int id;
   
   final int capacity = 20;
 //empty constuctor of user class
    public HotelManagement() {
    }

    
   
}


class HotelBranch extends HotelManagement{
    //class data members
    
    private String hotelType;
    private int hotelCapacity;
    private int noOfWaiters;
    private int noOfOtherWorker;
   
   
   static int added = 0;
   
   

    public HotelBranch(int branchId,String hotelType, int hotelCapacity, int hoOfWaiters, int noOfOtherWorker) {
        super.id = branchId;
        this.hotelType = hotelType;
        this.hotelCapacity = hotelCapacity;
        this.noOfWaiters = noOfWaiters;
        this.noOfOtherWorker = noOfOtherWorker;
        
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public int getHotelCapacity() {
        return hotelCapacity;
    }

    public void setHotelCapacity(int hotelCapacity) {
        this.hotelCapacity = hotelCapacity;
    }

    public int getNoOfWaiters() {
        return noOfWaiters;
    }

    public void setNoOfWaiters(int noOfWaiters) {
        this.noOfWaiters = noOfWaiters;
    }

    public int getNoOfOtherWorker() {
        return noOfOtherWorker;
    }

    public void setNoOfOtherWorker(int noOfOtherWorker) {
        this.noOfOtherWorker = noOfOtherWorker;
    }
    
    

    
   
   
 
    
 public void addHotelBranch(){
 
 
 }
  public void displayWeedingHotel(){
  
  }
    
    
//us full function to check limit
    public boolean isFull(){
            HotelBranch.added += 1;
        System.out.println("added : "+added);
        if(added >= this.hotelCapacity)
        {
            
            return false;
            
        }
        else{
             
            return true;
        }
    }

    @Override
    public String toString() {
        return "HotelBranch{" + "hotelType=" + hotelType + ", hotelCapacity=" + hotelCapacity + ", noOfWaiters=" + noOfWaiters + ", noOfOtherWorker=" + noOfOtherWorker + '}';
    }

    @Override
    public void addHotelBooking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayHotelBooking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

     
    
}



class Room extends HotelManagement {

    private double hotelPrice;
    private final int hotelRoomId;
    private final String hotelBookingDate;
    private final String hotelBookingTime;
    private final int hotelNoGuests;

    static int HALL_ID;
    int year = Year.now().getValue();
    
     public Room(double hotelPrice, int hotelRoomId, String hotelBookingDate, String hotelBookingTime, int hotelNoGuests) {
        this.hotelPrice = hotelPrice;
        this.hotelRoomId = hotelRoomId;
        this.hotelBookingDate = hotelBookingDate;
        this.hotelBookingTime = hotelBookingTime;
        this.hotelNoGuests = hotelNoGuests;
        super.id = HALL_ID;
                HALL_ID++;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }
     public double getHotelRoomIds() {
        return hotelRoomId;
    }
     public String getHotelBookingDate() {
        return hotelBookingDate;
    }
     public String getHotelBookingTime() {
        return hotelBookingTime;
    }
     public int getHotelNoGuests() {
        return hotelNoGuests;
    }

    @Override
    public void addHotelBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHotelBooking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayHotelBooking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Room{" + "hotelPrice=" + hotelPrice + ", hotelRoomId=" + hotelRoomId + ", hotelBookingDate=" + hotelBookingDate + ", hotelBookingTime=" + hotelBookingTime + ", hotelNoGuests=" + hotelNoGuests + ", year=" + year + '}';
    }

   
    

   

    
   

    

}




class DoubleBedRoom extends Room{
      public static int added;

    public DoubleBedRoom(double hotelPrice, int hotelRoomId, String hotelBookingDate, String hotelBookingTime, int hotelNoGuests) {
        super(hotelPrice, hotelRoomId, hotelBookingDate, hotelBookingTime, hotelNoGuests);
    }

   

   
    
     public boolean isFull(){
          //adding 1 patient when ever a patient addded to system
        added += 1;
        if(added > super.capacity)
        {
            System.out.println("addedd:"+added);
            System.out.println("capacity:"+super.capacity);
            return false;
            
        }
        else{
             System.out.println("addedd:"+added);
            System.out.println("capacity:"+super.capacity);
            return true;
        }
    }

}






class SingleBedRoom extends Room{
      public static int added;

    public SingleBedRoom(double hotelPrice, int hotelRoomId, String hotelBookingDate, String hotelBookingTime, int hotelNoGuests) {
        super(hotelPrice, hotelRoomId, hotelBookingDate, hotelBookingTime, hotelNoGuests);
    }

    

    
   
     public boolean isFull(){
          //adding 1 patient when ever a patient addded to system
        added += 1;
        if(added > super.capacity)
        {
            System.out.println("addedd:"+added);
            System.out.println("capacity:"+super.capacity);
            return false;
            
        }
        else{
             System.out.println("addedd:"+added);
            System.out.println("capacity:"+super.capacity);
            return true;
        }
    }
    
}

