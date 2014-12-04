
public class LinkList<Type> {

	@SuppressWarnings("hiding")
	private class Node<Type>{
		Type item;
		Node<Type> next;
		
		public Node(Type item) {
			super();
			this.item = item;
			next = null;
		}
		public Node() {
			super();
			item = null;
			next = null;
		}
	}
	
	private Node<Type> head;
	
	public Node<Type> getHead() {
		if(head == null){
			head = new Node<Type>();
		}
		return head;
	}

	public void setHead(Node<Type> head) {
		this.head = head;
	}

	public void CreateLinkList(int length){
		assert(length > 0);
		Node linkNode = this.getHead();
		linkNode.item = 'a';
		for(char i = 'b'; i < 'a' + length; i++){
			linkNode.next = new Node(i);
			linkNode = linkNode.next;
		}
		linkNode = null;
	}
	
	public void PrintLinkList(){
		Node node = head;
		while(node != null){
			System.out.print(node.item + " ");
			node = node.next;
		}
		System.out.println();
	}

	public void Add2Head(Type c) {
		Node newHead = new Node(c);
		newHead.next = head;
		head = newHead;
	}
	
	public void Add(Type c) {
		Node newTail = new Node(c);
		Node findTail = head;
		while(findTail.next != null) findTail = findTail.next;
		findTail.next = newTail;
	}
	
	public void Insert(Type c, int idx) {
		assert(idx >= 0);
		Node newNode = new Node(c);
		Node findIdxNode = head;
		for(int i = 0; i < idx; i++){
			findIdxNode = findIdxNode.next;
			if(findIdxNode.next == null){
				System.out.println("insert index must be smaller than the index of link list");
				return;
			}
		}
		Node afterIdxNode = findIdxNode.next;
		findIdxNode.next = newNode;
		newNode.next = afterIdxNode;
	}

	public void RemoveAt(int idx) {
		assert(idx >= 0);
		Node findIdxNode = head;
		if(idx == 0){
			head = findIdxNode.next;
			findIdxNode = null;
		}else{
			Node preNode = null;
			for(int i = 0; i < idx; i++){
				preNode = findIdxNode;
				findIdxNode = findIdxNode.next;
				if(findIdxNode.next == null){
					System.out.println("insert index must be smaller than the index of link list");
					return;
				}
			}
			preNode.next = findIdxNode.next;
			findIdxNode = null;
		}
		
	}

	public void Remove() {
		Node findTail = head;
		Node preTail = null;
		while(findTail.next != null){
			preTail = findTail;
			findTail = findTail.next;
		}
		preTail.next = null;
	}
}
