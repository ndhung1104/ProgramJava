package student;
import java.io.*;

public class Student {
    private String id = "";
    private String name = "";
    private double gpa = 0;
    private String image = "";
    private String note = "";

    public Student(String id, String name, double gpa, String image, String note) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.image = image;
        this.note = note;
    }

    public Student() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
