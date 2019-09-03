package fileOperation;

import java.io.*;
import java.util.ArrayList;

public class FileInputOutput {
    private final String fileName = "phonebook.txt";
    private File dataFile;

    public FileInputOutput() {
        try {
            dataFile = new File(fileName);
            dataFile.createNewFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveData(String data) throws Exception {
        if (dataFile.exists() && dataFile.canWrite()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(data);
            out.newLine();
            out.close();
            return;
        }
        throw new Exception("ERROR: permission denied, please try again");
    }

    public ArrayList<String> getData() throws Exception {
        if (dataFile.exists() && dataFile.canRead()) {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            ArrayList<String> data = new ArrayList<>();
            String record;
            while ((record = in.readLine()) != null) {
                data.add(record);
            }
            return data;
        }
        throw new Exception("ERROR: permission denied, please try again");
    }
}
