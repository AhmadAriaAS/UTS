import java.util.Scanner;

public class MainOperation {
    public static Rekening[] accounts;
    public static Transaksi[] transactions;
    private static MainTransaksi mainInstance;
    private static MainOperation instance;
    private FunctionsStorage funcs = new FunctionsStorage();
    private boolean initted = false;
    public int topTransaction = 4;
    public int topAccount = 4;

    public void init() {
        if (initted)
            return;

        accounts = new Rekening[15];
        transactions = new Transaksi[15];

        mainInstance = MainTransaksi.getInstance();
        instance = this;

        funcs.setInitialAccounts(accounts);
        funcs.setInitTransaction(transactions, accounts);
        initted = true;

    }

    public void operationHandler() {
        init();

        Scanner sc = new Scanner(System.in);

        Menus.mainMenu();
        System.out.print("Pilig (1-7): ");
        int choice = sc.nextInt();

        // 1. Tampil data rekening\n2. Tampil data transaksi\n3. Mencari saldo >
        // 500000\n4. Sort by name\n5. Input rekening Baru\n6. Tambah data transaksi\n7.
        // Keluar

        switch (choice) {
            case 1:
                Menus.printAccounts(accounts);
                this.operationHandler();
                break;
            case 2:
                Menus.getTransactions(transactions);
                this.operationHandler();
                break;
            case 3:
                Menus.getMinTransactions(transactions);
                this.operationHandler();
                break;
            case 4:
                funcs.sorter(accounts);
                this.operationHandler();
                break;
            case 5:
                funcs.addAccount(accounts);
                this.operationHandler();
                break;
            case 6:
                transactionDecider(transactions, accounts);
                this.operationHandler();
                break;
            case 7:
                System.exit(0);
                break;

            default:
                System.out.println("Maaf, pilihan tidak dapat di temukan!");
                this.operationHandler();
                break;
        }

        sc.close();
    }

    private void transactionDecider(Transaksi[] transactions, Rekening[] accounts) {
        Scanner sc = new Scanner(System.in);

        Menus.transactionDecideMenu();
        System.out.print("Pilih (1-3): ");
        int choice = sc.nextInt();

        // 1. Setor Tunai\n2. Tarik Tunai\n3. Keluar

        switch (choice) {
            case 1:
                funcs.addBalance(transactions, accounts);
                this.transactionDecider(transactions, accounts);
                break;
            case 2:
                funcs.reduceBalance(transactions, accounts);
                this.transactionDecider(transactions, accounts);
                break;
            case 3:
                this.operationHandler();
                break;

            default:
                System.out.println("Maaf, pilihan tidak dapat di temukan!");
                this.transactionDecider(transactions, accounts);
                break;
        }
    }

    public static MainOperation getInstance() {
        return instance;
    }
}
