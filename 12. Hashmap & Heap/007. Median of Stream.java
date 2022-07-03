import java.util.*;
// 295: https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {
    PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        right = new PriorityQueue<>(); // Min Heap
    }

    public void addNum(int num) {
        // Insertion
        double median = findMedian();
        if (num <= median) {
            left.add(num);
        } else {
            right.add(num);
        }

        // Balancing
        if (left.size() > right.size() + 1) {
            right.add(left.remove());
        } else if (right.size() > left.size() + 1) {
            left.add(right.remove());
        }
    }

    // Find Median -> Time = O(1)
    public double findMedian() {
        if (left.size() + right.size() == 0)
            return -1;

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else if (left.size() == right.size() + 1) {
            return left.peek();
        } else {
            return right.peek();
        }
    }
}