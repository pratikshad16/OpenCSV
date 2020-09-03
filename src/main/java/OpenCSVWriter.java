import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static final String OBJECT_LIST_SAMPLE = "./sample.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));
        ) {
            StatefulBeanToCsv<MyUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<MyUser> myUsers = new ArrayList<>();
            myUsers.add(new MyUser("Ashwini Kole", "ash.kole@gmail.com", "9987349335", "India"));
            myUsers.add(new MyUser("Ayesha Khan", "khanayesha16@gmail.com", "222225053", "India"));

            beanToCsv.write(myUsers);
        }
    }
}

