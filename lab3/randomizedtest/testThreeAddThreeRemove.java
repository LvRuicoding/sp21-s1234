package randomizedtest;
import edu.princeton.cs.algs4.StdRandom;

public class testThreeAddThreeRemove {
    public static void main(String args[]){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B =new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
            } else if (operationNumber == 2) {
                if(L.size()>0){
                    L.removeLast();
                    B.removeLast();
                }
            }
        }
        if(L.size()== B.size()){System.out.println("ok");}
        else {System.out.println("no");}
    }
}
