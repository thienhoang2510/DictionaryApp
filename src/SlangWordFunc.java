import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlangWordFunc {
    public TreeMap<String, String> map;
    public ArrayList<String> Arr = new ArrayList<>();
    public SlangWordFunc() throws IOException {
        map = GetFile.readFile("slang.txt");
    }
}
