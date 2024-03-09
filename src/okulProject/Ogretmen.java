package okulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);

    static Map<String, String> ogretmenlerMap = new HashMap<>();

    public static void feykOgretmenEkle() {
        ogretmenlerMap.put("12345678941", "Ali Can, 1980,Matematik");
        ogretmenlerMap.put("23467891019", "Veli Yan, 1980,Fizik");
        ogretmenlerMap.put("12356473891", "Ayse Tan, 1980,Kimya");
        ogretmenlerMap.put("98750763538", "Alp Kan, 1980,Matematik");
        ogretmenlerMap.put("32563784910", "Ahmet Van, 1980,Biyoloji");
    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih;

        do {

            System.out.println("=========AKYAR KOLEJI========\n" +
                    "=========OGRETMEN MENU=========\n" +
                    "\n" +
                    "\t  1- Ogretmen Listesi Yazdir\t\n" +
                    "\t  2- Soyisimden Ogretmen Bulma\n" +
                    "\t  3- Branstan Ogretmen Bulma\n" +
                    "\t  4- Bilgilerini Girerek Ogretmen Ekleme \n" +
                    "\t  5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t  A- ANAMENU\n" +
                    "\t  Q- CIKIS\n");
            tercih = scan.nextLine();

            switch (tercih) {
                case "1":// Ogretmen Listesi Yazdir
                    ogretmenListesiYazdir();
                    break;
                case "2":
                    soyisimdenOgretmenBulma();
                    break;
                case "3":
                    branstanOgretmenBulma();
                    break;
                case "4":
                    ogretmenEkleme();
                    break;
                case "5"://Kimlik no ile kayit silme
                    tcNoileOgretmenSil();
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

    public static void tcNoileOgretmenSil() {
        System.out.printf("Silinecek ogretmen kimlik nı giriniz");
        String silinecekOgretmen = scan.nextLine();
        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);

        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.printf("Istediginiz TC no ile ogretmen bulunamadi");
        }


    }

    public static void ogretmenEkleme() {
        System.out.printf("Tc No");
        String tcNo = scan.nextLine();
        System.out.printf("isim");
        String isim = scan.nextLine();
        System.out.printf("soyisim");
        String soyIsim = scan.nextLine();
        System.out.printf("Dogum yili");
        String dogumYili = scan.nextLine();
        System.out.printf("Brans");
        String brans = scan.nextLine();

        String eklenecekValue = isim + ", " + soyIsim + ", " + dogumYili + ", " + brans;

        ogretmenlerMap.put(tcNo, eklenecekValue);

    }

    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.printf("Aradiginiz Ogretmenin bransini giriniz");
        String istenenBrans = scan.nextLine();
        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println("=========AKYAR KOLEJI========\n" +
                "======= BRANS İLE OGRETMEN ARAMA=========\n" +
                "TcNo      Isim       Soyisim        DogumYili        Brans     ");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            //System.out.println(eachKey+" "+eachValue);

            String eachValuearr[] = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuearr[3])) {
                System.out.printf("%11s %-6s %-8s %4s %s \n", eachKey, eachValuearr[0], eachValuearr[1], eachValuearr[2], eachValuearr[3]);
            }
        }
        Thread.sleep(5000);

    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin soyismini giriniz");
        String istenenSoyisim = scan.nextLine();
        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println("=========AKYAR KOLEJI========\n" +
                "======= SOY ISIM İLE OGRETMEN ARAMA=========\n" +
                "TcNo      Isim       Soyisim        DogumYili        Brans     ");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            //System.out.println(eachKey+" "+eachValue);

            String eachValuearr[] = eachValue.split(", ");
            if (istenenSoyisim.equalsIgnoreCase(eachValuearr[1])) {
                System.out.printf("%11s %-6s %-8s %4s %s \n", eachKey, eachValuearr[0], eachValuearr[1], eachValuearr[2], eachValuearr[3]);
            }
        }
        Thread.sleep(5000);

    }

    public static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println("=========AKYAR KOLEJI========\n" +
                "=========OGRETMEN LISTESI=========\n" +
                "TcNo      Isim       Soyisim        DogumYili        Brans     ");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuearr = eachValue.split(", ");
            System.out.printf("%12s %-6s %-8s %4s  %s  \n", eachKey, eachValuearr[1], eachValuearr[2],eachValuearr[3],eachValuearr[4]);
        }
        Thread.sleep(5000);

    }
}
