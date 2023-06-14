import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------- DICTIONARY APP -----------");
            System.out.println("1. Tìm kiếm theo Slang word.");
            System.out.println("2. Tìm kiếm theo Definition.");
            System.out.println("3. Add một Slang word mới.");
            System.out.println("4. Edit một Slang word.");
            System.out.println("5. Delete một Slang word");
            System.out.println("6. Reset danh sách Slang words gốc.");
            System.out.println("7. Random một Slang word.");
            System.out.println("8. Đố vui S.");
            System.out.println("9. Đố vui D.");
            System.out.println("0. Thoát.");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Thoát...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn sai. Vui lòng chọn lại.");
            }
        }
    }
}