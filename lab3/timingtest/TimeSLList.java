package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns =  new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();
        for (int i=0;i<8;i++){
            SLList<Integer> testList = new SLList<>();
            for (int j=0;j<1000*Math.pow(2,i);j++){
                testList.addLast(1);
            }
            int temp= (int) Math.pow(2,i);
            Ns.addLast(temp*1000);
            Stopwatch sw = new Stopwatch();
            for (int k=0;k<10000;k++){
                testList.getLast();
            }
            times.addLast(sw.elapsedTime());
            ops.addLast(10000);
        }
        printTimingTable(Ns,times,ops);
    }

}
