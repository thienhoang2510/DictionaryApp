import java.io.*;
import java.util.*;

public class SlangWordService {
    Scanner scanner = new Scanner(System.in);
    private static final String slangWordFile = "slang.txt";
    private static final String slangWordUpdateFile = "slang_update.txt";
    public Map<String, String> map = new HashMap<>();
    public ArrayList<Object> history = new ArrayList<>();

    public void loadSlangWordsFromFile() throws IOException {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchBySlangWord() {
        System.out.print("Enter slang word to search: ");
        String slangWord = scanner.nextLine().trim().toLowerCase();

        if (map.containsKey(slangWord)) {
            String definition = map.get(slangWord);
            System.out.println("[" + slangWord + "] : " + definition);
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
                System.out.println("[" + sw + "] : " + def);
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
            } else if (choice.equals("n")) {
                System.out.println("Deletion canceled. Slang word not deleted.");
            }
        } else {
            System.out.println("Slang word not found!");
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }

    public void resetSlangWords() throws IOException {
        map.clear();
        loadSlangWordsFromFile();
        System.out.println("Reset successfully.");
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }

    public void randomSlangWord() {
        Random random = new Random();
        List<String> key = new ArrayList<>(map.keySet());

        if (!key.isEmpty()) {
            String randomSlangWord = key.get(random.nextInt(key.size()));
            String definition = map.get(randomSlangWord);
            System.out.println("Random Slang Word:");
            System.out.println("[" + randomSlangWord + "] : " + definition);
        } else {
            System.out.println("Slang words not available!");
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }

    public void slangWordFunQuiz() {
        Random random = new Random();
        List<String> keys = new ArrayList<>(map.keySet());
        String randomSlangWord = keys.get(random.nextInt(keys.size()));
        String definition = map.get(randomSlangWord);
        String[] options = randomOptionForSlang(keys, randomSlangWord, 4);

        System.out.println("Fun quiz - Guess the Slang Word:");
        System.out.println("Definition: " + definition);

        System.out.println("Options:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your answer (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice >= 1 && choice <= 4) {
            String selectedSlangWord = options[choice - 1];
            if (selectedSlangWord.equals(randomSlangWord)) {
                System.out.println("Congratulation! Your answer correct.");
            } else {
                System.out.println("Wrong answer! The correct slang word is: " + randomSlangWord);
            }
        } else {
            System.out.println("Invalid choice!");
        }
        System.out.print("Press enter to return to Menu!!!");
        scanner.nextLine();
    }
    public void definitionFunQuiz() {
        Random random = new Random();
        List<String> keys = new ArrayList<>(map.keySet());
        String randomSlangWord = keys.get(random.nextInt(keys.size()));
        String randomDefinition = map.get(randomSlangWord);
        String[] options = randomOptionsForDef(keys, randomSlangWord, randomDefinition, 4);

        System.out.println("Fun quiz - Guess the Definition:");
        System.out.println("Slang Word: " + randomSlangWord);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Enter your answer (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice >= 1 && choice <= 4) {
            String selectedDefinition = options[choice - 1];
            if (selectedDefinition.equals(randomDefinition)) {
                System.out.println("Congratulation! Your answer correct.");
            } else {
                System.out.println("Wrong answer! The correct definition is: " + randomDefinition);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
    private String[] randomOptionForSlang(List<String> keys, String answer, int numOptions) {
        Random random = new Random();
        List<String> options = new ArrayList<>();
        options.add(answer);
        while (options.size() < numOptions) {
            String randomSlangWord = keys.get(random.nextInt(keys.size()));
            if (!options.contains(randomSlangWord)) {
                options.add(randomSlangWord);
            }
        }
        return options.toArray(new String[0]);
    }
    private String[] randomOptionsForDef(List<String> keys, String correctSlangWord, String correctDefinition, int numOptions) {
        List<String> options = new ArrayList<>();
        options.add(correctDefinition);

        Random random = new Random();
        while (options.size() < numOptions) {
            String randomSlangWord = keys.get(random.nextInt(keys.size()));
            String randomDefinition = map.get(randomSlangWord);
            if (!options.contains(randomDefinition) && !randomSlangWord.equals(correctSlangWord)) {
                options.add(randomDefinition);
            }
        }
        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }
    private void addToHistory(String slangWord) {
        String item = slangWord;
        history.add(item);
    }
}
