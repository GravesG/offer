package com.gzt.nowcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MadianQuick {

    /*public static class MedianHolder {
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());

        private void modifyTwoHeapsSize() {
            if (this.maxHeap.size() == this.minHeap.size() + 2) {
                this.minHeap.add(this.maxHeap.poll());
            }
            if (this.minHeap.size() == this.maxHeap.size() + 2) {
                this.maxHeap.add(this.minHeap.poll());
            }
        }

        public Integer getMedian() {
            //获取两个堆的大小
            int maxHeapSize = this.maxHeap.size();
            int minHeapSize = this.minHeap.size();
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            Integer maxHeapHead = this.maxHeap.peek();
            Integer minHeapHead = this.minHeap.peek();
            if (((maxHeapSize + minHeapSize) & 1) == 0) {
                return (maxHeapHead + minHeapHead) / 2;
            }
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }

    }
    }


    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }*/
}
