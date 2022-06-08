import java.util.ArrayList;

public class Akun {
    String nomorRekening, nama;
    int saldo;
    ArrayList<Log> logs;
    public Akun(String nomorRekening, String nama, int saldo) {
        this.nomorRekening = nomorRekening;
        this.nama = nama;
        this.saldo = saldo;
        this.logs = new ArrayList<>();
    }
}