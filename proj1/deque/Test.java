package deque;

import java.util.Comparator;
import java.util.Iterator;

public class Test {
    public static void main(String args[]){
        Comparator<String> cmp = new Comparator<>() {
            //重写排序方法
            @Override
            public int compare(String strA, String strB) {
                return strB.compareTo(strA);
            }
        };
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<>(cmp);
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for(int i =15;i>0;i--){
            lld1.addFirst("hao");
        }
        System.out.print(lld1.get(1));
        lld1.size();
        String A = lld1.max();
    }
}
