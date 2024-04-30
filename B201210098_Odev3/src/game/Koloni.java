package game;

import java.util.ArrayList;
import java.util.Random;

public class Koloni {
	char simge;
	int populasyon;
	int yemekStok;
	int kazanma;
	int kaybetme;
	ArrayList<Koloni>koloniler=new ArrayList<Koloni>();
	public Koloni(char simge, int populasyon, int yemekStok, int kazanma,
			int kaybetme) {
		super();
		this.simge = simge;
		this.populasyon = populasyon;
		this.yemekStok = yemekStok;
		this.kazanma = kazanma;
		this.kaybetme = kaybetme;
	}
	public char getSimge() {
		return simge;
	}
	public void setSimge(char simge) {
		this.simge = simge;
	}
	public int getPopulasyon() {
		return populasyon;
	}
	public void setPopulasyon(int populasyon) {
		this.populasyon = populasyon;

	}
	public int getYemekStok() {
		return yemekStok;
	}
	public void setYemekStok(int yemekStok) {
		this.yemekStok = yemekStok;
	}
	public int getKazanma() {
		return kazanma;
	}
	public void setKazanma(int kazanma) {
		this.kazanma = kazanma;
	}
	public int getKaybetme() {
		return kaybetme;
	}
	public void setKaybetme(int kaybetme) {
		this.kaybetme = kaybetme;
	}
	@Override
	public String toString() {

		return String.format("%-10c %-12d %6d %15d %15d \n", simge, populasyon, yemekStok,kazanma,kaybetme);
	}
	public void KoloniOlustur(String girilenPopulasyon) {
		Random rnd=new Random();
		String[] populasyon=girilenPopulasyon.split(" ");
		for (int i = 0; i < populasyon.length; i++) {
			int sembol=rnd.nextInt(0x2660,0x2670);
			koloniler.add(new Koloni((char)sembol, Integer.parseInt(populasyon[i]), (int) Math.pow(Integer.parseInt(populasyon[i]), 2), 0, 0));
			//System.out.println(koloniler.get(i));
			
		}
	}
	

}
