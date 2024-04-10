import java.util.Scanner;
public class caserCipherProgram{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String plainText=sc.nextLine();
int key=sc.nextInt();
System.out.println("enter the encrypt:");
String caserCipherText=caserCipherEncrypt(plainText,key);
System.out.println("Case cipher encrypt:"+caserCipherText);
String caserDecryptedText=caserDecrypt(caserCipherText,key);
System.out.println("Case cipher decrypt:"+caserDecryptedText);
cryptanalysis(plainText, key);
sc.close();
}
private static String caserCipherEncrypt(String text,int key){
StringBuilder res=new StringBuilder();
for(char ch:text.toCharArray()){
if(Character.isLetter(ch)){
char base=Character.isUpperCase(ch)?'A':'a';
res.append((char)((ch-base+key)%26+base));
}
else{
res.append(ch);
}
}
return res.toString();
}
private static String caserDecrypt(String text,int key){
return caserCipherEncrypt(text,26-key);
}
private static void cryptanalysis(String original,String caserCipher){
System.out.println("cryptanalysis:");
System.out.println("original Text:"+original);
System.out.println("caserDecryption Attempts:");
for(int i=1;i<=26;i++){
String decryptedText = caserDecrypt(caserCipher,i);
System.out.println("key"+i+":"+decryptedText);
if(decryptedText.equalsIgnoreCase(original)){
System.out.println("Match found at key"+i+"! Decrypted text matches original.");
break;
}
}
}
}
