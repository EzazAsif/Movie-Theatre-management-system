import java.util.Scanner;
import java.io.*;
public class FileHandler {
    public void createFile(String filename){
        File file=new File(filename + ".txt");
    }
    public void readFile(String filename){
        try {
            BufferedReader b1 = new BufferedReader(new FileReader(filename + ".txt"));
            String content = b1.readLine();
            while (content != null) {
                System.out.println(content);
                content = b1.readLine();
            }
        }
        catch(IOException ie)
        {
            System.out.println("File error");
        }
    }
    public void writeFile(String filename,String str){

        try {
            BufferedWriter b1 = new BufferedWriter(new FileWriter(filename + ".txt"));
            b1.write(str);
            b1.close();
        }
        catch(IOException ie)
        {
            System.out.println("File error");
        }
    }
}
