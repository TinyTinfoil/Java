import java.util.ArrayList;
public class ArrayTest{
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);a.add(9);a.add(7);
        System.out.println("then (whic)");
        int[] t = {2,3,4,5,2};
        a.indexOf(2);
    }
    public static int totalValue(ArrayList<Integer> o){
        int a = 0;
        for(int i : o){
            a+=i;
        }
        return a;
    }
}

