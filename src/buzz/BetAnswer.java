/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author Polis/Electra
 */
public class BetAnswer {

    private final Scanner userInput;
    private final Scanner betInput;
    HashMap<String, ArrayList<Question>> map;
    ArrayList<String> category, printLanguage;
    User player;

    @SuppressWarnings("Convert2Diamond")
    public BetAnswer(HashMap<String, ArrayList<Question>> map, ArrayList<String> category, User player, ArrayList<String> printLanguage) {

        this.map = map;
        this.category = category;
        this.userInput = new Scanner(System.in);
        this.player = player;
        this.betInput = new Scanner(System.in);
        this.printLanguage = printLanguage;
    }

    public void start() throws IOException {

        for (int k = 0; k < 5; k++) {
            int bet = betting();
            int indexOfCategory = getRandomCategory();
            ArrayList<Question> questions = map.get(category.get(indexOfCategory));
            int indexOfQuestion = getRandomQuestion(questions);
            printQuestion(indexOfQuestion, questions);
            String input = userInput.next();
            if (questions.get(indexOfQuestion).getCorrectAns().equals(input) || questions.get(indexOfQuestion).getCorrectAnsNum().equals(input)) {
                player.addPoints(bet);
                System.out.println(printLanguage.get(13) + bet + printLanguage.get(14));
                System.out.println(printLanguage.get(9));
                System.in.read();
            } else {
                player.removePoints(bet);
                System.out.println(printLanguage.get(16) + bet );
                System.out.println(printLanguage.get(9));
                System.in.read();
            }
            questions.remove(indexOfQuestion);
        }
    }

    //Επιστρεφει  τo bet που εδωσε ο χρηστης για πονταρισμα
    private int betting() throws IOException {

        String input;
        boolean quit = false;
        while (!quit) {
            printBets();
            input = userInput.next();
            switch (input) {
                case "250":
                    return 250;
                case "500":
                    return 500;
                case "750":
                    return 750;
                case "1000":
                    return 1000;
                default:
                    System.out.println(printLanguage.get(8));
                    System.out.println(printLanguage.get(9));
                    System.in.read();
                    break;
            }
        }
        return -1;
    }
    //εκτυπωνει τα πονταρίσματα
    private void printBets() {
        System.out.print(printLanguage.get(17));
        System.out.print(" α) 250 ,");
        System.out.print(" β) 500 ,");
        System.out.print(" γ) 750 ,");
        System.out.println(" δ) 1000 ");
        System.out.print(">");
    }
    //εκτυπωνει τις ερωτησεις
    private void printQuestion(int indexOfQuestion, ArrayList<Question> questions) {
        System.out.println(questions.get(indexOfQuestion).getQuestion());
        System.out.print("1)" + questions.get(indexOfQuestion).getAns1());
        System.out.print(" 2)" + questions.get(indexOfQuestion).getAns2());
        System.out.print(" 3)" + questions.get(indexOfQuestion).getAns3());
        System.out.println(" 4)" + questions.get(indexOfQuestion).getAns4());
        System.out.print(">");
    }
    //επιστρεφει μια τυχαια κατηγορια
    private int getRandomCategory() {
        Random rand = new Random();
        return rand.nextInt(category.size());
    }
    //επιστρεφει μια τυχαια ερωτηση
    private int getRandomQuestion(ArrayList<Question> q) {
        Random rand = new Random();
        return rand.nextInt(q.size());
    }
}
