public class MainTransaksi {
    private static MainTransaksi instance;

    public static void main(String[] args) {
        instance = new MainTransaksi().setInstance();
        new MainOperation().operationHandler();
    }

    private MainTransaksi setInstance() {
        return this;
    }

    public static MainTransaksi getInstance() {
        return instance;
    }
}
