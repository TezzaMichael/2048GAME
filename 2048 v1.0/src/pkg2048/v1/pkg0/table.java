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
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author mtezza9@gmail
 * @version 1.0 2019-06-26
 * 
 */
public class table {
    private final Integer lista[][];
    private boolean gameover;
    public table(boolean gameover){
        lista = new Integer[4][4];
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
        for(int col=0; col<4; col++){
            if(getvalue(0,col) == getvalue(1,col) && getvalue(0,col) != 0 ){
                    setvalue(getvalue(0,col)*2,0,col);
                    setvalue(0,1,col);
                
            }
            if(getvalue(1,col) == getvalue(2,col) && getvalue(1,col) != 0 ){
                setvalue(getvalue(1,col)*2,1,col);
                setvalue(0,2,col);
                   /*if(getvalue(0,col) == 0){
                        setvalue(getvalue(1,col)*2,0,col);
                        setvalue(0,1,col);
                        setvalue(0,2,col);
                    }else{
                        setvalue(getvalue(1,col)*2,1,col);
                        setvalue(0,2,col);
                    }
                */
            }
            if(getvalue(2,col) == getvalue(3,col) && getvalue(2,col) != 0){
                setvalue(getvalue(2,col)*2,2,col);
                setvalue(0,3,col);
                /*if(getvalue(0,col) == 0 && getvalue(1,col) == 0){
                        setvalue(getvalue(2,col)*2,0,col);
                        setvalue(0,1,col);
                        setvalue(0,2,col);
                        setvalue(0,3,col);
                }else if(getvalue(0,col) == 0 && !(getvalue(1,col) == 0)){
                        setvalue(getvalue(1,col),0,col);
                        setvalue(getvalue(2,col)*2,1,col);
                        setvalue(0,2,col);
                        setvalue(0,3,col);
                }else if(!(getvalue(0,col) == 0) && getvalue(1,col) == 0){
                        setvalue(getvalue(2,col)*2,1,col);
                        setvalue(0,2,col);
                        setvalue(0,3,col);
                }else{
                        setvalue(getvalue(2,col)*2,2,col);
                        setvalue(0,3,col);
            }
                    */
            }
            if(getvalue(0,col) == getvalue(2,col) && getvalue(0,col) != 0 && getvalue(1,col) == 0){
                setvalue(getvalue(0,col)*2,0,col);
                setvalue(0,2,col);
            }
            if(getvalue(0,col) == getvalue(3,col) && getvalue(0,col) != 0 && getvalue(1,col) == 0 && getvalue(2,col) == 0){
                setvalue(getvalue(0,col)*2,0,col);
                setvalue(0,3,col);
            }
            if(getvalue(1,col) == getvalue(3,col) && getvalue(1,col) != 0 && getvalue(2,col) == 0) {
                setvalue(getvalue(1,col)*2,1,col);
                setvalue(0,3,col);
            }
            if(getvalue(0,col) == 0 && getvalue(1,col) == 0 && getvalue(2,col) == 0){
               setvalue(getvalue(3,col),0,col);
               setvalue(0,3,col);
            }else if(getvalue(0,col) == 0 && getvalue(1,col) == 0 && !(getvalue(2,col) == 0)){
               setvalue(getvalue(2,col),0,col);
               setvalue(getvalue(3,col),1,col);
               setvalue(0,2,col);
               setvalue(0,3,col);
            }else if(getvalue(0,col) == 0 && !(getvalue(1,col) == 0) && getvalue(2,col) == 0){
               setvalue(getvalue(1,col),0,col);
               setvalue(getvalue(3,col),1,col);
               setvalue(0,3,col);
            }else if(getvalue(0,col) == 0 && !(getvalue(1,col) == 0) && !(getvalue(2,col) == 0)){
               setvalue(getvalue(1,col),0,col);
               setvalue(getvalue(2,col),1,col);
               setvalue(getvalue(3,col),2,col);
               setvalue(0,3,col);
            }else if(!(getvalue(0,col) == 0) && getvalue(1,col) == 0 && getvalue(2,col) == 0){
               setvalue(getvalue(3,col),1,col);
               setvalue(0,3,col);
            }else if(!(getvalue(0,col) == 0) && getvalue(1,col) == 0 && !(getvalue(2,col) == 0)){
               setvalue(getvalue(2,col),1,col);
               setvalue(getvalue(3,col),2,col);
               setvalue(0,3,col);
            }else if(!(getvalue(0,col) == 0) && !(getvalue(1,col) == 0) && getvalue(2,col) == 0){
               setvalue(getvalue(3,col),2,col);
               setvalue(0,3,col);
            }
        }
        ArrayList<Integer> mazzo = new ArrayList<>(1);
        mazzo.add(1);
        mazzo.add(2);
        mazzo.add(3);
        mazzo.add(4);
        Collections.shuffle(mazzo);
         ArrayList<Integer> numeri = new ArrayList<>(1);
        numeri.add(2);
        numeri.add(2);
        numeri.add(2);
        numeri.add(4);
        Collections.shuffle(numeri);
        boolean flag = true;
        for(int count = 0; count < 4; count++){
            if(mazzo.get(count) == 1 && getvalue(3,0) == 0 && flag){
                setvalue(numeri.get(0),3,0);
                flag = false;
            }else if(mazzo.get(count) == 2 && getvalue(3,1) == 0 && flag){
                setvalue(numeri.get(0),3,1);
                flag = false;
            }else if(mazzo.get(count) == 3 && getvalue(3,2) == 0 && flag){
                setvalue(numeri.get(0),3,2);
                flag = false;
            }else if(mazzo.get(count) == 4 && (getvalue(3,3)) == 0 && flag){
                setvalue(numeri.get(0),3,3);
                flag = false;
            }
        }
        if(flag){
            if(!(HELP())){
                    setgameover(true);
                    GAMEOVER();
                }
        }
    }

