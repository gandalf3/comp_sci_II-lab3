import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by gandalf3 on 2/9/17.
 */

public class NumberFathomerGame {

    static Scanner inGet = new Scanner(System.in);
    static int randomNum = 0;

    private static int ObtainUserInt(String prompt) {
        System.out.println(prompt);

        while (true) {
            String uinput = inGet.nextLine();
            try {
                int ui = Integer.parseInt(uinput);
                return ui;
            } catch (NumberFormatException ow) {
                System.out.println("That's a really Terrible integer. Try using a different part of your keyboard:");
            }
        }
    }

    private static Boolean doGuess() {
        int uGuess = ObtainUserInt("Place le guess here:");

        if (uGuess > randomNum) {
            System.out.println("You are too high.");
        }
        if (uGuess < randomNum) {
            System.out.println("Too low! Terrain! Pull! Up!");
        }
        if (uGuess == randomNum) {
            System.out.println("Hey, that's my number! Did you steal my number?!");
            System.out.println("You guessed " + uGuess + ", and I guessed " + randomNum);
            System.out.println("As promised: Congratulations.");
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public static void main(String[] args) throws InterruptedException {
        String userDesire = "n";
        int rangeMin = 1;
        int rangeMax = 10;
        int maxTries = 3;


        while (true) {
            System.out.println("Hi, wanna leave? [y/n]: ");
            userDesire = inGet.nextLine();
            if (userDesire.startsWith("y")) {
                break;
            }
            userDesire = "n";

            System.out.println("Then let us play a Wonderful game of Guess the Number (yay)!");
            randomNum = ThreadLocalRandom.current().nextInt(rangeMin, rangeMax+1);
            Thread.sleep(1000);
            System.out.println("I have computed a Terrific number between " + rangeMin + " and " + rangeMax);
            Thread.sleep(1000);
            System.out.println("Tell me what it is in " + maxTries + " guesses, and I'll congratulate you! (it's gonna be Great)");
            int tries = 0;

            while (true) {
                if (tries < maxTries) {
                    if (doGuess()) {
                        break;
                    }
                    System.out.println("That's guess number " + (tries+1) + ". You have " + (maxTries-(tries+1)) + " guesses remaining.");
                }
                else {
                    System.out.println("Too bad. I shall now forget you.");
                    break;
                }

                tries++;
            }
            Thread.sleep(1000);

        }
        System.out.println("Fare thee well, fair and transient user!");

    }
}
