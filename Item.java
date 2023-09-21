import java.util.List;

public class Item {
    private int val,weight;
    public Item(int w,int v){
        val=v;
        weight=w;
    }
    public int getWeight(){
        return weight;
    }
    public int getVal(){
        return val;
    }
    @Override
    public String toString(){
        return String.format("{\"val\": %d, \"weight\": %d}",val,weight);
    }
    public static int sumVal(List<Item> items){
        return items.stream().mapToInt(Item::getVal).sum();
    }
    public static int sumWeight(List<Item> items){
        return items.stream().mapToInt(Item::getWeight).sum();
    }
}
