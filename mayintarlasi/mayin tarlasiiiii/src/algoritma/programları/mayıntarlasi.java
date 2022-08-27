package algoritma.programları;
import java.util.Random;
import java.util.Scanner;
public class mayıntarlasi {
    int boyut = 0;
    int[][] dizi;
    public void OyunuBaslat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("bir değer giriniz");
        boyut = Integer.parseInt(scanner.nextLine());
        Random rnd = new Random();
        dizi = new int[boyut][boyut];
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                int randomsayi = rnd.nextInt(10);
                if (randomsayi < 5) {
                    dizi[i][j] = 1;
                } else {
                    dizi[i][j] = 0;
                }
            }
        }
        MatrisiYazdir();

        OUTER:
        while (true) {
            if (KontrolEt()) {
                System.out.println("Başardınız tebrikler");
                break;
            }
            int x = Integer.parseInt(scanner.nextLine());
            int y = Integer.parseInt(scanner.nextLine());
            switch (dizi[x][y]) {
                case 1:
                    System.out.println("patlıyorsunuz");
                    break OUTER;
                case 2:
                    System.out.println("Bu seçimi kullandınız");
                    break;
                default:
                    dizi[x][y] = 2;
                    break;
            }
        }
    }

    void MatrisiYazdir() {
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                System.out.print(String.valueOf(dizi[i][j]));
            }
            System.out.println();
        }
    }

    boolean KontrolEt() {
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if (dizi[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
