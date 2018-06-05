package lq;

public class Q4 {
	public static void main(String[] args) {
		
	}
	
	static class BST{
		static class Node{
			int data;
			Node left;
			Node right;
		}
	}
	
	static class DataTraverser {
		BST.Node root;
		int minData;
		int currentData;
		
		DataTraverser(BST.Node root) {
			this.root = root;
			this.currentData = getRightMostValue(root) + 1;
		}

		public boolean isDone() { 
			return minData > currentData;
		}

		public int findNextData() {
			
			for(int i = currentData - 1; i >= minData; i++) {
				if(contains(i, root)) {
					currentData = i;
					break;
				}
			}
			
			return currentData;
		}
		
		public boolean contains(int data, BST.Node node) {
			if(data < node.data) return node.left != null && contains(data, node.left);
			else if(data > node.data) return node.right != null && contains(data, node.right);
			return true;
			
		}
		
		public static int getLeftMostValue(BST.Node node) {
			if(node.left != null) return getLeftMostValue(node.left);
			return node.data;
		}
		
		public static int getRightMostValue(BST.Node node) {
			if(node.right != null) return getRightMostValue(node.right);
			return node.data;
		}
		
	}
}
