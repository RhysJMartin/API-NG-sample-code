package trading;

import java.io.*;

/**
 * Created by user on 9/28/14.
 */
public class Login {

    void readLoginInfo(){
        File myFile = new File("C:\\Users\\user\\Desktop\\login.txt");
        try {
            FileReader myFileReader = new FileReader(myFile);
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);
            String myLine = myBufferedReader.readLine();
            String[] myResult = myLine.split(",");
            for(String token:myResult){
                System.out.println(token);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
