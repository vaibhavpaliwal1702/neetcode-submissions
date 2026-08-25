class TimeMap {
    HashMap<String, List<Integer>> timestamps;
    HashMap<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timestamps.containsKey(key)) {
            timestamps.put(key, new ArrayList<>());
            values.put(key, new ArrayList<>());
        }
        timestamps.get(key).add(timestamp);
        values.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key))
            return "";
        List<Integer> times = timestamps.get(key);
        List<String> vals = values.get(key);

        int left = 0, right = times.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times.get(mid) <= timestamp) {
                resultIndex = mid; // valid candidate, but keep looking for a closer one
                left = mid + 1;
            } else {
                right = mid - 1; // too far in the future, discard
            }
        }

        return resultIndex == -1 ? "" : vals.get(resultIndex);
    }
}
