import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "./users.csv";
    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("name :" + nextRecord[1]);
                System.out.println("email :" + nextRecord[1]);
                System.out.println("phone :" + nextRecord[2]);
                System.out.println("country :" + nextRecord[3]);
                System.out.println("==================");
            }
        }
    }
}
