package cc;

public class Wertung {


	private static int result = 0;
	private static int lampInt = 0;
	private final static int achievePoint = 6; 
	boolean lamp;
	
	static void setLamp(boolean isLampOff) {
	
		if(isLampOff)
			lampInt = 3;
		else
			lampInt = -3;
	
	}
	
	static void setDocument(boolean com) {
	
		if(com)
			result += 2;
	
	}
	
	static void setTelephone(String variation) {
		
		switch(variation) {
		
		case "AA" :
		case "AB" : result -= 2;	break;
		case "BA" : result += 3;	break;
		case "BB" : result += 2;	break;
		case "CA" : result += 4;	break;
		case "CB" : result += 3;	break;
		case "DA" : result += 2;	break;
		case "DB" : result -= 2;	break;
		
		default: System.out.println("Fehler");
		}
		// A -2
		// B +3 / +2
		// C +4 / +3
		// D +2 / -2
	}
	
	 
	static void setWebsite(char variation) {
	
		if(variation == 'A')
			result += 2;
		else
			result += 1;
	}
	
	static void setPlant(boolean bl){
		
		if(bl)
			result += 2;
		else
			result -= 2;
	}
	
	static int getGoodEnd() {
		System.out.println(result + lampInt);
		// true = good end // false = bad end
		if(result + lampInt > achievePoint){
			
			
			return 1;
		}
		
		return 2;
	}
}
