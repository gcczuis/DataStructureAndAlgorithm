package dataStructure.segmentTree;

public class Main {
    public static void main(String[] args){
        Integer[] arr = {0,2,3,4,2,4,5,6,7,8};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree);
        Integer query = segmentTree.query(3, 5);
        System.out.println(query);
    }
}
