package com.day13.task2;
class TrieNode{
	TrieNode[] children;
	boolean isEndOfWord;
	
	public TrieNode(){
		this.children=new TrieNode[26];
		this.isEndOfWord=false;
	}
}
public class Trie {
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}
	public void insert(String word) {
		TrieNode current=root;
		for(char ch: word.toCharArray()) {
			int index=ch-'a';
			if(current.children[index]==null)
				current.children[index]=new TrieNode();
			current =current.children[index];
		}
		current.isEndOfWord=true;
	}
	public boolean searchPrefix(String prefix) {
		TrieNode current=root;
		for(char ch: prefix.toCharArray()) {
			int index=ch-'a';
			if(current.children[index]==null)
				return false;
			current =current.children[index];
		}
		return true;
	}
	public static void main(String[] args) {
		Trie trie=new Trie();
		trie.insert("syam");
		trie.insert("david");
		trie.insert("john");
		trie.insert("mary");
		
		System.out.println("Is 'syam' a prefix...? "+trie.searchPrefix("syam"));
		System.out.println("Is 'yash' a prefix...? "+trie.searchPrefix("yash"));
		System.out.println("Is 'john' a prefix...? "+trie.searchPrefix("john"));
		System.out.println("Is 'sadia' a prefix...? "+trie.searchPrefix("sadia"));
	}
}
