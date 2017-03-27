package algorithm;
import java.util.*;

public class RandomInput{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        StringBuilder result = new StringBuilder(input);
        
        result = recursiveFunction(result);
        
        System.out.println(result);
    }
    
    public static StringBuilder recursiveFunction(StringBuilder input){
        
        //base case 1
        if(input == null || input.length()==0)
            return new StringBuilder();
            
        int length = input.length();
        
        int i =0;
        //base case check
        for(i =0; i<length; i++){
            if(input.charAt(i)=='{')
                break;
                
        }
        
        // base case 2: with no inner loops
        if(i == length){
//        	System.out.println("deb"+i);
            ArrayList<String> arr = new ArrayList<String>(Arrays.asList(input.toString().split("\\|")));
//            System.out.println(arr[0]);
            int l = arr.size();
//            System.out.println(l);
            Random random = new Random();
            int sel = random.nextInt(l);
            return new StringBuilder(arr.get(sel));
        }
        
        StringBuilder result = new StringBuilder();

        
        //sarting of subproblem 
        int start=0, end =0;
        
        // count of brackets
        int count1 = 0, count2=0;
        
        for(i=0; i< length;i++){
            
            StringBuilder temp = new StringBuilder();
//            System.out.println("debug");
            if(input.charAt(i) == '{'){
                start =1;
                i++;
//                System.out.println(i);
                while(start != end){
//                	System.out.println("debug1");
                    if(input.charAt(i) == '{'){
//                    	System.out.println("debug2");
                        start++;
                    }else if(input.charAt(i) == '}'){
//                    	System.out.println("debug3");
                        end++;
                    }
                    
                      if(start == end){
//                    	  System.out.println("debug4");
                    	  i++;
                    	  break;
                      }
                        
                        
                    temp.append(input.charAt(i));
                    i++;
                    
                }
//                System.out.println(temp);
                temp = recursiveFunction(temp);
                result.append(temp);
//                System.out.println("Result: " +result);
                result.append(" ");
                start=0;
                end =0;
                
            }else{
                result.append(input.charAt(i));
            }
            
           
            
            
        }
        
        result =  recursiveFunction(result);
        return result;
    } 
    
}