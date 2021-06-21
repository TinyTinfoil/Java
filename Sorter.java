import java.util.ArrayList;
/**
 * Write a description of class Sorter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorter
{
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);a.add(9);a.add(7);a.add(7);a.add(5);a.add(5);a.add(1);a.add(2);a.add(7);a.add(8);
        System.out.println(sort(a));
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> l){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int min = l.get(0);
        int t = l.size();
        while(temp.size()!=t){
            min = l.get(0);
        for(int i : l){
            if (i<min) min=i;
            System.out.println(min);
        }
        temp.add(l.remove(l.indexOf(min)));
    }
    return temp;
    }
}
