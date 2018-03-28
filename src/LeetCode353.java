class SnakeGame {
    // AC
    private int width;
    private int height;
    private Deque<int[]> snake;
    private Deque<int[]> foods;
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake = new ArrayDeque<>();
        snake.offerLast(new int[]{0, 0});
        // foods = new LinkedList<>();
        // for (int[] f : food) {
        //     foods.offer(f);
        // }
        foods = new LinkedList<>(Arrays.asList(food));
    }

    public int move(String direction) {
        int dir = direction.equals("U") ? 0 : direction.equals("L") ?
                  1 : direction.equals("R") ? 2 : 3;
        int[] cur = snake.peekLast();
        int[] next = new int[]{cur[0] + dx[dir], cur[1] + dy[dir]};

        if (!isInbound(next)) {
            snake.clear();
            snake.offerLast(cur);
            return -1;
        }

        snake.offerLast(next);
        if (Arrays.equals(next, foods.peek())) {
            foods.poll();
        } else {
            snake.pollFirst();
        }
        return snake.size() - 1;
    }

    private boolean isInbound(int[] next) {
        // not within the screen
        if (next[0] < 0 || height <= next[0]
            || next[1] < 0 || width <= next[1]) {
            return false;
        }

        // check if next move eats the snake body or not
        // if next location is the current tail of the snake,
        // we can still move and snake doesn't die
        if (Arrays.equals(next, snake.peekFirst())) {
            return true;
        }

        for (int[] iter : snake) {
            if (Arrays.equals(next, iter)) {
                return false;
            }
        }

        return true;
    }
}
