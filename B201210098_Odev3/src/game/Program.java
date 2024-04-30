package game;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		String diziString;
		System.out.println("Deger gir:");
		try (Scanner myObj = new Scanner(System.in)) {
			diziString=myObj.nextLine();
		}
		//System.out.printf("%-10s%-15s%s%15s%15s\n","Koloni","Populasyon","Yemek stok","Kazanma","Kaybetme");
		Koloni koloni=new Koloni(' ', 0, 0, 0, 0);
		koloni.KoloniOlustur(diziString);
		Oyun oyun=new Oyun();
		oyun.OyunOyna(koloni.koloniler);
	}

}
