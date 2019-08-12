package day31.exception_practice;

public class Test {
	public static void main (String[] args) {
		Test test = new Test();
		test.sayNick("fool");
	}
	
	public void sayNick(String nick) {
		try {
			if("fool".equals(nick)) {
				throw new FoolException();
			}
			
			System.out.println("∫∞∏Ì¿∫: " + nick);
		} catch (FoolException e) {
			System.err.print("Fool exception");
		}
	}
}
