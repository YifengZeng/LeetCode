class RandomizedSet {
private:

    unordered_map<int, int> map;
    vector<int> vec;

public:

    RandomizedSet() {

    }


    bool insert(int val) {
        if (map.find(val) != map.end()) {
            return false;
        }

        map[val] = vec.size();
        vec.push_back(val);
        return true;
    }


    bool remove(int val) {
        if (map.find(val) == map.end()) {
            return false;
        }

        int index = map[val];
        vec[index] = vec[vec.size() - 1];
        map[vec[vec.size() - 1]] = index;
        map.erase(val);
        // vec.erase(vec.begin() + vec.size() - 1);
        vec.pop_back();
        return true;
    }


    int getRandom() {
        int index = rand() % vec.size();
        return vec[index];
    }
};
