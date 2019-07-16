/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048.v1.pkg0;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author mtezza9@gmail
 * @version 1.0 2019-06-26
 *
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        table GAME = new table(false);
        //GAME.writeFile();
        for (int i = 0; i < 14 /*first 14 boxes are set to 0, last two to 2*/; i++){
            GAME.setvalue(0, i/4, i%4);
        }
        GAME.setvalue(2, 3, 2);
        GAME.setvalue(2, 3, 3);


        CustomPanel drawable = new CustomPanel(GAME);
        JFrame root = new JFrame("2048");
        root.setResizable(false);
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setContentPane(drawable);
        root.pack();
        root.setVisible(true);

        // migrated to CustomPanel.java

        /*Scanner in = new Scanner(System.in);
        System.out.println(GAME);
        while(!(GAME.getgameover())){
            System.out.print("PREMI 8-UP  6-RIGHT  2-DOWN  4-LEFT : ");
            int n = in.nextInt();
            if(n == 8){
                GAME.UP();
            }else if(n == 6){
                GAME.RIGHT();
            }else if(n == 2){
                GAME.DOWN();
            }else if(n == 4){
                GAME.LEFT();
            }else{
                System.out.println("Mossa non valida");
            }
            if(!(GAME.getgameover())){
                System.out.println("-----------------------" + " SCORE: " + GAME.SCORE() );
                System.out.println(GAME);
                if(GAME.SCORE() >= 2048){
                    System.out.println("Complimenti HAI VINTO!!!");
                    System.out.println("Continua per entrare in classifica!!!");
                }
            }
        }
        in.close();*/
    }
}
