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
public class SimpleAnswer {

    private final Scanner userInput;
    HashMap<String, ArrayList<Question>> map;
    ArrayList<String> category, printLanguage;
    User player;
        // Contructor
    @SuppressWarnings("Convert2Diamond")
    public SimpleAnswer(HashMap<String, ArrayList<Question>> map, ArrayList<String> category, User player, ArrayList<String> printLanguage) {

        this.map = map;
        this.category = category;
        this.userInput = new Scanner(System.in,"ISO-8859-7");
        this.player = player;
        this.printLanguage = printLanguage;
    }
    
    public void start() throws IOException {
        for (int k = 0; k < 5; k++) {
            int indexOfCategory = getRandomCategory();
            ArrayList<Question> questions = map.get(category.get(indexOfCategory));
            int indexOfQuestion = getRandomQuestion(questions);
            printQuestion(indexOfQuestion, questions);
            String input = userInput.nextLine();
            if (questions.get(indexOfQuestion).getCorrectAns().equals(input) || questions.get(indexOfQuestion).getCorrectAnsNum().equals(input))  {
                player.addPoints(1000);
                System.out.println(printLanguage.get(13)+ "1000" + printLanguage.get(14));
                System.out.println(printLanguage.get(9));
                System.in.read();
            } else {
                System.out.println(printLanguage.get(15));
                System.out.println(printLanguage.get(9));
                System.in.read();
            }
            questions.remove(indexOfQuestion);
        }

    }

    private void printQuestion(int indexOfQuestion, ArrayList<Question> questions) {
        System.out.println(questions.get(indexOfQuestion).getQuestion());
        System.out.print("1)" + questions.get(indexOfQuestion).getAns1());
        System.out.print(" 2)" + questions.get(indexOfQuestion).getAns2());
        System.out.print(" 3)" + questions.get(indexOfQuestion).getAns3());
        System.out.println(" 4)" + questions.get(indexOfQuestion).getAns4());
        System.out.print(">");
    }

    private int getRandomCategory() {
        Random rand = new Random();
        return rand.nextInt(category.size());
    }

    private int getRandomQuestion(ArrayList<Question> q) {
        Random rand = new Random();
        return rand.nextInt(q.size());
    }
}
