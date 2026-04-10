package com.example.Assignment7;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Assignment7.controllers.TraineeController;

@SpringBootApplication
public class Assignment7Application  implements CommandLineRunner {
	
	@Autowired
	TraineeController traineeController; 

	public static void main(String[] args) {
		System.out.println("Application Context is Loaded!!!");
		SpringApplication.run(Assignment7Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {

//		 Scanner sc = new Scanner(System.in);
//
//	        while (true) {
//	            System.out.println("\nPick your operation:");
//	            System.out.println("1. Add a Trainee");
//	            System.out.println("2. Delete a Trainee");
//	            System.out.println("3. Modify a Trainee");
//	            System.out.println("4. Retrieve a Trainee by id");
//	            System.out.println("5. Retrieve a Trainee by Name");
//	            System.out.println("6. Retrieve all Trainees");
//	            System.out.println("7. Exit");
//
//	            int choice = sc.nextInt();
//
//	            switch (choice) {
//
//	            case 1:
//	            	sc.nextLine();
//	                Trainee t = new Trainee();
//	                System.out.println("Enter Name: ");
//	                t.setTraineeName(sc.nextLine());
//
//	                System.out.println("Enter Domain: ");
//	                t.setTraineeDomain(sc.next());
//
//	                System.out.println("Enter Location: ");
//	                t.setTraineeLocation(sc.next());
//
//	                Trainee saved = traineeController.addTrainee(t);
//	                System.out.println("Added with ID: " + saved.getTraineeId());
//	                break;
//
//	            case 2:
//	                System.out.print("Enter ID to delete: ");
//	                int id = sc.nextInt();
//	                traineeController.deleteTrainee(id);
//	                System.out.println("Deleted successfully");
//	                break;
//
//	            case 3:
//	            	sc.nextLine();
//	            	System.out.print("Enter ID to update: ");
//	                int uid = sc.nextInt();
//	                
//	                sc.nextLine();
//	                Trainee nt = new Trainee();
//	                System.out.println("Enter New Name: ");
//	                nt.setTraineeName(sc.nextLine());
//
//	                System.out.println("Enter New Domain: ");
//	                nt.setTraineeDomain(sc.next());
//
//	                System.out.println("Enter New Location: ");
//	                nt.setTraineeLocation(sc.next());
//
//	                Trainee updated = traineeController.updateTrainee(uid, nt);
//	                if (updated != null)
//	                    System.out.println("Updated successfully");
//	                else
//	                    System.out.println("Trainee not found");
//	                break;
//
//	            case 4:
//	                System.out.print("Enter ID: ");
//	                int rid = sc.nextInt();
//	                Optional<Trainee> tr = traineeController.getTrainee(rid);
//	              
//	                if (tr != null)
//	                    System.out.println(tr.get().getTraineeName() + " " + tr.get().getTraineeDomain());
//	                else
//	                    System.out.println("Not found");
//	                break;
//	            case 5:
//	            	sc.nextLine();
//	            	System.out.print("Enter Name: ");
//	                String rname= sc.nextLine();
//	                Optional<Trainee> tn = traineeController.findBytraineeName(rname);
//	              
//	                if (tn != null)
//	                    System.out.println(tn.get().getTraineeName() + " " + tn.get().getTraineeDomain());
//	                else
//	                    System.out.println("Not found");
//	                break;
//	            	
//	            case 6:
//	                List<Trainee> list = traineeController.getAllTrainees();
//	                for (Trainee tt : list) {
//	                    System.out.println("Id="+tt.getTraineeId() + ", Name=" + tt.getTraineeName()+ ", Domain="+ tt.getTraineeDomain()+", Location="+tt.getTraineeLocation());
//	                }
//	                break;
//
//	            case 7:
//	                System.exit(0);
//
//	            default:
//	                System.out.println("Invalid choice");
//    }
//	
//	

	        	}
	}
















