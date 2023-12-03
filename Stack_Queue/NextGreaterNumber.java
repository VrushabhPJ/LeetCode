package Stack_Queue;

import java.util.*;

public class NextGreaterNumber {
    public static ArrayList<Integer> nextGreaterNumber(List<Integer> arr, int n){
        ArrayList<Integer> ans= new ArrayList<>();
        int element, next;
        Stack<Integer> st= new Stack<>();
        st.add(arr.get(0));

        for (int i=1; i<n; i++) {
            next= arr.get(i);

            if(!st.isEmpty()) {
                element = st.pop();

                while(element < next) {
                    ans.add(next);
                    if(st.isEmpty())
                        break;
                    element= st.pop();
                }

                if(element > next) {
                    st.push(element);
                }
            }

            st.push(next);
        }
        while (!st.isEmpty()) {
            element = st.pop();
            next = -1;
            ans.add(next);
        }

        return ans;
    }
    public static void main(String[] args) {
        List<Integer> arr= Arrays.asList(11, 13, 21, 3);
        ArrayList<Integer> ans= nextGreaterNumber(arr , arr.size());
        for (Integer tmp: ans) {
            System.out.print(tmp +" ,");
        }

    }
}
