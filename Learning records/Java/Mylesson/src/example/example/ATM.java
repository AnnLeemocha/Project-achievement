package example.example;

/**
 * ■ 實作一個ATM類別
 * _ ■ -balance:int
 * _ ■ -loginSuccess:boolean
 * _ ■ -name:String
 * _ ■ -password:String
 * _ ■ +login():name:String,password:String
 * _ ■ +despoit():amount:int
 * _ ■ +withdraw():amount:int
 */

public class ATM {
    /**
     * 屬性資料
     */
    private int balance;
    private boolean loginSuccess;
    private String name;
    private String password;

    /**
     * 方法資料 - 建構式
     */
    ATM() {
        // balance=0; // 餘額
    }

    public ATM(String newName, String newPassword) {
        // if (newName != "" && newPassword.length() >= 6) { // 用scanner.next()無空字串
        if (newPassword.length() >= 6) { // 密碼>6碼
            name = newName;
            password = newPassword;
        } else {
            System.out.println("註冊失敗！");
        }
    }

    /**
     * 方法資料 - 操作
     */
    // 登錄
    public void login(String checkName, String checkPassword) {
        if (name == null && password == null) {
            System.out.println("尚未有註冊帳號！");
            return;
        }
        loginSuccess = (name.equals(checkName) && password.equals(checkPassword)) ? true : false;
        System.out.println("登入" + (loginSuccess ? "成功！" : "失敗！帳號或密碼錯誤！"));
    }

    // 登出
    public void logout() {
        loginSuccess = false;
    }

    /**
     * 資料修正 - set 系列
     */
    // 存入存款
    public void despoit(int amount) {
        if (isLogout()) {
            return;
        }
        boolean check = amount > 0;
        System.out.println(check ? "存款成功！" : "輸入錯誤，存款失敗！");
        if (check) {
            balance += amount;
            System.out.printf("存入：%d \t  目前餘額：%d\n", amount, balance);
        }

        // if (!isLogout() && amount > 0) {
        // balance += amount;
        // System.out.println("存款成功！");
        // System.out.printf("存入：%d \t 目前餘額：%d\n", amount, balance);
        // } else {
        // System.out.println("輸入錯誤，存款失敗！");
        // }
    }

    // 提出存款
    public void withdraw(int amount) {
        if (isLogout()) {
            return;
        }
        if (amount > balance) {
            System.out.printf("餘額不足，提款失敗！ (餘額：%d) < %d\n", balance, amount);
            return;
        }
        if (amount < 0) {
            System.out.println("輸入錯誤，提款失敗！");
            return;
        }

        balance -= amount;
        System.out.println("提款成功！");
        System.out.printf("提出：%d \t  目前餘額：%d\n", amount, balance);
    }

    /**
     * 資料顯示 - get 系列
     */
    // 個資顯示
    public String getInfo() {
        if (isLogout()) {
            return null;
        }
        String str = String.format("ATM{balance=%d, loginSuccess=%s, name='%s', password='%s'}", balance,
                loginSuccess, name, password);
        return str;
    }

    public boolean getloginSuccess() {
        return loginSuccess;
    }

    // 查詢餘額
    public void getBalance() {
        if (isLogout()) {
            return;
        }
        System.out.println("您的戶頭餘額為：" + balance);
    }

    /**
     * 確認登入
     * 
     * @return
     */
    // 確定登入才能執行
    public boolean isLogout() {
        if (!loginSuccess) {
            System.out.println("尚未登入...");
            return !loginSuccess;
        }
        return !loginSuccess;
    }

}
