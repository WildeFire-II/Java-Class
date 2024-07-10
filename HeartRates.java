// Name: Aiden McBride
// Date: 7/10/24
// Class: CS145
// Assignment:  Lab 2 - Target heart rate calculator
// Purpose:  Create a class that will calculate target heart rate based on age.
// Citation: Deitel/Deitel - 11th edition (Late Objects)

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public HeartRates(String firstName, String lastName, int birthDay, int birthMonth, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    // Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Method to calculate age
    public int getAge() {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    // Method to calculate maximum heart rate
    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    // Method to calculate target heart rate range
    public String getTargetHeartRate() {
        int maxHeartRate = getMaxHeartRate();
        int lowerLimit = (int) (maxHeartRate * 0.50);
        int upperLimit = (int) (maxHeartRate * 0.85);
        return lowerLimit + " - " + upperLimit + " beats per minute";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for the person's information
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter birth day (1-31): ");
        int birthDay = input.nextInt();
        System.out.print("Enter birth month (1-12): ");
        int birthMonth = input.nextInt();
        System.out.print("Enter birth year: ");
        int birthYear = input.nextInt();

        // Instantiate an object of HeartRates
        HeartRates heartRates = new HeartRates(firstName, lastName, birthDay, birthMonth, birthYear);

        // Print the person's information
        System.out.println("\nPerson's Information:");
        System.out.println("First Name: " + heartRates.getFirstName());
        System.out.println("Last Name: " + heartRates.getLastName());
        System.out.println("Date of Birth: " + heartRates.getBirthMonth() + "/" + heartRates.getBirthDay() + "/" + heartRates.getBirthYear());

        // Calculate and print the person's age, maximum heart rate, and target heart rate range
        System.out.println("Age: " + heartRates.getAge() + " years");
        System.out.println("Maximum Heart Rate: " + heartRates.getMaxHeartRate() + " beats per minute");
        System.out.println("Target Heart Rate Range: " + heartRates.getTargetHeartRate());

        input.close();
    }
}
