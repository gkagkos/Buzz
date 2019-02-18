/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

/**
 *
 * @author Polis
 */
public class Question {

    private final String question, ans1, ans2, ans3, ans4, correctAns, correctAnsNum;
    //Constructor για αρχικοποιηση με τις παραπανω τιμες 
    public Question(String question, String ans1, String ans2, String ans3, String ans4, String correctAns, String correctAnsNum) {
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.correctAns = correctAns;
        this.correctAnsNum = correctAnsNum;
    }

    //επιστρεφει την ερωτηση
    public String getQuestion() {
        return question;
    }

    //επιστρεφει την απαντηση1
    public String getAns1() {
        return ans1;
    }
    //επιστρεφει την απαντηση2

    public String getAns2() {
        return ans2;
    }
    //επιστρεφει την απαντηση3

    public String getAns3() {
        return ans3;
    }
    //επιστρεφει την απαντηση4

    public String getAns4() {
        return ans4;
    }
    //επιστρεφει την σωστη απαντηση

    public String getCorrectAns() {
        return correctAns;
    }
    
    
    //επιστρέφει τον αριθμό της σωστής απάντησης
    public String getCorrectAnsNum() {
        return correctAnsNum;
    }
}
