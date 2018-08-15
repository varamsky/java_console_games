/**
This is a console version of the hangman game in java.
You might like to add few more words to the Words 'repository' to make a little bit more interesting!
*/

import java.util.Random;
import java.util.Scanner;

public class simple_Hangman
{

    public static void main(String sk[]) {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        String repository[] = {"world", "hello", "signature", "delta", "speed", "bodyguard", "ball", "donkey", "creature", "hound", "hell", "random", "repository", "dance", "music", "alien", "floor", "heaven", "madam", "atom", "life", "jaguar", "fathom"};

        System.out.println("\n\t\t\t\tHangman\n\n");
        System.out.print("\t\t\t  ");

        String guess;
        int i, j, rl, c = -5;
        int rand = random.nextInt(6);

        rl = repository[rand].length();

        String word[] = new String[rl];

        for (i = 0; i < rl; i++) {
            word[i] = "_";
            System.out.print(" " + word[i] + " ");
        }
        System.out.println("\n\n");

        for (j = 1; j <= 15; j++) {
            c = 0;

            System.out.print("\nEnter your guess : ");
            guess = sc.next();

            if (guess.length() != 1) {
                j--;
                continue;
            }

            for (i = 0; i < rl; i++) {
                if ((Character.toString(repository[rand].charAt(i))).equalsIgnoreCase(guess))
                    word[i] = guess.toUpperCase();
            }
            System.out.print("\n\n\t\t\t  ");

            for (i = 0; i < rl; i++) {
                System.out.print(" " + word[i] + " ");
                if (word[i] == "_")
                    c++;
            }

            if (c == 0) {
                c = -1;
                break;
            }

        }

        if (c == -1)
            System.out.println("\n\nCongratulations!!\nYOU WON");
        else
        {
            System.out.println("\n\nSorry!!\nYOU LOST");
            System.out.println("The Word was : "+repository[rand].toUpperCase());
        }
    }
}
