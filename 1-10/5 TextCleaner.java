import java.util.Scanner;

public class TextCleaner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите начальный символ:");
        char startChar = scanner.next().charAt(0);

        System.out.println("Введите конечный символ:");
        char endChar = scanner.next().charAt(0);

        String cleanedText = removeTextBetween(text, startChar, endChar);
        
        System.out.println("Результат: " + cleanedText);
    }

    public static String removeTextBetween(String text, char start, char end) {
        StringBuilder result = new StringBuilder();
        boolean inside = false; // Флаг для отслеживания, находимся ли мы между символами

        for (char c : text.toCharArray()) {
            if (c == start) {
                inside = true; // Начало части для удаления
            }
            if (!inside) {
                result.append(c); 
            }
            if (c == end) {
                inside = false; 
            }
        }

        return result.toString();
    }
}
