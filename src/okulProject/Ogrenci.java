package okulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {
    static Scanner scan = new Scanner(System.in);

    static Map<String, String> ogrenciMap = new HashMap<>();

    public static void feykOgrenciEkle() {
        ogrenciMap.put("12345678941", "Ali Can,2007,2526,12,B");
        ogrenciMap.put("23467891019", "Veli Yan, 2010,2736,12,C");
        ogrenciMap.put("12356473891", "Ayse Tan, 2011,3637,11,D");
        ogrenciMap.put("98750763538", "Alp Kan, 2008,7465,13,A");
        ogrenciMap.put("32563784910", "Ahmet Van, 2006,6473,12,D");
    }

    public static void ogrenciMenu() throws InterruptedException {
        String tercih = "";

        do {


            System.out.println("=========AKYAR KOLEJI========\n" +
                    "=========OGRENCİ MENU=========\n" +
                    "\n" +
                    "\t  1- Ogrenci Listesi Yazdir\t\n" +
                    "\t  2- Soyisimden Ogrenci Bulma\n" +
                    "\t  3- Sinif ve Sube ile Bulma\n" +
                    "\t  4- Bilgilerini Girerek Ogrenci Bulma \n" +
                    "\t  5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t  A- ANAMENU\n" +
                    "\t  Q- CIKIS\n");

            tercih = scan.nextLine();
            switch (tercih) {
                case "1":
                    ogrenciListesiYazdir();
                    break;
                case "2":
                    soyisimdenOgrenciBulma();
                    break;
                case "3":
                    sinifVeSubeIleOgrenciBulma();
                    break;
                case "4":
                    bilgileriniGirerekOgrenciBulma();
                    break;
                case "5":
                    tcNoileOgrenciSil();
                    break;
                case "a":
                    break;
                case "A":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println();
            }

        } while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();

    }

    public static void tcNoileOgrenciSil() {
        System.out.printf("Silinecek ogrenci kimlik nı giriniz");
        String silinecekOgrenci = scan.nextLine();
        String silinecekValue = ogrenciMap.get(silinecekOgrenci);

        String sonucValue = ogrenciMap.remove(silinecekOgrenci);
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.printf("Istediginiz TC no ile ogrenci bulunamadi");
        }

    }

    public static void bilgileriniGirerekOgrenciBulma() {
        ogrenciEkle();
    }

    private static void ogrenciEkle() {
        System.out.println("Tc No");
        String tcNo = scan.nextLine();
        System.out.println("Isim");
        String isim = scan.nextLine();
        System.out.println("Soyisim");
        String soyIsim = scan.nextLine();
        System.out.println("Dogum Yili");
        String dogumYili = scan.nextLine();
        System.out.println("Okul No");
        String okulNo = scan.nextLine();
        System.out.println("Sinif");
        String sinif = scan.nextLine();
        System.out.println("Sube");
        String sube = scan.nextLine();

        String key = tcNo;
        String value = isim + ", " + soyIsim + ", " + dogumYili + ", " + okulNo + ", " + sinif + ", " + sube;
        ogrenciMap.put(key,value);

    }

    public static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("Istediginiz ogrenci sinifini yaziniz");
        String istenilenSinif = scan.nextLine();
        System.out.println("Istediginiz ogrenci subesini yaziniz");
        String istenilenSube = scan.nextLine();

        System.out.println("=========AKYAR KOLEJI========\n" +
                "=========OGRENCİ LISTESI=========\n" +
                "TcNo         Isim         Soyisim        DogumYili        OkulNo       Sinif      Sube    ");

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = new String[0];

            if (istenilenSinif.equalsIgnoreCase(eachValueArr[4]) && istenilenSube.equalsIgnoreCase(eachValueArr[5])) {
                eachValueArr = eachValue.split(", ");
                System.out.printf("%12s %-6s %-8s %4-s  %-4 %-2 %-2 \n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
            }
        }
        Thread.sleep(5000);
    }

    public static void soyisimdenOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("Istediginiz ogrenci soy ismini yaziniz");
        String istenilenSoyIsim = scan.nextLine();

        System.out.println("=========AKYAR KOLEJI========\n" +
                "=========OGRENCİ LISTESI=========\n" +
                "TcNo         Isim         Soyisim        DogumYili        OkulNo       Sinif      Sube    ");

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = new String[0];

            if (istenilenSoyIsim.equalsIgnoreCase(eachValueArr[1])) {

                eachValueArr = eachValue.split(", ");
                System.out.printf("%12s %-6s %-8s %4-s  %-4 %-2 %-2 \n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
            }
        }
        Thread.sleep(5000);
    }

    public static void ogrenciListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("=========AKYAR KOLEJI========\n" +
                "=========OGRENCİ LISTESI=========\n" +
                "TcNo         Isim         Soyisim        DogumYili        OkulNo       Sinif      Sube    ");

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            System.out.printf("%12s %-6s %-8s %4-s  %-4 %-2 %-2 \n", eachKey, eachValueArr[0]);
        }
        Thread.sleep(5000);
    }

}
