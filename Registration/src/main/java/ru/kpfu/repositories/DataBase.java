package ru.kpfu.repositories;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import ru.kpfu.interfaces.DataBaseInterface;

import java.io.*;

/**
 * Created by Admin on 21.09.2016.
 */
public class DataBase implements DataBaseInterface{

    public void Writer(String[] message) throws IOException {

        CSVWriter writer = new CSVWriter(new FileWriter("D:\\registration1.csv", true), ',');
        writer.writeNext(message);
        writer.flush();
    }

    public boolean Reader(String login) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("D:\\registration1.csv"), ',');
        String[] stringOfData;
        while ((stringOfData = reader.readNext()) != null) {
            if(stringOfData[0].equals(login)) return true;
        }
        return false;

    }
}
