package Laba2;

import java.util.ArrayList;

public class StudentJournal {
    String curatorName;
    ArrayList<Student> students;
    int numberOfStudents;

    StudentJournal(String curatorName) {
        students = new ArrayList<Student>();
        this.curatorName = curatorName;
    }

    StudentJournal() {
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student) {
        students.add(student);
        numberOfStudents ++;
    }

    public Student getStudentAt(int at) {
        return students.get(at);
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

}
