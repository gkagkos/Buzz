/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Polis/Electra
 */
public class Game {

    private final Scanner userInput;

    public Game() {
        userInput = new Scanner(System.in,"ISO-8859-7");

    }
    
    public void newGame() throws FileNotFoundException, IOException {
        //διαβαζει εισοδο απο το χρηστη για την γλωσσα
        System.out.println("Choose your language : \n1)Ελληνικά \n2)English");
        System.out.print(">");
        String lang = userInput.nextLine();
        //δημιουργω το ινιτ και διαβαζω το MAP το Category και το printLanguage
        Initialize init = new Initialize(lang);
        
        HashMap<String, ArrayList<Question>> map = init.getHashMap();
        ArrayList<String> category = init.getArrayList();
        ArrayList<String> printLanguage = init.getLanguage();
        
        System.out.println(printLanguage.get(0));
        System.out.print(printLanguage.get(1));
        String name = userInput.nextLine();
        User player = new User(name);
        
        System.out.print(printLanguage.get(2));
        int rounds = userInput.nextInt();
        

        SimpleAnswer simpleAns = new SimpleAnswer(map, category, player, printLanguage);
        BetAnswer betAns = new BetAnswer(map, category, player, printLanguage);

        for (int i = 0; i < rounds; i++) {
            printWelcome(printLanguage);
            String input = userInput.next();
            switch (input) {
                case "1":
                    simpleAns.start();
                    break;
                case "2":
                    betAns.start();
                    break;
                case "3":
                    System.out.println(printLanguage.get(10) + player.getName() + printLanguage.get(11) + player.getPoints() + printLanguage.get(12));
                    System.out.println(printLanguage.get(9));
                    System.in.read();
                    i--;
                    break;
                case "4":
                    i = rounds + 1;
                    break;
                default:
                    System.out.println(printLanguage.get(8));
                    System.out.println(printLanguage.get(9));
                    System.in.read();
                    i--;
            }

        }
        System.out.println(printLanguage.get(10) + player.getName() + printLanguage.get(11) + player.getPoints() + printLanguage.get(12));
    }

    private void printWelcome(ArrayList<String> printLanguage) {
        System.out.println();
        System.out.println(printLanguage.get(3));
        System.out.println(printLanguage.get(4));
        System.out.println(printLanguage.get(5));
        System.out.println(printLanguage.get(6));
        System.out.println(printLanguage.get(7));
        System.out.print(">");
    }

}
