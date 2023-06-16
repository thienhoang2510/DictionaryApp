import java.io.*;
import java.util.*;

public class GetFile {
    public static TreeMap<String, String> readFile(String filename) throws IOException {
        TreeMap<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String parts[] = line.split("`", 2);
                if (parts.length >= 2) {
                    map.put(parts[0].toLowerCase(Locale.ROOT), parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void writeFile(String fileName, TreeMap<String, String> map) {
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(writer);
            for (String key : map.keySet()) {
                String line = String.join("`", key, map.get(key));
                line += "\n";
                bw.write(line);
            }
        } catch (IOException e) {
            System.err.format("Error: " + e.getMessage());
        }
    }
}
