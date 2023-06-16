package datastructure;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries t = new Tries();
		t.add("NOTE");
		t.add("NO");
		System.out.println(t.search("NOTE"));
		System.out.println(t.search("NO"));
		System.out.println(t.search("NTE"));
		t.remove("NOTE");
		System.out.println();
		System.out.println(t.search("NOTE"));
		System.out.println(t.search("NO"));
	}

}
