/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048.v1.pkg0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author mtezza9@gmail
 * @version 1.0 2019-06-26
 * 
 */
public class table {
    public final static int N = 6;

    private final Integer lista[][] = new Integer[N][N];
    private boolean gameover;

    public table(boolean gameover){
        this.gameover = gameover;
    }
    
    /**
     *
     * @param value valore della casella
     * @param riga la riga della casella
     * @param colonna la colonna della casella
     */
    public void setvalue(int value, int riga, int colonna){
        lista[riga][colonna] = value;
    }

    /**
     *
     * @param riga
     * @param colonna
     * @return il valore della casella
     */
    public int getvalue(int riga, int colonna){
        return lista[riga][colonna];
    }
    
    /**
     *
     * @param value
     */
    public void setgameover(boolean value){
        gameover = value;
    }

    /**
     *
     * @return true se è gameover, false se non è gameover
     */
    public boolean getgameover(){
        return gameover;
    }
    
    /**
     *
     * @throws IOException
     */
    public void UP() throws IOException{
        for(int col = 0; col<N; col++){
            int last = 0;
            int lastIndex = 0;
            for (int row = 0; row<N; row++){
                if (getvalue(row, col) == 0) continue;
                if (getvalue(row, col) == last){
                    setvalue(getvalue(lastIndex-1, col)*2, lastIndex-1, col);
                    last = 0;
                } else
                    setvalue(last = getvalue(row, col), lastIndex++, col);
            }
            for (; lastIndex<N; lastIndex++) setvalue(0, lastIndex, col);
        }

        ArrayList<Integer> mazzo = new ArrayList<>(N);
        for (int i = 0; i<N; i++) mazzo.add(i);
        Collections.shuffle(mazzo);
        
        boolean flag = true;
        int n = Math.random() < 0.75 ? 2 : 4;
        for(int count = 0; count<N && flag; count++){
            if(getvalue(N-1, mazzo.get(count)) == 0){
                setvalue(n, N-1, mazzo.get(count));
                flag = false;
            }
        }
        if (flag && !HELP()) {
            setgameover(true);
            GAMEOVER();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void DOWN() throws IOException{
        for(int col = 0; col<N; col++){
            int last = 0;
            int lastIndex = N-1;
            for (int row = N-1; row>=0; row--){
                if (getvalue(row, col) == 0) continue;
                if (getvalue(row, col) == last){
                    setvalue(getvalue(lastIndex+1, col)*2, lastIndex+1, col);
                    last = 0;
                } else
                    setvalue(last = getvalue(row, col), lastIndex--, col);
            }
            for (; lastIndex>=0; lastIndex--) setvalue(0, lastIndex, col);
        }

        ArrayList<Integer> mazzo = new ArrayList<>(N);
        for (int i = 0; i<N; i++) mazzo.add(i);
        Collections.shuffle(mazzo);
        boolean flag = true;
        int n = Math.random() < 0.75 ? 2 : 4;
        for(int count = 0; count<N && flag; count++){
            if(getvalue(0, mazzo.get(count)) == 0){
                setvalue(n, 0, mazzo.get(count));
                flag = false;
            }
        }
        if (flag && !HELP()) {
            setgameover(true);
            GAMEOVER();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void LEFT() throws IOException{
        for(int row = 0; row<4; row++){
            int last = 0;
            int lastIndex = 0;
            for (int col = 0; col<N; col++){
                if (getvalue(row, col) == 0) continue;
                if (getvalue(row, col) == last){
                    setvalue(getvalue(row, lastIndex-1)*2, row, lastIndex-1);
                    last = 0;
                } else
                    setvalue(last = getvalue(row, col), row, lastIndex++);
            }
            for (; lastIndex<N; lastIndex++) setvalue(0, row, lastIndex);
        }

        ArrayList<Integer> mazzo = new ArrayList<>(N);
        for (int i = 0; i<N; i++) mazzo.add(i);
        Collections.shuffle(mazzo);
        boolean flag = true;
        int n = Math.random() < 0.75 ? 2 : 4;
        for(int count = 0; count<N && flag; count++){
            if(getvalue(mazzo.get(count), N-1) == 0){
                setvalue(n, mazzo.get(count), N-1);
                flag = false;
            }
        }
        if (flag && !HELP()) {
            setgameover(true);
            GAMEOVER();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void RIGHT() throws IOException{
        for(int row = 0; row<N; row++){
            int last = 0;
            int lastIndex = N-1;
            for (int col = N-1; col>=0; col--){
                if (getvalue(row, col) == 0) continue;
                if (getvalue(row, col) == last){
                    setvalue(getvalue(row, lastIndex+1)*2, row, lastIndex+1);
                    last = 0;
                } else
                    setvalue(last = getvalue(row, col), row, lastIndex--);
            }
            for (; lastIndex>=0; lastIndex--) setvalue(0, row, lastIndex);
        }
        
        ArrayList<Integer> mazzo = new ArrayList<>(N);
        for (int i = 0; i<N; i++) mazzo.add(i);
        Collections.shuffle(mazzo);
        boolean flag = true;
        int n = Math.random() < 0.75 ? 2 : 4;
        for(int count = 0; count<N && flag; count++){
            if(getvalue(mazzo.get(count), 0) == 0){
                setvalue(n, mazzo.get(count), 0);
                flag = false;
            }
        }
        if (flag && !HELP()) {
            setgameover(true);
            GAMEOVER();
        }
    }

    private void GAMEOVER() throws IOException {
        System.out.println("GAME OVER");
        File();
    }

    private boolean HELP(){
        for(int c=0; c<N; c++){
            for (int i=0; i<N-1; i++){
                if (getvalue(i, c) == getvalue(i+1, c)){
                    System.out.println("Mossa consigliata: UP");
                    return true;
                }
                if (getvalue(c, i) == getvalue(c, i+1)){
                    System.out.println("Mossa consigliata: RIGHT");
                    return true;
                }
            }
        }
        return false;
    }

    /**println
     *
     * @return
     */
    public int SCORE() {
        int punteggio = 0;
        for(int a=0; a<N; a++){
           for(int b=0; b<N; b++){
               punteggio += lista[a][b];
           }
        }
        return punteggio;
    }
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void File() throws FileNotFoundException, IOException {
        ArrayList<String> Score = new ArrayList<>(1);
        FileReader fr = new FileReader("pkg2048/v1/pkg0/file/high_score.txt");
        BufferedReader b = new BufferedReader(fr);
        
        boolean added = false;
        for(int a = 0; a<10; a++){
            String[] strs = b.readLine().split(" ", 2);
            int score = SCORE();
            if (Integer.parseInt(strs[1]) < score && !added){
                Scanner in = new Scanner(System.in);
                System.out.print("Immettere Nome in Maiuscolo da 3 caratteri (es. CAP): ");
                String name = in.next();
                Score.add(name+" "+String.format("%04d", score));
                in.close();
                added = true;
                a++;
            }
            Score.add(strs[0]+" "+strs[1]);
        }
        b.close();
            
        FileWriter fw = new FileWriter("pkg2048/v1/pkg0/file/high_score.txt");
        System.out.println("- - - HIGH SCORE - - -");
        for (String str : Score){
            fw.write(str+"\n");
            System.out.println(str);
        }
        fw.flush();
        fw.close();
    }
}
