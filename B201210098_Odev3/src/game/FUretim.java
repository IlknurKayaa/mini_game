package game;

import java.util.Random;

public class FUretim extends Uretim {
	Random rnd=new Random();
	@Override
	public int Uret() {
		
		return rnd.nextInt(0,20);
	}

}
