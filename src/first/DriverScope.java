package first;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*class Student{  
	  int rollno;  
	  String name;  
	  int age;  
	  Student(int rollno,String name,int age){  
	   this.rollno=rollno;  
	   this.name=name;  
	   this.age=age;  
	  }  
	}  
*/
/*
import java.util.*;  
class Book {  
int id;  
String name,author,publisher;  
int quantity;  
public Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
} 
*/

class Book implements Comparable<Book> {    
	int id;    
	String name,author,publisher;    
	int quantity;    
	public Book(int id, String name, String author, String publisher, int quantity) {    
	    this.id = id;    
	    this.name = name;    
	    this.author = author;    
	    this.publisher = publisher;    
	    this.quantity = quantity;    
	}   
	//implementing the abstract method  
	public int compareTo(Book b) {    
	    return b.name.compareTo(name);
	}
	
	
}

/*class NameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Book b1=(Book)o1;
		Book b2=(Book)o2;
		
		return b1.name.compareTo(b2.name);
	}

	
} 

*/


public class DriverScope {
 //public static TreeMap<Integer,Book> map=new TreeMap<Integer,Book>(); 
//	 static HashMap<Integer,Book> map=new HashMap<Integer,Book>(); 
	static WeakHashMap<Integer,String> map=new WeakHashMap<Integer,String>();          
	public static void main(String[] args) {
		
		
	     map.put(110,"Amit");    
	     map.put(232,"Ravi");   
	     map.put(121,"Vijay"); 
	     map.put(121,"Vijay"); 
	     map.put(153,"Rahul"); 
	     map.put(153,"Sanjay"); 
//	     map.put(null,"Sanj");
//	     map.put(188,null);
	     map.put(200, "");
//	     map.put(null,null);
//	     map.put(194,null);
//	     System.out.println("Initial Map: "+map);  
	     //Inserts, as the specified pair is unique  
	     map.putIfAbsent(104,"Gaurav");  
//	     System.out.println("Updated Map: "+map);  
	     //Returns the current value, as the specified pair already exist  
	     map.put(105,"Amit");
//	     map.put(105,"jay");
//	     map.put(107,null);
//	     map.put(106,null); 
         map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(map->{
        	 int key=map.getKey();
        	 String s=map.getValue();
        	 
        	 System.out.println(key+" "+s);
        	 
         });}}
