package GET;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterCounter {
    public static void main(String[] args) {
        // 提示用户输入文件名
        String fileName = readFileName();

        try {
            // 读取文件内容
            Path filePath = Paths.get(fileName);
            if (Files.exists(filePath)) {
                String text = new String(Files.readAllBytes(filePath));

                // 统计每个字母出现的次数
                Map<Character, Integer> charCounts = countLetters(text);

                // 输出结果
                for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
                    System.out.printf("Number of %cs:%d\n", entry.getKey(), entry.getValue());
                }
            } else {
                System.out.println("The file doesn't exist");
            }
        } catch (IOException e) {
            System.out.println("Error in reading file: " + e.getMessage());
        }
    }

    private static String readFileName() {
        // 先尝试使用 System.console().readLine()
        String fileName = System.console() != null ? System.console().readLine() : null;

        // 如果 System.console().readLine() 返回 null,则从标准输入中读取
        if (fileName == null) {
            System.out.println("Enter a filename:");
            fileName = new Scanner(System.in).nextLine();
        }

        return fileName;
    }

    private static Map<Character, Integer> countLetters(String text) {
        Map<Character, Integer> charCounts = new TreeMap<>();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char upperC = Character.toUpperCase(c);
                charCounts.merge(upperC, 1, Integer::sum);
            }
        }

        return charCounts;
    }
}