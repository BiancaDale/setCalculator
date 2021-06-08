public class setCalculator {
	static Scanner input = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) { 
    	
    	System.out.println("Enter a sequence of non-negative numbers: ");
         
    	System.out.println("Enter a second sequence of non-negative numbers: ");
 
        System.out.println("Check if TreeSet is empty : " );
        
        while(true) {
        	System.out.print("\nEnter Sequences: ");
        	if(input.next()== "\n") {
        		break;
        	} try {
        		compute();
        	} catch (IllegalArgumentException e) {
        		System.out.println("Error in input: " + e.getMessage());
        	}
        }
        input.close();
    }
    
    public static void compute(){
    	
    	 TreeSet<Integer> setA, setB;  // The two sets of integers.      
    	 boolean addOperator = input.hasNext("\\+");
    	 boolean minusOperator = input.hasNext("\\-");
    	 boolean multiplyOperator = input.hasNext("\\*");
         setA = readSet();
    	if (addOperator == false && minusOperator == false && multiplyOperator == false)
    		throw new IllegalArgumentException(
    		         "Expected *, +, or  - after first set.");
    	setB = readSet();
    	if( input.next() != "\n")
    		throw new IllegalArgumentException("Extra unexpected input.");
    	if(addOperator == true)
            setA.addAll(setB);     // Union.
         else if (multiplyOperator == true)
            setA.retainAll(setB);  // Intersection.
         else
            setA.removeAll(setB);  // Set difference.
         
         System.out.print("Value:  " + setA);
         
         /*
          * Start with an empty set.
Read the '[' that begins the set.
Repeat:
   Read the next number and add it to the set.
   If the next character is ']':
      break.
   Read the comma that separates one number from the next.
Read the ']'.
Return the set.
          */
    }
    
    private static TreeSet<Integer> readSet() {
    	 
        TreeSet<Integer> set = new TreeSet<Integer>();
        boolean start = input.hasNext("[");
        boolean end = input.hasNext("]");
        if(start == false) {
        	throw new IllegalArgumentException("Expected '[' at start of set.");
        	
        }
        if(end == true){
        	input.next();
        	return set;
        }
        while (true) {
            // Read the next integer and add it to the set.
         
         if (! input.hasNextInt())
            throw new IllegalArgumentException("Expected an integer.");
         int n = input.nextInt(); // Read the integer.
         set.add(new Integer(n));  // (Could have just said set.add(n)!)
         if (end == true)
            break;  // ']' marks the end of the set.
         else if (input.hasNext(","))
            input.next(); // Read a comma and continue.
         else
            throw new IllegalArgumentException("Expected ',' or ']'.");
      }

        input.next(); // Read the ']' that ended the set.

      return set;
}
}
