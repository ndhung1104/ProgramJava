import student.StudentManagement;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        try {
            System.out.println("=== Student management program ===");
            boolean isRunning = true;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (isRunning) {

                System.out.println("---- MENU ----");
                System.out.println("1. Add student");
                System.out.println("2. Update student information");
                System.out.println("3. Delete a student");
                System.out.println("4. View student list with the student id in ascending order");
                System.out.println("5. View student list with the GPA in ascending order");
                System.out.println("6. Save student list into file (CSV)");
                System.out.println("7. Import student list from text file (CSV)");
                System.out.println("8. Export student list to text file (CSV)");
                System.out.println("0. Exit");
                System.out.print("Your choice: ");
                String choice = br.readLine();
                switch (choice) {
                    case "1": {
                        sm.addStudent(br);
                        break;
                    }
                    case "2": {
                        sm.updateStudentInfo(br);
                        break;
                    }
                    case "3": {
                        sm.deleteStudent(br);
                        break;
                    }
                    case "4": {
                        sm.viewStudentList("id");
                        break;
                    }
                    case "5": {
                        sm.viewStudentList("gpa");
                        break;
                    }
                    case "6": {
                        break;
                    }
                    case "7": {
                        System.out.print("Enter CSV file path to import (e.g., students.csv): ");
                        String path = br.readLine();
                        sm.importFromCSV(path);
                        break;
                    }
                    case "8": {
                        System.out.println("Enter CSV file path to export (e.g., student.csv): ");
                        String path = br.readLine();
                        sm.exportToCSV(path);
                        break;
                    }
                    case "0": {
                        isRunning = false;
                        break;
                    }
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            }
            br.close();
        } catch (Exception e) {
            System.err.println("Send halp to main! " + e.getMessage());
        }
    }
}
