import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtils {

    public static int findVowels(String str){
        if (str == null)
            return 0;

        String vowels= "aeiou";
        int count = 0;
        for(var ch : str.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    public static String reverse(String str){
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for(int i=str.length()-1; i >=0; i--)
            reversed.append(str.charAt(i));
        
        return reversed.toString();
    }

    public static String reverseWords(String sentence){
        if (sentence == null)
            return "";
        String [] words = sentence.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

        // StringBuilder result = new StringBuilder();
        // for (int i=words.length -1; i >=0; i--)
        //     result.append(words[i]+ " ");
        // return result.toString();
    }

    public static boolean  areRotations(String str1, String str2){
        if(str1 == null || str2 == null)
            return false;
        return (str1.length() == str2.length() && (str1+str1).contains(str2));
    }

    public static String removeDuplicates(String str){
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch :  str.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static char  mostRepeated(String str){
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException();

        int [] frequecies = new int [256];
        for (var ch : str.toCharArray())
            frequecies[ch]++;
        
        int  max = 0;
        char  result =  ' ';
        for (int  i=0; i <  frequecies.length; i++){
            if(frequecies[i]  > max){
                max =  frequecies[i];
                result = (char) i;
            }
        }
        return result;

        // Map<Character, Integer> elements  =  HashMap<>();
        // int count = 0;
        // for  (var ch : str.toCharArray())
        //     if(elements.containsKey(ch))
        //         elements.replace(ch, elements.get(ch)+1);
        //     else
        //         elements.put(ch, 1);
    }

    public  static String capitolize(String sentence){
        String [] words = sentence.trim().replaceAll(" +", " ").split(" ");
        for(int i=0; i < words.length; i++){
            if(words[i].length() > 1)
                words[i] = words[i].substring(0, 1).toUpperCase()+words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public  static boolean areAnagram(String first, String second){
        if  (first == null || second == null)
            return  false;

        var array1  =  first.toCharArray();
        Arrays.sort(array1);

        var  array2 =   second.toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);

    }

    public static boolean isPalindrom(String str){
        int  first = 0;
        int second = str.length()-1;
        while (first <  second){
            if  (str.charAt(first++) !=  str.charAt(second--))
                return false;
        }
        return  true;
    }
}
