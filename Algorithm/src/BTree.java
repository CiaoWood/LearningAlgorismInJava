import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BTree implements Testable {

	public BTree() {
	}
	
	public BTree(int v) {
		value = v;
	}
	
	int value = 0;
	BTree left;
	BTree right;
	
	public void Test(){
		TestPrintInorder();
	}
	
	private void TestPrintInorderFromPreorder() {
		// construct a bin search tree;
		//       6
		//     4   8
		//    3 5 7 11
		int[] preorderArr = {6,4,3,5,8,7,11};
		ArrayList<BTree> bTreeArr = GetAllTrees(preorderArr, 0, preorderArr.length - 1);
		for(BTree root : bTreeArr){
			PrintInorder(root);
		}
	}
	
	// test inorder with and without recursion
	public void TestPrintInorder(){
		// construct a bin search tree;
		//       6
		//     4   8
		//    3 5 7 11
		BTree root = new BTree(6);
		root.left = new BTree(4);
		root.right = new BTree(8);
		root.left.left = new BTree(3);
		root.left.right = new BTree(5);
		root.right.left = new BTree(7);
		root.right.right = new BTree(11);
		
		PrintInorder(root);
		System.out.println();
		PrintInorderRecursion(root);
	}
	
	// inorder that doesn't use inorder
	private void PrintInorderRecursion(BTree root) {
		Stack<BTree> stack = new Stack<BTree>();
		BTree current = root;
		
		// only when the current is null and the stack is empty shall we stop the loop
		while(current != null || !stack.isEmpty()){
			if(current != null){
				stack.push(current);
				current = current.left;
			}else{
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.right;
			}
		}
	}

	// inorder using recursion
	private void PrintInorder(BTree root) {
		if(root == null) return;
		PrintInorder(root.left);
		System.out.print(root.value + ">");
		PrintInorder(root.right);
	}

	private ArrayList<BTree> GetAllTrees(int[] inorderArr, int start, int end) {
		ArrayList<BTree> returnTrees = new ArrayList<BTree>();
		return returnTrees;
	}

	public void TestPrintBoundary(){
		// construct a bin search tree;
		//       6
		//     4   8
		//    3 5 7 11
		BTree root = new BTree(6);
		root.left = new BTree(4);
		root.right = new BTree(8);
		//root.left.left = new BTree(3);
		root.left.right = new BTree(5);
		root.right.left = new BTree(7);
		root.right.right = new BTree(11);
		
		PrintBoundary(root);
		
	}
	
	private void PrintBoundary(BTree root) {
		PreorderLeftOnly(root);
		PreorderLeafOnly(root);
		PostorderRightOnly(root);
	}

	private void PostorderRightOnly(BTree root) {
		if(root == null) return;

		
		PostorderRightOnly(root.right);
		//若不判断根节点，则根节点出现2次
		if(root.left != null || root.right != null)
			System.out.print(root.value + ">");
	}

	private void PreorderLeftOnly(BTree root) {
		if(root == null) return;
		else if(root.left != null || root.right != null)
			System.out.print(root.value + ">");
		//如果是左下角的点，忽略它
		PreorderLeftOnly(root.left);
	}

	private void PreorderLeafOnly(BTree root) {
		if(root == null) return;
		
		if(root.left == null && root.right == null)
			System.out.print(root.value + ">");
		
		PreorderLeafOnly(root.left);
		PreorderLeafOnly(root.right);
	}

	public void TestIfBST(){
		// construct a bin search tree;
		//       6
		//     4   8
		//    3 5 7 11
		BTree root = new BTree(6);
		root.left = new BTree(4);
		root.right = new BTree(8);
		root.left.left = new BTree(3);
		root.left.right = new BTree(5);
		root.right.left = new BTree(7);
		root.right.right = new BTree(11);
		
		boolean ifBST = IsBST(root);
		System.out.println("This is a Binary Search Tree?" + ifBST);
	}
	
	public void TestPTL(){
		// construct a bin search tree;
		//       6
		//     4   8
		//    3 5 7 9
		BTree root = new BTree(6);
		root.left = new BTree(4);
		root.right = new BTree(8);
		root.left.left = new BTree(3);
		root.left.right = new BTree(5);
		root.right.left = new BTree(7);
		root.right.right = new BTree(9);
		
		System.out.println("use non-recursive method:");
		PrintTreeLevel(root, 0);
		PrintTreeLevel(root, 1);
		PrintTreeLevel(root, 2);
		PrintTreeLevel(root, 3);
		
		System.out.println();
		System.out.println("use recursive method:");
		PrintTreeLevel(root, 0, 0);
		PrintTreeLevel(root, 0, 1);
		PrintTreeLevel(root, 0, 2);
		PrintTreeLevel(root, 0, 3);
	}
	
	/**
	 *  the header function to judge if the tree is binary search tree
	 * @param tree
	 * @return
	 */
	public boolean IsBST(BTree tree) {
		if(tree == null) return true;
		if(tree.left != null){
			if(tree.left.value >= tree.value) return false;
			if(!IsBST(tree.left)) return false;
		}
		if(tree.right != null){
			if(tree.right.value <= tree.value) return false;
			if(!IsBST(tree.right)) return false;
		}
		return true;
	}
	
	/**
	 * print the level in a btree
	 * @param root
	 * @param level
	 */
	public void PrintTreeLevel(BTree root, int level){
		
		if(root == null || level < 0) return;
		
		Queue<BTree> treeQueue = new LinkedList<BTree>();
		Queue<Integer> levelQueue = new LinkedList<Integer>();
		treeQueue.add(root);
		levelQueue.add(0);
		
		BTree treeTemp = null;
		int levelTemp = 0;
		while(!treeQueue.isEmpty()){
			treeTemp = treeQueue.poll();
			levelTemp = levelQueue.poll();
			if(levelTemp == level){
				System.out.print(treeTemp.value + " ");
			}else{
				if(treeTemp.left != null){
					treeQueue.add(treeTemp.left);
					levelQueue.add(levelTemp+1);
				}
				if(treeTemp.right != null){
					treeQueue.add(treeTemp.right);
					levelQueue.add(levelTemp+1);
				}
			}
		}
	}
	/**
	 * Use recursion to print tree level
	 * @param root
	 * @param currentLevel
	 * @param desire
	 */
	public void PrintTreeLevel(BTree t, int currentLevel, int desire){
		if(t == null || currentLevel > desire) return;
		
		if(currentLevel == desire){
			System.out.print(t.value + "|");
		}else{
			PrintTreeLevel(t.left, currentLevel + 1, desire);
			PrintTreeLevel(t.right, currentLevel + 1, desire);
		}
	}
}
