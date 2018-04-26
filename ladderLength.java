package algo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ladderLength {
	public int ladderL(String start, String end, List<String> dict) {
	      // Use queue to help BFS
	      Queue<String> queue = new LinkedList<String>();
	      queue.add(start);
	      queue.add(null);

	      Set<String> dictSet = new HashSet<String>();
	      Iterator<String> it = dict.iterator();
	            while(it.hasNext())
	                dictSet.add(it.next());


	      // Mark visited word
	      Set<String> visited = new HashSet<String>();
	      visited.add(start);

	      int level = 1;

	      while (!queue.isEmpty()) {
	        String str = queue.poll();

	        if (str != null) {
	            if (str.equals(end)) return level;
	          // Modify str's each character (so word distance is 1)
	          for (int i = 0; i < str.length(); i++) {
	            char[] chars = str.toCharArray();

	            for (char c = 'a'; c <= 'z'; c++) {
	              chars[i] = c;

	              String word = new String(chars);



	              // Put it to the queue
	              if (dictSet.contains(word) && !visited.contains(word)) {
	                  dictSet.remove(word);
	                  // Found the end word
	                  if (word.equals(end)) return level + 1;
	                    queue.add(word);
	                    visited.add(word);
	                  }
	            }
	          }
	        } else {
	          level++;

	          if (!queue.isEmpty()) { 
	            queue.add(null);
	          }
	        }
	      }

	      return 0;
	}
}


