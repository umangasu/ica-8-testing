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

    public String openFile(String path) throws Exception {
        String line = "";
        try {
            Path folder = Paths.get(path);
            System.out.println("Given path of files : " + folder);
            String filePath = folder + "/urinal.dat";
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("urinal.dat file not found in the given path");
            }
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                while ((line = br.readLine()) != null) {
                    System.out.println("Line : " + line);
                }
            }
            catch(Exception ex) {
                System.out.println("Exception while reading .dat file : " + ex.getMessage());
                throw new Exception();
            }
        }
        catch(Exception ex) {
            System.out.println("Exception in outer try block : " + ex.getMessage());
            throw ex;
        }
        return line;
    }

    public void validateString(String input) {
        if(input.length() == 0) {
            throw new IllegalArgumentException("Empty input string");
        }
        for(int i=0;i<input.length();i++) {
            if(!(input.charAt(i) == '0' || input.charAt(i) == '1')) {
                throw new IllegalArgumentException("Input String has invalid characters");
            }
        }
        if(input.length()>20 || input.length()<1)
            throw new IllegalArgumentException("Input String has invalid number of characters");
    }



}