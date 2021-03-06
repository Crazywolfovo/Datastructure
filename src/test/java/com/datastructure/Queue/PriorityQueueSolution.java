package com.datastructure.Queue;
/// 347. Top K Frequent Elements
/// https://leetcode.com/problems/top-k-frequent-elements/description/

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class PriorityQueueSolution {

    private class Freq implements Comparable<Freq> {

        int e, freq;

        Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            return Integer.compare(another.freq, this.freq);
        }
    }

    private List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k)
                pq.enqueue(new Freq(key, map.get(key)));
            else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }

    private void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    @Test
    public void test() {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new PriorityQueueSolution()).topKFrequent(nums, k));
    }
}
