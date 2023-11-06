
public class XIAOGUO {


    private String name;

    private Integer age;

    private Integer number;

    @Override
    public String toString() {
        return "XIAOGUO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public XIAOGUO(String name, Integer age, Integer number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public XIAOGUO() {
    }


}
