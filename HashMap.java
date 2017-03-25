package algorithm;

import java.util.*;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class HashMap {
	
	public static final int SIZE = 4513; // size of table
	private static Node table[] = new Node[SIZE];
	
	public static class Node{
		String word;
		int count;
		Node next;
		
		Node(String w){
			word = w;
			count = 1;
			next =null;
		}
		
		public void setValue(int v){
			count += v;
		}
		
		public String getKey(){
			return word;
		}
		
		}
	
	
		public static int hashValue (String word){
			int hvalue=0;
			
			
			for(int i =0; i< word.length();i++){
				hvalue += (i*i)*(int)(word.charAt(i));
			}
			
			hvalue = hvalue % SIZE;
			
			return hvalue;
		}
		
		public static void insert(String word, int value){
			
			int bucket = hashValue(word);
			Node cell = table[bucket];
			
			if(cell == null){
				table[bucket] = new Node(word); 
				return;
			} 
			else{
				Node last = cell;
				while(cell!=null){
					
					if(cell.word.equals(word)){
						cell.setValue(value);
						return;
					}
					
					last = cell;
					cell = cell.next;
					
				}
				
				last.next = new Node(word);
				
			}
			
		}
		
		public static void listKeyValue(){
			  for (Node n: table){
		    	   
		    	   if(n!=null)
		    		   System.out.println();
		    	   
		    	   
		    	   while(n!=null){
		    		   
		    		   System.out.print(n.word + " : " + n.count + " ,");
		    		   n  = n.next;
		    	   }
		    	   
		       }
		       
		}
		
		public static void delete(String w){
			
			int bucket = hashValue(w);
			Node cell = table[bucket];
			
			if(cell == null){
				System.out.println("Not Found");
				return;
			}
			
			if(cell.word.equals(w)){
				table[bucket] = cell.next;
				return;
			}
			else if(cell.next == null){
				System.out.println("Not Found");
				return;
			}
			
			while(cell.next!= null){
				if(cell.next.word.equals(w)){
					cell.next = cell.next.next;
					System.out.println("Deleted");
					return;
				}
				cell = cell.next;
			}
			
			return;
			
		}
		
		
		public static void insertValue(){
			Scanner s = new Scanner(System.in);
			System.out.println("enter word to insert");
			String w = s.next();
			insert(w,1);
		}
		
		public static void deleteValue(){
			Scanner s = new Scanner(System.in);
			System.out.println("enter word to delete");
			String w = s.next();
			delete(w);
		}
		
		
		public static void increaseValue(){
			Scanner s = new Scanner(System.in);
			System.out.println("enter word to increase");
			String w = s.next();


			
			int bucket = hashValue(w);
			Node cell = table[bucket];
			
			if(cell == null){
				table[bucket] = new Node(w); 
				return;
			} 
			else{
				Node last = cell;
				while(cell!=null){
					
					if(cell.word.equals(w)){
						cell.setValue(1);
						return;
					}
					
					last = cell;
					cell = cell.next;
					
				}
				
				last.next = new Node(w);
				
			}
		}
			
			
			
			public static void findValue(){
				Scanner s = new Scanner(System.in);
				System.out.println("enter word to find");
				String w = s.next();


				
				int bucket = hashValue(w);
				Node cell = table[bucket];
				
				if(cell == null){
					table[bucket] = new Node(w); 
					return;
				} 
				else{
					while(cell!=null){
						
						if(cell.word.equals(w)){
							System.out.println("Word: " + cell.word + " Value: "+ cell.count);
							return;
						}
						
						cell = cell.next;
						
					}
					
					System.out.println("Not found");
					
				}
				
				
			
		}
	
	

	public static void main (String args[]) throws Exception {
		
	       System.out.println ("Counting Words");       
	       FileReader fr = new FileReader ("C:\\test.txt");        
	       BufferedReader br = new BufferedReader (fr);     
	       String line = br.readLine ();
	       int count = 0;
	       while (line != null) {
	          String []parts = line.split(" ");
	          for( String w : parts)
	          {
	        	  insert(w, 1);
	        	  count++;
	          }
	          line = br.readLine();
	       }     
	       
	       System.out.println(count);
	       count = 0;
	     
	       
	       int input = 99;
	       Scanner s = new Scanner(System.in);
	       
	       
	       while(input!=9){
	    	   System.out.println("Enter your choice");
	    	   input = s.nextInt(); 
		       switch(input){
		       
		       		case 1: insertValue();
		       			break;
		       		
		       		case 2: listKeyValue();
		       			break;
		       			
		       		case 3: increaseValue();
	       				break;
		       			
		       		case 4: findValue();
       					break;
	       			
		       		case 5: deleteValue();
       					break;
       				
		       		default:
		       			break;
		       }
	       }
	       

	    }
	

	
}

