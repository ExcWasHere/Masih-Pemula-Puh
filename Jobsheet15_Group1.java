
import java.util.Scanner;

public class Jobsheet15_Group1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MaxEntries = 26;
        String[] StudentName = new String[MaxEntries];
        String[] CourseCode = new String[MaxEntries];
        String[] CourseName = new String[MaxEntries];
        String[] StudentNim = new String[MaxEntries];
        int[] CreditHours = new int[MaxEntries];
        int EntryStorage = 0;

        while (true) {
            System.out.println("---KRS Exc,Keenan,Wahyu System---");
            System.out.println("1. Input Data KRS");
            System.out.println("2. Display List KRS Student");
            System.out.println("3. Analyze Data KRS");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                // Input Course Registration Data
                if (EntryStorage >= MaxEntries) {
                    System.out.println("Registration is full!");
                    continue;
                }

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Student ID Number (NIM): ");
                String nim = sc.nextLine();

                // Calculate current total credits for the student
                int totalCredits = 0;
                for (int i = 0; i < EntryStorage; i++) {
                    if (StudentNim[i].equals(nim)) {
                        totalCredits += CreditHours[i];
                    }
                }

                // Check credit limit
                if (totalCredits >= 20) {
                    System.out.println("Error: Maximum credit limit (20 SKS) reached!");
                    continue;
                }

                System.out.print("Enter Course Code: ");
                String courseCode = sc.nextLine();

                System.out.print("Enter Course Name: ");
                String courseName = sc.nextLine();

                System.out.print("Enter Credit Hours (1-3 SKS): ");
                int sks = sc.nextInt();

                // Validate credit hours
                if (sks < 1 || sks > 3) {
                    System.out.println("Error: Credit hours must be between 1 and 3 SKS!");
                    continue;
                }

                // Check total credits after adding new course
                if (totalCredits + sks > 20) {
                    System.out.println("Error: Adding this course exceeds 20 SKS limit!");
                    continue;
                }

                // Add course registration data
                StudentName[EntryStorage] = name;
                StudentNim[EntryStorage] = nim;
                CourseCode[EntryStorage] = courseCode;
                CourseName[EntryStorage] = courseName;
                CreditHours[EntryStorage] = sks;

                EntryStorage++;
                System.out.println("Course registration added successfully!");
            } else if (choice == 2) {
                // Display Student Course Registration
                System.out.print("Enter Student ID Number (NIM) to display: ");
                String searchNIM = sc.nextLine();

                int totalCredits = 0;
                boolean found = false;

                System.out.println("\n--- Course Registration for NIM: " + searchNIM + " ---");
                for (int i = 0; i < EntryStorage; i++) {
                    if (StudentNim[i].equals(searchNIM)) {
                        System.out.println("Course Code: " + CourseCode[i]);
                        System.out.println("Course Name: " + CourseName[i]);
                        System.out.println("Credit Hours: " + CreditHours[i] + " SKS");
                        System.out.println("---");
                        totalCredits += CreditHours[i];
                        found = true;
                    }
                }

                if (found) {
                    System.out.println("Total Credit Hours: " + totalCredits + " SKS");
                } else {
                    System.out.println("No course registrations found for this NIM.");
                }

            } else if (choice == 3) {
                // Analyze Students with Low Credit Hours
                System.out.println("\n--- Students Taking Less Than 20 SKS ---");

                // Track analyzed NIM
                String[] analyzedNIMs = new String[EntryStorage];
                int analyzedCount = 0;
                int lowCreditStudentCount = 0;

                for (int i = 0; i < EntryStorage; i++) {
                    String currentNIM = StudentNim[i];

                    // Check if NIM has been analyzed
                    boolean isAnalyzed = false;
                    for (int j = 0; j < analyzedCount; j++) {
                        if (analyzedNIMs[j].equals(currentNIM)) {
                            isAnalyzed = true;
                            break;
                        }
                    }

                    // Skip if NIM already analyzed
                    if (isAnalyzed) {
                        continue;
                    }

                    // Calculate total credits for this student
                    int studentTotalCredits = 0;
                    for (int j = 0; j < EntryStorage; j++) {
                        if (StudentNim[j].equals(currentNIM)) {
                            studentTotalCredits += CreditHours[j];
                        }
                    }

                    // Check student has less than 20 SKS
                    if (studentTotalCredits < 20) {
                        System.out.println("NIM: " + currentNIM);
                        System.out.println("Name: " + StudentName[i]);
                        System.out.println("Total Credits: " + studentTotalCredits + " SKS");
                        System.out.println("---");
                        lowCreditStudentCount++;

                        // Mark this NIM as analyzed
                        analyzedNIMs[analyzedCount] = currentNIM;
                        analyzedCount++;
                    }
                }

                System.out.println("Total Students with Less Than 20 SKS: " + lowCreditStudentCount);

            } else if (choice == 4) {
                // Exit system
                System.out.println("Thankyou For Using EKW System. HaveFun!");
                break;

            } else {
                // Invalid choice
                System.out.println("Invalid choice. Please try again!.");
            }

        }
        sc.close();
    }
}
