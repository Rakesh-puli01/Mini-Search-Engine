package trie;

import java.util.*;

public class Trie {

    private TrieNode root;

    public Trie(){
        root=new TrieNode();
    }

    public void insert(String word){

        TrieNode node=root;

        for(char c:word.toCharArray()){
            node.children.putIfAbsent(c,new TrieNode());
            node=node.children.get(c);
        }

        node.isWord=true;
    }

    public List<String> autoComplete(String prefix){

        List<String> result=new ArrayList<>();
        TrieNode node=root;

        for(char c:prefix.toCharArray()){

            if(!node.children.containsKey(c))
                return result;

            node=node.children.get(c);
        }

        dfs(node,prefix,result);

        return result;
    }

    private void dfs(TrieNode node,String word,List<String> result){

        if(node.isWord)
            result.add(word);

        for(char c:node.children.keySet()){
            dfs(node.children.get(c),word+c,result);
        }
    }
}