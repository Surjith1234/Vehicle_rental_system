package VehicleProject;
import java.sql.SQLException;
import java.util.*;
public class Vehicle 
{
	public static void main(String[] args) throws SQLException 
	{
		String mail_id,pass_word;
		UserLogin ul;
		Admin al;
		Byte choice;
		CarRental cr = new CarRental();
		BikeRental br= new BikeRental();
		String c_name,c_licenceNumber,c_v_name;
		String c_phno;int c_v_id;
		int avail;
	    Customer c=new Customer();
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter 1 to Login");
    System.out.println("Enter 2 to Register");
    System.out.println("Enter 3 to Admin Login");
    choice=sc.nextByte();
    switch(choice)
    {
    case 1:
    	System.out.println("Enter Mail Id");
    	mail_id=sc.next();
    	System.out.println("Enter Password");
    	pass_word=sc.next();
    	ul=new UserLogin(mail_id,pass_word);
    	if(ul.find())
    	{
    		System.out.println("Select 1 to Bike");
    		System.out.println("Select 2 to Car");
			choice=sc.nextByte();
			switch(choice)
			{
			case 1:
				while(true)
				{
					System.out.println("Enter 1 to list a vehicle");
					System.out.println("Enter 2 to check Availability");
					System.out.println("Enter 3 to exit");
				    choice=sc.nextByte();
				    switch(choice)
				    {
				    case 1:
				    	br.displayVehicle();
				    	break;
				    case 2:
				    	System.out.println("Enter vehicle id to check availability");
				    	avail=sc.nextInt();
				    	if(br.checkAvailability(avail))
				    	{
				    	System.out.println("Enter a Name");
				    	c_name=sc.nextLine();
				    	System.out.println("Enter a Licence Number");
				    	c_licenceNumber=sc.nextLine();
				    	System.out.println("Enter a Phone Number");
				    	c_phno=sc.next();
				    	System.out.println("Enter a bike name you want");
				    	c_v_name=sc.nextLine();
				    	System.out.println("Enter a bike Id you want");
				    	c_v_id=sc.nextInt(); 
				    	c=new Customer(c_name,c_licenceNumber,c_phno, c_v_id,c_v_name,"Bike");
				    	}
				    	else
				    	{
				    		System.out.println("Not available");
				    	}
				    	break;
				    case 3:System.exit(0);
				    }    
				}
			case 2:
				while(true)
				{
					System.out.println("Enter 1 to list a vehicle");
					System.out.println("Enter 2 to Rent a vehicle");
				    choice=sc.nextByte();
				    switch(choice)
				    {
				    case 1:
				        cr.displayVehicle();
				    	break;
				    case 2:
				    	System.out.println("Enter vehicle id to check availability");
				    	avail=sc.nextInt();
				    	if(cr.checkAvailability(avail))
				    	{
				    	System.out.println("Enter a Name");
				    	c_name=sc.nextLine();
				    	System.out.println("Enter a Licence Number");
				    	c_licenceNumber=sc.nextLine();
				    	System.out.println("Enter a Phone Number");
				    	c_phno=sc.next();
				    	System.out.println("Enter a bike name you want");
				    	c_v_name=sc.nextLine();
				    	System.out.println("Enter a bike Id you want");
				    	c_v_id=sc.nextInt();
				    	c=new Customer(c_name,c_licenceNumber,c_phno,(int) c_v_id,c_v_name,"Car");
				         break;
				    	}
				    	else
				    	{
				    		System.out.println("Not available");
				    	}
				    	break;
				    case 3:System.exit(0);				    	
				    }				    
				}
			}
    	}    	
    case 2:
    	System.out.println("Enter Mail Id");
    	mail_id=sc.next();
    	System.out.println("Enter Password");
    	pass_word=sc.next();
    	ul=new UserLogin(mail_id,pass_word);
    	break;
    case 3:
    	System.out.println("Enter Mail Id");
    	mail_id=sc.next();
    	System.out.println("Enter Password");
    	pass_word=sc.next();
    	al=new Admin(mail_id,pass_word);
    	if(al.find())
    	{
    		String v_name,v_number;
    		int v_id,v_Rentalamt;
    		int dep_amt;
    		System.out.println("Select 1 to Bike");
    		System.out.println("Select 2 to Car");
    		choice=sc.nextByte();
    		switch(choice)
    		{
    		case 1:
    			while(true)
    			{
	    			System.out.println("Enter 1 to add a vehicle");
	    			System.out.println("Enter 2 to search a Bike");
	    			System.out.println("Enter 3 to change a caution deposit amount");
	    			choice=sc.nextByte();
	    			sc.nextLine();
	    			switch(choice)
	    			{
	    			case 1:
	    				System.out.println("Enter a Bike Name");
	    				v_name=sc.nextLine();
	    				System.out.println("Enter a Bike id");
	    				v_id=sc.nextInt();
	    				sc.nextLine();
	    				System.out.println("Enter a number plate number");
	    				v_number=sc.nextLine();
	    				System.out.println("Enter a Bike Rental Amount");
	    				v_Rentalamt=sc.nextInt();
	    				br=new BikeRental(v_name,v_id,v_number,v_Rentalamt);
	    				br.insert();
	    				break;
	    			case 2:	
	    				System.out.println("Enter a Bike name to visit");
	    				v_name=sc.nextLine();
	    				br.search(v_name);
	    				break;
	    			case 3:
	    				System.out.println("Enter a change deposit amount");
	    				dep_amt=sc.nextInt();
	    				br.setdeposit(dep_amt);
	    				break;
	    			}
	    			break;
    			}
    		case 2:
    			while(true)
    			{
	    			System.out.println("Enter 1 to add a vehicle");
	    			System.out.println("Enter 2 to search a car");
	    			System.out.println("Enter 3 to change a caution deposit amount");
	    			choice=sc.nextByte();
	    			switch(choice)
	    			{
	    			case 1:
	    				System.out.println("Enter a Car Name");
	    				v_id=sc.nextInt();
	    				System.out.println("Enter a Car id");
	    				v_name=sc.nextLine();
	    				System.out.println("Enter a number plate number");
	    				v_number=sc.nextLine();
	    				System.out.println("Enter a car Rental Amount");
	    				v_Rentalamt=sc.nextInt();
	    				cr=new CarRental(v_name,v_id,v_number,v_Rentalamt);
	    				break;
	    			case 2:	
	    				System.out.println("Enter a car name to visit");
	    				v_name=sc.nextLine();
	    				cr.search(v_name);
	    				break;
	    			case 3:
	    				System.out.println("Enter a change deposit amount");
	    				dep_amt=sc.nextInt();
	    				br.setdeposit(dep_amt);
	    				break;
	    			}  			
    			}	  			
    		}
    	}
    	break;
    }
	}
}
