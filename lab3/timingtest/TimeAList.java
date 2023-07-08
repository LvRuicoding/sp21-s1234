package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> NList = new AList<>();
        AList<Double> TimeList = new AList<>();
        for (int i=0;i<8;i++){
            Stopwatch sw = new Stopwatch();
            AList<Integer> testList =new AList<>();
            for (int j=0;j<1000*Math.pow(2,i);j++){
                testList.addLast(1);
            }
            TimeList.addLast(sw.elapsedTime());
        }
        for(int i=0;i<8;i++){
            int temple = (int) Math.pow(2,i);
            NList.addLast(temple*1000);
        }
        printTimingTable(NList,TimeList,NList);
    }
}
