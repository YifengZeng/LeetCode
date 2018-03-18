class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int n = 0;
                while (Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i) - '0';
                    i++;
                }
                nums.push(n);
                i--;
            } else if (ch == '[') {
                stack.push(ch);
            } else if (ch ==']') {
                pop(stack, nums.isEmpty() ? 1 : nums.pop());
            } else if (Character.isLetter(ch)) {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private void pop(Deque<Character> stack, int n) {
        List<Character> helper = new ArrayList<>();
        while (!stack.isEmpty() && stack.peek() != '[') {
            helper.add(stack.pop());
        }
        stack.pop();
        for (int i = 0; i < n; i++) {
            for (int j = helper.size() - 1; j >= 0; j--) {
                stack.push(helper.get(j));
            }
        }
    }
}
