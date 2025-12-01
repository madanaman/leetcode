package quest.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayWithStackOperations {
    public static List<String> buildArray(int[] target, int n) {
        int[] stream_data = new int[n];
        List<String> result = new ArrayList<String>();
        int last_target_ele=target[target.length-1];
        for(int i=0;i<n;i++){
            if (i>=last_target_ele){
                stream_data[i]=-1;
                continue;
            }
            if(Arrays.binarySearch(target,i+1)>=0){
                stream_data[i]=1;
            }

        }
        for(int num:stream_data){
            if(num==0){
                result.add("Push");
                result.add("Pop");
            }
            if(num==1){
                result.add("Push");
            }
            if(num==-1){
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1,2}, 4));
    }

}
