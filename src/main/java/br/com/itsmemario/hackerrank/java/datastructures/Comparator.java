package br.com.itsmemario.hackerrank.java.datastructures;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-comparator/problem
 * 
 * Difficulty: Medium
 * 
 * @author mario
 *
 */
class Checker implements java.util.Comparator<Player>{
    
    public int compare(Player player1, Player player2){
        
    	
    	if(player1.score==player2.score) {
    		return player1.name.compareTo(player2.name);
    	}else {
    		return player2.score - player1.score;
    	}
        
    }
    
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Comparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}