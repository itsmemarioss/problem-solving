package hackerrank;

import java.util.*;

class Checker implements Comparator<Player>{
    
    public int compare(Player player1, Player player2){
        int result = player2.score - player1.score;
        if(result == 0 && (player1.name.compareTo(player2.name) < 0)) {
        	result--;
        }
    	return result;
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

public class Solution {

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