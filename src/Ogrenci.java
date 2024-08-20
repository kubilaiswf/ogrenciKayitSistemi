import java.io.*;

public abstract class Ogrenci {
    private static int numara = 0;
    private String ad;
    private String soyad;
    private int yas;
    private String bolum;
    private int ogrenciNumarasi;

    public Ogrenci(String ad, String soyad, int yas, String bolum) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.bolum = bolum;
        this.ogrenciNumarasi = ++numara;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public int getYas() {
        return yas;
    }

    public String getBolum() {
        return bolum;
    }

    public int getOgrenciNumarasi() {
        return ogrenciNumarasi;
    }

    public abstract void bilgileriYazdir();

    public void kayitEkle(Ogrenci ogrenci) {
        try {
            FileWriter fileWriter = new FileWriter("Ogrenciler.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(ogrenci.getAd() + "," + ogrenci.getSoyad() + "," + ogrenci.getYas() + "," + ogrenci.getBolum() + "," + ogrenci.getOgrenciNumarasi());
            printWriter.close();
            System.out.println("Öğrenci başarıyla kaydedildi.");
        } catch (IOException e) {
            System.out.println("Kayıt ekleme işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }

    public void kayitSil(int ogrenciNumarasi) {
        try {
            File inputFile = new File("Ogrenciler.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = "";
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.split(",")[4].equals(Integer.toString(ogrenciNumarasi))) {
                    lineToRemove = currentLine;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Kayıt silme işlemi sırasında bir hata oluştu.");
                } else {
                    System.out.println("Öğrenci başarıyla silindi.");
                }
            } else {
                System.out.println("Kayıt silme işlemi sırasında bir hata oluştu.");
            }

        } catch (IOException e) {
            System.out.println("Kayıt silme işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }

    public void kayitGuncelle(int ogrenciNumarasi, String yeniAd, String yeniSoyad, int yeniYas, String yeniBolum) {
        try {
            File inputFile = new File("Ogrenciler.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.split(",")[4].equals(Integer.toString(ogrenciNumarasi))) {
                    writer.write(yeniAd + "," + yeniSoyad + "," + yeniYas + "," + yeniBolum + "," + ogrenciNumarasi + System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();

            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Kayıt güncelleme işlemi sırasında bir hata oluştu.");
                } else {
                    System.out.println("Öğrenci başarıyla güncellendi.");
                }
            } else {
                System.out.println("Kayıt güncelleme işlemi sırasında bir hata oluştu.");
            }

        } catch (IOException e) {
            System.out.println("Kayıt güncelleme işlemi sırasında bir hata oluştu: " + e.getMessage());
        }
    }


}

