import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "/home/roksana/Desktop/tekstDoLab4.txt";
        System.out.println("wynik" + huffmanAlg(filePath));
    }

    public static String huffmanAlg(String filePath) {
        String text = "";
        try (BufferedReader b = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = b.readLine()) != null) {
                text = text + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int L = text.length();
        String uniqueChars = uniqueCharacters(text);
        int numberOfChars = uniqueChars.length();
        int N = (int) Math.ceil(Math.log(numberOfChars) / Math.log(2));
        writeToFileNumberOfChars("/home/roksana/Desktop/dlugoscSlownika.txt", numberOfChars);
        Map<Character, String> mask = createMask(uniqueChars, N);
        int R = (8 - (L * N + 3) % 8) % 8; //nadmiarowe bity
        StringBuilder stringBuilder = new StringBuilder();
        return convertWithMask(stringBuilder, mask, text, R);
    }

    public static String uniqueCharacters(String text) {
        int[] characters = new int[128];
        String uniqueChar = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            characters[ch]++;
        }
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] > 0) {
                char ch = (char) i;
                uniqueChar = uniqueChar + ch;
            }
        }
        return uniqueChar;
    }

    public static void writeToFileNumberOfChars(String filePath, int numberOfChars) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write((char) numberOfChars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, String> createMask(String uniqueChars, int numberOfBits) {
        Map<Character, String> mask = new HashMap<>();
        for (int i = 0; i < uniqueChars.length(); i++) {
            mask.put(uniqueChars.charAt(i), toBinary(i, numberOfBits));
        }
        return mask;
    }

    public static String toBinary(int value, int numberOfBits) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            if (value % 2 == 1) {
                result.insert(0, 1);
            } else {
                result.insert(0, 0);
            }
            value = value / 2;
        }
        while (result.length() < numberOfBits) {
            result.insert(0, 0);
        }
        return result.toString();
    }

    public static String convertWithMask(StringBuilder inputStringBuilder, Map<Character, String> mask, String originalText, int R) {
        StringBuilder temp = new StringBuilder();
        temp.insert(0, toBinary(R, 3)); //informacja o liczbie nadmiarowych bitów
        String rest = "";
        int decimal;
        for (int i = 0; i < originalText.length(); i++) {
            String val = mask.get(originalText.charAt(i));
            temp.append(val);
            if (temp.length() >= 8) {
                String stringByte = mySubstring((temp.toString()), 0, 7);
                decimal = fromBinaryToDecimal(stringByte);
                inputStringBuilder.append((char) decimal);
                if (temp.length() > 8) {
                    rest = mySubstring((temp.toString()), 8, temp.length() - 1).trim();
                } else {
                    rest = "";
                }
                temp.delete(0, temp.length());
                temp.append(rest);

            } else if (i == originalText.length() - 1 && !temp.isEmpty()) {
                while (R > 0) {
                    temp.append(1);
                    R--;
                }
                decimal = fromBinaryToDecimal(temp.toString());
                inputStringBuilder.append((char) decimal);
            }
        }
        return inputStringBuilder.toString();
    }

    public static int fromBinaryToDecimal(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result = result + (int) (Math.pow(2, ((s.length() - 1) - i)));
            }
        }
        return result;
    }

    public static String mySubstring(String s, int index1, int index2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index1; i <= index2; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}