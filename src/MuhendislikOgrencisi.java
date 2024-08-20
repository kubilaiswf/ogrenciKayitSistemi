public class MuhendislikOgrencisi extends Ogrenci {

    public MuhendislikOgrencisi(String ad, String soyad, int yas) {
        super(ad, soyad, yas, "Muhendislik");
    }

    @Override
    public void bilgileriYazdir() {
        System.out.println("Ad: " + getAd() + " Soyad: " + getSoyad() + " Yas: " + getYas() + " Bolum: " + getBolum() +  " Ogrenci Numarasi: " + getOgrenciNumarasi());




    }
}
