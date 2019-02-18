/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Polis
 */
public class Buzz {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        try {
            game.newGame();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Buzz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cannot read file...");
        }
    }

}
