package structures;

import java.util.ArrayList;

public class Node<T> {

	private int level;
	private T info;
	private Node<T> father;
	private ArrayList<Node<T>> listNodes;
	
	public Node(T info, int level){
		this.info = info;
		this.level = level;
		this.listNodes = new ArrayList<>();
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public ArrayList<Node<T>> getListNodes() {
		return listNodes;
	}

	public void setListNodes(ArrayList<Node<T>> listNodes) {
		this.listNodes = listNodes;
	}
	
	public T getInformation() {
		return info;
	}
	
	public Node<T> getFather() {
		return father;
	}
	
	public int getLevel() {
		return level;
	}
}