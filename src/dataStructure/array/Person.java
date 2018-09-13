package dataStructure.array;

public class Person {
    private int age;
    private String addr;
    private String name;

    public Person(int age, String addr, String name) {
        this.age = age;
        this.addr = addr;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", addr='" + addr + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public static void main(String[] args){
        Array<Person> array = new Array<>();
        array.addLast(new Person(10,"ssss","gcc"));
        array.addLast(new Person(20,"ssss","gcc"));
        array.addLast(new Person(30,"ssss","gcc"));
        array.addLast(new Person(40,"ssss","gcc"));
        array.addLast(new Person(10,"ssss","gcc"));
        array.addLast(new Person(20,"ssss","gcc"));
        array.addLast(new Person(30,"ssss","gcc"));
        array.addLast(new Person(40,"ssss","gcc"));
        array.addLast(new Person(10,"ssss","gcc"));
        array.addLast(new Person(20,"ssss","gcc"));
        array.addLast(new Person(30,"ssss","gcc"));
        array.addLast(new Person(40,"ssss","gcc"));
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        array.removeLast();
        System.out.println(array);


    }
}
