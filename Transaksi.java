public class Transaksi {
    private double saldo, saldoAwal, saldoAkhir, used;
    private String tanggalTransaksi, type, noAccount;
    private Transaksi instance;

    Transaksi(double saldo, double saldoAwal, double saldoAkhir, double used, String tanggalTransaksi, String type,
            String noAccount) {
        this.saldo = saldo;
        this.saldoAwal = saldoAwal;
        this.saldoAkhir = saldoAkhir;
        this.used = used;
        this.tanggalTransaksi = tanggalTransaksi;
        this.type = type;
        this.noAccount = noAccount;
        instance = this;
    }

    public Transaksi getInstance() {
        return instance;
    }

    public String[] getData() {
        String[] result = { Double.toString(this.saldo), Double.toString(this.saldoAwal),
                Double.toString(this.saldoAkhir), this.tanggalTransaksi, this.type, this.noAccount };
        return result;
    }
}
