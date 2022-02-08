package sample;

import javafx.scene.image.Image;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Game {
    public int xNull, yNull;

    public void move(int x, int y) {
        if (Math.abs(x - xNull) + Math.abs(y - yNull) == 1) {
            solution[xNull][yNull] = solution[x][y];
            solution[x][y] = null;
            xNull = x;
            yNull = y;
        }
        endGame=isSolution(reset,solution);
    }

    public int width, height;
    public Image solution[][];
    public Image reset[][];
    public static boolean endGame =false;
    public Game(Image image, int width, int height) {
        this.width = width;
        this.height = height;
        reset=ImageCutter.cut(image, width, height);
        reset[width - 1][height - 1] = null;
        solution=new Image[width][height];
        for (int i = 0; i <reset.length; i++) {
            if (reset[i].length >= 0) System.arraycopy(reset[i], 0, solution[i], 0, reset[i].length);
        }
        shaking(solution);
        for (int i = 0; i <solution.length; i++) {
            for (int j = 0; j <solution[i].length ; j++) {
                if(solution[i][j]==null){
                    xNull=i;
                    yNull=j;
                }
            }
        }
    }

    public void shaking(Image[][] tab) {
        for (int i = 0; i < 500; i++) {
            int a = (int) (Math.random() * 4);
            if (a == 0) {
                tab = moveRight(tab);
            } else if (a == 1) {
                tab = moveLeft(tab);
            } else if (a == 2) {
                tab = moveDown(tab);
            } else if(a==3){
                tab = moveUp(tab);
            }
        }
    }

    public Image[][] moveRight(Image tab[][]) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == null) {
                    if (i == tab.length-1) {
                    } else {
                        tab[i][j] = tab[i + 1][j];
                        tab[i + 1][j] = null;
                    }
                }
            }
        }
        return tab;
    }

    public Image[][] moveLeft(Image tab[][]) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == null) {
                    if (i == 0) {
                    } else {
                        tab[i][j] = tab[i - 1][j];
                        tab[i - 1][j] = null;
                    }
                }
            }
        }
        return tab;
    }

    public Image[][] moveUp(Image tab[][]) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == null) {
                    if (j == 0) {
                    } else {
                        tab[i][j] = tab[i][j-1];
                        tab[i][j-1] = null;
                    }
                }
            }
        }
        return tab;
    }

    public Image[][] moveDown(Image tab[][]) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == null) {
                    if (j ==tab[i].length-1 ) {
                    } else {
                        tab[i][j] = tab[i][j+1];
                        tab[i][j+1] = null;
                    }
                }
            }
        }
        return tab;
    }
    public boolean isSolution(Image reset[][], Image solution[][]){
        for (int i = 0; i <reset.length; i++) {
            for (int j = 0; j <reset[i].length; j++) {
                if(reset[i][j]!=solution[i][j]){
                    return false;
                }
            }
        }
        try {
            JOptionPane.showMessageDialog(null, "Congratulations!!!");
            Main.stage.setScene(new WriteYourName().scene);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
