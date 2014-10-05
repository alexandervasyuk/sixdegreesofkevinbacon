public class Queue {
	Node head;
	Node tail;

	Queue() {
		head = null;
		tail = null;
	}
	
	public void enqueue(Object o) {
		Node n = new Node(o);
		if (head != null && tail != null) {
			tail.next = n;
			tail = n;
		} else {
			tail = n;
			head = tail;
		}
	}

	public Object dequeue() {
		if (head == null) return null;

		Object item = head.data;
		head = head.next;
		return item;
	}

	public boolean isEmpty() {
		return head == null;
	}
}
