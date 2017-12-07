package day07;

import java.util.ArrayList;
import java.util.List;

import util.FileIO;

public class Day07 {
	
	private static final String FILENAME = "./resources/Input_Day07.txt";
	private static final String PATTERN = "(?<node>.*)\\s\\((?<weight>\\d*)\\)(?>\\s->\\s)?(?<children>.*)";
	
	private static List<String> data = FileIO.getFileAsList(FILENAME);
	

}

class Node {
	private String fileName;
	private int weight;
	private Node parent;
	private List<Node> children;
	
	private Node() {
	}
	
	public Node(String fileName, int weight){
		this(fileName, weight, null, new ArrayList<Node>());
	}
	
	public Node(String fileName, int weight, Node parent) {
		this(fileName, weight, parent, new ArrayList<Node>());
	}
	
	
	public Node(String fileName, int weight, Node parent, List<Node> children) {
		this.fileName = fileName;
		this.children = children;
		this.parent = parent;
		this.weight = weight;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void addChild(Node node) {
		children.add(node);
	}
	
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public List<Node> getChildren() {
		return children;
	}
	
	public String toString() {
		return String.format("%s (%d)", fileName, weight);
	}
}