    /**
     *
     * @throws IOException
     */
    public void DOWN() throws IOException{
        for(int col=0; col<4; col++){
            if(getvalue(3,col) == getvalue(2,col) && getvalue(3,col) != 0 ){
                    setvalue(getvalue(3,col)*2,3,col);
                    setvalue(0,2,col);
                
            }if(getvalue(2,col) == getvalue(1,col) && getvalue(1,col) != 0 ){
                setvalue(getvalue(2,col)*2,2,col);
                setvalue(0,1,col);
                   /*if(getvalue(3,col) == 0){
                        setvalue(getvalue(2,col)*2,3,col);
                        setvalue(0,1,col);
                        setvalue(0,2,col);
                    }else{
                        setvalue(getvalue(2,col)*2,2,col);
                        setvalue(0,1,col);
                    }*/
            }
            if(getvalue(0,col) == getvalue(1,col) && getvalue(1,col) != 0){
                setvalue(getvalue(0,col)*2,1,col);
                setvalue(0,0,col);
                    /*if(getvalue(3,col) == 0 && getvalue(2,col) == 0){
                        setvalue(getvalue(0,col)*2,3,col);
                        setvalue(0,1,col);
                        setvalue(0,2,col);
                        setvalue(0,0,col);
                    }else if(getvalue(3,col) == 0 && !(getvalue(2,col) == 0)){
                        setvalue(getvalue(2,col),3,col);
                        setvalue(getvalue(0,col)*2,2,col);
                        setvalue(0,1,col);
                        setvalue(0,0,col);
                    }else if(!(getvalue(3,col) == 0) && getvalue(2,col) == 0){
                        setvalue(getvalue(0,col)*2,2,col);
                        setvalue(0,1,col);
                        setvalue(0,0,col);
                    }else{
                        setvalue(getvalue(0,col)*2,1,col);
                        setvalue(0,0,col);
                    }*/
            }
            if(getvalue(3,col) == getvalue(1,col) && getvalue(3,col) != 0 && getvalue(2,col) == 0){
                setvalue(getvalue(3,col)*2,3,col);
                setvalue(0,1,col);
            }
            if(getvalue(3,col) == getvalue(0,col) && getvalue(3,col) != 0 && getvalue(2,col) == 0 && getvalue(1,col) == 0){
                setvalue(getvalue(3,col)*2,3,col);
                setvalue(0,0,col);
            }
            if(getvalue(2,col) == getvalue(0,col) && getvalue(2,col) != 0 && getvalue(1,col) == 0) {
                setvalue(getvalue(2,col)*2,2,col);
                setvalue(0,0,col);
            }
            
            if(getvalue(3,col) == 0 && getvalue(2,col) == 0 && getvalue(1,col) == 0){
               setvalue(getvalue(0,col),3,col);
               setvalue(0,0,col);
            }else if(getvalue(3,col) == 0 && getvalue(2,col) == 0 && !(getvalue(1,col) == 0)){
               setvalue(getvalue(1,col),3,col);
               setvalue(getvalue(0,col),2,col);
               setvalue(0,1,col);
               setvalue(0,0,col);
            }else if(getvalue(3,col) == 0 && !(getvalue(2,col) == 0) && getvalue(1,col) == 0){
               setvalue(getvalue(2,col),3,col);
               setvalue(getvalue(0,col),2,col);
               setvalue(0,0,col);
            }else if(getvalue(3,col) == 0 && !(getvalue(2,col) == 0) && !(getvalue(1,col) == 0)){
               setvalue(getvalue(2,col),3,col);
               setvalue(getvalue(1,col),2,col);
               setvalue(getvalue(0,col),1,col);
               setvalue(0,0,col);
            }else if(!(getvalue(3,col) == 0) && getvalue(2,col) == 0 && getvalue(1,col) == 0){
               setvalue(getvalue(0,col),2,col);
               setvalue(0,0,col);
            }else if(!(getvalue(3,col) == 0) && getvalue(2,col) == 0 && !(getvalue(1,col) == 0)){
               setvalue(getvalue(1,col),2,col);
               setvalue(getvalue(0,col),1,col);
               setvalue(0,0,col);
            }else if(!(getvalue(3,col) == 0) && !(getvalue(2,col) == 0) && getvalue(1,col) == 0){
               setvalue(getvalue(0,col),1,col);
               setvalue(0,0,col); 
            }
           
        }
        ArrayList<Integer> mazzo = new ArrayList<>(1);
        mazzo.add(1);
        mazzo.add(2);
        mazzo.add(3);
        mazzo.add(4);
        Collections.shuffle(mazzo);
        ArrayList<Integer> numeri = new ArrayList<>(1);
        numeri.add(2);
        numeri.add(2);
        numeri.add(2);
        numeri.add(4);
        Collections.shuffle(numeri);
        boolean flag = true;
        for(int count = 0; count < 4; count++){
            if(mazzo.get(count) == 1 && getvalue(0,0) == 0 && flag){
                setvalue(numeri.get(0),0,0);
                flag = false;
            }else if(mazzo.get(count) == 2 && getvalue(0,1) == 0 && flag){
                setvalue(numeri.get(0),0,1);
                flag = false;
            }else if(mazzo.get(count) == 3 && getvalue(0,2) == 0 && flag){
                setvalue(numeri.get(0),0,2);
                flag = false;
            }else if(mazzo.get(count) == 4 && (getvalue(0,3)) == 0 && flag){
                setvalue(numeri.get(0),0,3);
                flag = false;
            }
        }
        if(flag){
            if(!(HELP())){
                    setgameover(true);
                    GAMEOVER();
                }
        }
    }

