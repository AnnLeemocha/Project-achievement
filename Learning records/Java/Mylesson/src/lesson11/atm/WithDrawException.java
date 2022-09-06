package lesson11.atm;

/**
 * 自行拋出例外方式
 * 1.在自訂建立例外處理的子類中，自行繼承Exception類別
 * 2.在要丟進來的方法中，先建立例外類別後再進行拋出使用
 * 3.在要丟進來的方法中，需要再進行拋出
 * 
 * 檢查提款金額是否大於餘額
 */
/**
 * 外部類
 * 內部類方法寫入 ATM ，此外部類可刪
 */
public class WithDrawException extends Exception {

    private int amount;

    // 建構式
    WithDrawException(int amount) {
        // 呼叫 Exception 的建構式，帶參數為字串型態之錯誤資訊
        super("餘額不足");
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
