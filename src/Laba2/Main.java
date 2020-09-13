package Laba2;

import com.google.gson.*;

import java.math.BigInteger;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        StudentJournal journal = new StudentJournal("Marya Ivanovna");

        String surname = null;
        String name = null;
        Date birthday = null;
        BigInteger phoneNumber = null;
        String address = null;
        boolean rightInput = false;
        Scanner in = new Scanner(System.in);
        String tempString;

       try{
           surname = "Vanya";
           name = "Durachok";
           birthday = format.parse("12.12.1992");
           phoneNumber = new BigInteger("380684535889");
           address = "Zalypivka village";
           journal.addStudent(new Student(surname, name, birthday, address, phoneNumber));
       } catch (Exception e) {
           System.out.println("Fooooooooooooooo");
           System.out.println(e.getMessage());
       }

        do{
            try{
                System.out.print("Name: ");
                tempString = in.nextLine().trim();
                if(tempString.matches("[a-zA-Z]*")) {
                    name = new String(tempString);
                    rightInput = true;
                }else {
                    rightInput = false;
                }
            }catch (Exception e) {
                rightInput = false;
            }
            if(!rightInput) {
                System.out.println("Please ,check correctness");
            }
        } while(!rightInput);

        do{
            try{
                System.out.print("Surname: ");
                tempString = in.nextLine().trim();
                if(tempString.matches("[a-zA-Z]*")) {
                    surname = new String(tempString);
                    rightInput = true;
                }else {
                    rightInput = false;
                }
            }catch (Exception e) {
                rightInput = false;
            }
            if(!rightInput) {
                System.out.println("Please ,check correctness");
            }
        } while(!rightInput);

        do{
            try{
                System.out.print("Birthday: ");
                tempString = in.nextLine().trim();
                if(tempString.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {

                    birthday = format.parse(tempString);
                    rightInput = true;
                }else {
                    rightInput = false;

                }
            }catch (Exception e) {
                rightInput = false;
            }
            if(!rightInput) {
                System.out.println("Please ,check correctness");
            }
        } while(!rightInput);


        do{
            try{
                System.out.print("Address: ");
                tempString = in.nextLine().trim();
                if(tempString.matches("[a-zA-Z\\s(\\d*)]*")) {
                    address = new String(tempString);
                    rightInput = true;
                }else {
                    rightInput = false;
                }
            }catch (Exception e) {
                rightInput = false;
            }
            if(!rightInput) {
                System.out.println("Please ,check correctness");
            }
        } while(!rightInput);

        do{
            try{
                System.out.print("Phone number: ");
                tempString = in.nextLine().trim();
                if(tempString.matches("\\d{12}")) {
                    phoneNumber = new BigInteger(tempString);
                    rightInput = true;
                }else {
                    rightInput = false;
                }
            }catch (Exception e) {
                rightInput = false;
            }
            if(!rightInput) {
                System.out.println("Please ,check correctness");
            }
        } while(!rightInput);

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthday(birthday);
        student.setAddress(address);
        student.setPhoneNumber(phoneNumber);
        try {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            String jsonText = gson.toJson(student);

            Student student1 = gson.fromJson(jsonText, Student.class);
            System.out.println('\n' + "Entered one in json string:");
            System.out.println(jsonText);
            System.out.print('\n' + "Equality of initial one and created from json: ");
            System.out.println(student.equals(student1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        journal.addStudent(student);

        System.out.println("Output all students from journal? Yes/No");

        try{
            String answer;
            answer = in.nextLine();
            if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                System.out.println('\n'+"Curator name: " + journal.getCuratorName());
                int numberOfStudent = journal.getNumberOfStudents();
                System.out.println("Number of students: " + numberOfStudent + 'n');
                for(int i=0; i < numberOfStudent; i++) {
                    System.out.println(journal.getStudentAt(i).toString());
                }
            }
        }catch (Exception e ) {
            System.out.println(e.getMessage());
        }
        tempString = in.nextLine();
        String garbage = "    /\\_____/\\\n" +
                "   /  o   o  \\\n" +
                        "  ( ==  ^  == )\n" +
                "   )         (\n" +
                        "  (           )\n" +
                " ( (  )   (  ) )\n" +
                        "(__(__)___(__)__)";
        System.out.println('\n' + garbage);

    }
}