//	     System.out.println("Updated Map: "+map);  }}
	     
		 /*  ConcurrentLinkedQueue<Integer> queue = new LinkedList<Integer>();  
//	       List<Integer> list = new ArrayList<Integer>();  
	       queue.add(11);  
	       queue.add(100);  
	       queue.add(122);  
	       queue.add(102);  
	       queue.add(112); 
	       queue.add(112);
//	       queue.add(null);
	       System.out.println(queue);
	       System.out.println(Collections.max(queue));
	       System.out.println(Collections.min(queue));
	       ArrayList al=new ArrayList(queue);
	       System.out.print(Collections.sort(al));
	}}

	
		
		//priority queue does not allow for null but allows for duplicates value
		//Elements are stored according to their priority and it does not follow insertion order or linear sorted order
		//While deleting items from pq it will delete the least priority item because the items are stored with ascending order of priority
		//While accessing the element from the queue using element method or peek method we always get the head of the queue that is first item of the queue which has the least priority because this is the first item stored in the list
		//Dequeue is double ended queue if we use poll or pollfirst(similaraly getfirst and getlast methods are also present) it will remove the first element form the queue and work like queue that is Fifo and when we use polllast method to remove the element then it will work like stack that is lifo
		//Dequeue does not allow for null and allows for duplicates
		//It manitains the insertion order
		//As deque is queue when we use element method then it will give us the first element
		//When we implement queue or deque as linked list in that case it will allow null as well
		//We can use List as as list,queue or Stack in case of stack we can use it's method like push , pull and also in that case we have to use Linkedlist only we can't use list
		//There are methods that linked list provides like pollFirst,pollLast,getFirst, getLast so in that case it can work like both the queue and stack 
        //Queue is not getting sorted using comparable interface and comparator option is not available for it , List can be sorted  using Collection.sort(list), for reverse order Collections.sort(list,Collections.reverseOrder()) or if the data is other than wrapper classes or String,String buffer then we have to use comparator , Comparable does not work for list, For TreeSet if the data is other than wrapper classes, String or String buffer then only sorting is required which can be done using Comparable or Comparator interface or else it maintains the natural sorting order  
		//Hashmap allows duplicate values but duplicate keys are not allowed if we add duplicate key then it will update the content with the latest value, Also one null key and multiple null values are allowed and it does not maintain the order
		//LinkedHashmap is same as above but it maintains the insertion order
		// map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		// map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
		//map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
		//map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		//Hashset and linkedhashset can be sorted by converting to list and then using Collections.sort(al); or Collections.sort(al,Collections.reverseOrder()) but it does not work for user defined objects even if we implement comparable interface or use comparator;
		//Hashset and linkedhashset both dont allow duplicates and allow one null value, insertion order is not preserved in hashset but preserved in linkedhashset
		//List can be sorted using Collections.sort(al); Collections.sort(al,Collections.reverseOrder()); if the elements are of wrapper type or String or String buffer but for user defined objects we have to implement comparable interface and then use Collections.sort(al); Collections.sort(al,Collections.reverseOrder()) or we can use comparator Collections.sort(set, new NameComparator());
		//HashTable null keys and values and duplicate keys are not allowed but duplicate values are allowed
		// HashMap allows one null key and multiple null values. vs	Hashtable doesn't allow any null key or value.
		//HashMap is non synchronized vs Hashtable is  synchronized
		
		/*
		
			    //Creating Books  
			    Book b1=new Book(103,"Let us C","Yashwant Kanetkar","BPB",8);  
			    Book b2=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
			    Book b3=new Book(102,"Operating System","Galvin","Wiley",6);  
			    //Adding Books to HashSet  
			    map.put(31,b1);  
			    map.put(53,b2);  
			    map.put(44,b3);
			    map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(map->{
			    	//if we change comparingByKey(Comparator.reverseOrder()) this will sort the keys in reverse	    	
				    int key=map.getKey();
				   Book b= map.getValue();
				   System.out.println	(key +" "+b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
				    }
				    
				   );

			   
			   
			    }}

		
	/*	TreeSet<String> list=new TreeSet<String>();//Creating arraylist  
         list.add("Ravi");//Adding object in arraylist  
         list.add("Vijay");  
         list.add("Ravi");  
         list.add("Ajay");  
         list.add("Ajay");
 //       list.add(null);
//         list.add(null);
//         Collections.sort(list);
         System.out.println("Traversing list through List Iterator:");  
         //Here, element iterates in reverse order  
 /*           ListIterator<String> list1=list.listIterator(list.size());  
            while(list1.hasPrevious())  
            {  
                String str=list1.previous();  
                System.out.println(str);  
            }  
            System.out.println("Traversing list through for each:");  
            for(String s:list) {
            	System.out.println(s);
            }
            System.out.println("Traversing list through iterator:");  
            Iterator itr1=list.iterator();
            while(itr1.hasNext()) {
            	System.out.println(itr1.next());
           }
            
       /*     
      System.out.println("Traversing list through for loop:");  
         for(int i=0;i<list.size();i++)  
         {  
          System.out.println(list.get(i));     
         } 
            
      System.out.println("Traversing list through forEach() method:");  
      //The forEach() method is a new feature, introduced in Java 8.  
          list.forEach(a->{ //Here, we are using lambda expression  
              System.out.println(a);  
            });  
              
          System.out.println("Traversing list through forEachRemaining() method:");  
            Iterator<String> itr=list.iterator();  
            itr.forEachRemaining(a-> //Here, we are using lambda expression  
            {  
          System.out.println(a);  
            });  
	}}
		      
	/*	        Queue<Integer> list = new PriorityQueue<Integer>();  
		        list.add(46);  
		        list.add(67);  
		        list.add(24);  
		        list.add(16);  
		        list.add(8);  
		        list.add(12);  
		        System.out.println(Collections.sort(list));
		        System.out.println("Value of maximum element from the collection: "+Collections.max(list));  
		        System.out.println("Value of minimum element from the collection: "+Collections.min(list));  
		    }  
		}  
		             
		
	/*	Hashtable<Integer,String> map=new Hashtable<Integer,String>();          
		     map.put(110,"Amit");    
		     map.put(232,"Ravi");   
		     map.put(121,"Vijay");    
		     map.put(153,"Rahul");    
		     System.out.println("Initial Map: "+map);  
		     //Inserts, as the specified pair is unique  
		     map.putIfAbsent(104,"Gaurav");  
		     System.out.println("Updated Map: "+map);  
		     //Returns the current value, as the specified pair already exist  
		     map.put(105,"Vijay");
		     map.put(105,"Jay");
//		     map.put(106,null); 
             map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	}}
//		     System.out.println("Updated Map: "+map);  
	
/*	Map map=new LinkedHashMap();  
	    //Adding elements to map  
	    map.put(13,"Amit");  
	    map.put(23,"Rahul");  
	    map.put(31,"Jai");  
	    map.put(21,"Amit");  
	    //Traversing Map  
	    Set set=map.entrySet();//Converting to Set so that we can traverse  
	    Iterator itr=set.iterator();  
	    while(itr.hasNext()){  
	        //Converting to Map.Entry so that we can get key and value separately  
	        Map.Entry entry=(Map.Entry)itr.next();  
	        System.out.println(entry.getKey()+" "+entry.getValue());  
	    }  */
		
		/*        TreeMap<Integer,String> vec = new TreeMap<Integer,String>();  
			          //Adding elements to a vector  
		          vec.put(1,"Tiger");  
		          vec.put(1,"Cat");  
			          vec.put(2,"Lion");  
			          vec.put(3,"Dog");  
			          vec.put(4,"Elephant");  
			          vec.put(7,"Elephant");
			         
	//		          System.out.println(vec.descendingMap());
			          vec.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
//			          vec.put(5, null);
	//		          vec.put(6, null);
			          //Check size and capacity  
//		          System.out.println("Size is: "+vec.size());  
//		          System.out.println("Default capacity is: "+vec.);  
			          //Display Vector elements  
//			          System.out.println("Vector element is: "+vec); 
			          System.out.println(vec.descendingMap());
			          vec.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
	}}
	
//			          System.out.println("Vector element is: "+vec); 
/*			          for(Map.Entry m:vec.entrySet())  
			          {  
			              System.out.println(m.getKey()+" "+m.getValue());      
			          }  
	}}
/*			          vec.add("Rat");  
			          vec.add("Cat");  
			          vec.add("Deer");  
			          vec.add("Snake");  
			          vec.add("Parrot");  
			          vec.add("Parrot");  
//			          vec.add(null);
			          //Again check size and capacity after two insertions  
			          System.out.println("Size after addition: "+vec.size());  
			          System.out.println("Vector element is: "+vec);  
//			          System.out.println("Capacity after addition is: "+vec.capacity());  

*/		
	    
	    //Creating Books 
		
