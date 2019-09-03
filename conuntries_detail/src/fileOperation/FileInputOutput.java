/**
 * FileInputOutput.java
 *
 * This class design to control file operations.
 * It can read and save new country in countries list.
 * It can read and save country detail in records file.
 * It can read and save comments of selected country in comments file.
 * It holds temporary values on time of app execution.
 * It handles redirection of pages on call.
 *
 * @author Alexander Pinto
 * @version 1.0
 */
package fileOperation;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FileInputOutput {
    /**
     * Default error message constant
     */
    private final String IO_ERROR_MESSAGE = "ERROR: permission denied, please try again";
    /**
     * Class global file object reference
     */
    private File dataFile;

    /**
     * Convert string name into formatted form without space and convert it into lower case
     *
     * @param name String name of country or continent
     * @return Formatted name
     */
    private String formatName(String name) {
        return name.replaceAll("\\s+", "").toLowerCase();
    }

    /**
     * Add new country into countries list file
     *
     * @param name      name of the country
     * @param continent name of the continent associated to country
     * @throws Exception return exception of error occur
     */
    private void addCountryToList(String name, String continent) throws Exception {
        /** Format name of continent */
        continent = formatName(continent);
        /** Create file object of countries list for selected continent */
        dataFile = new File(Utils.getContinent(continent));
        /** Check if file is exist and create new if it doesnt */
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        /** Check if file has write access */
        if (dataFile.canWrite()) {
            /** Create buffer writer object to write content into file */
            BufferedWriter out = new BufferedWriter(new FileWriter(Utils.getContinent(continent), true));
            /** Append name of country in file */
            out.write(Utils.capitalise(name));
            /** Move cursor to new line for next record*/
            out.newLine();
            /** Close file*/
            out.close();
            return;
        }
        /** Throw exception if file doesnt have write permission */
        throw new Exception(IO_ERROR_MESSAGE);
    }

    /**
     * Get list of countries from file based on selected continent
     *
     * @param continent name of selected continent
     * @return ArrayList list of countries
     * @throws Exception return error if something goes wrong
     */
    public ArrayList<String> getCountriesFromList(String continent) throws Exception {
        /** Format name of continent */
        continent = formatName(continent);
        /** Create file object of countries list for selected continent */
        dataFile = new File(Utils.getContinent(continent));
        /** Create new file if it doesnt exist and return empty list */
        if (!dataFile.exists()) {
            dataFile.createNewFile();
            return new ArrayList<>();
        }
        /** Check if file has read permission */
        if (dataFile.canRead()) {
            /** Create buffer reader object to read content from file */
            BufferedReader in = new BufferedReader(new FileReader(Utils.getContinent(continent)));
            /** Create new array list to hold list of countries */
            ArrayList<String> data = new ArrayList<>();
            String record;
            /** Read all record from file and save it in array */
            while ((record = in.readLine()) != null) {
                data.add(record);
            }
            /** Close file */
            in.close();
            /** Sort record in alphabets order */
            Collections.sort(data);
            /** Return file list of countries */
            return data;
        }
        /** Return error if file doesnt have permission */
        throw new Exception(IO_ERROR_MESSAGE);
    }

    /**
     * Add new country detail into database
     *
     * @param name   name of country
     * @param record data of new country
     * @throws Exception return error if something goes wrong
     */
    public void addCountryRecord(String name, String record) throws Exception {
        /** Fetch and format name of currently selected continent */
        String continent = formatName(Utils.getInstance().getSelectedContinent());
        /** Create file object of countries record of selected continent */
        dataFile = new File(Utils.getCountryRecords(continent));
        /** Get list of all countries from database */
        ArrayList<String> countryList = getCountriesFromList(continent);
        /** Check if country is already exist in database and display error message */
        for (String country : countryList) {
            if (formatName(country).equals(formatName(name))) {
                throw new InvalidParameterException("Requested country is already exist in record database");
            }
        }
        /** Create new file if it doesnt exist */
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        /** Check if file has write permission */
        if (dataFile.canWrite()) {
            /** Create buffer writer object to write content in file */
            BufferedWriter out = new BufferedWriter(new FileWriter(Utils.getCountryRecords(continent), true));
            /** Set format of record */
            record = name + "===" + record;
            /** Append new country record in database */
            out.write(record);
            /** Move cursor to new line for next record */
            out.newLine();
            /** Close file*/
            out.close();
            /** Add name of country in countries list */
            addCountryToList(name, continent);
            return;
        }
        /** Return error if file does not have write permission */
        throw new Exception(IO_ERROR_MESSAGE);
    }

    /**
     * Get details of country from database
     *
     * @return hashmap object of country record
     * @throws Exception return error if something goes wrong
     */
    public HashMap<String, String> getCountryRecord() throws Exception {
        /** Fetch and format name of currently selected continent */
        String continent = formatName(Utils.getInstance().getSelectedContinent());
        /** Fetch and format name of currently selected country */
        String country = Utils.getInstance().getSelectedCountry();
        /** Create file object of countries record of selected continent */
        dataFile = new File(Utils.getCountryRecords(continent));
        /** Create object structure to store country detail */
        HashMap<String, String> hashMap = new HashMap<>();
        /** Create new file and return empty object if file doesnt exist */
        if (!dataFile.exists()) {
            dataFile.createNewFile();
            return hashMap;
        }
        /** Check if file has read permission */
        if (dataFile.canRead()) {
            /** Create buffer reader object to read content from file */
            BufferedReader in = new BufferedReader(new FileReader(Utils.getCountryRecords(continent)));
            String record;
            /** Read all record from file */
            while ((record = in.readLine()) != null) {
                /** Extract country name from record */
                String[] data = record.split("===");
                /** Check if record exist with matching name of country */
                if (country.toLowerCase().equals(data[0].toLowerCase())) {
                    /** Extract country record field and save it as hash map */
                    String[] row = data[1].split("::");
                    System.out.println(row);
                    hashMap.put("name", Utils.capitalise(row[0]));
                    hashMap.put("capital", Utils.capitalise(row[1]));
                    hashMap.put("language", Utils.capitalise(row[2]));
                    hashMap.put("area", row[3]);
                    hashMap.put("population", row[4]);
                    hashMap.put("currency", Utils.capitalise(row[5]));
                    hashMap.put("callingCode", row[6]);
                    hashMap.put("domain", row[7]);
                    hashMap.put("motto", !row[8].equals("null") ? Utils.capitalise(row[8]) : "Motto not available");
                    hashMap.put("description", !row[9].equals("null") ? Utils.capitalise(row[9]) : "No description available");
                }
            }
            /** Close file */
            in.close();
            /** Return country detail */
            return hashMap;
        }
        /** Return error if file doesnt have read permission*/
        throw new Exception(IO_ERROR_MESSAGE);
    }

    /**
     * Add new comment in database for selected country
     *
     * @param comment Comment message
     * @throws Exception Return error if something goes wrong
     */
    public void addComment(String comment) throws Exception {
        /** Fetch and format name of currently selected country */
        String country = formatName(Utils.getInstance().getSelectedCountry());
        /** Create file object of selected country comments */
        dataFile = new File(Utils.getComments(country));
        /** Create new file if it doesnt exist */
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        /** Check if file has write permission */
        if (dataFile.canWrite()) {
            /** Create buffer writer object to write content in file */
            BufferedWriter out = new BufferedWriter(new FileWriter(Utils.getComments(country), true));
            /** Add new comment in file */
            out.write(comment);
            /** Move cursor to new line for next record */
            out.newLine();
            /** Close file */
            out.close();
            return;
        }
        /** Return error if file does not have write permission */
        throw new Exception(IO_ERROR_MESSAGE);
    }

    /**
     * Get list of comments for selected country
     *
     * @return ArrayList List of comments
     * @throws Exception Return error if something goes wrong
     */
    public ArrayList<String> getComments() throws Exception {
        /** Get currently selected country from service */
        String country = formatName(Utils.getInstance().getSelectedCountry());
        /** Create file object of comments */
        dataFile = new File(Utils.getComments(country));
        /** Create file if it doesnt exist and return empty list */
        if (!dataFile.exists()) {
            dataFile.createNewFile();
            return new ArrayList<>();
        }
        /** Check if file has read permission*/
        if (dataFile.canRead()) {
            /** Create buffer reader object to read content from file */
            BufferedReader in = new BufferedReader(new FileReader(Utils.getComments(country)));
            /** Create new array list to store comments */
            ArrayList<String> comments = new ArrayList<>();
            String record;
            /** Read and store all comments in list */
            while ((record = in.readLine()) != null) {
                comments.add(record);
            }
            /** Close file*/
            in.close();
            return comments;
        }
        /** Return error if file does not have read permission */
        throw new Exception(IO_ERROR_MESSAGE);
    }
}
