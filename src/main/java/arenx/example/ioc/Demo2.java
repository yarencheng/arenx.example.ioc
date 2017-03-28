package arenx.example.ioc;

public class Demo2 {
	
	static class Hans{
		public void talk(){ System.out.println("植物不會快樂"); }
	}
	
	static class Leo{
		public void talk(){ throw new RuntimeException("Go to work~!!!!");}
	}
	
	static class Dave{
		
		public void wantTalk(){
			
			Leo leo = new Leo();
			try{
				leo.talk();
				leo.talk();
				leo.talk();
				leo.talk();
				
				return;
				
			} catch (RuntimeException e) {
				// Leo is angry. Turn to Hans
			}
			
			Hans hans = new Hans();
			try{
				hans.talk();
				hans.talk();
				hans.talk();
				hans.talk();
				
				return;
				
			} catch (RuntimeException e) {
				// Hans is angry too.
			}			
		}
	}
	
	public static void main(String[] argv){
		
		Dave dave = new Dave();
		dave.wantTalk();
	}
	
	
}