/*	    Book b1=new Book(103,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Book b2=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    Book b3=new Book(102,"Operating System","Galvin","Wiley",6);  
	    //Adding Books to HashSet  
	    map.put(31,b1);  
	    map.put(53,b2);  
	    map.put(44,b3);
	  
	    map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(map->{
	    	//	    	printval();});
	    int key=map.getKey();
	   Book b= map.getValue();
	   System.out.println	(key +" "+b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
	    }
	    
	   );
	   
	}
	
	 
}
	    
//	    System.out.println(set.pop().id);
//	    ArrayList<Book> al= new ArrayList<Book>(set);
//    Collections.sort(al);
//	    Collections.sort(al,new NameComparator());
/*	    for(Book b:map) {
		    System.out.println(b.id+" "+b.author+" "+b.name+" "+b.publisher+" "+b.quantity);
		    }
			
	    
/*    Iterator i=set.descendingIterator();
	    while(i.hasNext()) {
	    	Book b=(Book)i.next();
	    	System.out.println(b.id+" "+b.author+" "+b.name+" "+b.publisher+" "+b.quantity);
	    }*/
	    
	    
		
		
		/*LinkedHashSet<String> set=new LinkedHashSet();  
        set.add("One");    
        set.add("Two");    
        set.add("Three");   
        set.add("Four");  
        set.add("Five"); 
 //       set.add(null);
      ArrayList al=new ArrayList(set);
      Collections.sort(al,Collections.reverseOrder());
        Iterator<String> i=al.iterator();  
        while(i.hasNext())  
        {  
        System.out.println(i.next());  
        } Collections.sort(al);
		*/
		
