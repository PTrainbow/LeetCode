import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode295 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }

    /**
     * 击败 5.3%```
     * 原来是在考察最大堆```
     */
    static class MedianFinder {
        List<Integer> data = new ArrayList<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
           for (int i = 0; i< data.size();i++) {
               if (data.get(i) > num) {
                   data.add(i, num);
                   return;
               }
           }
           data.add(num);
        }

        public double findMedian() {
            if (data.size() % 2 == 0) {
                return (data.get(data.size() / 2) + data.get(data.size() / 2 - 1)) * 1.0f / 2;
            } else {
                return data.get(data.size() / 2) * 1.0f;
            }
        }
    }

}