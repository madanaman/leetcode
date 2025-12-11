package quest.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class unableToEatLunch {
    public int countStudents_some_test_failed(int[] students, int[] sandwiches) {
        int student_zero = 0;
        int student_one = 0;
        int sandwich_zero = 0;
        int sandwich_one = 0;
        for(int i =0;i<students.length;i++){
            if(students[i]==0){
                student_zero++;
            } else {
                student_one++;
            }
            if(sandwiches[i]==0){
                sandwich_zero++;
            } else {
                sandwich_one++;
            }
        }
        int unable_to_eat = (Math.abs(student_one-sandwich_one)) + (Math.abs(student_zero-sandwich_zero));

        return unable_to_eat;
    }
    public int countStudents_works(int[] students, int[] sandwiches) {
        int sandwich_found_idx = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int val: students){
            queue.addLast(val);
        }
        int permissiable_miss_counter = 0;
        while(permissiable_miss_counter!=queue.size()){
            if(queue.peekFirst()!=null){
                if(queue.peekFirst()==sandwiches[sandwich_found_idx]) {
                    sandwich_found_idx++;
                    permissiable_miss_counter = 0;
                    queue.pop();
                } else {
                    queue.addLast(queue.pop());
                    permissiable_miss_counter ++;
                }
            }
        }
        return queue.size();

    }
    public int countStudents(int[] students, int[] sandwiches) {
        int[] student_counters = new int[2];
        for(int student:students){
            student_counters[student]++;
        }
        for(int sand: sandwiches){
            if(student_counters[sand]==0){
                break;
            }
            student_counters[sand]--;
        }
        return student_counters[0]+student_counters[1];

    }
}
