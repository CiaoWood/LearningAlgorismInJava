import java.util.LinkedList;
import java.util.Queue;


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
		TestIfBST();
		TestPTL();
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
