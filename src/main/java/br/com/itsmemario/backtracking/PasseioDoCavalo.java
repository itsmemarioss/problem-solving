package br.com.itsmemario.backtracking;

import java.util.ArrayDeque;
import java.util.Queue;

public class PasseioDoCavalo {
	
	
	int xInicial = 0;
	int yInicial = 0;
	int jogadas = 0;
	
	int[][] tabuleiro;
	
	//Jogadas possíveis
	int[] xs = {1, 2,  2,  1, -1, -2, -2, -1};
	int[] ys = {2, 1, -1, -2, -2, -1,  1,  2};
	
	Queue<Movimento> moves = new ArrayDeque<>();
	
	public PasseioDoCavalo(int x, int y, int tabuleiro) {
		this.xInicial = x;
		this.yInicial = y;
		this.tabuleiro = new int[tabuleiro][tabuleiro];
		this.tabuleiro[x][y] = 1;
		jogadas++;
	}	
	
	private boolean terminou() {
		return jogadas == Math.pow(tabuleiro.length,2);
	}

	private boolean tentaMovimento(int x, int y) {
		
		//printBoard();
		
		boolean sucesso = false;
		Movimento m = null;
		
		for(int i = 0; i<8;i++) {
			
			int a = x+xs[i];
			int b = y+ys[i];
		
			//jogada possível
			if( (a < tabuleiro.length) && ( a>=0 ) && 
				(b < tabuleiro.length) && ( b>=0 ) &&
				(tabuleiro[a][b]==0) ) {	
			
				//registra a jogada
				m = new Movimento(a,b); 
				tabuleiro[m.x][m.y] = ++jogadas;
				moves.offer(m);
				sucesso = true;
				
				boolean nextMove = tentaMovimento(m.x, m.y);
				
				if(!nextMove && !terminou()) {
					//desfazer jogada
					moves.poll();
					jogadas--;
					tabuleiro[m.x][m.y] = 0;
					sucesso = false;
				}else{
					break;
				}
				
			}//fim jogada possível
			
		}	
		
		return sucesso;
	}
	
	private void printBoard() {
		System.out.println("Jogada Nº"+jogadas);
		System.out.println("===============================");
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.printf("%2d| ",tabuleiro[i][j]);
			}
			System.out.println();
		}
		System.out.println("===============================");
	}

	class Movimento{
		int x,y;
		Movimento (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private void start() {
		boolean result = tentaMovimento(xInicial, yInicial);
		if(result) {
			printBoard();
		}else {
			System.out.println("Sem solução");
		}
	}
	
	public static void main(String[] args) {
		new PasseioDoCavalo(0, 0, 8).start();
	}
	
}
