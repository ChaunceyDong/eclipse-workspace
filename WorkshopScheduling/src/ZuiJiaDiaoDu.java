import java.util.*;


public class ZuiJiaDiaoDu {

    private static class Machine implements Comparable{
        int i,dep;
        int[] len;

        public int compareTo(Object o){
            Machine machine = (Machine) o;
            int result = Integer.compare(len[i], machine.len[i]);

            return result;
        }
    }

    private static int n,k;
    private static int[] len,t;
    private static int best;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (true){
            n = input.nextInt();
            k = input.nextInt();

            len = new int[k];
            t = new int[n];

            for(int i=0; i<n; i++)
                t[i] = input.nextInt();

            for(int i=0; i<k; i++) len[i]=0;
//    		input.close();

            best = bound();

            System.out.println(BBMachine());
        }
    }

    private static int bound(){
        Arrays.sort(t);
        for(int i=0; i<n; i++)
            len[ind(len)] += t[i];

        return comp(len);
    }

    private static int ind(int[] len){
        int tmp = 0;
        for(int i=1; i<k; i++)
            if(len[i] < len[tmp])
                tmp = i;

        return tmp;
    }

    private static int comp(int[] len){
        int tmp = 0;
        for(int i=0; i<k; i++)
            if(len[i] > tmp)
                tmp = len[i];

        return tmp;
    }

    private static int BBMachine(){
        Queue<Machine> H = new PriorityQueue<>();
        Machine E = new Machine();
        E.len = new int[k];
        E.i=0; E.dep=0;
        for(int i=0; i<k; i++) E.len[i]=0;
        int dep = 0;
        while (true){
            if(dep == n){
                int tmp = comp(E.len);
                if(tmp < best) best=tmp;
            }else{
                for(int i=0; i<k; i++){
                    Machine N = new Machine();
                    N.len = new int[k];
                    N.i=i; N.dep=dep;
                    for(int j=0; j<k; j++) N.len[j]=E.len[j];
                    N.len[i] += t[dep];
                    if(N.len[i] < best) H.add(N);
                }
            }
            if(H.isEmpty()) return best;
            E = H.poll();
            dep = E.dep+1;
        }
    }
}