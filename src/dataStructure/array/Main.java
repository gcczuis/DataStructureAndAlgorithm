package dataStructure.array;

public class Main {
    public static void main(String[] args){
        Array array = new Array();
        for (int i = 0; i < array.getCapacity()-2; i++){
            array.addLast(1);
        }
        array.add(1,2);
        System.out.println(array.toString());
    }
}
