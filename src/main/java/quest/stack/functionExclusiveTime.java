package quest.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class functionExclusiveTime {
    public int[] exclusiveTime1(int n, List<String> logs) {
        int[] result = new int[n];
        HashMap<Integer, Stack<Integer>> current_exec_logs = new HashMap<>();
        int prev_exec_time = 0;
        int prev_function_id = -1;
        String prev_state = "start";
        int last_elem_tracker = 0;
        int total_logs = logs.size();
        for(String log: logs){
            last_elem_tracker++;
            String[] parsed_log = log.split(":");/*["0:start:0"]*/
            int func_id = Integer.valueOf(parsed_log[0]);
            String state = parsed_log[1];
            int time = Integer.valueOf(parsed_log[2]);
            if (prev_function_id == -1){
                prev_function_id = func_id;
            }
            if(state.equals("start")){
                if(prev_state.equals("start")){
                    result[prev_function_id]+=(time-prev_exec_time);
                }
                current_exec_logs
                        .computeIfAbsent(func_id, k -> new Stack<>())
                        .push(time);
            }
            if(state.equals("end")){
                if(last_elem_tracker==total_logs){
                    result[func_id]+=(time-prev_exec_time);
                } else {
                    result[func_id] += (time - current_exec_logs.get(func_id).pop() + 1);
                }
            }
            prev_exec_time = time;
            prev_state=state;
        }
        return result;
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimes = new int[n];
        // Stack stores the ID of the function that is currently running
        Stack<Integer> stack = new Stack<>();

        // This tracks the timestamp of the *previous* log event processed
        int previousTimestamp = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int funcId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            // 1. Calculate time consumed by the *previous* running function(s)
            // The time duration between this current timestamp and the previous one
            // belongs entirely to the function ID at the TOP of the stack (if any).
            if (!stack.isEmpty()) {
                // Add the elapsed time since the last log entry to the current top function's total
                exclusiveTimes[stack.peek()] += (timestamp - previousTimestamp);
            }

            // 2. Update the stack state based on the current log entry
            if (type.equals("start")) {
                stack.push(funcId);
            } else {
                // If it's an "end" event, this function has finished. Pop it off the stack.
                stack.pop();
                // A function's "end" log uses 1 unit of time *at that timestamp*.
                // We add that single unit here because the main loop handles intervals.
                exclusiveTimes[funcId] += 1;
            }

            // 3. Update the tracker for the next iteration
            // The timestamp for the NEXT calculation starts from *after* this current event finishes.
            if (type.equals("start")) {
                // The *actual work* for a start log begins at this timestamp
                previousTimestamp = timestamp;
            } else {
                // The *actual work* for an end log finishes *after* this timestamp is consumed
                previousTimestamp = timestamp + 1;
            }
        }

        return exclusiveTimes;
    }
}
