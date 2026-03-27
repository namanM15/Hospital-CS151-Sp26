import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital("San Jose Hospital");

        while (true) {
            System.out.print("Hospital Main Menu\n" +
                            "==================\n" +
                            "1. Add Patient\n" +
                            "2. Add Doctor\n" +
                            "3. Create Appointment\n" +
                            "4. View Patients\n" +
                            "5. View Doctors\n" +
                            "6. View Appointments\n" +
                            "7. Add Room\n" +
                            "8. Assign Room to Patient\n" +
                            "9. Exit\n" +
                            "Choose an option: ");
                    
            String input = sc.nextLine();
        }
    }
}
