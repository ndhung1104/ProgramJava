package student;

import java.util.*;
import java.io.*;

public class StudentManagement {
    private ArrayList<Student> studentList = null;
    private Map<String, Student> studentMap = null;

    public StudentManagement() {
        this.studentList = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    public StudentManagement(ArrayList<Student> studentList) {
        this.studentList = studentList;

        studentMap = new HashMap<>();
        for (Student s : this.studentList) {
            studentMap.put(s.getId(), s);
        }
    }

    public void addStudent(BufferedReader br) {
        Student s = new Student();

        try {

            System.out.print("Input student id: ");
            s.setId(br.readLine().trim());

            System.out.print("Input student name: ");
            s.setName(br.readLine());

            System.out.print("Input student gpa: ");
            s.setGpa(Double.parseDouble(br.readLine()));

            System.out.print("Input student image: ");
            s.setImage(br.readLine());

            System.out.print("Input student note: ");
            s.setNote(br.readLine());
        } catch (IOException e) {
            System.err.println("Send halp to addStudent!");
        }

        studentList.add(s);
        studentMap.put(s.getId(), s);
        System.out.println("Add completed!");
    }

    private void printStudent(Student s) {
        System.out.println("Id: " + s.getId() + " - Name: " + s.getName() + " - GPA: " + s.getGpa() + " - Image: " + s.getImage() + " - Note: " + s.getNote());
    }

    private void printList() {
        for (Student s : studentList) {
            this.printStudent(s);
        }
    }

    public void viewStudentList(String element) {
        if (element.equals("id")) {
            studentList.sort(Comparator.comparing(Student::getId));
        } else {
            studentList.sort(Comparator.comparing(Student::getGpa));
        }
        printList();
    }


    public void updateStudentInfo(BufferedReader br) {
        try {
            System.out.print("Input student id: ");
            String idToSearch = br.readLine();
            Student foundStudent = studentMap.get(idToSearch);

            if (foundStudent == null) {
                System.out.println("Cannot find student with id " + idToSearch);
            } else {
                System.out.println("Found student with info: ");
                this.printStudent(foundStudent);
                System.out.println("Please enter new info for this student as below: ");

                System.out.print("Input student id: ");
                foundStudent.setId(br.readLine().trim());

                System.out.print("Input student name: ");
                foundStudent.setName(br.readLine());

                System.out.print("Input student gpa: ");
                foundStudent.setGpa(Double.parseDouble(br.readLine()));

                System.out.print("Input student image: ");
                foundStudent.setImage(br.readLine());

                System.out.print("Input student note: ");
                foundStudent.setNote(br.readLine());

                studentMap.remove(idToSearch);
                studentMap.put(foundStudent.getId(), foundStudent); // remove old key and add new key to map
            }
            System.out.println("Update completed!");
        } catch (Exception e) {
            System.err.println("Send halp to updateStudentInfo!");
        }
    }

    public void deleteStudent(BufferedReader br) {
        try {
            System.out.print("Input student id: ");
            String idToSearch = br.readLine();
            Student foundStudent = studentMap.get(idToSearch);

            if (foundStudent == null) {
                System.out.println("Cannot find student with id " + idToSearch);
            } else {
                studentList.removeIf(s -> s.getId().equals(idToSearch));
                studentMap.remove(idToSearch);
                System.out.println("Student has been removed!");
            }
        } catch (IOException e) {
            System.err.println("Send halp to deleteStudent!");
        }
    }

    public void importFromCSV(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();

            if (line.equals("id,name,gpa,image,note"))
                line = br.readLine(); // remove column name

            if (!line.isEmpty()) {
                studentMap.clear();
                studentList.clear();
            }

            while (line != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    Student s = new Student(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3], fields[4]);
                    studentList.add(s);
                    studentMap.put(s.getId(), s);
                }
                line = br.readLine();
            }
            br.close();
            System.out.println("Import completed!");

        } catch (Exception e) {
            System.err.println("Send halp to importFromCSV");
        }
    }

    public void exportToCSV(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write("id,name,gpa,image,note");
            bw.newLine();
            for (Student s : studentList) {
                bw.write(s.getId() + ",");
                bw.write(s.getName() + ",");
                bw.write(String.format(Locale.US, "%.2f,", s.getGpa()));
                bw.write(s.getImage() + ",");
                bw.write(s.getNote());
                bw.newLine();
            }
            bw.close();
            System.out.println("Export completed!");
        } catch (Exception e) {
            System.err.println("Send halp to exportToCSV");
        }
    }


}
