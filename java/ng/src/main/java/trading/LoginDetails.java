package trading;

import java.io.*;

/**
 * Created by user on 3/5/14.
 */
public class LoginDetails {

    private String applicationKey;
    private String sessionToken;
    private Boolean jsonOrRescript;
    private File myFile;


    public LoginDetails(File aFileName) {
        this.myFile = aFileName;
        readLoginInfo();
        jsonOrRescript = true;
    }

    void readLoginInfo(){
        try {
            FileReader myFileReader = new FileReader(myFile);
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);
            String myLine = myBufferedReader.readLine();
            String[] myResult = myLine.split(",");
            applicationKey = myResult[0];
            sessionToken = myResult[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public Boolean getJsonOrRescript() {
        return jsonOrRescript;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void setJsonOrRescript(Boolean jsonOrRescript) {
        this.jsonOrRescript = jsonOrRescript;
    }
}

