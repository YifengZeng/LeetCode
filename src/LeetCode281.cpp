class ZigzagIterator {

private:
    vector<int> v1;
    vector<int> v2;
    int i1;
    int i2;

public:
    ZigzagIterator(vector<int>& v1, vector<int>& v2) {
        this->v1 = v1;
        this->v2 = v2;
        i1 = 0;
        i2 = 0;
    }

    int next() {
        return (i1 < v1.size() && i1 <= i2 || i2 == v2.size()) ?
                v1[i1++] : v2[i2++];
    }

    bool hasNext() {
        return i1 < v1.size() || i2 < v2.size();
    }
};
