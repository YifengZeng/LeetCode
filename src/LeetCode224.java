class Solution {
    public int calculate(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i++) - '0';
                }
                nums.push(n);
                i--;
            } else if (ch == '+' || ch == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    pop(stack, nums);
                }
                stack.push(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    pop(stack, nums);
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            pop(stack, nums);
        }
        return nums.pop();
    }

    private void pop(Deque<Character> stack, Deque<Integer> nums) {
        int n1 = nums.pop();
        int n2 = nums.pop();
        char op = stack.pop();
        if (op == '+') {
            nums.push(n2 + n1);
        } else if (op == '-') {
            nums.push(n2 - n1);
        }
    }
}
