package lesson9.animal;

public class NewAniimal extends Object {
    public static final int MALE = 0;
    final public static int FEMALE = 1;

    public String name2;
    private String name;
    private double weight;
    // private static int count;
    protected int sex; // 子類可使用
    int sex2;

    // VSCODE
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public NewAniimal() {
    }

    // Java Code Generators
    public NewAniimal(String name2, String name, double weight, int sex, int sex2) {
        this.name2 = name2;
        this.name = name;
        this.weight = weight;
        this.sex = sex;
        this.sex2 = sex2;
    }

    public String getName2() {
        return this.name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex2() {
        return this.sex2;
    }

    public void setSex2(int sex2) {
        this.sex2 = sex2;
    }

    public NewAniimal name2(String name2) {
        setName2(name2);
        return this;
    }

    public NewAniimal name(String name) {
        setName(name);
        return this;
    }

    public NewAniimal weight(double weight) {
        setWeight(weight);
        return this;
    }

    public NewAniimal sex(int sex) {
        setSex(sex);
        return this;
    }

    public NewAniimal sex2(int sex2) {
        setSex2(sex2);
        return this;
    }

    // @Override
    // public boolean equals(Object o) {
    // if (o == this)
    // return true;
    // if (!(o instanceof NewAniimal)) {
    // return false;
    // }
    // NewAniimal newAniimal = (NewAniimal) o;
    // return Objects.equals(name2, newAniimal.name2) && Objects.equals(name,
    // newAniimal.name) && weight == newAniimal.weight && sex == newAniimal.sex &&
    // sex2 == newAniimal.sex2;
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(name2, name, weight, sex, sex2);
    // }

    @Override
    public String toString() {
        return "{" +
                " name2='" + getName2() + "'" +
                ", name='" + getName() + "'" +
                ", weight='" + getWeight() + "'" +
                ", sex='" + getSex() + "'" +
                ", sex2='" + getSex2() + "'" +
                "}";
    }

}
