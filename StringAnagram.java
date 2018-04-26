package algo;

import java.util.HashMap;

public class StringAnagram {

	
	public static void main(String[] args) {
		String s1 = "b54Keep a-up";
		String s2 = "a45Keep /b// --up";
	
		s1 = s1.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
		s2 = s2.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		
		if(s1.length()!=s2.length()) {
			System.out.println(false);
			return;
		}
			
		for(Character c : s1.toCharArray())
			if(hm.containsKey(c))
				hm.put(c, hm.get(c)+1);
			else
				hm.put(c, 1);
		int i;
		for(Character c: s2.toCharArray())
			if(!hm.containsKey(c)) {
				System.out.println(false);
				return;
			}
				
			else {
				if((i = hm.get(c))==1)
					hm.remove(c);
				else
					hm.put(c,i-1);
			}
		
		if(!hm.isEmpty())
			System.out.println(false);
		else
			System.out.println(true);
		
		
		
	}
	
}
