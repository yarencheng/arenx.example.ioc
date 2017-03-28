package arenx.example.ioc;


public class Demo4 {
	
	//
	// Interface
	//
	
	interface PepoleWhoReadAlot{
		public void talk();
	}
	
	//
	// Instance
	//
	
	static class Hans implements PepoleWhoReadAlot{
		public void talk(){ System.out.println("植物不會快樂"); }
	}
	
	static class Leo implements PepoleWhoReadAlot{
		public void talk(){ throw new RuntimeException("Go to work~!!!!");}
	}
	
	static class Dave{
		
		PepoleWhoReadAlot somebodyHappyToTalk;
		
		public Dave(PepoleWhoReadAlot somebodyHappyToTalk){
			this.somebodyHappyToTalk = somebodyHappyToTalk;	
		}
		
		public void wantTalk(){  			
			while(true)
				somebodyHappyToTalk.talk();
		}
	}
	
	//
	// Supervisor who control every thing
	//
	
	static class KH{
		public void BuildSoftwareOffice(){
			
			PepoleWhoReadAlot somebodyHappyToTalkForDave = new Hans();
			
			Dave dave = new Dave(somebodyHappyToTalkForDave);
			dave.wantTalk();
		}
	}
	
	
}
