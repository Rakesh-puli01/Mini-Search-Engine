package engine;

import java.util.*;

public class InvertedIndex {

    private Map<String,Map<Integer,Integer>> index;

    public InvertedIndex(){
        index=new HashMap<>();
    }

    public void addWord(String word,int docId){

        index.putIfAbsent(word,new HashMap<>());

        Map<Integer,Integer> docs=index.get(word);

        docs.put(docId,docs.getOrDefault(docId,0)+1);
    }

    public Map<Integer,Integer> search(String word){

        return index.getOrDefault(word,new HashMap<>());
    }

    public Set<String> getVocabulary(){
        return index.keySet();
    }

    public void removeDocument(int docId){

        for(String word:index.keySet()){
            index.get(word).remove(docId);
        }
    }
}