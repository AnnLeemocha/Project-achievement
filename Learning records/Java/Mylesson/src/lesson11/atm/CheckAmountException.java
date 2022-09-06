package lesson11.atm;

/**
 * 外部類
 * 內部類方法寫入 ATM ，此外部類可刪
 */
public class CheckAmountException extends Exception {

    int amount;

    CheckAmountException(int amount) {
        super("金額不能輸入零或負數");
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
