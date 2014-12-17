
public class LinkList<Type> implements Testable {

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
			System.out.print(node.item + ">");
			node = node.next;
		}
		System.out.println();
	}

	/**
	 * 加到链表的头部
	 * @param c
	 */
	public void Add2Head(Type c) {
		Node newHead = new Node(c);
		newHead.next = head;
		head = newHead;
	}
	
	/**
	 * 加到链表的尾部
	 * @param c
	 */
	public void Add(Type c) {
		Node newTail = new Node(c);
		Node findTail = head;
		while(findTail.next != null) findTail = findTail.next;
		findTail.next = newTail;
	}
	
	/**
	 * 插入链表的任意位置，包括头部和尾部
	 * @param c 新节点值
	 * @param idx 插入索引
	 * @throws Exception 若索引超出范围
	 */
	public void Insert(Type c, int idx) throws Exception {
		assert(idx >= 0);
		// 若idx=0，则直接调用Add2Head函数插入到头部
		if(idx == 0) {
			Add2Head(c);
			return;
		}
		Node newNode = new Node(c);
		Node findIdxNode = head;
		for(int i = 0; i < idx; i++){
			findIdxNode = findIdxNode.next;
			if(findIdxNode == null){
				throw new Exception("The insert index must be smaller than the index of link list");
			}
		}
		Node afterIdxNode = findIdxNode.next;
		findIdxNode.next = newNode;
		newNode.next = afterIdxNode;
	}

	/**
	 * 移除指定索引的元素
	 * @param idx
	 * @throws Exception
	 */
	public void RemoveAt(int idx) throws Exception {
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
				if(findIdxNode == null){
					throw new Exception("The remove index must be smaller than the index of link list");
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

	@Override
	public void Test() {
		LinkList l = new LinkList();
		l.CreateLinkList(10);
		System.out.println("The linked list is:");
		l.PrintLinkList();
		l.Add("I shall be in the tail");
		l.PrintLinkList();
		l.Add2Head("I shall be in the head");
		l.PrintLinkList();
		try {
			l.Insert(888, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		l.PrintLinkList();
		l.Remove();
		l.PrintLinkList();
		try {
			l.RemoveAt(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		l.PrintLinkList();
		try {
			l.RemoveAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		l.PrintLinkList();
	}
}
