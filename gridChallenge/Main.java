package gridChallenge;

public class Main {
	 public static void main(String[] args) {
	        int W = 5;
	        int H = 10;

	        //DisplayGrid d = new DisplayGrid();
	        LargestBlockSearch b = new LargestBlockSearch();
	        b.createGame(W, H);
	        b.displayGrid();
	        
	        Grid g = b.findLargest();
	        if (g != null) {
	        	System.out.println("");
	            System.out.println("Largest Block");
	            
	            b.displayLargestBlock(g);
	        }
}
}

//test comment