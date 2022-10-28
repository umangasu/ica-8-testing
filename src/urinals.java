//Author - Umang Sahastransu

import org.junit.jupiter.api.function.Executable;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class urinals {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public Boolean getString() {  // checks to see if valid string
        return true;
    }

    public String inputMethod(String inputMethod) throws Exception {
        Scanner newscan = new Scanner(System.in);
        String input = "-1";
        if(inputMethod.equalsIgnoreCase("keyboard")) {
            System.out.println("Enter the string : ");
            input = newscan.nextLine();
        } else if(inputMethod.equalsIgnoreCase("file")) {
            System.out.println("Enter the path where the file exists : ");
            String path = newscan.nextLine();
//            input = openFile(path);
        }
        return input;
    }



}