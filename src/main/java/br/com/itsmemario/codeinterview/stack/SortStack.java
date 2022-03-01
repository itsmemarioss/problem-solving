package br.com.itsmemario.codeinterview.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 */
public class SortStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addAll(Arrays.asList(10,3,7,1,9));

        Deque<Integer> tmpStack = new LinkedList<>();

        while(!stack.isEmpty()) {
            Integer first = stack.pollFirst();
            if(tmpStack.isEmpty()) {
                tmpStack.offerFirst(first);
            }else{
                while (tmpStack.peekFirst() < first) {
                    stack.offerFirst( tmpStack.pollFirst() );
                }
                tmpStack.offerFirst(first);
            }
        }

        System.out.println(tmpStack);
    }
}
