package leetCode.collisionPointer.threeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这道题的难点在于排除重复的组合
 * 当排序完成后可能会出现-8,-2,-2,-1,-1,0,1,1,2,3,3,4
 * 假设现在遍历的元素是第一个-2,在找到右边所有和-2组合的二元集A={[-2,-2,4];[-2,1,1];[-2,0,2]}之后,
 * 此时到了第二个-2
 * 策略一：直接忽略这个-2，直接到-1，因为第二个-2和第一个-2重复，第二个-2和其之后的
 *        满足条件的二元组组合一定在集合A中形成重复。
 * 策略二：不寻找当前遍历元素之前的元素，什么意思呢，假设我当前元素是-2，所以我应该在-2之后的集合中寻找符合条件的
 *        二元组，因为在当前元素是-8的时候，已经找到了所有包含-8的满足条件的三元组，所以如果当前元素是-2的时候找到
 *        的满足条件的三元组包含-8，那么一定和之前的三元组重复了。
 * 策略三：在二元组中找到满足的解后，忽略相同的二元解。我们遍历二元集的方法是指针碰撞，所以当前元素是-2时，找到了第一个
 *        二元解[-1,3]然后指针start++，end--,此时指针需要忽略相同的元素，在当前数据下忽略3，因为和倒数第二个3重复,
 *        此时如果不忽略，则相当于若此时有解则三元解必含有-2,3这俩元素，肯定和前面找到的解重复。
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> rets = new ArrayList<>();
        Arrays.sort(nums);
        int lastNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {//由于只在当前遍历元素后面寻找三元集所以，元素后面至少得有俩元素
            if(nums[i] == lastNum) continue;
            int resSum = 0 - nums[i];
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] < resSum) start ++;
                else if(nums[start] + nums[end] > resSum) end --;
                else {
                    List<Integer> ret = Arrays.asList(nums[i], nums[start], nums[end]);
                    rets.add(ret);
                    while(start < end){
                        if(nums[start] == nums[start + 1]) start ++;
                        if(nums[end] == nums[end - 1]) end --;
                        if(start < end && nums[start] != nums[start + 1] && nums[end] != nums[end - 1]){
                            start ++;
                            end --;
                            break;
                        }
                    }
                }
            }
            lastNum = nums[i];
        }
        return rets;
    }

  /*  public static void main(String[] args){
        int[] nums = {2,1,4,-1,-5,0,1,-2};
        List<List<Integer>> lists = threeSum(nums);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));

        }
    }*/

}
