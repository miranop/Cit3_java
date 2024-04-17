public class ArraySample {
    
    int prime[] = {2,3,5,7,11,13,17,19,23,29};
    int data[];//初期化されていない配列 
    public static void main(String[] args) {
        ArraySample sample = new ArraySample();

        sample.initData();
        sample.Printdata();
        sample.PrintData2();

        sample.swap(0, 4);
        sample.Printdata();

        sample.printsum();

        int r = (int)(Math.random()*5);
        System.out.println(r);
        
    }
    void initData(){
        data = new int[prime.length];//配列primeと同じものを関数内で作成
        for (int i=0;i<prime.length;i++){
            data[i] = prime[i];//値を一つずつコピー
        }
    }
    void Printdata(){
        for (int i = 0;i<data.length;i++){
            System.out.println(data[i]+" ");
        }
        System.out.println();
    }

    void PrintData2(){
        for(int d: data){
            System.out.println(d+" ");
        }
        System.out.println();
    }
    //拡張for分を使うメリット,lengthを使わずに短く書くことができる。配列の番号をいちいち割り当てる必要性がない。
    //配列data[]のx番目の要素とy番目の要素を入れ替える
    void swap(int x,int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    void printsum(){
        int ps[] = new int[0];
        for(int i = 0;i<prime.length-1;i++){
            ps[i] = prime[i]+prime[i+1];
            System.err.println(ps[i]);
        }
        System.err.println();
    }

    void shuffle(){
        int sh = (int)(Math.random()*data.length);

        for (int i = 0;i<data.length;i++){
            swap(i, sh);
        }
    }
    
}
