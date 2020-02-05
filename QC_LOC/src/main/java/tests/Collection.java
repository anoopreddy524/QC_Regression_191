package tests;
import java.util.*; 
public class Collection {
	

//=====================  Collection Using Vector ====================
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v=new Vector<String>();  
		v.add("Ayush");  
		v.add("Amit");  
		v.add("Ashish");  
		v.add("Garima");  
		Iterator<String> itr=v.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
	}
}
	
	
}*/
//=======================================================================

//=====================  Collection Using LinkedList ====================

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> lt=new LinkedList<String>();  
		lt.add("Ayush");  
		lt.add("Amit");  
		lt.add("Ashish");  
		lt.add("Garima");  
		lt.add("Garima"); 
		Iterator<String> itr=lt.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
	}
}
	
	
}*/
//=======================================================================

//=====================  Collection Using Deque ====================

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> deque=new ArrayDeque<String>();  
		deque.add("Ayush");  
		deque.add("Amit");  
		deque.add("Ashish");  
		deque.add("Garima");
		deque.remove();
		System.out.println("Initial ArrayDeque: " + deque); 
		// Displaying the ArrayDeque after removal 
        System.out.println("ArrayDeque after removing " + "elements: " + deque); 
		
		/*Iterator<String> itr=deque.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
	}*/
}
	
	
}
//=======================================================================
 