/*		TreeSet<Book> set=new TreeSet<Book>(new NameComparator());  
	    //Creating Books  
	    Book b1=new Book(103,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Book b2=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    Book b3=new Book(102,"Operating System","Galvin","Wiley",6);  
	    //Adding Books to HashSet  
	    set.add(b1);  
	    set.add(b2);  
	    set.add(b3);
//	    ArrayList<Book> al=new ArrayList<Book>(set);
 //   Collections.sort(set,new NameComparator());
//	    Collections.sort(set, Collections.reverseOrder());
	    //Traversing HashSet  
	    for(Book b:set){  
	    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	    }  }} */
		
/*		Map<Integer,Book> map=new TreeMap<Integer,Book>();    
	    //Creating Books    
	    Book b1=new Book(102,"Let us C","Yashwant Kanetkar","BPB",8);    
	    Book b2=new Book(103,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
	    Book b3=new Book(101,"Operating System","Galvin","Wiley",6);    
	    //Adding Books to map   
	    map.put(3,b1);  
	    map.put(1,b2);  
	    map.put(2,b3);  
	    map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())); 
	    //Traversing map  
	  for(Map.Entry<Integer, Book> entry:map.entrySet()){    
	        int key=entry.getKey();  
	        Book b=entry.getValue();  
	        System.out.println(key+" Details:");  
	        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
	    } }}
		
		
		/*List<Book> set=new LinkedList<Book>();    
	    //Creating Books    
	    Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);    
	    Book b2=new Book(233,"Operating System","Galvin","Wiley",6);    
	    Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
	    //Adding Books to TreeSet    
	    set.add(b1);    
	    set.add(b2);    
	    set.add(b3);  
//	   Collections.sort(set,new NameComparator());
	    //Traversing TreeSet    
	    for(Book b:set){    
	    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);    
	    }   */ 
		
		/*Map<Integer,String> map=new LinkedHashMap<Integer,String>();  
		  map.put(100,"Amit");  
		  map.put(101,"Vijay"); 
		  map.put(103,"Reyansh");  
		  map.put(102,"Rahul");  
		 
		  map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		  //Elements can traverse in any order  
		/*  for(Map.Entry m:map.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  */
		//  System.out.println(map);
		 
		
	/*	LinkedList<String> deque=new LinkedList<String>();  
	    deque.add("Arvind");  
	    deque.add("Vimal");  
	    deque.add("Mukul");  
	    deque.add("Amit");  
//	    deque.add(null); 
	    deque.push("Hitesh");
//	    deque.offerFirst("jai");  
	    System.out.println("After offerFirst Traversal...");  
	    Collections.sort(deque,Collections.reverseOrder());
	    for(String s:deque){  
	        System.out.println(s);  
	    }  
	    
	    System.out.println(deque.get(0));
	    //deque.poll();  
	    //deque.pollFirst();//it is same as poll()  
	    System.out.println(deque.remove(deque.size()-1));  
	    deque.pollFirst();
	    deque.pollLast();
	    deque.peekFirst();
	    deque.peekLast();
	    System.out.println("After pollLast() Traversal...");  
	    for(String s:deque){  
	        System.out.println(s);  
	    }  
	} */
	
		
	/*	Deque<String> deque=new PriorityQueue<String>();  
		    deque.add("arvind");  
		    deque.add("vimal");  
		    deque.add("mukul");  
		    deque.add("Amit");  
//		    deque.add(null);  
//		    deque.offerFirst("jai");  
		    System.out.println("After offerFirst Traversal...");  
		    for(String s:deque){  
		        System.out.println(s);  
		    }  
		    
		    System.out.println(deque.element());
		    //deque.poll();  
//		    deque.pollFirst();//it is same as poll()  
//		    deque.pollLast();  
		    System.out.println("After pollLast() Traversal...");  
		    for(String s:deque){  
		        System.out.println(s);  
		    }  */
		
	
	
		
		
	/*	PriorityQueue<String> q=new PriorityQueue<String>();  
		q.add("Rahul");
		q.add("Vijay");  
		q.add("Karan");  
		q.add("Jai"); 
		q.add("Amit"); 
//		queue.add("Amit"); 
//		queue.add(null); 
		System.out.println("head:"+q.element());  
		System.out.println("head:"+q.peek());  
		System.out.println("iterating the queue elements:");  
		Collections.sort(q);
		Collections.sort(q,new NameComparator());
		Iterator itr=q.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		q.remove();  
		q.poll();  
		System.out.println("after removing two elements:");  
		Iterator<String> itr2=q.iterator();  
		while(itr2.hasNext()){  
		System.out.println(itr2.next());  
		}  
		
		
		   /* ArrayList<Book> set=new ArrayList<Book>();  
		    //Creating Books  
		    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
		    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
		    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
		    //Adding Books to HashSet  
		    set.add(b1);  
		    set.add(b2);  
		    set.add(b3);  
		    //Traversing HashSet  
		  /*  for(Book b:set){  
		    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
		    }  
		    
		    System.out.println(set.toString());
		}  
	
	*/

		/*  List<String> fruitList = new ArrayList<>();    
		 fruitList.add("Mango");    
		 fruitList.add("Banana");    
		 fruitList.add("Apple");    
		 fruitList.add("Strawberry"); 
		 fruitList.add("null"); 
		 fruitList.add("null"); 
		 //Converting ArrayList to Array  
		 String[] array = fruitList.toArray(new String[fruitList.size()]);    
		 System.out.println("Printing Array: "+Arrays.toString(array));  
		 System.out.println("Printing List: "+fruitList);  
		 
		 fruitList.set(1, "dates");
		 System.out.println("Printing List: "+fruitList);  
		 fruitList.add(1, "Grapes");
		 System.out.println("Printing List: "+fruitList);  
		 
		 Collections.sort(fruitList);
		 
		 
		 System.out.println("Printing List: "+fruitList);  
		 
		 HashSet<String> set=new HashSet<String>(fruitList);
		 
		 set.add("null");
		 System.out.println("Printing Set: "+set);  
		/* List<Integer> digi = new ArrayList<>();    
		 digi.add(23);    
		 digi.add(31);  
		 digi.add(13);  
		 digi.add(21);  
		 //Converting ArrayList to Array  
		 int[] digi1 = digi.toArray();
		 System.out.println("Printing Array: "+Arrays.toString(array));  
		 System.out.println("Printing List: "+fruitList);  
		
		/*int[] array={1,2,3,4,5};
		System.out.println("Printing Array: "+Arrays.toString(array));
		//Converting Array to List
		System.out.println(array);
		List<int[]> list=Arrays.asList(array);
		System.out.println(list);
		
		String[] strarray={"Java","Ruby","Python"};
		System.out.println("Printing Array: "+Arrays.toString(strarray));
		//Converting Array to List
		System.out.println(array);
		List<String> strlist=Arrays.asList(strarray);
		System.out.println(strlist);*/
		
		/*ArrayList<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");  
		  ArrayList<String> al2=new ArrayList<String>();  
		  al2.add("Ravi");  
		  al2.add("Hanumat");  
		  al.retainAll(al2);  
		  System.out.println("iterating the elements after retaining the elements of al2");  
		  Iterator itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  */
		
		/*ArrayList<String> al=new ArrayList<String>();  
        System.out.println("Initial list of elements: "+al);  
        //Adding elements to the end of the list  
        al.add("Ravi");  
        al.add("Vijay");  
        al.add("Ajay");  
        System.out.println("After invoking add(E e) method: "+al);  
        //Adding an element at the specific position  
        al.add(1, "Gaurav");  
        System.out.println("After invoking add(int index, E element) method: "+al);  
        ArrayList<String> al2=new ArrayList<String>();  
        al2.add("Sonoo");  
        al2.add("Hanumat");  
        //Adding second list elements to the first list  
        al.addAll(al2);  
        System.out.println("After invoking addAll(Collection<? extends E> c) method: "+al);  
        ArrayList<String> al3=new ArrayList<String>();  
        al3.add("John");  
        al3.add("Rahul");  
        //Adding second list elements to the first list at specific position  
        al.addAll(1, al3);  
        System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: "+al);  */
          
			 
			  //Creating user-defined class objects  
			 /* Student s1=new Student(101,"Sonoo",23);  
			  Student s2=new Student(102,"Ravi",21);  
			  Student s3=new Student(103,"Hanumat",25);  
			  //creating arraylist  
			  ArrayList<Student> al=new ArrayList<Student>();  
			  al.add(s1);//adding Student class object  
			  al.add(s2);  
			  al.add(s3);  
			  //Getting Iterator  
			  Iterator<Student> itr=al.iterator();  
			  //traversing elements of ArrayList object  
			  while(itr.hasNext()){  
			    Student st=itr.next();  
			    System.out.println(st.rollno+" "+st.name+" "+st.age);  
			  }  
			 }  
			
		
		
	  /*  {  
	        String s1 = new String("this is javatpoint");  
	        String s2=new String();
	        for(int i=s1.length()-1;i>=0;i--)  {
	        	char ch=s1.charAt(i);
	            s2=s2+s2.valueOf(ch);
	        }
	
	            System.out.println(s2);//Displays result  
	            if(s1.equalsIgnoreCase(s2)) {
	            System.out.println("String is palindrome");
	    } 
	            
	            String s3 = new String("this is javatpoint"); 
	            String[] s4;
	            s4= s3.split(" ");
	            
	    
	    }*/
	    
		
	/*	int [] a= {1,2,3,4,5,6,7,8,9,10};
		List<int[]> al=Arrays.asList(a);
		System.out.println(a.toString());
		ArrayList b=new ArrayList();
		b.addAll(al);
		System.out.println(b);
				ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement miniDriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(miniDriver.findElements(By.tagName("a")).size());
		WebElement footerdriver=miniDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
        for(int i=1;i<footerdriver.findElements(By.tagName("a")).size();i++) {
        	String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
        	footerdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
        }
        Set<String> windows=driver.getWindowHandles();
       for(String id:windows) {
       	System.out.println(driver.switchTo().window(id).getTitle());
        	
        } 
        for(int i=0;i<windows.size();i++) {
       	System.out.println(driver.switchTo().window("windows(i)").getTitle());
        	System.out.println(driver.switchTo().window(windows(i)).getTitle());
        }
		
		 
         
         */
		
		
         
         
//	}}


