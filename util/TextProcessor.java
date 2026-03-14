package util;

import java.util.*;

public class TextProcessor {

    private static Set<String> stopWords=new HashSet<>(Arrays.asList(
            "a","the","is","and","of","to"
    ));

    public static List<String> tokenize(String text){

        text=text.toLowerCase();
        text=text.replaceAll("[^a-zA-Z0-9 ]","");

        String[] words=text.split("\\s+");

        List<String> result=new ArrayList<>();

        for(String w:words){
            if(!stopWords.contains(w))
                result.add(w);
        }

        return result;
    }
}