import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class FunctionsStorage {

    public DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void setInitialAccounts(Rekening[] accounts) {
        accounts[0] = new Rekening(randomAccountNumber(), "Dadang", "Tukimah", "421-42143-321",
                "dadangsolid123@vmail.com");
        accounts[1] = new Rekening(randomAccountNumber(), "Tarno", "Imah", "32141-4125136", "tarno542@outlock.com");
        accounts[2] = new Rekening(randomAccountNumber(), "Kiman", "Tuminah", "3214-421512-515151",
                "kiman258@vmail.com");
        accounts[3] = new Rekening(randomAccountNumber(), "Asep", "Tatik", "32141-232", "asep24324@vmail.com");
        accounts[4] = new Rekening(randomAccountNumber(), "Ujang", "Sarminah", "3214-23453", "ujang5223@outlock.com");

    }

    public void setInitTransaction(Transaksi[] transactions, Rekening[] accounts) {
        transactions[0] = new Transaksi(1500000, 1000000, 1500000, 500000, "4/2/2023", "Setor",
                getRandomAccount(accounts));
        transactions[1] = new Transaksi(450000, 650000, 450000, 200000, "5/2/2023", "Tarik Tunai",
                getRandomAccount(accounts));
        transactions[2] = new Transaksi(890000, 750000, 890000, 140000, "1/2/2023", "Setor",
                getRandomAccount(accounts));
        transactions[3] = new Transaksi(1120000, 800000, 1120000, 320000, "12/3/2023", "Setor",
                getRandomAccount(accounts));
        transactions[4] = new Transaksi(762000, 550000, 762000, 212000, "15/3/2023", "Setor",
                getRandomAccount(accounts));
    }

    public int searchIndexAccount(String target, Rekening[] data) {
        MainOperation mo = MainOperation.getInstance();
        int resultIndex = -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null)
                continue;

            String[] result = data[i].getData();

            if (result[0].equalsIgnoreCase(target)) {
                resultIndex = i;
                break;
            }
        }

        return resultIndex;
    }

    public int searchIndexTrans(String target, Transaksi[] data) {
        MainOperation mo = MainOperation.getInstance();
        int resultIndex = -1;

        for (int i = mo.topTransaction; i > 0; i--) {
            if (data[i] == null)
                continue;

            String[] result = data[i].getData();

            if (result[result.length - 1].equalsIgnoreCase(target)) {
                resultIndex = i;
                break;
            }
        }

        return resultIndex;
    }

    public void addBalance(Transaksi[] transactions, Rekening[] accounts) {
        MainOperation mo = MainOperation.getInstance();

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nomor rekening: ");
        String accountNumber = sc.nextLine();

        int searchResult = searchIndexAccount(accountNumber, accounts);

        if (searchResult == -1) {
            System.out.println("Nomor rekening tidak ditemukan!");
            return;
        }

        mo.topTransaction++;

        int indexTransaction = searchIndexTrans(accountNumber, transactions);

        if (indexTransaction == -1) {
            // System.out.print("Masukkan Saldo Awal: ");
            // double balance = sc.nextDouble();

            System.out.print("Masukkan Jumlah Setoran: ");
            double used = sc.nextDouble();

            Date currentDate = new Date();
            String dateTrans = dateFormat.format(currentDate);

            String type = "Setor";

            transactions[mo.topTransaction] = new Transaksi(used, used, used, used, dateTrans, type, accountNumber);
        } else {
            String[] currentTransaction = transactions[indexTransaction].getData();

            System.out.print("Masukkan Jumlah Setoran: ");
            double used = sc.nextDouble();

            Date currentDate = new Date();
            String dateTrans = dateFormat.format(currentDate);

            String type = "Setor";

            transactions[mo.topTransaction] = new Transaksi((used + Double.parseDouble(currentTransaction[0])),
                    Double.parseDouble(currentTransaction[0]), used, used, dateTrans, type, accountNumber);
        }

        System.out.println("Transaksi Berhasil");
    }

    public void reduceBalance(Transaksi[] transactions, Rekening[] accounts) {
        MainOperation mo = MainOperation.getInstance();

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nomor rekening: ");
        String accountNumber = sc.nextLine();

        if (searchIndexAccount(accountNumber, accounts) == -1) {
            System.out.println("Nomor rekening tidak ditemukan!");
            return;
        }

        mo.topTransaction++;

        int indexTransaction = searchIndexTrans(accountNumber, transactions);

        if (indexTransaction == -1) {
            System.out.print("Anda tidak dapat mengurangi rekening dengan saldo 0");
            return;
        } else {
            String[] currentTransaction = transactions[indexTransaction].getData();

            System.out.print("Masukkan jumlah penarikan: ");
            double used = sc.nextDouble();

            Date currentDate = new Date();
            String dateTrans = dateFormat.format(currentDate);

            String type = "Tarik Tunai";

            transactions[mo.topTransaction] = new Transaksi((Double.parseDouble(currentTransaction[0]) - used),
                    Double.parseDouble(currentTransaction[0]), used, used, dateTrans, type, accountNumber);
        }

        System.out.println("Transaksi Berhasil");

    }

    public void addAccount(Rekening[] accounts) {
        MainOperation mo = MainOperation.getInstance();

        Scanner sc = new Scanner(System.in);

        String noRekening, nama, mom, Phone, Email;
        noRekening = randomAccountNumber();

        for (Rekening rekening : accounts) {
            String[] data = rekening.getData();

            if (data[0].equalsIgnoreCase(noRekening))
                noRekening = randomAccountNumber();

            else {
                break;
            }

        }

        mo.topAccount++;

        System.out.print("Masukkan nama: ");
        nama = sc.nextLine();

        System.out.print("Masukkan nama ibu: ");
        mom = sc.nextLine();

        System.out.print("Masukkan nomor hp: ");
        Phone = sc.nextLine();

        System.out.print("Masukkan email: ");
        Email = sc.nextLine();

        accounts[mo.topAccount] = new Rekening(noRekening, nama, mom, Phone, Email);

        System.out.println("Penambahan Rekening Berhasil");
    }

    private String getRandomAccount(Rekening[] data) {
        Random rn = new Random();
        int randomNumb = rn.nextInt(data.length);
        boolean isNotNull = false;

        for (; !isNotNull;) {
            if (data[randomNumb] == null)
                randomNumb = rn.nextInt(data.length);

            else {
                break;
            }
        }

        String[] result = data[randomNumb].getData();

        return result[0];
    }

    private String randomAccountNumber() {
        String result = "";
        Random rn = new Random();

        for (int i = 0; i < 13; i++) {
            if (i == 13 - 4) {
                result += " ";
            }

            int x = rn.nextInt(0, 9);

            result += x;
        }

        return result;
    }

    public void sorter(Rekening[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null)
                continue;

            for (int j = i; j < data.length; j++) {
                if (data[j] == null)
                    continue;

                String[] currentDataI = data[i].getData();
                String[] currentDataJ = data[j].getData();

                if (currentDataJ[1].charAt(0) <= currentDataI[1].charAt(0)) {
                    Rekening temp = data[i];

                    data[i] = data[j];
                    data[j] = temp;
                }

            }
        }

        Menus.printAccounts(data);

    }
}
