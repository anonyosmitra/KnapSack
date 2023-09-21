import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int[] binMap=new int[32];
    static int weights[] = {3, 1, 6, 10, 1, 4, 9, 1, 7, 2, 6, 1, 6, 2, 2, 4, 8, 1, 7, 3, 6, 2, 9, 5, 3, 3, 4, 7, 3, 5, 30, 50};
    static int values[] = {7, 4, 9, 18, 9, 15, 4, 2, 6, 13, 18, 12, 12, 16, 19, 19, 10, 16, 14, 3, 14, 4, 15, 7, 5, 10, 10, 13, 19, 9, 8, 5};
    static int size = 32;
    static List<Item> items = new ArrayList<>();
    static long setCount=0;
    static int W_max = 75;
    public static void main(String[] args) {
        List<Item> maxSet=new ArrayList<>();
        int maxVal=0;
        for (int i = 0; i < size; i++)
            items.add(new Item(weights[i], values[i]));
        makeMap();
        int perc=0;
        System.out.println(perc+"%");
        for(long i=0;i<=setCount;i++){
            int p=(int)((float) i / setCount * 100);
            if (p!=perc) {
                perc=p;
                System.out.println(perc+"%");
            }
            List<Item> st=getSet(i);
            if(Item.sumWeight(st)<=W_max && Item.sumVal(st)>maxVal){
                maxSet=st;
                maxVal=Item.sumVal(st);
            }
        }
        System.out.println("Max val: "+maxVal);
        System.out.println(maxSet);
    }
    public static void makeMap(){
        for(int i=size-1;i>=0;i--){
            binMap[i]= (int) Math.pow(2,size-1-i);
            setCount+=binMap[i];
        }
    }
    public static List<Item> getSet(long a) {
        List<Item> st=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if(binMap[i]<=a){
                st.add(items.get(i));
                a-=binMap[i];
            }
        }
        return st;
    }
}
/*

 */