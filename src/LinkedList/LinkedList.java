package LinkedList;

import java.util.NoSuchElementException;

class Node {
	int val = 0;
	Node next;

	@Override
	public String toString() {
		return "Node [val=" + val + ", next=" + next + "]";
	}
}

class Linked {
	public Node getNewNode(int val, Node node) {
		Node a = new Node();
		a.val = val;
		a.next = null;
		return a;
	}

	public Node add(int val, Node node) {
		if (node == null) {
			return getNewNode(val, node);
		} else {
			node.next = add(val, node.next);
		}
		return node;
	}

	public int getFirst(Node node) {
		if (node == null) {
			throw new NoSuchElementException();
		} else
			return node.val;
	}

	public int getLast(Node node) {
		if (node.next == null) {
			return node.val;
		} else {
			return getLast(node.next);
		}
	}

	public Node removeFirst(Node node) {
		if (node == null) {
			throw new NoSuchElementException();
		} else {
			return node = node.next;
		}
	}

	public Node removeLast(Node node) {
		if (node.next == null) {
			return node.next = null;
		} else {
			node.next = removeLast(node.next);
		}
		return node;
	}

	public Node addFirst(int val, Node node) {
		Node newNode = new Node();
		newNode.val = val;
		newNode.next = node;
		return newNode;
	}

	public Node addLast(int val, Node node) {
		return add(val, node);
	}

	public boolean contains(int val, Node node) {
		if (node.val == val) {
			return true;
		} else {
			if (node.next == null) {
				return false;
			} else {
				return contains(val, node.next);
			}
		}
	}

	int listSize = 0;

	public int size(Node node) {
		if (node.next == null) {
			int finalSize = listSize++;
			listSize = 0;
			return finalSize;
		} else {
			listSize++;
			return size(node.next);
		}
	}

	int getIndex = 0;

	public int get(int index, Node node) {
		if (node.next == null) {
			return -1;
		} else {
			if (getIndex == index) {
				getIndex = 0;
				return node.val;
			} else {
				getIndex++;
				return get(index, node.next);
			}
		}
	}

	int setIndex = 0;

	public Node set(int indexOf, int with, Node node) {
		if (setIndex == indexOf) {
			node.val = with;
		} else {
			setIndex++;
			node.next = set(indexOf, with, node.next);
		}
		setIndex = 0;
		return node;
	}

	int removeIndex = 0;

	public Node remove(int index, Node node) {
		if (removeIndex == index) {
			node = node.next;
		} else {
			removeIndex++;
			node.next = remove(index, node.next);
		}
		removeIndex = 0;
		return node;
	}

	int indexOfIndex = 0;

	public int indexOf(int index, Node node) {
		if (indexOfIndex == index) {
			indexOfIndex = 0;
			return node.val;
		} else {
			indexOfIndex++;
			return indexOf(index, node.next);
		}
	}
	
	public int[] toArray(Node node) {
		int size = size(node);
		int[] arr = new int[size+1];
		for(int i = 0; node != null; i++ ) {
			arr[i] = node.val;
			node = node.next;
		}
		return arr;
	}
}

public class LinkedList {

	public static void main(String[] args) throws Exception {
		Linked list = new Linked();
		Node node = null;

		node = list.add(10, node);
		node = list.add(20, node);
		node = list.add(30, node);
		node = list.add(40, node);
		node = list.add(50, node);
		node = list.add(60, node);
		node = list.add(70, node);
		node = list.add(80, node);
		node = list.add(90, node);

		// getFirst()
		System.out.println("First element in the list is " + list.getFirst(node));

		// getLast()
		System.out.println("Last element in the list is " + list.getLast(node));

		// removeFirst()
		node = list.removeFirst(node);
		System.out.println("First element removed");

		// removeLast()
		node = list.removeLast(node);
		System.out.println("Last element removed");

		// addFirst()
		node = list.addFirst(1, node);
		System.out.println("First element added");

		// addLast()
		node = list.addLast(999, node);
		System.out.println("Last element added");

		// contains()
		System.out.println(list.contains(999, node));

		// size()
		System.out.println("The size of the list is " + list.size(node));
		System.out.println("The size of the list is " + list.size(node));

		// get()
		System.out.println("The element with index 5 is " + list.get(5, node));

		// set()
		node = list.set(4, 55, node);

		// remove
		node = list.remove(4, node);

		// indexOf()
		System.out.println(list.indexOf(2, node));
		
		//toArray()
		int[] arr = list.toArray(node);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println(node);
	}

}
