public class Node<T> {

	public T data;
	public Node<T> Next;

	// Constructor to initialize node details
	public Node(T data) {
		this.data = data;
		Next = null;
	}

}