package game;

import java.util.ArrayList;

import java.util.Random;

public class Oyun {
	int turSayisi;
	Random rnd=new Random();
	int taktik;
	int taktik2;
	int uretim;
	int savas;
	int savas2;
	int durumKontrol;
	boolean durum=true;
	Taktik taktikSec=new FTaktik();
	Taktik taktikSec2=new STaktik();
	Uretim uretimSec=new FUretim();
	Uretim uretimSec2=new SUretim();
	public void OyunOyna(ArrayList<Koloni> koloniler) {
		while (durum==true) {
			//tur başı
			for (int i = 0; i < koloniler.size(); i++) {
				for (int j = i+1; j < koloniler.size(); j++) {
					if (koloniler.get(i).populasyon!=0&&koloniler.get(j).populasyon!=0) {
						taktik=rnd.nextInt(0,2);
						taktik2=rnd.nextInt(0,2);
						//ilk koloni ve ikinci koloni için her tur farklı taktik belirleme
						if (taktik==0&&taktik2==0) {
							savas=taktikSec2.Savas();
							savas2=taktikSec2.Savas();
						}
						else if (taktik==0&&taktik2==1) {
							savas=taktikSec2.Savas();
							savas2=taktikSec.Savas();
						}
						else if (taktik==1&&taktik2==0) {
							savas=taktikSec.Savas();
							savas2=taktikSec2.Savas();
						}
						else {
							savas=taktikSec.Savas();
							savas2=taktikSec.Savas();
						}
						// belirlenen taktiklere göre savaş
						if (savas>savas2) {
								koloniler.get(i).kazanma++;
								koloniler.get(j).kaybetme++;
								koloniler.get(j).populasyon=koloniler.get(j).populasyon-((koloniler.get(j).populasyon*(savas-savas2))/1000);
								koloniler.get(i).yemekStok=koloniler.get(i).yemekStok+((koloniler.get(j).yemekStok*(savas-savas2))/1000);
								koloniler.get(j).yemekStok=koloniler.get(j).yemekStok-((koloniler.get(j).yemekStok*(savas-savas2))/1000);

							

							
						}
						else if(savas<savas2){
								koloniler.get(j).kazanma++;
								koloniler.get(i).kaybetme++;
								koloniler.get(i).populasyon=koloniler.get(i).populasyon-((koloniler.get(i).populasyon*(savas2-savas))/1000);
								koloniler.get(j).yemekStok=koloniler.get(j).yemekStok+((koloniler.get(i).yemekStok*(savas2-savas))/1000);
								koloniler.get(i).yemekStok=koloniler.get(i).yemekStok-((koloniler.get(i).yemekStok*(savas2-savas))/1000);

							
						}
						else { // savaslar esit
							//populasyonu büyük olan kazanır
							if (koloniler.get(i).populasyon>koloniler.get(j).populasyon) {
								koloniler.get(i).kazanma++;
								koloniler.get(j).kaybetme++;
								koloniler.get(j).populasyon=koloniler.get(j).populasyon-((koloniler.get(j).populasyon*(savas-savas2))/1000);
								koloniler.get(i).yemekStok=koloniler.get(i).yemekStok+((koloniler.get(j).yemekStok*(savas-savas2))/1000);
								koloniler.get(j).yemekStok=koloniler.get(j).yemekStok-((koloniler.get(j).yemekStok*(savas-savas2))/1000);
							}
							else if (koloniler.get(j).populasyon>koloniler.get(i).populasyon) {
								koloniler.get(j).kazanma++;
								koloniler.get(i).kaybetme++;
								koloniler.get(i).populasyon=koloniler.get(i).populasyon-((koloniler.get(i).populasyon*(savas2-savas))/1000);
								koloniler.get(j).yemekStok=koloniler.get(j).yemekStok+((koloniler.get(i).yemekStok*(savas2-savas))/1000);
								koloniler.get(i).yemekStok=koloniler.get(i).yemekStok-((koloniler.get(i).yemekStok*(savas2-savas))/1000);
							}
							//populasyon değerleri de eşitse
							else {
								int rastgele=rnd.nextInt(0,2);
								if (rastgele==0) {
									koloniler.get(i).kazanma++;
									koloniler.get(j).kaybetme++;
									koloniler.get(j).populasyon=koloniler.get(j).populasyon-((koloniler.get(j).populasyon*(savas-savas2))/1000);
									koloniler.get(i).yemekStok=koloniler.get(i).yemekStok+((koloniler.get(j).yemekStok*(savas-savas2))/1000);
									koloniler.get(j).yemekStok=koloniler.get(j).yemekStok-((koloniler.get(j).yemekStok*(savas-savas2))/1000);
								}
								else {
									koloniler.get(j).kazanma++;
									koloniler.get(i).kaybetme++;
									koloniler.get(i).populasyon=koloniler.get(i).populasyon-((koloniler.get(i).populasyon*(savas2-savas))/1000);
									koloniler.get(j).yemekStok=koloniler.get(j).yemekStok+((koloniler.get(i).yemekStok*(savas2-savas))/1000);
									koloniler.get(i).yemekStok=koloniler.get(i).yemekStok-((koloniler.get(i).yemekStok*(savas2-savas))/1000);
								}
							}
							
						}
					}

					// kolonide yok olma durum kontrolü 
					if (koloniler.get(i).populasyon<=1||koloniler.get(i).yemekStok<=1) {
						koloniler.get(i).populasyon=koloniler.get(i).yemekStok=koloniler.get(i).kazanma=koloniler.get(i).kaybetme=0;
						
					}
					else if (koloniler.get(j).populasyon<=1||koloniler.get(j).yemekStok<=1) {
						koloniler.get(j).populasyon=koloniler.get(j).yemekStok=koloniler.get(j).kazanma=koloniler.get(j).kaybetme=0;
						
					}
					//System.out.println("Savaşan 1  :"+koloniler.get(i)+"Savaşan 2  :"+koloniler.get(j));
				}
			}
			//tur bitimi
			// tur sonu değer atama
			turSayisi++;
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("Tur:"+turSayisi);
			System.out.printf("%-10s%-15s%s%15s%15s\n","Koloni","Populasyon","Yemek stok","Kazanma","Kaybetme");
			// her elemana tek tek değer atama 
			for (int i = 0; i < koloniler.size(); i++) {
				if (koloniler.get(i).populasyon!=0) { //koloni ölmediyse değer ata
					// tur sonundaki üretim değerleri
					uretim=rnd.nextInt(0,2);
					if (uretim==0) {
						koloniler.get(i).yemekStok=koloniler.get(i).yemekStok+uretimSec2.Uret();
					}
					else {
						koloniler.get(i).yemekStok=koloniler.get(i).yemekStok+uretimSec.Uret();
					}
					
					// tur sonu her elemana oto değerler
					koloniler.get(i).populasyon=koloniler.get(i).populasyon+((koloniler.get(i).populasyon*20)/100);
					koloniler.get(i).yemekStok=koloniler.get(i).yemekStok-(koloniler.get(i).populasyon*2);
					// gücelpopulasyonx2 den gelen değer kendi stoğundan fazlaysa
					if (koloniler.get(i).yemekStok<=1) {
						koloniler.get(i).populasyon=koloniler.get(i).yemekStok=koloniler.get(i).kazanma=koloniler.get(i).kaybetme=0;
						durumKontrol++;
						System.out.printf("%-10c %-12s %6s %15s %15s \n", koloniler.get(i).simge, "--", "--","--","--");
						System.out.println("\n");
					}
					else {
						System.out.println(koloniler.get(i));
					}
				}
				
				// 
				else {
					durumKontrol++;
					System.out.printf("%-10c %-12s %6s %15s %15s \n", koloniler.get(i).simge, "--", "--","--","--");
					System.out.println("\n");
					
				}
				



			}
			// oyun sonu kontrolü
			if (durumKontrol==koloniler.size()-1) {
				durum=false;
			}
			durumKontrol=0;
			
			
		}
		
	}
	
	

	
}
