import java.util.*;
import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException {
        SlangWordService sw = new SlangWordService();
        Scanner scanner = new Scanner(System.in);
        sw.loadSlangWordsFromFile();

        while (true) {
            System.out.println("\n----- Dictionary App -----");
            System.out.println("1. Search by SlangWord:");
            System.out.println("2. Search by Definition:");
            System.out.println("3. Show History:");
            System.out.println("4. Add new SlangWord:");
            System.out.println("5. Edit SlangWord:");
            System.out.println("6. Delete SlangWord:");
            System.out.println("7. Reset SlangWord:");
            System.out.println("8. Random SlangWord:");
            System.out.println("9. Quiz - Guess the SlangWord:");
            System.out.println("10. Quiz - Guess the Definition:");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sw.searchBySlangWord();
                    break;
                case 2:
                    sw.searchByDefinition();
                    break;
                case 3:
                    sw.showHistory();
                    break;
                case 4:
                    sw.addNewSlangWord();
                    break;
                case 5:
                    sw.editSlangWord();
                    break;
                case 6:
                    sw.deleteSlangWord();
                    break;
                case 7:
                    sw.resetSlangWords();
                    break;
                case 8:
                    sw.randomSlangWord();
                    break;
                case 9:
                    sw.slangWordFunQuiz();
                    break;
                case 10:
                    sw.definitionFunQuiz();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}