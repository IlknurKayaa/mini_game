package game;

import java.util.Random;

public class FTaktik extends Taktik{
	Random rnRandom=  new Random();
	@Override
	public int Savas() {
		
		return rnRandom.nextInt(0,1000);
		
	}

}
