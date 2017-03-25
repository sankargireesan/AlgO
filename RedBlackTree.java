package algorithm;

import java.util.Scanner;

public class RedBlackTree {
	
	public static final String black ="black";
	public static final String red ="red";

	
	public static class Node {
		int key;
		String color;
		Node left;
		Node right;
		Node parent;
		
		Node(int k,String c){
			key = k;
			color = c;
			left=right=parent=null;
		}
	}
	
	
	static Node Nil = new Node(-1, black);
	static Node root = Nil;
	
	
	static void inorderTreeWalk(Node x){
		if(x == Nil)
			return;
		inorderTreeWalk(x.left);
		if(x.parent==Nil)
			System.out.println("  "+x.key+"(root)");
		else
		System.out.println("  "+x.key+" ");
		inorderTreeWalk(x.right);
	}
	
	static Node Min(Node x){
		while(x.left!=Nil){
			x=x.left;
		}
		return x;
	}
	
	static Node Max(Node x){
		while(x.right!=Nil){
			x=x.right;
		}
		return x;
	}
	
	
	static Node Search(Node x,int k){
		 
		if (x==Nil || x.key == k)
			return x;
		if(k < x.key)
			return Search(x.left,k);
		else
			return Search(x.right,k);
	}
	 
	 static Node Successor(Node x){
		 
		 if(x.right != Nil)
			 return Min(x.right);
		 
		 Node y = x.parent;
		 
		 while ( y!= Nil && x==y.right){
			 x =y;
			 y =y.parent;
		 }
		 return y;
	 
	 }
	 
	 static Node Predecessor(Node x){
		 if(x.left!=Nil){
			 return Max(x.left);
		 }
		 
		 Node y = x.parent;
		 while(y!= Nil && x==y.left){
			 x = y;
			 y = y.parent;
		 }
		 return y;
	 }
	
	
	 static void leftRotate(Node T,Node x){

			Node y = x.right;
			x.right=y.left;
			//if(y.left!=Nil)
			y.left.parent=x;
			
			y.parent=x.parent;
			if(x.parent==Nil)
				root=y;
			else if(x == x.parent.left)
				x.parent.left=y;
			else
				x.parent.right=y;
			y.left=x;
			x.parent=y;

	}
	
	
	
	static void rightRotate(Node T, Node x){
		Node y = x.left;
		x.left = y.right;
		//if(y.right!=Nil)
		y.right.parent =x;
		y.parent = x.parent;
		if(x.parent== Nil)
			root = y;
		else if (x == x.parent.left)
			x.parent.left =y;
		else
			x.parent.right =y;
		
		y.right = x;
		x.parent =y;
	}
		
	
	static void insert(Node T,Node z){
		Node y = Nil;
		Node x = root;
		
		while(x!=Nil){
			y=x;
			if(z.key <= x.key)
				x=x.left;
			else
				x=x.right;
		}
			z.parent=y;
			
		if(y==Nil)
			root=z;
		
		else if(z.key<y.key)
			y.left=z;
		else
			y.right=z;
		
		z.left = Nil;
		z.right =Nil;
		z.color = red;
		insertFixUp(T,z);
	}
	
	static void  insertFixUp(Node T,Node z){

		Node y;

		while(z.parent.color.equals(red)){
			
			if(z.parent == z.parent.parent.left){
				
				y=z.parent.parent.right;
				
				if(y.color==red){
					
					z.parent.color = black;
					y.color = black;
					
					z.parent.parent.color=red;
					z=z.parent.parent;
				}
				
				else {
					if(z == z.parent.right){
				
					
						z=z.parent;
						leftRotate(T,z);
						
				}
				
				 if(z == z.parent.left){
					
					z.parent.color = black;
					z.parent.parent.color = red;
					
					rightRotate(T,z.parent.parent);
					}
			}		
			}
			else{
				
					y=z.parent.parent.left;
					if(y.color.equals(red)){
						
						y.color = black;
						z.parent.color = black;
						z.parent.parent.color  = red;
						z=z.parent.parent;
						
					}
					else{
						if(z == z.parent.left){
							z=z.parent;
							rightRotate(T,z);
						}
						if(z==z.parent.right){
							
							z.parent.color = black;
							z.parent.parent.color = red;
							leftRotate(T,z.parent.parent);
						}
					}
					}
								
			}
			root.color = black;
		}
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input = 99;
	       Scanner s = new Scanner(System.in);
	       
	       
	       while(input!=9){
	    	   System.out.println("Enter your choice");
	    	   input = s.nextInt(); 
		       switch(input){
		       
		       		case 1: 
		       			System.out.println("Enter the key:");
		       			int key = s.nextInt();
		       			Node z = new Node(key,red);
		       			z.right=Nil;
		       			z.left=Nil;
		       			z.parent=Nil;
		       			insert(root,z);
		       			break;
		       		
		       		case 2: 
		       			System.out.println("Find the min:");
		       			Node min = Min(root);
		       			System.out.println("Minimum is : "+ min.key);
		       			break;
		       			
		       		case 3:
		       			System.out.println("Find the max:");
		       			Node max = Max(root);
		       			System.out.println("MAximum is : "+ max.key);
		       			break;
		       			
		       		case 4:
		       			System.out.println("Finding the element:");
		       			System.out.println("Enter the key:");
		       			key = s.nextInt();
		       			Node result = Search(root, key);
		       			System.out.println("Found the element : "+ result.key+" Color is : "+result.color);
		       			break;
	       			
		       		case 5: 
		       			System.out.println("Enter the key:");
		       			key = s.nextInt();
		       			result = Successor(Search(root, key));
		       			System.out.println("Successor is : "+ result.key);
		       			break;
		       			
		       		case 6: 
		       			System.out.println("Enter the key:");
		       			key = s.nextInt();
		       			result = Predecessor(Search(root, key));
		       			System.out.println("Predecessor is : "+ result.key);
		       			break;
		       			
		       		case 7: 
		       			System.out.println("In order traversal:");
		       			inorderTreeWalk(root);
		       			break;
    				
		       		default:
		       			break;
		       }
	       }
	}

}



