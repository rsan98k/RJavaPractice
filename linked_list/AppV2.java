import java.util.*;

class BetterNode {
	
	int data;
	BetterNode next;
	BetterNode prev;

	BetterNode(int data, BetterNode next, BetterNode prev){
		this.data = data;
		this.next  = next;
		this.prev = prev;
	}

}

public class AppV2 {
	public static void main(String[] args){
		try{
			int[] arr = {15,11,2,3,4,1,7};
			System.out.print("DLL is -> ");
			BetterNode head = convertArrToDLL(arr);
			traveseDLLOneWay(head);

			System.out.println("Deleting head");
			head = deleteHead(head);
			traveseDLLOneWay(head);

			System.out.println("Deleting tail");
			head = deleteTail(head);
			traveseDLLOneWay(head);

			System.out.println("Deleting 3rd element");
			head = DeleteKthElement(head, 3);
			traveseDLLOneWay(head);

			System.out.println("Deleting element with value as 2");
			head = DeleteByValue(head, 1);
			traveseDLLOneWay(head);

			System.out.println("Inserting element 68 before tail");
			head = insertBeforeTail(head, 68);
			traveseDLLOneWay(head);

			System.out.println("Inserting element before 2nd element");
			head = insertBeforeKthElement(head, 1, 23);
			traveseDLLOneWay(head);

			System.out.println("Inserting element node with data as 11");
			insertBeforeNode(head.next.next, 100);
			traveseDLLOneWay(head);

		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static BetterNode convertArrToDLL(int[] arr){
		BetterNode head = new BetterNode(arr[0], null, null);
		BetterNode temp = head;

		for(int i=1; i<arr.length; i++){
			BetterNode n = new BetterNode(arr[i], null,temp);
			temp.next = n;
			temp = n;
			//System.out.println("Inserting following node with prev data as "+n.prev.data);
		}	

		return head;
	}

	public static void traverseDLL(BetterNode head){
		BetterNode temp = head;
		System.out.println("printing DLL data from start to end");
		while(temp.next != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}

		System.out.print(temp.data+" ");


		System.out.println();

		

		System.out.println("printing DLL data from end to start");

		while(temp.prev != null){
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}

		System.out.print(temp.data+" ");
	}

	public static void traveseDLLOneWay(BetterNode head){
		BetterNode temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static BetterNode deleteHead(BetterNode head){
		BetterNode temp = head;

		if(temp == null || (temp.prev == null && temp.next == null)){
			return null;
		}

		BetterNode newHead = temp.next;
		temp.next = null;
		newHead.prev = null;
		return newHead;
	}


	public static BetterNode deleteTail(BetterNode head){
		BetterNode temp = head;

		if(temp == null || (temp.prev == null && temp.next == null)){
			return null;
		}

		//loop ends at new tail i.e. second last element from the start
		while(temp.next.next != null){
			temp = temp.next;
		}

		//current tail
		BetterNode currTail = temp.next;
		currTail.prev = null;
		temp.next = null;

		return head;
	}

	public static BetterNode DeleteKthElement(BetterNode head, int k){
		BetterNode temp = head;
		int pos = 0;

		if(temp == null){
			return null;
		}

		while(temp != null){
			pos++;

			if(pos == k){
				break;
			}

			temp = temp.next; 
		}

		BetterNode prevTemp = temp.prev;
		BetterNode nextTemp = temp.next;
		if(prevTemp == null && nextTemp == null){
			return null;
		} else if(prevTemp == null){
			return deleteHead(head);
		} else if(nextTemp == null){
			return deleteTail(head);
		} else {
			prevTemp.next = nextTemp;
			nextTemp.prev = prevTemp;
			temp.next = null;
			temp.prev = null;
			return head;
		}
	}

	public static BetterNode DeleteByValue(BetterNode head, int val){
		BetterNode temp = head;


		if(temp == null){
			return null;
		}

		while(temp != null){
			if(temp.data == val){
				break;
			}	
			temp = temp.next;
		}

		BetterNode prevTemp = temp.prev;
		BetterNode nextTemp = temp.next;
		if(prevTemp == null && nextTemp == null){
			return null;
		} else if(prevTemp == null){
			return deleteHead(head);
		} else if(nextTemp == null){
			return deleteTail(head);
		} else {
			prevTemp.next = nextTemp;
			nextTemp.prev = prevTemp;
			temp.next = null;
			temp.prev = null;
			return head;
		}
	}

	public static BetterNode insertBeforeHead(BetterNode head, int val){
		BetterNode newHead = new BetterNode(val, head, null);
		head.prev = newHead;

		return newHead;

	}

	public static BetterNode insertBeforeTail(BetterNode head, int val){
		BetterNode temp = head;

		while(temp.next != null){
			temp = temp.next;
		}

		BetterNode n = new BetterNode(val, null, null);

		temp.prev.next = n;

		n.prev = temp.prev;
		n.next = temp;

		temp.prev = n;

		return head;

	}

	public static BetterNode insertBeforeKthElement(BetterNode head, int k, int val){
		BetterNode temp = head;
		int pos = 0;


		if(temp == null){
			return null;
		}

		while(temp != null){
			pos++;
			if(pos == k){
				break;
			}	
			temp = temp.next;
		}

		if((temp.prev == null && temp.next == null) || temp.prev == null) {
			return insertBeforeHead(head, val);

		} else if(temp.next == null){
			return insertBeforeTail(head, val);
		}

		BetterNode n = new BetterNode(val, null, null);

		temp.prev.next = n;

		n.next = temp;
		n.prev = temp.prev;

		temp.prev = n;


		return head;
	}

	public static void insertBeforeNode(BetterNode node, int val){

		// if(node.next == null){
		// 	return insertBeforeTail(node, val);
		// }

		BetterNode prevTemp = node.prev;
		BetterNode nodeToInsert = new BetterNode(val, null, null);

		prevTemp.next = nodeToInsert;

		nodeToInsert.prev = node.prev;
		nodeToInsert.next = node;

		node.prev = nodeToInsert;		
		
	}

	public static BetterNode reverseDLL(BetterNode head){
		

	}
}