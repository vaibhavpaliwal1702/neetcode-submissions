class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // Step 1: count how many times each letter appears
        for (char c : tasks) {
            freq[c - 'A'] += 1;   // BLANK 1
        }

        // Step 2: find the single highest count (this is what built the A-skeleton)
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);      // BLANK 2
        }

        // Step 3: count how many letters tied for that highest count
        // (in our A×3,B×1,C×2 example this was 1 — only A hit max 3;
        //  in A×3,B×3 it was 2, both tied at max 3)
        int numMax = 0;
        for (int f : freq) {
            if (f == maxFreq) numMax++;  // BLANK 3
        }

        // Step 4: the skeleton length — (maxFreq-1) full gaps of size (n+1),
        // plus numMax for the final row of tied-max tasks that need no trailing gap
        int skeleton = (maxFreq-1)*(n+1) + numMax;     // BLANK 4, using maxFreq, n, numMax

        // Step 5: if there are enough other tasks to fill every gap with room
        // to spare, the real answer is just the total task count instead
        return Math.max(tasks.length, skeleton);
    }
}