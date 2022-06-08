import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            ArrayList<Akun> akuns = new ArrayList<>();
            akuns.add(new Akun("0213456", "Susi", 100000));
            akuns.add(new Akun("0314865", "Budi", 50000));
            Akun loggedIn = akuns.get(0);
            String menu;
            do{
                System.out.println("Menu : ");
                System.out.println("1. Transfer");
                System.out.println("2. Cek Mutasi");
                System.out.println("3. Keluar");
                System.out.println("Pilih : ");
                menu = in.next();
                switch (menu){
                    case "1":
                        System.out.print("Masukkan nomor rekening tujuan (0213456 / 0314865): ");
                        String nomorRekening = in.next();
                        for(Akun akun : akuns){
                            if(akun.nomorRekening.equals(nomorRekening)){
                                if(akun==loggedIn){
                                    System.out.println("Tidak bisa mengirim pada akun yang sendiri\n");
                                }else{
                            System.out.print("Masukkan jumlah uang yang dikirim : ");
                            int jumlah = in.nextInt();
                            if(jumlah>loggedIn.saldo){
                                System.out.println("Saldo tidak cukup\n");
                                    }else{
                                        System.out.print("Masukkan berita acara : ");
                                        String beritaAcara = in.next();
                                        loggedIn.saldo-=jumlah;
                                        loggedIn.logs.add(new Log(akun, beritaAcara, jumlah, "mentransfer"));
                                        akun.saldo+=jumlah;
                                        akun.logs.add(new Log(loggedIn, beritaAcara, jumlah, "ditransfer"));
                                        System.out.println("Saldo "+loggedIn.nama+" : "+loggedIn.saldo);
                                        System.out.println("Saldo "+akun.nama+" : "+akun.saldo+"\n");
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    case "2":
                        for(Log log : loggedIn.logs){
                            System.out.println(log.akun.nama);
                            System.out.println(log.akun.nomorRekening);
                            System.out.println("Rp. " + log.jumlah);
                            System.out.println(log.beritaAcara);
                            System.out.println(log.tipe);
                        }
                        break;
                }
            }while (!menu.equals("3"));
        }
    }
}
