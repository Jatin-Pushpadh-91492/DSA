package datastructure;
import java.util.ArrayList;
public class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> childern;
	public TreeNode(T data) {
		this.data = data;
		this.childern = new ArrayList<>();
	}
}
