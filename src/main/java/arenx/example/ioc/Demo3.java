package arenx.example.ioc;

public class Demo3 {
	
	interface PepoleWhoReadAlot{
		public void talk();
	}
	
	static class Hans implements PepoleWhoReadAlot{
		public void talk(){ System.out.println("植物不會快樂"); }
	}
	
	static class Leo implements PepoleWhoReadAlot{
		public void talk(){ throw new RuntimeException("Go to work~!!!!");}
	}
	
	static class Dave{
		
		public void wantTalk(){  
			KH kh = new KH();
			PepoleWhoReadAlot somebodyHappyToTalk = kh.getSombodyHappyToTalk(); // GOOD: factory pattern or service locator pattern
			
			somebodyHappyToTalk.talk();
			somebodyHappyToTalk.talk();
			somebodyHappyToTalk.talk();
			somebodyHappyToTalk.talk();
		}
	}
	
	static class KH{
		public PepoleWhoReadAlot getSombodyHappyToTalk(){
			return new Hans();
		}
	}
	
	public static void main(String[] argv){		
		Dave dave = new Dave();
		dave.wantTalk();
	}
}
