/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vlad Crihan
 */
import java.util.Scanner;
public class Exercise8_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[][] game = new String[7][13];
        
        game = initializeGame(game);
        printTable(game);
     
     Scanner input = new Scanner(System.in);
     
    int temp2 = 0;
    int temp1 = 0; 
    int temp = 0; 
    boolean win = false; 
    while(win != true){
            
        if(temp % 2 == 0){
            boolean turn = false;
            while(turn != true){
                System.out.print("Enter a row (0, 1, or 2) for player X:");
                temp1 = changeX(input.nextInt());
                System.out.print("Enter a column (0, 1, or 2) for player X:");
                temp2 = changeY(input.nextInt());
                turn = checkPosition(game,temp1,temp2);
                if(turn == true){
                    game[temp1][temp2] = "X";
                    temp++;
                }else
                    System.out.println("Please enter an unused spot");
                printTable(game);
                win = checkWin(game);
                if(win == true)
                    System.out.println("X won!");
                
                if(temp == 9 && turn == false){
                System.out.println("DRAW!");
                turn = true;
                }
            }
        }
        else{
            boolean turn = false;
            while(turn != true){
                System.out.print("Enter a row (0, 1, or 2) for player 0:");
                temp1 = changeX(input.nextInt());
                System.out.print("Enter a column (0, 1, or 2) for player 0:");
                temp2 = changeY(input.nextInt());
                turn = checkPosition(game,temp1,temp2);
                if(turn == true){
                    game[temp1][temp2] = "0";
                    temp++;
                }else
                    System.out.println("Please enter an unused spot");
                printTable(game);
                win = checkWin(game);
                if(win == true)
                    System.out.println("0 won!");
            }
        }
    }
    }
    
    public static void printTable(String[][] table){
        
        //print table
        for (int row = 0; row < table.length; row++){
            
            for (int collumn = 0; collumn < table[0].length; collumn++)
                System.out.print(table[row][collumn]);
            
            System.out.println("");
        }
    }
    
    public static int changeX(int input){
        
        int temp = 0;
        switch(input){
            case(0): temp = 1; break;
            case(1): temp = 3; break;
            case(2): temp = 5; break;
            default:
                System.out.println("Please input a number between 0-3");
        }
        return temp;
    }
    
    public static int changeY(int input){
        
        int temp = 0;
        switch(input){
            case(0): temp = 2;break;
            case(1): temp = 6;break;
            case(2): temp = 10;break;
            default:
                System.out.println("Please input a number between 0-3");
        }
        return temp;
    }
    public static String[][] initializeGame(String[][] game){
        
        //create initial table
        for (int row = 0; row < game.length; row++) {
        
            for (int collumn = 0; collumn < game[0].length; collumn++){
                if(row % 2 == 0)
                    game[row][collumn] = "-";
                
                else if(row % 1 ==0){
                    if(collumn % 4 == 0)
                        game[row][collumn] = "|";
                    else
                        game[row][collumn] = " ";
                }
            }
        }
        return game;
    }
    
    public static boolean checkWin(String[][] game){
        
        boolean check = checkWinX(game);
        if(check != true){
            check = checkWinY(game);
            
            if(check != true){
                check = checkDiag(game);
            }
        }
        return check;
    }
    
    public static boolean checkWinX(String[][] game){
        
        boolean temp1 = false;
        int temp = 0;
        for (int row = 0; row < game.length; row++){
            temp = 0;
            for (int collumn = 0; collumn < game[0].length; collumn++) {
                if(game[row][collumn] == "X")
                    temp++;
                
                else if(game[row][collumn] == "Y")
                    temp++;
                
                if(temp == 3)
                    return true;
            }
        }
        return temp1;
    }
    
    public static boolean checkWinY(String[][] game){
        
        boolean temp1 = false;
        int temp = 0;
        for (int row = 0; row < game[0].length; row++){
            temp = 0;
            for (int collumn = 0; collumn < game.length; collumn++) {
                if(game[collumn][row] == "X")
                    temp++;
                
                else if(game[collumn][row] == "Y")
                    temp++;
                
                if(temp == 3)
                    return true;
            }
        }
        return temp1;
    }
    
    public static boolean checkDiag(String[][] game){
        
        if( (game[1][2] == "X" && game[3][6] == "X" && game[5][10] == "X") ||
                (game[1][10] == "X" && game[3][6] == "X" && game[5][2] == "X"))
            return true;
        
        else if((game[1][2] == "0" && game[3][6] == "0" && game[5][10] == "0")||
                (game[1][10] == "0" && game[3][6] == "0" && game[5][2] == "0"))
            return true;
        return false;
    }
    
    public static boolean checkPosition(String[][] game,int temp1,int temp2){
        
        for (int row = 0; row < game.length; row++)
            for (int collumn = 0; collumn < game[row].length; collumn++) {
                if(game[temp1][temp2] == "0" || game[temp1][temp2]=="X")
                    return false;
                else
                    return true;
            }
        return false;
    }
}