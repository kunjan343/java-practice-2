package fileOperation;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileInputOutput {
    private final String IO_ERROR_MESSAGE = "ERROR: permission denied, please try again";
    private File dataFile;

    private String formatName(String name) {
        return name.replaceAll("\\s+", "").toLowerCase();
    }

    private void addCountryToList(String name, String continent) throws Exception {
        continent = formatName(continent);
        dataFile = new File(Utils.getContinent(continent));
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        if (dataFile.canWrite()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(Utils.getContinent(continent), true));
            out.write(name);
            out.newLine();
            out.close();
            return;
        }
        throw new Exception(IO_ERROR_MESSAGE);
    }

    public ArrayList<String> getCountriesFromList(String continent) throws Exception {
        continent = formatName(continent);
        dataFile = new File(Utils.getContinent(continent));
        if (!dataFile.exists()) {
            dataFile.createNewFile();
            return new ArrayList<>();
        }
        if (dataFile.canRead()) {
            BufferedReader in = new BufferedReader(new FileReader(Utils.getContinent(continent)));
            ArrayList<String> data = new ArrayList<>();
            String record;
            while ((record = in.readLine()) != null) {
                data.add(record);
            }
            in.close();
            return data;
        }
        throw new Exception(IO_ERROR_MESSAGE);
    }

    public HashMap<String, String> getCountryRecord() throws Exception {
        String continent = formatName(Utils.getInstance().getSelectedContinent());
        String country = Utils.getInstance().getSelectedCountry();
        dataFile = new File(Utils.getCountryRecords(continent));
        HashMap<String, String> hashMap = new HashMap<>();
        if (!dataFile.exists()) {
            dataFile.createNewFile();
            return hashMap;
        }
        if (dataFile.canRead()) {
            BufferedReader in = new BufferedReader(new FileReader(Utils.getCountryRecords(continent)));
            String record;
            while ((record = in.readLine()) != null) {
                String[] data = record.split("===");
                if (country.toLowerCase().equals(data[0].toLowerCase())) {
                    String[] row = data[1].split("::");
                    System.out.println(row);
                    hashMap.put("name", row[0]);
                    hashMap.put("capital", row[1]);
                    hashMap.put("language", row[2]);
                    hashMap.put("area", row[3]);
                    hashMap.put("population", row[4]);
                    hashMap.put("currency", row[5]);
                    hashMap.put("callingCode", row[6]);
                    hashMap.put("domain", row[7]);
                    if (!row[8].isEmpty()) {
                        hashMap.put("motto", row[8]);
                    }
                    if (!row[9].isEmpty()) {
                        hashMap.put("description", row[9]);
                    }
                }
                in.close();
                return hashMap;
            }
        }
        throw new Exception(IO_ERROR_MESSAGE);
    }

    public void addCountryRecord(String name, String record) throws Exception {
        String continent = formatName(Utils.getInstance().getSelectedContinent());
        dataFile = new File(Utils.getCountryRecords(continent));
        ArrayList<String> countryList = getCountriesFromList(continent);
        for (String country : countryList) {
            if (country.equals(name)) {
                throw new InvalidParameterException("Requested country is already exist in record database");
            }
        }
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        if (dataFile.canWrite()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(Utils.getCountryRecords(continent), true));
            record = name + "===" + record;
            out.write(record);
            out.newLine();
            out.close();
            addCountryToList(name, continent);
            return;
        }
        throw new Exception(IO_ERROR_MESSAGE);
    }

    public ArrayList<String> getComments() throws Exception {
        String country = formatName(Utils.getInstance().getSelectedCountry());
        dataFile = new File(Utils.getComments(country));
        if (!dataFile.exists()) {
            dataFile.createNewFile();
            return new ArrayList<>();
        }
        if (dataFile.canRead()) {
            BufferedReader in = new BufferedReader(new FileReader(Utils.getComments(country)));
            ArrayList<String> comments = new ArrayList<>();
            String record;
            while ((record = in.readLine()) != null) {
                comments.add(record);
            }
            in.close();
            return comments;
        }
        throw new Exception(IO_ERROR_MESSAGE);
    }

    public void addComment(String comment) throws Exception {
        String country = formatName(Utils.getInstance().getSelectedCountry());
        dataFile = new File(Utils.getComments(country));
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        if (dataFile.canWrite()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(Utils.getComments(country), true));
            out.write(comment);
            out.newLine();
            out.close();
            return;
        }
        throw new Exception(IO_ERROR_MESSAGE);
    }
}
