import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteDiary {
    public static void main(String[] args) {
        String diaryFilePath = "Diary.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(diaryFilePath));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter content (enter END or end to finish):");
            while (true) {
                String input = scanner.nextLine();
                if ("END".equalsIgnoreCase(input)) {
                    break;
                }
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}