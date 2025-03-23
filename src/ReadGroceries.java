import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadGroceries {
    public static void main(String[] args) {
        String path = "D:\\JAVA\\e11\\exercise\\Groceries.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}