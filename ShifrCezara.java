package All;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ShifrCezara {
    public void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зашифрованный текст Цезаря:");
        String str = scanner.nextLine();
        String new_str = "";
        for (int i = 0; i < str.length();i++){
            byte[] symvol = str.getBytes("US-ASCII");
            System.out.println(symvol);
        }
    }
}
