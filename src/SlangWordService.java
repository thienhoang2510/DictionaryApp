import java.io.*;
import java.util.*;

public class SlangWordService {
    Scanner scanner = new Scanner(System.in);
    private static final String slangWordFile = "slang.txt";
    private static final String slangWordUpdateFile = "slang_update.txt";
    public Map<String, String> map = new HashMap<>();
    public ArrayList<Object> history = new ArrayList<>();

    public void loadSlangWordsFromFile() throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(slangWordFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("`");
                if (parts.length >= 2) {
                    String slangWord = parts[0].trim();
                    String definition = parts[1].trim();
                    map.put(slangWord.toLowerCase(Locale.ROOT), definition);
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void searchBySlangWord() {
        System.out.print("Enter slang word to search: ");
        String slangWord = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(slangWord)) {
            String definition = map.get(slangWord);
            System.out.println("Definition: " + definition);
            addToHistory(slangWord);
        } else {
            System.out.println("Slang word not found!");
        }
        System.out.print("Press enter to return to Menu.");
        scanner.nextLine();
    }
    public void searchByDefinition() {
        System.out.print("Enter definition to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String sw = entry.getKey();
            String def = entry.getValue();
            if (def.toLowerCase().contains(keyword)) {
                System.out.println("[" + sw + "] : [" + def + "]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Slang words not found with definition!");
        }
        addToHistory(keyword);
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void showHistory() {
        System.out.println("Search History:");
        for (Object item : history) {
            System.out.println(item);
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void addNewSlangWord() {
        System.out.print("Enter slang word to add: ");
        String slangWord = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(slangWord)) {
            System.out.println("Slang word already exists.");
            System.out.println("Add failed!");
        } else {
            System.out.print("Enter the definition: ");
            String definition = scanner.nextLine().trim();
            map.put(slangWord, definition);
            System.out.println("Slang word added successfully.");
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void editSlangWord() {
        System.out.print("Enter slang word to edit: ");
        String slangWord = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(slangWord)) {
            System.out.print("Enter new definition: ");
            String newDefinition = scanner.nextLine().trim();
            map.put(slangWord, newDefinition);
            System.out.println("Edit successfully.");
        } else {
            System.out.println("Slang word not found!");
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void deleteSlangWord() {
        System.out.print("Enter slang word to delete: ");
        String slangWord = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(slangWord)) {
            System.out.println("Are you sure you want to delete this slang word? (y/n)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                map.remove(slangWord);
                System.out.println("Slang word deleted successfully.");
            } else {
                System.out.println("Deletion canceled. Slang word not deleted.");
            }
        } else {
            System.out.println("Slang word not found.");
        }
    }
    public void resetSlangWords() throws IOException {
        map.clear();
        loadSlangWordsFromFile();
        System.out.println("Reset successfully.");
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void addToHistory(String slangWord) {
        String item = slangWord;
        history.add(item);
    }
}