    /**
     *
     * @throws IOException
     */
    public void LEFT() throws IOException{
        for(int rig=0; rig<4; rig++){
            if(getvalue(rig,0) == getvalue(rig,1) && getvalue(rig,0) != 0 ){
                    setvalue(getvalue(rig,0)*2,rig,0);
                    setvalue(0,rig,1);
                
            }if(getvalue(rig,1) == getvalue(rig,2) && getvalue(rig,1) != 0 ){
                setvalue(getvalue(rig,2)*2,rig,1);
                setvalue(0,rig,2);
                   /*if(getvalue(rig,0) == 0){
                        setvalue(getvalue(rig,2)*2,rig,0);
                        setvalue(0,rig,1);
                        setvalue(0,rig,2);
                    }else{
                        setvalue(getvalue(rig,2)*2,rig,1);
                        setvalue(0,rig,2);
                    }*/
            }
            if(getvalue(rig,2) == getvalue(rig,3) && getvalue(rig,2) != 0){
                setvalue(getvalue(rig,2)*2,rig,2);
                setvalue(0,rig,3);
                    /*if(getvalue(rig,0) == 0 && getvalue(rig,1) == 0){
                        setvalue(getvalue(rig,2)*2,rig,0);
                        setvalue(0,rig,1);
                        setvalue(0,rig,2);
                        setvalue(0,rig,3);
                    }else if(getvalue(rig,0) == 0 && !(getvalue(rig,1) == 0)){
                        setvalue(getvalue(rig,1),rig,0);
                        setvalue(getvalue(rig,2)*2,rig,1);
                        setvalue(0,rig,2);
                        setvalue(0,rig,3);
                    }else if(!(getvalue(rig,0) == 0) && getvalue(rig,1) == 0){
                        setvalue(getvalue(rig,2)*2,rig,1);
                        setvalue(0,rig,2);
                        setvalue(0,rig,3);
                    }else{
                        setvalue(getvalue(rig,2)*2,rig,2);
                        setvalue(0,rig,3);
                    }*/
            }
            if(getvalue(rig,0) == getvalue(rig,2) && getvalue(rig,0) != 0 && getvalue(rig,1) == 0){
                setvalue(getvalue(rig,0)*2,rig,0);
                setvalue(0,rig,2);
            }
            if(getvalue(rig,0) == getvalue(rig,3) && getvalue(rig,0) != 0 && getvalue(rig,1) == 0 && getvalue(rig,2) == 0){
                setvalue(getvalue(rig,0)*2,rig,0);
                setvalue(0,rig,3);
            }
            if(getvalue(rig,1) == getvalue(rig,3) && getvalue(rig,1) != 0 && getvalue(rig,2) == 0) {
                setvalue(getvalue(rig,1)*2,rig,1);
                setvalue(0,rig,3);
            }
            if(getvalue(rig,0) == 0 && getvalue(rig,1) == 0 && getvalue(rig,2) == 0){
               setvalue(getvalue(rig,3),rig,0);
               setvalue(0,rig,3);
            }else if(getvalue(rig,0) == 0 && getvalue(rig,1) == 0 && !(getvalue(rig,2) == 0)){
               setvalue(getvalue(rig,2),rig,0);
               setvalue(getvalue(rig,3),rig,1);
               setvalue(0,rig,2);
               setvalue(0,rig,3);
            }else if(getvalue(rig,0) == 0 && !(getvalue(rig,1) == 0) && getvalue(rig,2) == 0){
               setvalue(getvalue(rig,1),rig,0);
               setvalue(getvalue(rig,3),rig,1);
               setvalue(0,rig,3);
            }else if(getvalue(rig,0) == 0 && !(getvalue(rig,1) == 0) && !(getvalue(rig,2) == 0)){
               setvalue(getvalue(rig,1),rig,0);
               setvalue(getvalue(rig,2),rig,1);
               setvalue(getvalue(rig,3),rig,2);
               setvalue(0,rig,3);
            }else if(!(getvalue(rig,0) == 0) && getvalue(rig,1) == 0 && getvalue(rig,2) == 0){
               setvalue(getvalue(rig,3),rig,1);
               setvalue(0,rig,3);
            }else if(!(getvalue(rig,0) == 0) && getvalue(rig,1) == 0 && !(getvalue(rig,2) == 0)){
               setvalue(getvalue(rig,2),rig,1);
               setvalue(getvalue(rig,3),rig,2);
               setvalue(0,rig,3);
            }else if(!(getvalue(rig,0) == 0) && !(getvalue(rig,1) == 0) && getvalue(rig,2) == 0){
               setvalue(getvalue(rig,3),rig,2);
               setvalue(0,rig,3);
            }
        }
        ArrayList<Integer> mazzo = new ArrayList<>(1);
        mazzo.add(1);
        mazzo.add(2);
        mazzo.add(3);
        mazzo.add(4);
        Collections.shuffle(mazzo);
         ArrayList<Integer> numeri = new ArrayList<>(1);
        numeri.add(2);
        numeri.add(2);
        numeri.add(2);
        numeri.add(4);
        Collections.shuffle(numeri);
        boolean flag = true;
        for(int count = 0; count < 4; count++){
            if(mazzo.get(count) == 1 && getvalue(0,3) == 0 && flag){
                setvalue(numeri.get(0),0,3);
                flag = false;
            }else if(mazzo.get(count) == 2 && getvalue(1,3) == 0 && flag){
                setvalue(numeri.get(0),1,3);
                flag = false;
            }else if(mazzo.get(count) == 3 && getvalue(3,2) == 0 && flag){
                setvalue(numeri.get(0),3,2);
                flag = false;
            }else if(mazzo.get(count) == 4 && getvalue(3,3) == 0 && flag){
                setvalue(numeri.get(0),3,3);
                flag = false;
            }
        }
        if(flag){
            if(!(HELP())){
                    setgameover(true);
                    GAMEOVER();
                }
        }
    }

