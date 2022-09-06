package lesson9.animal;

public class Fox extends Animal {
    /*
     * 子類別實體化後會先呼叫父類別的建構式
     * 如果沒有指定呼叫哪個父類別建構式則會
     * 自動呼叫無參數建構式為主，
     * 透過super()關鍵字
     */
    public Fox(String name, double weight) {
        super(name, weight);
    }
}
