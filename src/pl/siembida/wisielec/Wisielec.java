package pl.siembida.wisielec;

import java.util.Random;
import java.util.Scanner;

public class Wisielec {

    public static final String[] words = {
            "młotek",
            "gra",
            "java",
            "woreczek"
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int nrOfWord = rand.nextInt(words.length);
        String word = words[nrOfWord];
        boolean[] guessed = new boolean[word.length()];
        char c;
        int foults = 10;
        System.out.println("*******************Gra w wisielca*******************");
        do {
            System.out.println("Zgadujesz kolejne litery w słowie: ");
            System.out.println(guessedWord(word, guessed));
            System.out.println("Podaj literę: ");
            c = sc.next().charAt(0);
            if (!tryLetter(word, guessed, c)) {
                foults--;
                // rysowanie wisielca
                for (int i = 0; i < 10 - foults; i++) {
                    System.out.print("X ");
                }
                System.out.println();
            }
        } while (foults > 0 && !isGuessed(guessed));

        if(foults==0){
            System.out.println("\n*************");
            System.out.println("Przegrałeś!");
            System.out.println("***********\n");
        } else{
            System.out.println("\n*************");
            System.out.println("Wygrałeś!\nOdgadłeś słowo: "+ word);
            System.out.println("***********\n");
        }

    }

    private static boolean isGuessed(boolean[] guess) {
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == false) {
                return false;
            }
        }
        return true;
    }


    private static boolean tryLetter(String word, boolean[] guess, char c) {
        boolean goal = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                guess[i] = true;
                goal = true;
            }
        }
        return goal;
    }

    private static String guessedWord(String word, boolean[] guess) {
        {
            StringBuilder s = new StringBuilder(word);
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == false) {
                    s.replace(i, i + 1, ".");
                }
            }
            return s.toString();
        }
    }
}