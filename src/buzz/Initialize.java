/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Polis/Electra
 */
public class Initialize {

    private final HashMap<String, ArrayList<Question>> map;
    private final File dir1, dir2;
    private final ArrayList<String> categories, language;

    //αρχικοποιηση ενος HashMap<String,Πινακα απο Question>
    //αρχικοποιηση μιας τυπου File μεταβλητης που θα περιεχει ολα τα directories των αρχειων
    //αρχικοποιηση ενος ArrayList<String> που απλα περιεχει ολα τις κατηγοριες
    @SuppressWarnings("Convert2Diamond")
    public Initialize(String language) throws FileNotFoundException {

        this.map = new HashMap<String, ArrayList<Question>>();
        if (language.equals("1") || language.equals("Ελληνικά")) {
            this.dir1 = new File("Questions/Greek/");
            this.dir2 = new File("Language/Greek.txt");
        } else {
            this.dir1 = new File("Questions/English/");
            this.dir2 = new File("Language/English.txt");
        }
        this.categories = new ArrayList<String>();
        this.language = new ArrayList<String>();

    }

    // επιστρέφει ενα HashMap με key το ονομα του αρχειου/κατηγοριας 
    //και value ενα πίνακα απο αντικειμενα της κλασης Question
    public HashMap<String, ArrayList<Question>> getHashMap() throws FileNotFoundException {
        String questionRead, ans1, ans2, ans3, ans4, correctAns, correctAnsNum;
        // Για καθε αρχειο στον φακελο του dir1
        for (File file : dir1.listFiles()) {
            // 
            Scanner reader = new Scanner(file,"ISO-8859-7");
            reader.useDelimiter(",|\\r\\n");
            @SuppressWarnings("Convert2Diamond")
            ArrayList<Question> questions = new ArrayList<Question>();
            // Αν υπαρχει επομενη γραμμη στο φακελο
            while (reader.hasNextLine()) {
                questionRead = reader.next();
                ans1 = reader.next();
                ans2 = reader.next();
                ans3 = reader.next();
                ans4 = reader.next();
                correctAns = reader.next();
                correctAnsNum = reader.next();
                //αρχικοποιηση αντικειμενου Question και εισαγωγη στον πινακα questions
                Question question = new Question(questionRead, ans1, ans2, ans3, ans4, correctAns, correctAnsNum);
                questions.add(question);
            }
            //εισαγωγη στοιχειων...
            map.put(file.getName(), questions);
        reader.close();    
        }
        
        return map;
    }

    //επιστρεφει ενα ArrayList που περιεχει τις κατηγοριες σε String μορφη
    public ArrayList<String> getArrayList() {
        categories.add("Art.txt");
        categories.add("Sports.txt");
        categories.add("Movies.txt");
        categories.add("History.txt");
        categories.add("Geography.txt");
        return categories;
    }
//γαμιεται
    public ArrayList<String> getLanguage() throws FileNotFoundException {

        Scanner reader = new Scanner(dir2,"ISO-8859-7");
        
        while (reader.hasNextLine()) {
            language.add(reader.nextLine());
        }
        reader.close();
        return language;
    }
}
