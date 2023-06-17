import java.io.*;
import java.util.*;

public class SlangWordService {
    Scanner scanner = new Scanner(System.in);
    private static final String slangWordFile = "slang.txt";
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
    public void showHistory() {
        System.out.println("Search History:");
        for (Object item : history) {
            System.out.println(item);
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void addToHistory(String slangWord) {
        String item = slangWord;
        history.add(item);
    }
}
