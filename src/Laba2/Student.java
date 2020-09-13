package Laba2;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String surname;
    private String name;
    private Date birthday;
    private BigInteger phoneNumber;
    private String address;

    Student() {
    }

    Student(String surname, String name, Date birthday,  String address, BigInteger phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getBirthday() {
        SimpleDateFormat birthdayString = new SimpleDateFormat();

        return birthdayString.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = (Date) birthday.clone();
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean equals(Student student) {
        if (!this.name.equalsIgnoreCase(student.name)) {
            return false;
        } else if (!this.surname.equalsIgnoreCase(student.surname)) {
            return false;
        } else if (this.birthday.getTime() != student.birthday.getTime()) {
            return false;
        } else if (this.phoneNumber.compareTo(student.phoneNumber) != 0) {
            return false;
        } else return this.address.equalsIgnoreCase(student.address);
    }

    public String toString() {

        return "Name: " + name + '\n' +
                "Surname: " + surname + '\n' +
                "Birthday: " + birthday + '\n' +
                "Address: " + address + '\n' +
                "Phone number: " + phoneNumber + '\n';
    }

}