package radix;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class main {

    public static int[] radixSort(int[] numeros){
        if(numeros.length == 0) return new int[0];
        //Pasamos el array de enteros a array de strings
        String[] sNumeros = Utils.intArrayToStringArray(numeros);
        //Le agregamos los ceros necesarios adelante
        sNumeros = Utils.fixStringSizeArray(sNumeros);
        int maxLen = sNumeros[0].length();
        for(int i = maxLen-1; i >= 0; i--){
            sNumeros = Utils.bucketsToArray(Utils.arrayToBuckets(sNumeros, i), sNumeros.length);
        }
        return Utils.stringArrayToIntArray(sNumeros);
    }


    public static void main(String[] args){
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};

        arr = radixSort(arr);
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }

    }
}
