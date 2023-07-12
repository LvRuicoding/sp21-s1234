package deque;

import java.util.Iterator;

public class Test {
    public static void main(String args[]){
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for(int i =15;i>0;i--){
            lld1.addFirst(i);
            lld2.addFirst(i);
        }
        System.out.print(lld1.get(1));
        System.out.print(lld2.get(1));
    }
}
