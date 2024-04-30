package game;

import java.util.Random;

public class STaktik extends Taktik{

Random rndRandom=new Random();
	@Override
	public int Savas() {
		return rndRandom.nextInt(0,500);
		
		
	}


}
