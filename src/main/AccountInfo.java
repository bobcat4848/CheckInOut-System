package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AccountInfo {

    private File file;
    private BufferedWriter bw;
    private BufferedReader br;

    public AccountInfo() {
        try {
            File dir = new File(System.getProperty("user.dir"));
            this.file = new File(dir.getAbsoluteFile(), "accountData.cfg");

            if (!file.exists()) {
                file.createNewFile();
            }

            this.bw = new BufferedWriter(new FileWriter(file, true));
            this.br = new BufferedReader(new FileReader(file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(String[] toWrite) {
        try {
            for (int i = 0; i < toWrite.length; i++) {
                if (i == toWrite.length - 1) {
                    bw.write(toWrite[i]);
                    break;
                }
                bw.write(toWrite[i] + ";");
            }
            bw.newLine();
            bw.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /*
    public void rewrite(int lineNumber, String[] newInfo) {
        try {
            HashMap<Integer, String[]> previousInfo = read();
            previousInfo.put(lineNumber, newInfo);
            for (Map.Entry<Integer, String[]> entry : previousInfo.entrySet()) {
                if (entry.getValue() == newInfo) {
                    this.bw = new BufferedWriter(new FileWriter(file, false));
                } else {
                    this.bw = new BufferedWriter(new FileWriter(file, true));
                    String[] toWrite = entry.getValue();
                    for (int i = 0; i < toWrite.length; i++) {
                        if (i == toWrite.length - 1) {
                            bw.write(toWrite[i]);
                            break;
                        }
                        bw.write(toWrite[i] + ";");
                    }

                    bw.newLine();
                }
            }

            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/

    public HashMap<Integer, String[]> read() {
        HashMap<Integer, String[]> output = new HashMap<>();
        int lineNumber = 0;
        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userOutput = line.split(";");
                output.put(lineNumber, userOutput);
                lineNumber++;

                // Debug Code to test that values are not null
                /*
                System.out.println("The user data is " + userOutput[0] + userOutput[1] + userOutput[2] +
                        " and the line number is " + lineNumber);
                System.out.println("The Hashmap output is ");
                String[] userInformation = {};
                for (Map.Entry<Integer, String[]> entry : output.entrySet()) {
                    userInformation = entry.getValue();
                }
                System.out.println(userInformation[0] + userInformation[1] + userInformation[2]);
                */
            }

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return output;
    }
}