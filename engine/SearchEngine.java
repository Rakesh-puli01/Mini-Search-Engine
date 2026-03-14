package engine;

import java.util.*;

import model.Document;
import trie.Trie;
import util.TextProcessor;

public class SearchEngine {

    private Trie trie;
    private InvertedIndex index;
    private Map<Integer,Document> documents;
    private List<String> history;

    public SearchEngine(){

        trie=new Trie();
        index=new InvertedIndex();
        documents=new HashMap<>();
        history=new ArrayList<>();
    }

    public void addDocument(Document doc){

        documents.put(doc.getId(),doc);

        List<String> words=TextProcessor.tokenize(doc.getContent());

        for(String w:words){

            trie.insert(w);
            index.addWord(w,doc.getId());
        }
    }

    public void deleteDocument(int id){

        documents.remove(id);
        index.removeDocument(id);

        System.out.println("Document removed");
    }

    public void autoComplete(String prefix){

        List<String> list=trie.autoComplete(prefix);

        if(list.isEmpty()){
            System.out.println("No suggestions");
            return;
        }

        for(String w:list)
            System.out.println(w);
    }

      private String highlightWords(String content, String[] words) {

    String result = content;

    for(String word : words){
        word = word.trim();

        // case-insensitive replace
        result = result.replaceAll("(?i)\\b" + word + "\\b", "\"" + word + "\"");
    }

    return result;
}

  public void searchSingleWord(String word){

    history.add(word);

    Map<Integer,Integer> map = index.search(word.toLowerCase());

    if(map == null || map.isEmpty()){
        System.out.println("No documents found.");
        return;
    }

    String[] words = {word};

    for(Integer docId : map.keySet()){

        Document doc = documents.get(docId);

        String content = doc.getContent();

        String highlighted = highlightWords(content, words);

        System.out.println("Document ID : " + docId);
        System.out.println(highlighted);
        System.out.println("----------------------------------");
    }
}
    
  

public void searchMultipleWords(String query){

    history.add(query);

    String[] words = query.toLowerCase().split(",");

    Set<Integer> result = null;

    for(String word : words){

        word = word.trim();

        Map<Integer,Integer> map = index.search(word);

        if(result == null)
            result = new HashSet<>(map.keySet());
        else
            result.retainAll(map.keySet());
    }

    if(result == null || result.isEmpty()){
        System.out.println("No documents found.");
        return;
    }

    for(Integer docId : result){

        Document doc = documents.get(docId);
        String content = doc.getContent();

        String highlighted = highlightWords(content, words);

        System.out.println("Document ID : " + docId);
        System.out.println(highlighted);
        System.out.println("----------------------------------");
    }
}

    public void phraseSearch(String phrase){

        history.add("\""+phrase+"\"");

        for(Document doc:documents.values()){

            if(doc.getContent().toLowerCase().contains(phrase))
                System.out.println("Doc "+doc.getId()+" -> "+doc.getContent());
        }
    }

    public void showVocabulary(){

        for(String w:index.getVocabulary())
            System.out.println(w);
    }

    public void showHistory(){

        for(String h:history)
            System.out.println(h);
    }

}