import java.util.Scanner;

public class ReadDataFromUser {

    public String getDataFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input that you want:");
        String input = scanner.nextLine().toUpperCase();
        System.out.println("The user input is " + input);
        return input;
    }
}
