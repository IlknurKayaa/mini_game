package game;

import java.util.Random;

public class SUretim extends Uretim{
	Random rnd=new Random();
	@Override
	public int Uret() {
		return rnd.nextInt(0,10);
	}
}
