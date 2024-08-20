public class MimarlikOgrencisi extends Ogrenci {


        public MimarlikOgrencisi(String ad, String soyad, int yas) {
            super(ad, soyad, yas, "Mimarlik");

        }


        @Override
        public void bilgileriYazdir() {
            System.out.println("Ad: " + getAd() + " Soyad: " + getSoyad() + " Yas: " + getYas() + " Bolum: " + getBolum() + " Ogrenci Numarasi: " + getOgrenciNumarasi());
        }

    }