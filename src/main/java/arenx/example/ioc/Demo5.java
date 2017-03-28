package arenx.example.ioc;

public class Demo5 {
	
	static class Stock{
		public Stock(String name){}
	}
	
	//
	// Interface
	//
	
	interface PepoleWhoReadAlot{
		public void talk();
	}
	
	interface StockGod{
		Stock recommand();
	}
	
	//
	// Instance
	//
	
	static class Hans implements PepoleWhoReadAlot, StockGod {
		public void talk(){ System.out.println("植物不會快樂"); }
		public Stock recommand() { return new Stock("美國 VT");};
	}
	
	static class Leo implements PepoleWhoReadAlot{
		public void talk(){ throw new RuntimeException("Go to work~!!!!");}
	}
	
	static class Kevin implements StockGod{
		public Stock recommand() { return new Stock("台榮");};
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
	
	static class CM{
		
		PepoleWhoReadAlot somebodyHappyToTalk;
		StockGod stockGod;
		
		public CM(PepoleWhoReadAlot somebodyHappyToTalk, StockGod stockGod){
			this.somebodyHappyToTalk = somebodyHappyToTalk;
			this.stockGod = stockGod;
		}
		
		public void wantTalk(){ 
			
			while(true)
				somebodyHappyToTalk.talk();
		}

		public void needMoney(){
			while(true)
				stockGod.recommand();
		}
	}
	
	//
	// Supervisor who control every thing
	//
	
	static class KH{
		public void BuildSoftwareOffice(){
			
			PepoleWhoReadAlot somebodyHappyToTalk = new Hans();
			
			//
			// KH 知道 Dave 只能跟 Hans 聊天
			//
			Dave dave = new Dave(somebodyHappyToTalk);
			dave.wantTalk();
	
			StockGod stockGodForCM = new Kevin();
			
			//
			// KH 知道 CM 只能跟 Hans 聊天
			// KH 知道 CM 只想跟 Kevin 要明牌
			//
			CM cm = new CM(somebodyHappyToTalk, stockGodForCM);
			cm.needMoney();
			cm.wantTalk();
		}
	}
	
	public static void main(String[] argc){
		KH kh = new KH();
		kh.BuildSoftwareOffice();
	}
	
}
