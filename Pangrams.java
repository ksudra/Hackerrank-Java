import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static boolean isLetter(char ch) {
        if (Character.isLetter(ch)) return true;
        else return false;
    }
    
    public static String pangrams(String s) {
        s = s.replaceAll("\\s", "");
        s = s.toLowerCase();
        boolean[] alphabet = new boolean[26];
        
        for(int i = 0; i < s.length(); i ++) {
            if(isLetter(s.charAt(i))) {
                int letter = s.charAt(i) - 'a';
                alphabet[letter] = true;
            }
        }
        
        for (boolean b : alphabet) {
            if(!b) return "not pangram";
        }
        
        return "pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
