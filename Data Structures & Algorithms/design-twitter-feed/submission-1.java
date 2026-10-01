class Twitter {
    public HashMap<Integer, List<int[]>> newsFeed = new HashMap<Integer, List<int[]>>();
    public HashMap<Integer, Set<Integer>> FolUnFol = new HashMap<Integer, Set<Integer>>();
    public int time = 0;
    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        if (!newsFeed.containsKey(userId)) {
            newsFeed.put(userId, new ArrayList<>());
        }
        newsFeed.get(userId).add(new int[] {tweetId, time});
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Step 1: this user's own tweets go into the heap
        for (int[] t : newsFeed.getOrDefault(userId, new ArrayList<>())) {
            pq.add(t);
        }

        // Step 2: every followee's tweets go into the heap too
        for (int followeeId : FolUnFol.getOrDefault(userId, new HashSet<>())) {
            for (int[] t : newsFeed.getOrDefault(followeeId, new ArrayList<>())) {
                pq.add(t);
            }
        }

        // Step 3: pull out the top 10 most recent, by tweetId only
        List<Integer> res = new ArrayList<>();
        int count = 0;   
        while (count < 10 && pq.size() > 0) {
            res.add(pq.poll()[0]);
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!FolUnFol.containsKey(followerId)) {
            FolUnFol.put(followerId, new HashSet<>());
        }
        FolUnFol.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (FolUnFol.containsKey(followerId)) {
            FolUnFol.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}