    /**
     *
     * @throws IOException
     */
    public void RIGHT() throws IOException{
        for(int rig=0; rig<4; rig++){
            if(getvalue(rig,3) == getvalue(rig,2) && getvalue(rig,3) != 0 ){
                    setvalue(getvalue(rig,3)*2,rig,3);
                    setvalue(0,rig,2);
                
            }if(getvalue(rig,2) == getvalue(rig,1) && getvalue(rig,2) != 0 ){
                setvalue(getvalue(rig,1)*2,rig,2);
                setvalue(0,rig,1);
                   /*if(getvalue(rig,3) == 0){
                        setvalue(getvalue(rig,1)*2,rig,3);
                        setvalue(0,rig,2);
                        setvalue(0,rig,1);
                    }else{
                        setvalue(getvalue(rig,1)*2,rig,2);
                        setvalue(0,rig,1);
                    }*/
            }
            if(getvalue(rig,1) == getvalue(rig,0) && getvalue(rig,1) != 0){
                setvalue(getvalue(rig,1)*2,rig,1);
                setvalue(0,rig,0);
                    /*if(getvalue(rig,3) == 0 && getvalue(rig,2) == 0){
                        setvalue(getvalue(rig,1)*2,rig,3);
                        setvalue(0,rig,2);
                        setvalue(0,rig,1);
                        setvalue(0,rig,0);
                    }else if(getvalue(rig,3) == 0 && !(getvalue(rig,2) == 0)){
                        setvalue(getvalue(rig,2),rig,3);
                        setvalue(getvalue(rig,1)*2,rig,2);
                        setvalue(0,rig,1);
                        setvalue(0,rig,0);
                    }else if(!(getvalue(rig,3) == 0) && getvalue(rig,2) == 0){
                        setvalue(getvalue(rig,1)*2,rig,2);
                        setvalue(0,rig,1);
                        setvalue(0,rig,0);
                    }else{
                        setvalue(getvalue(rig,1)*2,rig,1);
                        setvalue(0,rig,0);
                    }*/
            }
            if(getvalue(rig,3) == getvalue(rig,1) && getvalue(rig,3) != 0 && getvalue(rig,2) == 0){
                setvalue(getvalue(rig,3)*2,rig,3);
                setvalue(0,rig,1);
            }
            if(getvalue(rig,3) == getvalue(rig,0) && getvalue(rig,3) != 0 && getvalue(rig,2) == 0 && getvalue(rig,1) == 0){
                setvalue(getvalue(rig,3)*2,rig,3);
                setvalue(0,rig,0);
            }
            if(getvalue(rig,2) == getvalue(rig,0) && getvalue(rig,2) != 0 && getvalue(rig,1) == 0) {
                setvalue(getvalue(rig,2)*2,rig,2);
                setvalue(0,rig,0);
            }
        
            if(getvalue(rig,3) == 0 && getvalue(rig,2) == 0 && getvalue(rig,1) == 0){
               setvalue(getvalue(rig,0),rig,3);
               setvalue(0,rig,0);
            }else if(getvalue(rig,3) == 0 && getvalue(rig,2) == 0 && !(getvalue(rig,1) == 0)){
               setvalue(getvalue(rig,1),rig,3);
               setvalue(getvalue(rig,0),rig,2);
               setvalue(0,rig,1);
               setvalue(0,rig,0);
            }else if(getvalue(rig,3) == 0 && !(getvalue(rig,2) == 0) && getvalue(rig,1) == 0){
               setvalue(getvalue(rig,2),rig,3);
               setvalue(getvalue(rig,0),rig,2);
               setvalue(0,rig,0);
            }else if(getvalue(rig,3) == 0 && !(getvalue(rig,2) == 0) && !(getvalue(rig,1) == 0)){
               setvalue(getvalue(rig,2),rig,3);
               setvalue(getvalue(rig,1),rig,2);
               setvalue(getvalue(rig,0),rig,1);
               setvalue(0,rig,0);
            }else if(!(getvalue(rig,3) == 0) && getvalue(rig,2) == 0 && getvalue(rig,1) == 0){
               setvalue(getvalue(rig,0),rig,2);
               setvalue(0,rig,0);
            }else if(!(getvalue(rig,3) == 0) && getvalue(rig,2) == 0 && !(getvalue(rig,1) == 0)){
               setvalue(getvalue(rig,1),rig,2);
               setvalue(getvalue(rig,0),rig,1);
               setvalue(0,rig,0);
            }else if(!(getvalue(rig,3) == 0) && !(getvalue(rig,2) == 0) && getvalue(rig,1) == 0){
               setvalue(getvalue(rig,0),rig,1);
               setvalue(0,rig,0);
            }
        }
        ArrayList<Integer> mazzo = new ArrayList<>(1);
        mazzo.add(1);
        mazzo.add(2);
        mazzo.add(3);
        mazzo.add(4);
        Collections.shuffle(mazzo);
         ArrayList<Integer> numeri = new ArrayList<>(1);
        numeri.add(2);
        numeri.add(2);
        numeri.add(2);
        numeri.add(4);
        Collections.shuffle(numeri);
        boolean flag = true;
        for(int count = 0; count < 4; count++){
            if(mazzo.get(count) == 1 && getvalue(0,0) == 0 && flag){
                setvalue(numeri.get(0),0,0);
                flag = false;
            }else if(mazzo.get(count) == 2 && getvalue(1,0) == 0 && flag){
                setvalue(numeri.get(0),1,0);
                flag = false;
            }else if(mazzo.get(count) == 3 && getvalue(2,0) == 0 && flag){
                setvalue(numeri.get(0),2,0);
                flag = false;
            }else if(mazzo.get(count) == 4 && getvalue(3,0) == 0 && flag){
                setvalue(numeri.get(0),3,0);
                flag = false;
            }
        }
        if(flag){
            if(!(HELP())){
                    setgameover(true);
                    GAMEOVER();
                }
        }
    }
    @Override
    public String toString(){
       String s = "";
       for(int a=0; a<4; a++){
           for(int b=0; b<4; b++){
               if(lista[a][b] != 0){
                   if(lista[a][b]/100 > 0){
                       s+=lista[a][b];
                   }else if(lista[a][b]/10 > 0){
                       s+=lista[a][b];
                       s+=" ";
                   }else{
                       s+= " ";
                       s+=lista[a][b];
                       s+=" ";
                   }
                   
               }else{
                   s+= "   ";
               }
               s+= "  ";
           }
           s+="\n";
       }
       return s;
    }

