public class Main {
    public static void main(String[] args) {

        Ogrenci ogrenci = new MuhendislikOgrencisi("Kubilay","Karacar",20);
        Ogrenci ogrenci2 = new MimarlikOgrencisi("Zuhtu","Yandimoglu",19);

        ogrenci.bilgileriYazdir();
        ogrenci.kayitEkle(ogrenci2);
        ogrenci2.bilgileriYazdir();
        ogrenci.kayitEkle(ogrenci);
        ogrenci.kayitGuncelle(ogrenci.getOgrenciNumarasi(),"Halit","Cerrahpasali",18,"Mimarlik");
        ogrenci.kayitSil(ogrenci2.getOgrenciNumarasi());



    }
}


