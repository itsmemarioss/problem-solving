package br.com.itsmemario;

public class Main {

	public static void main(String[] args) {
		//You have String 1: "abcdefgh". Write a code to remove "ad " so that you are left with "bcefgh".
		String text = "abcdefgh";
		char[] array = "ad".toCharArray();
		for (int i = 0; i < array.length; i++) {
			StringBuilder sb = new StringBuilder();
			
			int index = text.indexOf(array[i]);
			
			sb.append(text.substring(0, index));
			if(index+1!=text.length())
				sb.append(text.substring(index+1));
			
			text = sb.toString();
			
		}
		
		System.out.println(text);

	}

}
