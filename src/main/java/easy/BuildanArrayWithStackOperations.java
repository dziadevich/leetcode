package easy;

import java.util.ArrayList;
import java.util.List;

public class BuildanArrayWithStackOperations {
    public static void main(String[] args) {
        System.out.println(BuildanArrayWithStackOperations.buildArray(new int[]{1,3}, 3));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList();
        //if a number is missing push diff times and pop diff times.
        int index=0,num=1;
        while(index<target.length){
            //If number is missing then,
            if(num<target[index]){
                int no_of_miss=target[index]-num;
                while(no_of_miss-->0){
                    res.add("Push");
                    res.add("Pop");
                }
                num=target[index];
            }
            //Else,push and go to next index
            else{
                res.add("Push");
                num++;index++;
            }

        }
        return res;
    }
}
