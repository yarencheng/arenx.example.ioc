package arenx.example.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo6 {
	
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

			ApplicationContext ctx = new FileSystemXmlApplicationContext("kh.xml");
			
			Dave dave = ctx.getBean("dave", Dave.class);
			dave.wantTalk();
			
			CM cm = ctx.getBean("cm", CM.class);
			cm.needMoney();
			cm.wantTalk();
		}
	}
	
	public static void main(String[] argc){
		KH kh = new KH();
		kh.BuildSoftwareOffice();
		
	}
}
