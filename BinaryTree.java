package algo;

class Node{
	int value;
	Node left,right;

	Node(int v){
	 value = v;
	 left = right = null;
	}
}

class BinaryTree{
 Node root = null;
 
 BinaryTree(){
     root = null;
 }
 
 public boolean isBST(Node root, int min, int max){
  
   if(root ==null)
     return true;
   
   if(root.value < min || root.value > max)
     return false;
   
   return isBST(root.left,min,root.value) && isBST(root.right,root.value+1, max);
   
 }
 
 public static void flatten(Node root) {
	 
	 if(root == null)
		 return;
	 
	 Node left = root.left;
	 Node right = root.right;
	 
	 flatten(left);
	 flatten(right);
	 
	 
	 root.left=null;
	 root.right=left;
	 
	 while(root.right!=null)
		 root = root.right;
	 
	 root.right=right;
	 
 }
 
 
 public static String inOrder(Node root) {
	 if(root==null)
		 return "";
	 
	 return inOrder(root.left)+" "+Integer.toString(root.value)+" "+inOrder(root.right);
 }
 
 
 // Driver method
 public static void main(String[] args){
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(5);
     tree.root.left.left = new Node(3);
     tree.root.left.right = new Node(4);

     System.out.println(inOrder(tree.root));
     
     flatten(tree.root);
     System.out.println(inOrder(tree.root));
     
//     System.out.println(tree.isBST(tree.root,Integer.MIN_VALUE, Integer.MAX_VALUE));
 }
 
}
