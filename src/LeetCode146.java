import java.util.*;

public class LeetCode146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.print();
//
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.print();

        System.out.println(lRUCache.get(1));   // 返回 1
        lRUCache.print();

//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.print();
//
//        System.out.println(lRUCache.get(2));  // 返回 -1 (未找到)
//        lRUCache.print();
//
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.print();
//
//        System.out.println(lRUCache.get(1));  // 返回 -1 (未找到)
//        lRUCache.print();
//
//        System.out.println(lRUCache.get(3));  // 返回 3
//        lRUCache.print();
//
//        System.out.println(lRUCache.get(4));   // 返回 4
//        lRUCache.print();
    }

    static class CacheItem {
        int value;
        int key;
        CacheItem next, pre;
    }

    /**
     * LinkedHashMap
     */
    static class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int maxSize = 0;

        public LRUCache2(int capacity) {
            super(capacity);
            maxSize = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > maxSize;
        }
    }

    /**
     * 当然可以使用 LinkedHashMap, 但是那样就没意义了
     * 此处考察双向链表操作
     * removeTail 的时候第一遍写错了
     */
    static class LRUCache {
        private int max_size = 0;
        private int cur_size = 0;
        private CacheItem head = new CacheItem(), tail = new CacheItem();

        private HashMap<Integer, CacheItem> data = new HashMap<>();

        public LRUCache(int capacity) {
            max_size = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            CacheItem item = data.get(key);
            if (item == null) {
                return -1;
            } else {
                moveToHead(item);
                return item.value;
            }
        }

        public void put(int key, int value) {
            CacheItem cache = data.get(key);
            if (cache == null) {
                if (cur_size + 1 > max_size) {
                    data.remove(removeTail().key);
                }
                CacheItem newItem = new CacheItem();
                newItem.value = value;
                newItem.key = key;
                data.put(key, newItem);
                insertToHead(newItem);
            } else {
                cache.value = value;
                moveToHead(cache);
            }
        }

        private CacheItem removeTail() {
            CacheItem removed = tail.pre;
            removeCache(removed);
            cur_size--;
            return removed;
        }

        private void insertToHead(CacheItem newItem) {
            CacheItem next = head.next;
            head.next = newItem;
            newItem.pre = head;
            newItem.next = next;
            next.pre = newItem;
            cur_size++;
        }

        private void moveToHead(CacheItem newItem) {
            removeCache(newItem);
            insertToHead(newItem);
        }

        private void removeCache(CacheItem newItem) {
            newItem.pre.next = newItem.next;
            newItem.next.pre = newItem.pre;
        }

        private void print() {
            CacheItem tmp = head.next;
            while (tmp != tail) {
                System.out.println(tmp.key + "=" + tmp.value);
                tmp = tmp.next;
            }
            System.out.println("===============");
        }
    }

}
