import java.util.Scanner;
public class CaesarCipherprogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text to encrypt: ");
        String plainText = scanner.nextLine(); 
        System.out.print("Enter the secret key: ");
        int key = scanner.nextInt();
        String caesarCipherText = caesarCipherEncrypt(plainText, key);
        System.out.println("Caesar Cipher Encrypted Text: " + caesarCipherText);
        String caesarDecryptedText = caesarCipherDecrypt(caesarCipherText, key);
        System.out.println("Caesar Cipher Decrypted Text: " + caesarDecryptedText);
        cryptanalysis(plainText, caesarCipherText);
        scanner.close();
    }
    private static String caesarCipherEncrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encryptedText.append((char) ((ch - base + key) % 26 + base));
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }
    private static String caesarCipherDecrypt(String text, int key) {
        return caesarCipherEncrypt(text, 26 - key); 
    }
    private static void cryptanalysis(String original, String caesarCipher) {
        System.out.println("\nCryptanalysis Results:");
        System.out.println("Original Text: " + original);
        System.out.println("Caesar Cipher Decryption Attempts:");
        for (int i = 1; i <= 26; i++) {
            System.out.println("Key " + i + ": " + caesarCipherDecrypt(caesarCipher, i));
        }
    }
}
