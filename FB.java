package algo;

public class FB {

	interface File4KIterator {
	  boolean hasNext();
	  String next4K();
	}

	class FileLineIterator {
	  FileLineIterator(File4KIterator it);
	  
	  String current4k = null;
	  
	  boolean hasNext(){
	   
	    if(current4k.contains("\n"))
	      return true;
	    
	    return it.hasNext();
	  }
	  
	  String nextLine(){
	   
	    if(current4k ==null)
	      current4k=it.next4K();
	    
	    
	    
	    while(!current4k.contains("\n") && it.hasNext() )
	        current4k+=it.next4K();
	      
	      if(!current4k.contains("\n"))
	        return current4k;
	    
	      
	      int index = current4k.indexOf("\n");
	      String line = current4k.substring(0,index+1);
	      
	      current4k = current4k.substring(index+1);
	      return line;
	    }
	  
	}

	class FileSizeNIterator {
	  FileSizeNIterator(File4KIterator it);

	  boolean hasNext(int n){
	    if(current4k.length() > n)
	      return true;
	    
	    return it.hasNext();
	  }

	  String nextNChars(int n){
	    
	    if(current4k ==null)
	      current4k=it.next4K();
	    
	    
	    
	    while(current4k.length() < n && it.hasNext() )
	        current4k+=it.next4K();
	      
	      if(current4k.length() < n)
	        return current4k;
	    
	      
	      // int index = current4k.indexOf("\n");
	      String line = current4k.substring(0,n);
	      
	      current4k = current4k.substring(n+1);
	      return line;
	    }
	    
	  }
}





//
//
//	Assume file doesn't have to end with \n.
//	File: "1234\n 5555 5555 5555 52\n1\n\2"

// 1234
// 555555555552
// 1
// 2

//	File: "1\n2\n"
//	hasNext():
//	True
//
//	current4k:
//	12345678
//
//	nextLine():
//	123\n
//
//	  
//	  
//	nextLine:
//	123\n
//	1234567\n
//	12\n
//	34\n







