public class ZigzagIterator {

    private int i1;
    private int i2;
    private List<Integer> v1;
    private List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = 0;
        i2 = 0;
        this.v1 = new ArrayList<>(v1);
        this.v2 = new ArrayList<>(v2);
    }

    public int next() {
        if (i1 < v1.size() && i1 <= i2 || i2 == v2.size()) {
            return v1.get(i1++);
        } else {
            return v2.get(i2++);
        }
    }

    public boolean hasNext() {
        return i1 < v1.size() || i2 < v2.size();
    }
}
