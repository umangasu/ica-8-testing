//Author - Umang Sahastransu

import org.junit.jupiter.api.function.Executable;

import java.io.*;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class urinals {
    public static void main(String[] args) throws Exception {
        urinals urinals = new urinals();
        String inputString = urinals.inputMethod("file");
        urinals.validateString(inputString);
        urinals.writeFile(inputString);
    }

    public String inputMethod(String inputMethod) throws Exception {
        Scanner newscan = new Scanner(System.in);
        String input = "-1";
        if(inputMethod.equalsIgnoreCase("keyboard")) {
            System.out.println("Enter the string : ");
            input = newscan.nextLine();
        } else if(inputMethod.equalsIgnoreCase("file")) {
            System.out.println("Enter the path where the file (urinal.dat) exists (Ex - /Users/umangsahastransu/IdeaProjects/ica-8-test) : ");
            String path = newscan.nextLine();
            input = openFile(path);
        }
        return input;
    }

    public String openFile(String path) throws IOException {
        String str = "";
        Path folder = Paths.get(path);
        System.out.println("Given path of file : " + folder);
        String filePath = folder + "/urinal.dat";
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("urinal.dat file not found in the given path");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                str = line;
                System.out.println("Line : " + str);
            }
        }
        catch(IOException ex) {
            System.out.println("Exception while reading .dat file : " + ex.getMessage());
            throw ex;
        }
        return str;

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
        if(input.length()>20)
            throw new IllegalArgumentException("Input String has invalid number of characters");
    }

    public int maxFreeUrinals(String inputString) {
        int error11 = inputString.indexOf("11");
        if (error11 != -1){
            return -1;
        }

        long previousCount = inputString.chars().filter(ch -> ch == '1').count();

        char[] ch = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            ch[i] = inputString.charAt(i);
        }

        for (int i = 0; i < ch.length; i++) {
            if (i == 0) {
                if (ch.length == 1) {
                    return 1 - Integer.parseInt(String.valueOf(ch[0]));
                } else if (ch[i] == '0' && ch[i + 1] == '0') {
                    ch[i] = '1';
                }
            } else if (i == ch.length - 1) {
                if (ch[i] == '0' && ch[i - 1] == '0') {
                    ch[i] = '1';
                }
            } else {
                if (ch[i] == '0' && ch[i - 1] == '0' && ch[i + 1] == '0') {
                    ch[i] = '1';
                }
            }
        }
            int curCount = 0;

            for (char c : ch) {
                if (c == '1') {
                    curCount++;
                }
            }

        return (int) (previousCount - curCount);

    }

    public void writeFile(String output) throws IOException {
        try {
            boolean ruleFilePresent = false;
            String folderName = ".";
            File[] listFiles = new File(folderName).listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    String fileName = listFiles[i].getName();
                    if (fileName.startsWith("rule")
                            && fileName.endsWith(".txt")) {
                        ruleFilePresent = true;
                        int fileCounter = 1;
                        if(fileName.charAt(4) != '.'){
                            fileCounter = Integer.parseInt(fileName.substring(4,5))+1;
                        }
                        String newFileName = "./rule" + fileCounter + ".txt";
                        File rename = new File(newFileName);
                        boolean flag = listFiles[i].renameTo(rename);
                        if(flag) {
                            System.out.println("File name incremented successfully");
                        } else {
                            throw new FileSystemException("Bad File name");
                        }
                    }
                }
            }
            if(!ruleFilePresent) {
                try {
                    File newRuleFile = new File("rule.txt");
                    if (newRuleFile.createNewFile()) {
                        System.out.println("File created in root directory of this repo: " + newRuleFile.getName());
                        BufferedWriter writer = new BufferedWriter(new FileWriter(newRuleFile));
                        writer.write(output);
                        writer.close();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    throw e;
                }
            }
        } catch(Exception exception) {
            System.out.println("File reading failed : " + exception.getMessage());
            exception.getStackTrace();
            throw new IOException("No files found in the given directory");
        }
    }


}