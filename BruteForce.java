public class BruteForce {
	private static final String password = "~";
	private static StringBuilder string = new StringBuilder("");
	private static int min = 33, max = 127;
	private static long start;
	
	public static void loop(int index) {
            int k = min;
            do {
                string.setCharAt(index, (char) k);
                    if(index < string.length() - 1) {
                        loop(index + 1);
                    }
                    //System.out.println(string);
                    if(string.toString().equals(password)) {
                            System.out.println("password found: " + string);
                            System.out.println("It took: " + convertmillis(System.currentTimeMillis() - start));
                            System.exit(0);
                    }
                    k++;
            } while (k < max);
        }
	
	public static void main(String[] args) {
		start = System.currentTimeMillis();               
                while(true) {
                        string.append((char) min);

                        for(int i = 0; i < string.length(); i++) {
                                for(int j = min; j  < max; j++) {
                                        string.setCharAt(i, (char) j);
                                        loop(i);
                                }
                        }
                }
	}
	
	public static String convertmillis(long input) {
		int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;
			        
		int day = 86400000;
		int hour = 3600000;
		int minute = 60000;
		int second = 1000;
			    
			       
		if(input >= day) {
		     days = (int) (input / day);
		     millis = (int) (input % day);
		} else 
			millis = (int) input;
			           
		if(millis >= hour) {
		     hours = millis / hour;
		     millis = millis% hour;
		}
			       
		if(millis >= minute) {
			 minutes = millis / minute;
			 millis = millis % minute;
		}
		
		if(millis >= second) {
			seconds = millis / second;
			millis = millis % second;
		}
			      
		return (days  + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
	}
}
