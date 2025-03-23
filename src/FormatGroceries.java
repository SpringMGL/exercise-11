import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FormatGroceries {
    public static void main(String[] args) {
        String inputFile = "D:\\JAVA\\e11\\exercise\\Groceries.txt";
        String outputFile = "D:\\JAVA\\e11\\exercise\\FormattedGroceries.txt.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("| %-5s | %-15s | %-10s | %-10s |\n", "ID", "Item", "Quantity(KG)", "Price(€)"));
            writer.write(String.format("| %-5s | %-15s | %-10s | %-10s |\n", "---", "---", "---", "---"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                writer.write(String.format("| %-5s | %-15s | %-10s | %-10.2f |\n", 
                    parts[0], parts[1], parts[2], Double.parseDouble(parts[3])));
            }

            double total = 0;
            reader.reset();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                total += Double.parseDouble(parts[3]);
            }
            writer.write(String.format("*********************************************************** The grocery shopping total is: €%.2f ***********************************************************\n", total));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}