class Node {
	
	int data;
	Node next;

	Node(int data, Node node){
		this.data = data;
		this.next  = node;
	}

}





public class App{	

	public static void main(String[] args){
		int[] arr = {15,11,2,3,4};
		Node head = convertArrToLL(arr);
		traverseLinkedList(head);

		System.out.println("the lenght of the linked list is -> "+lengthOfLL(head));
		System.out.println("is the element 3 present in the LL -> "+searchInLL(head, 3));
		

		//System.out.println("below is LL after deleting element with 3 as value");
		//deleteElementInLL(head, 3);

		System.out.println("below is LL after deleting  the 3rd element");
		traverseLinkedList(deleteKthElement(head, 3));

		System.out.println("deleting head, below is the new LL");
		head = deleteHead(head);
		traverseLinkedList(head);


		System.out.println("deleting tail, below is the new LL");
		head = deleteTail(head);
		traverseLinkedList(head);

		System.out.println("inserting 55 at 2nd position, below is the new LL");
		traverseLinkedList(insertAtlKthPosOfLL(head, 2, 55));

		System.out.println("inserting 55 at 2nd position, below is the new LL");
		traverseLinkedList(insertAtlKthPosOfLL(head, 9, 55));

		System.out.println("inserting 33 at 2nd position, below is the new LL");
		traverseLinkedList(insertAtlKthPosOfLL(head, 2, 33));

		System.out.println("inserting 44 before 33 value element, below is the new LL");
		traverseLinkedList(insertElementBeforeAValueElement(head, 33, 44));

		System.out.println("inserting 100 before 55 value element, below is the new LL");
		traverseLinkedList(insertElementBeforeAValueElement(head, 55, 100));

		


	}

	public static Node convertArrToLL(int[] arr){
		Node head = new Node(arr[0],null);
		Node temp = head;
		for(int i=1; i<arr.length; i++){

			Node n = new Node(arr[i],null);
			temp.next = n;
			temp = n;
		}

		return head;
	}

	public static void traverseLinkedList(Node head){
		Node n = head;

		while(n != null){
			if(n.next == null){
				System.out.print(n.data);
			} else{
				System.out.print(n.data+" -> ");
			}
			
			
			n = n.next;
			
		} 
		System.out.println();
	}

	public static int lengthOfLL(Node head){
		Node temp = head;
		int counter = 0;
		while(temp != null){
			temp = temp.next;
			counter++;
		}
		return counter;

	}

	public static boolean searchInLL(Node head, int val){
		Node temp = head;
		boolean isPresent = false;
		while(temp != null){
			if(temp.data == val){
				isPresent = true;
				break;
			}

			temp = temp.next;
		}

		return isPresent;
	}

	public static void deleteElementInLL(Node head, int val){
		Node temp = head;
		Node prev = null;

		if(temp.data == val){
			head =  temp.next;
		}
		if(temp != null){
				
		

		while(temp != null){
			if(temp.data == val){
				prev.next = temp.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}

		traverseLinkedList(head);

		}

	}

	public static Node deleteHead(Node head){
		Node temp = head;
		if(temp == null){
			return temp;
		}
		return temp.next;
	}

	public static Node insertHead(Node head, int data){
		Node temp = head;
		return new Node(data, temp);
	}

	public static Node deleteTail(Node head){
		Node temp = head;
		
		 if(temp == null || temp.next == null){
		 	return null;
		 }

		while(temp.next.next != null){
			temp = temp.next;
		}

		temp.next = null;

		return head;
	}

	public static Node insertTail(Node head, int data){
		Node temp = head;
		
		while(temp.next != null){
			temp = temp.next;
		}

		temp.next = new Node(data, null);
		return head;
	}


	public static Node deleteKthElement(Node head, int pos){
		Node temp = head;
		Node prev = null;
		int counter = 0;


		if(pos == 1){
			return temp.next;
		}
		if(temp == null){
			return head;	
		}

		while(temp != null){
			++counter;

			if(counter == pos){
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}

		return head;
	}

	public static Node insertAtlKthPosOfLL(Node head, int k, int val){
		Node temp = head;
		int counter = 0;
		boolean isValidPos = false;
		
		if(k==1){
			Node newHead = new Node(val, head);
			return newHead;
		}

		if(temp == null && k == 1){
			return new Node(val, null);
		}	

		while(temp != null){
			++counter;

			if(k-1 == counter){
				temp.next = new Node(val,temp.next); 
				isValidPos = true;
				break;
			}
			
			temp = temp.next;
		}	

		if(!isValidPos){
			System.out.println("Position not valid, will return original LL");
		}
		
		
		return head;

	}


	public static Node insertElementBeforeAValueElement(Node head, int targetValue, int value){

		Node temp = head;
		
		boolean isValidValue = false;

		if(temp == null){
			return head;
		}

		if(temp.next == null){
			if(temp.data == targetValue){
				return new Node(value, temp);
			} else{
				System.out.println("value "+targetValue+" not available in the LL, returning original LL");
			}	
		}

		if(temp.data == targetValue){
			return new Node(value, temp);
		}

		while(temp.next != null){

			if(temp.next.data == targetValue){
				isValidValue = true;
				temp.next = new Node(value, temp.next);
				break;
			}
			
			temp = temp.next;
		}

		if(!isValidValue){
			System.out.println("value "+targetValue+" not available in the LL, returning original LL");

		}

		return head;

	}
}