class Solution {
    // AC
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftH = height[i];
            int leftIndex = i;
            for (int left = i - 1; left >= 0; left--) {
                if (height[left] > leftH) {
                    leftH = height[left];
                    leftIndex = left;
                }
            }
            int rightH = height[i];
            int rightIndex = i;
            for (int right = i + 1; right < height.length; right++) {
                if (height[right] > rightH) {
                    rightH = height[right];
                    rightIndex = right;
                }
            }
            int h = height[i];
            sum += Math.max(Math.min(leftH, rightH) - h, 0);
        }

        return sum;
    }
}



class Solution {
    // AC
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            sum += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }
}




class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int i = 0;
        int j = height.length - 1;
        int sum = 0;

        while (i <= j) {
            if (left < right) {
                sum += Math.max(0, left - height[i]);
                left = Math.max(left, height[i]);
                i++;
            } else {
                sum += Math.max(0, right - height[j]);
                right = Math.max(right, height[j]);
                j--;
            }
        }
        return sum;
    }
}




class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int cur = height[i];
            System.out.println(stack.toString());
            while (!stack.isEmpty() && height[stack.peek()] <= cur) {
                int h = height[stack.pop()];
                int index = stack.isEmpty() ? -1 : stack.peek();
                int left = index == -1 ? 0 : height[index];
                int w = i - index - 1;
                sum += Math.max(0, Math.min(left, cur) - h) * w;
            }
            stack.push(i);
        }
        return sum;
    }
