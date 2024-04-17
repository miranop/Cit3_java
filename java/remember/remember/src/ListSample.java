import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListSample {
    
    int prime[] = {2,3,5,7,11,13,17,19,23,29};

    List<Integer> data = new ArrayList<>();//空のリスト

    public static void main(String[] args) {
        ListSample sample = new ListSample();

        sample.initData();
        sample.PrintData();
        sample.PrintData2();

        sample.swap(0, 4);
        sample.PrintData();

        sample.printsum();

        sample.shuffle();
        sample.PrintData();
    }

    void initData(){
        for(int i = 0;i<prime.length;i++){
            data.add(prime[i]);
        }
    }
    void PrintData(){
        for(int i = 0;i<data.size();i++){
            System.out.println(data.get(i)+" ");
        }
        System.out.println();
    }
    void PrintData2(){
        for(int d:data){
            System.out.println(d+" ");
        }
        System.out.println();
    }

    void swap(int x,int y){
        Collections.swap(data, x, y);
    }
    void printsum(){
        List<Integer> ps = new ArrayList<>();
        for(int i = 0;i<prime.length;i++){
            int ans = prime[i]+prime[i+1];
            ps.add(ans);
        }
        System.out.println(ps);
        System.out.println();
    }

    void shuffle(){
        int sh = (int)(Math.random()*data.size());
        Random random = new Random(sh);
        Collections.shuffle(data, random);
        System.out.println(data);
    }
}
