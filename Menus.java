public class Menus {
        public static void mainMenu() {
                System.out.println(
                                "1. Tampil data rekening\n2. Tampil data transaksi\n3. Mencari saldo > 500000\n4. Sort by name\n5. Input rekening Baru\n6. Tambah data transaksi\n7. Keluar");
        }

        public static void printAccounts(Rekening[] accounts) {
                System.out.printf(
                                "--------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf(
                                "|                                                             Rekening                                                                     |%n");
                System.out.printf(
                                "--------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-14s | %-15s | %-30s | %-20s | %-45s | %n", "No.Rekening", "Nama", "Nama Ibu",
                                "Phone",
                                "Email");
                System.out.printf(
                                "--------------------------------------------------------------------------------------------------------------------------------------------%n");

                for (Rekening rekening : accounts) {
                        if (rekening == null)
                                continue;

                        String[] data = rekening.getData();

                        System.out.printf("| %-13s | %-15s | %-30s | %-20s | %-45s | %n", data[0], data[1], data[2],
                                        data[3],
                                        data[4]);

                }

                System.out.printf(
                                "--------------------------------------------------------------------------------------------------------------------------------------------%n");
        }

        public static void getTransactions(Transaksi[] transactions) {
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf(
                                "|                                                             Transaksi                                                                                           |%n");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-14s | %-15s | %-30s | %-20s | %-45s | %-20s | %n", "No.Rekening", "Saldo",
                                "Saldo Awal",
                                "Nominal",
                                "Tanggal Transaksi", "Tipe");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");

                for (int i = 0; i < transactions.length; i++) {
                        if (transactions[i] == null)
                                continue;

                        String[] dataTransactions = transactions[i].getData();

                        System.out.printf("| %-13s | %-15s | %-30s | %-20s | %-45s | %-20s | %n",
                                        dataTransactions[dataTransactions.length - 1],
                                        dataTransactions[0], dataTransactions[1],
                                        dataTransactions[2],
                                        dataTransactions[3], dataTransactions[4]);
                }

                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        }

        public static void getMinTransactions(Transaksi[] transactions) {
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf(
                                "|                                                             Transaksi                                                                    |%n");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| %-14s | %-15s | %-30s | %-20s | %-45s | %-20s | %n", "No.Rekening", "Saldo",
                                "Saldo Awal",
                                "Nominal",
                                "Tanggal Transaksi", "Tipe");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");

                for (int i = 0; i < transactions.length; i++) {
                        if (transactions[i] == null)
                                continue;

                        String[] dataTransactions = transactions[i].getData();

                        if (Double.parseDouble(dataTransactions[0]) < 500000)
                                continue;

                        System.out.printf("| %-13s | %-15s | %-30s | %-20s | %-45s | %-20s | %n",
                                        dataTransactions[dataTransactions.length - 1],
                                        dataTransactions[0], dataTransactions[1],
                                        dataTransactions[2],
                                        dataTransactions[3], dataTransactions[4]);
                }

                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");

        }

        public static void transactionDecideMenu() {
                System.out.println("1. Setor Tunai\n2. Tarik Tunai\n3. Keluar");
        }
}
