package TrieDataStructure208;

public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word){
    	TrieNode curr = root;
    	for(int i = 0; i < word.length(); i++){
    		char ch = word.charAt(i);
    		if(!curr.containsKey(ch)){
    			curr.put(ch, new TrieNode());
    		}
    		curr = curr.get(ch);
    	}
    	curr.setEnd();
    }
    
    private TrieNode searchPrefix(String prefix){
    	TrieNode curr = root;
    	for(int i = 0; i < prefix.length(); i++){
    		char ch = prefix.charAt(i);
    		if(curr.containsKey(ch)){
    			curr = curr.get(ch);
    		} else {
    			return null;
    		}
    	}
    	return curr;
    }
    
    public boolean hasPrefix(String prefix){
    	if(searchPrefix(prefix) == null){
    		return false;
    	} else{
    		return true;
    	}
    }
    
    public boolean hasWord(String word){
    	TrieNode node = searchPrefix(word);
    	return node != null && node.isEnd();
    }
    
    public boolean startsWith(String word){
    	TrieNode node = searchPrefix(word);
    	return node != null;
    }
}
