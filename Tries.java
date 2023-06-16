package datastructure;

class TrieNode{
	char data;
	boolean isTerminal;
	TrieNode childern[];
	int childCount;
	
	public TrieNode(char data) {
		this.data = data;
		this.isTerminal = false;
		this.childern = new TrieNode[26];
		this.childCount = 0;
	}
}

public class Tries {
	
	private TrieNode root;
	
	public Tries() {
		root = new TrieNode('\0');
	}
	
	private void addHelper(TrieNode root , String word) {
		if(word.length() == 0) {
			root.isTerminal = true;
			return;
		}
		
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.childern[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.childern[childIndex] = child;
			root.childCount++;
		}
		addHelper(child , word.substring(1));
	}
	
	public void add(String word){
		addHelper(root , word);
	}
	
	private boolean searchHelper(TrieNode root , String word){
		if(word.length() == 0){
			// root.isTerminating = true;
			return root.isTerminal;
		}
		int childIndex =word.charAt(0) - 'A';
		TrieNode child = root.childern[childIndex] ;
		if(child != null){
			return searchHelper(child , word.substring(1));
		} 
		return false;
	}
	
	public boolean search(String word) {
		
		return searchHelper(root , word);
	}
	
	private void removeHelper(TrieNode root, String word) {
		if(word.length() == 0) {
			root.isTerminal = false;
			return;
		}
		
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.childern[childIndex];
		if(child != null) {
			removeHelper(child , word.substring(1));
			if(!child.isTerminal && child.childCount == 0) {
				child.childern[childIndex] = null;
				root.childCount--;
			}
		}
		
		return;
		
	}
	
	public void remove(String word) {
		
		removeHelper(root,word);
	}
	
	
	

}
