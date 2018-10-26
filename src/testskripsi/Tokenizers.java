/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testskripsi;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sayamafahri
 */
public class Tokenizers {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Tweet: ");
        String sentence = input.nextLine();
        
        StringTokenizer objToken = new StringTokenizer(sentence);
        int token_count = 1;
        
        System.out.println();
        System.out.println("-- Hasil Kalimat yang dihasilkan di hitung --");
        System.out.println();
        
        while(objToken.hasMoreTokens()) {
            System.out.println(objToken.nextToken() + " - Token # " + token_count);
            token_count++;
        }
    }
    
}
