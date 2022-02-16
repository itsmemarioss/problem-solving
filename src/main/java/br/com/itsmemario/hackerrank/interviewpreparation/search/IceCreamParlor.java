package br.com.itsmemario.hackerrank.interviewpreparation.search;

import java.util.*;

public class IceCreamParlor {

    static class MenuItem {
        int price, index;
        public MenuItem(int p, int i){
            this.price = p;
            this.index = i;
        }
    }
    
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Comparator<MenuItem> comparator = (i1, i2)-> i1.price - i2.price;
        
        ArrayList<MenuItem> items = new ArrayList<>(cost.length);
        for(int i = 0;i<cost.length;i++){
            items.add(new MenuItem(cost[i],i+1) );
        }
        
        Collections.sort(items, comparator);
        MenuItem first = null;
        MenuItem second = null;
        
        for(MenuItem i : items){
            
        	first = i;
        	
            int leftover = money - i.price;
            int index = Collections.binarySearch(items, new MenuItem(leftover,0), comparator);
            
            while(index >= 0 ){
            	second = items.get(index);
            	
            	if(second.index == first.index){
            		items.remove(index);
            		index = Collections.binarySearch(items, new MenuItem(leftover,0), comparator);
            	}else {
            		break;
            	}
            }
            
            if(second != null && money==i.price+second.price){
                break;
            }
        }
        
        int min = Math.min(first.index, second.index);
        int max = Math.max(first.index, second.index);
        
        System.out.printf("%d %d%n",min,max);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
