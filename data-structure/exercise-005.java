package javaapplication1;

import java.util.Scanner;

public class JavaApplication1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int number;

        System.out.println("Digite um número inteiro: ");
        number = leitor.nextInt();
        
        for (int line = 1; line <= number; line++) {
            String result = "";
            for (int column = 1; column <= line; column++) {
                result += line + " ";
            }
            System.out.println(result);
        }
    }
}
