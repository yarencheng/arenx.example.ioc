package arenx.example.ioc;

public class Demo1 {

	static class Hans{
		public void talk(){ System.out.println("植物不會快樂");}
	}
	
	static class Dave{
		
		public void wantTalk(){ // BAD			
			Hans hans = new Hans();
			hans.talk();
			hans.talk();
			hans.talk();
			hans.talk();
		}
		
		public void wantTalk(Hans hans){ // GOOD: dependency injection
			hans.talk();	
			hans.talk();
			hans.talk();
			hans.talk();
		}
	}
	
	public static void main(String[] argv){
		
		Dave dave = new Dave();
		dave.wantTalk();  // BAD
				
		Hans hans = new Hans();
		dave.wantTalk(hans); // GOOD: dependency injection
	}
	
	
}
