# mini_game

![image](https://github.com/IlknurKayaa/mini_game/assets/83220057/b7b0b907-baab-4821-94f8-3fe6ad4915fc)

Her sayının basamak sayısı ve girilen sayı adedi değişkenlik gösterebilir. Bu koddaki her sayı farklı bir 
kolonideki popülasyonu göstermektedir. Her koloni farklı bir sembol (rastgele bir karakter) ile temsil 
edilmelidir. Her koloni farklı bir savaş taktiği kullanabilmektedir (Bu taktik yapısından (struct)
üretilmiş bir değişken değil, taktik yapısından kalıtım alan (benzetim) farklı bir türdür.). Bir koloni 
başka bir koloni ile savaşacağı zaman Taktik yapısının Savas fonksiyonun çağırmakta ve bu 
fonksiyonun 0-1000 arası döndüreceği değere göre hangi koloninin değeri büyükse savaşı o koloni 
kazanmaktadır. Örneği A kolonisi 700 değeri ile B kolonisi 800 değeri ile savaştığında B kolonisi savaşı 
kazanır. Aradaki fark 100 olduğu ve 1000 değerine göre %10 olduğu için A kolonisinin popülasyonu 
%10 azalır. A kolonisinin yemek stoğunun %10’u B kolonisine geçer. Berabere durumunda 
popülasyonu fazla olan kazanır. Popülasyon da eşitse rastgele biri kazanmalıdır.
Her koloni farklı bir üretim tekniği kullanabilmektedir (Bu Uretim yapısından üretilmiş bir değişken 
değil, Uretim yapısından kalıtım alan farklı bir türdür.). Her turda her koloni Uretim yapısının Uret 
fonksiyonunu çağırarak döndürdükleri 1-10 arası tam sayı değerini yemek stoğuna eklerler.
Her kolonide başlangıç yemek stoğu ilk durumdaki popülasyonun karesi kadardır.
Her turda her koloninin popülasyonu %20 oranında artar ve Yemek stoğu (GüncelPopülasyon x 2)
oranında azalır.
Yemek stoğu veya popülasyonu sıfıra veya eksiye düşen koloninin yaşamı sona erer.
Her turda bütün koloniler diğer bütün koloniler ile savaşır. Örneğin 4 koloni varsa her turda toplamda 
6 savaş yapılacaktır. Program sadece 1 koloni kalana kadar devam eder ve son kalan koloni ekranda 
gösterilip program sonlanır. Bütün sayısal değer ve işlemler tam sayıya göre yapılmalıdır.
