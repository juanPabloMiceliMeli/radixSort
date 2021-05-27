package radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {

    public static ArrayList<String>[] arrayToBuckets(String[] s, int index){
        ArrayList<String>[] buckets = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<String>();
        }

        for(int i = 0; i < s.length; i++){
            String word = s[i];
            int bucketIndex = word.charAt(index)-'0';
            buckets[bucketIndex].add(word);
        }
        return buckets;
    }

    public static String[] bucketsToArray(ArrayList<String>[] buckets, int size){
        String[] res = new String[size];
        int contador = 0;
        for(int i = 0; i < buckets.length; i++){
            for(int j = 0; j < buckets[i].size(); j++){
                res[contador] = buckets[i].get(j);
                contador++;
            }
        }
        return res;
    }

    public static String[] intArrayToStringArray(int[] inArray){

        //Paso a tipo de dato intStream (investigar streams que parecen copados)
        IntStream iS = Arrays.stream(inArray);
        //Transformo cada elemento de del stream a string.
        Stream<String> sS = iS.mapToObj(String::valueOf);
        //Paso de stream a array normal
        return sS.toArray(String[]::new);
    }

    public static int[] stringArrayToIntArray(String[] inArray){
        return Arrays.stream(inArray).mapToInt(Integer::parseInt).toArray();
    }

    public static String fixStringSize(String number, int size){

        int N = number.length();
        while (N<size){
            number = "0"+number;
            N++;
        }

        return number;
    }

    public static int maxLengthString(String[] array){
        int maxLen = -1;
        for(String s : array){
            int newLen = s.length();
            if(maxLen < newLen){
                maxLen = newLen;
            }
        }
        return maxLen;
    }

    public static String[] fixStringSizeArray(String[] numbers){
        int maxLen = maxLengthString(numbers);
        int N = numbers.length;
        for(int i = 0; i < N; i++){
            numbers[i] = fixStringSize(numbers[i], maxLen);
        }
        return numbers;

    }
}