    private void GAMEOVER() throws IOException {
        System.out.println("GAME OVER");
        File();
        
   }
    private boolean HELP(){
            for(int c=0; c<4; c++){
                if(getvalue(0,c) == getvalue(1,c) || getvalue(1,c) == getvalue(2,c) || getvalue(2,c) == getvalue(3,c)){
                    System.out.println("Mossa consigliata: UP");
                    return true;
                }else if(getvalue(3,c) == getvalue(2,c) || getvalue(2,c) == getvalue(1,c) || getvalue(1,c) == getvalue(0,c)){
                    System.out.println("Mossa consigliata: DOWN");
                    return true;
                }else if(getvalue(c,0) == getvalue(c,1) || getvalue(c,1) == getvalue(c,2) || getvalue(c,2) == getvalue(c,3)){
                    System.out.println("Mossa consigliata: RIGHT");
                    return true;
                }else if(getvalue(c,3) == getvalue(c,2) || getvalue(c,2) == getvalue(c,1) || getvalue(c,1) == getvalue(c,0)){
                    System.out.println("Mossa consigliata: LEFT");
                    return true;
                }
            }
            return false;
    }

    /**
     *
     * @return
     */
    public int SCORE() {
        int punteggio = 0;
        for(int a=0; a<4; a++){
           for(int b=0; b<4; b++){
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
        FileReader fr;
        FileWriter fw;
        fr=new FileReader("src/pkg2048/v1/pkg0/file/high_score.txt");
        BufferedReader b;
        b=new BufferedReader(fr);
        for(int a = 0; a<10; a++){
            Score.add(b.readLine());
        }
        //System.out.println(Score);
        String Ten = Score.get(9);
        String[] part = Ten.split(" ");
        int Score_Ten = Integer.parseInt(part[1]);
        String Name_Ten = part[0];
        String One = Score.get(0);
        part = One.split(" ");
        int Score_One = Integer.parseInt(part[1]);
        String Name_One = part[0];
        String Two = Score.get(1);
        part = Two.split(" ");
        int Score_Two = Integer.parseInt(part[1]);
        String Name_Two = part[0];
        String Three = Score.get(2);
        part = Three.split(" ");
        int Score_Three = Integer.parseInt(part[1]);
        String Name_Three = part[0];
        String Four = Score.get(3);
        part = Four.split(" ");
        int Score_Four = Integer.parseInt(part[1]);
        String Name_Four = part[0];
        String Five = Score.get(4);
        part = Five.split(" ");
        int Score_Five = Integer.parseInt(part[1]);
        String Name_Five = part[0];
        String Six = Score.get(5);
        part = Six.split(" ");
        int Score_Six = Integer.parseInt(part[1]);
        String Name_Six = part[0];
        String Seven = Score.get(6);
        part = Seven.split(" ");
        int Score_Seven = Integer.parseInt(part[1]);
        String Name_Seven = part[0];
        String Eight = Score.get(7);
        part = Eight.split(" ");
        int Score_Eight = Integer.parseInt(part[1]);
        String Name_Eight = part[0];
        String Nine = Score.get(8);
        part = Nine.split(" ");
        int Score_Nine = Integer.parseInt(part[1]);
        String Name_Nine = part[0];
        //System.out.println(Score_Ten);
        //System.out.println(Score_Nine);
        //System.out.println(Score_Eight);
        //System.out.println(Score_Seven);
        //System.out.println(Score_Six);
        //System.out.println(Score_Five);
        //System.out.println(Score_Four);
        //System.out.println(Score_Three);
        //System.out.println(Score_Two);
        //System.out.println(Score_One);
        boolean flag = true;
        if(SCORE() > Score_One && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = Score_Six;
            Name_Seven = Name_Six;
            Score_Six = Score_Five;
            Name_Six = Name_Five;
            Score_Five = Score_Four;
            Name_Five = Name_Four;
            Score_Four = Score_Three;
            Name_Four = Name_Three;
            Score_Three = Score_Two;
            Name_Three = Name_Two;
            Score_Two = Score_One;
            Name_Two = Name_One;
            Score_One = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_One = in.next();
        }else if(SCORE() > Score_Two && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = Score_Six;
            Name_Seven = Name_Six;
            Score_Six = Score_Five;
            Name_Six = Name_Five;
            Score_Five = Score_Four;
            Name_Five = Name_Four;
            Score_Four = Score_Three;
            Name_Four = Name_Three;
            Score_Three = Score_Two;
            Name_Three = Name_Two;
            Score_Two = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Two = in.next();
        }else if(SCORE() > Score_Three && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = Score_Six;
            Name_Seven = Name_Six;
            Score_Six = Score_Five;
            Name_Six = Name_Five;
            Score_Five = Score_Four;
            Name_Five = Name_Four;
            Score_Four = Score_Three;
            Name_Four = Name_Three;
            Score_Three = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Three = in.next();
        }else if(SCORE() > Score_Four && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = Score_Six;
            Name_Seven = Name_Six;
            Score_Six = Score_Five;
            Name_Six = Name_Five;
            Score_Five = Score_Four;
            Name_Five = Name_Four;
            Score_Four = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Four = in.next();
        }else if(SCORE() > Score_Five && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = Score_Six;
            Name_Seven = Name_Six;
            Score_Six = Score_Five;
            Name_Six = Name_Five;
            Score_Five = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Five = in.next();
        }else if(SCORE() > Score_Six && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = Score_Six;
            Name_Seven = Name_Six;
            Score_Six = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Six = in.next();
        }else if(SCORE() > Score_Seven && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = Score_Seven;
            Name_Eight = Name_Seven;
            Score_Seven = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Seven = in.next();
        }else if(SCORE() > Score_Eight && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = Score_Eight;
            Name_Nine = Name_Eight;
            Score_Eight = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Eight = in.next();
        }else if(SCORE() > Score_Nine && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = Score_Nine;
            Name_Ten = Name_Nine;
            Score_Nine = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Nine = in.next();
        }else if(SCORE() > Score_Ten && flag){
            Scanner in = new Scanner(System.in);
            Score_Ten = SCORE();
            System.out.print("Immettere Nome in Maiuscolo da 3 caratteri(es. CAP): ");
            Name_Ten = in.next();
        }
        fw = new FileWriter("src/pkg2048/v1/pkg0/file/high_score.txt");
        if(Score_One/1000 > 0){//Controllo 1
            fw.write(Name_One + " " + Score_One +"\n");
        }else if(Score_One/100 > 0){
            fw.write(Name_One + " 0" + Score_One +"\n");
        }else if(Score_One/10 > 0){
            fw.write(Name_One + " 00" + Score_One +"\n");
        }else{
            fw.write(Name_One + " 000" + Score_One +"\n");
        }
        if(Score_Two/1000 > 0){//Controllo 2
            fw.write(Name_Two + " " + Score_Two +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Two + " 0" + Score_Two +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Two + " 00" + Score_Two +"\n");
        }else{
            fw.write(Name_Two + " 000" + Score_Two +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 3
            fw.write(Name_Three + " " + Score_Three +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Three + " 0" + Score_Three +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Three + " 00" + Score_Three +"\n");
        }else{
            fw.write(Name_Three + " 000" + Score_Three +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 4
            fw.write(Name_Four + " " + Score_Four +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Four + " 0" + Score_Four +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Four + " 00" + Score_Four +"\n");
        }else{
            fw.write(Name_Four + " 000" + Score_Four +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 5
            fw.write(Name_Five + " " + Score_Five +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Five + " 0" + Score_Five +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Five + " 00" + Score_Five +"\n");
        }else{
            fw.write(Name_Five + " 000" + Score_Five +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 6
            fw.write(Name_Six + " " + Score_Six +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Six + " 0" + Score_Six +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Six + " 00" + Score_Six +"\n");
        }else{
            fw.write(Name_Six + " 000" + Score_Six +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 7
            fw.write(Name_Seven + " " + Score_Seven +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Seven + " 0" + Score_Seven +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Seven + " 00" + Score_Seven +"\n");
        }else{
            fw.write(Name_Seven + " 000" + Score_Seven +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 8
            fw.write(Name_Eight + " " + Score_Eight +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Eight + " 0" + Score_Eight +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Eight + " 00" + Score_Eight +"\n");
        }else{
            fw.write(Name_Eight + " 000" + Score_Eight +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 9
            fw.write(Name_Nine + " " + Score_Nine +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Nine + " 0" + Score_Nine +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Nine + " 00" + Score_Nine +"\n");
        }else{
            fw.write(Name_Nine + " 000" + Score_Nine +"\n");
        }
        if(Score_Two/1000 > 0){//controllo 10
            fw.write(Name_Ten + " " + Score_Ten +"\n");
        }else if(Score_Two/100 > 0){
            fw.write(Name_Ten + " 0" + Score_Ten +"\n");
        }else if(Score_Two/10 > 0){
            fw.write(Name_Ten + " 00" + Score_Ten +"\n");
        }else{
            fw.write(Name_Ten + " 000" + Score_Ten +"\n");
        }    
        fw.flush();
        fw.close();
        
        System.out.println("- - - HIGH SCORE - - -");
        System.out.println(Name_One + " " + Score_One);
        System.out.println(Name_Two + " " + Score_Two);
        System.out.println(Name_Three + " " + Score_Three);
        System.out.println(Name_Four + " " + Score_Four);
        System.out.println(Name_Five + " " + Score_Five);
        System.out.println(Name_Six + " " + Score_Six);
        System.out.println(Name_Seven + " " + Score_Seven);
        System.out.println(Name_Eight + " " + Score_Eight);
        System.out.println(Name_Nine + " " + Score_Nine);
        System.out.println(Name_Ten + " " + Score_Ten);
        
        }
}
