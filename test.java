import java.net.*;
import java.util.function.*;
import java.util.stream.LongStream;
import java.util.*;
public class test{
    public static void main(String[] args){
        Bug a = ((Bug) System.out::println);
        a.apply(a);
    }
}