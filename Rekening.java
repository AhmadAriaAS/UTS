public class Rekening {
    private String noRekening, nama, namaIbu, Phone, Email;
    private Rekening instance;

    Rekening(String noRekening, String nama, String namaIbu, String Phone, String Email) {
        this.noRekening = noRekening;
        this.nama = nama;
        this.namaIbu = namaIbu;
        this.Phone = Phone;
        this.Email = Email;
        this.instance = this;
    }

    public Rekening getInstance() {
        return instance;
    }

    public String[] getData() {
        String[] result = { this.noRekening, this.nama, this.namaIbu, this.Phone, this.Email };
        return result;
    }
}