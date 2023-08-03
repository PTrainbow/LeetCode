public class LeetCode208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));   // 返回 True
    }


    /**
     * 额 最初版本，只击败了 12%```
     * 使用 hashmap 存储，插入耗时，读取其实也肯定比数组耗时，看了别人的解法，直接使用 Node[26] 就可以了
     *
     * 改了 hashmap 以后提交依然只击败了 40%
     *
     * 查看耗时低的提交，发现其 Node 结构与我不同
     * 我的 Node 节点每个节点都会存储对应的字符，然后用一个 isWord 判断是否是最后一个单词字母，所以在插入时回不断赋值
     * 修改为 Node 节点内容为完整的 word String 以后，非单词节点都是是空，不需要赋值和创建字符
     *
     * 最终在当前的测试 case 下，击败了 99%，不知道为什么会差这么多
     *
     */
    static class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node tmp = root;
            for (char c: word.toCharArray()) {
                if (tmp.next[c - 'a'] == null) {
                    tmp.next[c - 'a'] = new Node();
                }
                tmp = tmp.next[c - 'a'];
            }
            tmp.val = word;
        }

        public boolean search(String word) {
            Node tmp = root;
            for (char c: word.toCharArray()) {
                Node child = tmp.next[c - 'a'];
                if (child == null) {
                    return false;
                } else {
                    tmp = child;
                }
            }
            return tmp.val != null && tmp.val.equals(word);
        }

        public boolean startsWith(String prefix) {
            Node tmp = root;
            for (char c: prefix.toCharArray()) {
                Node child = tmp.next[c - 'a'];
                if (child == null) {
                    return false;
                } else {
                    tmp = child;
                }
            }
            return true;
        }
    }

    private static class Node {
        Node[] next = new Node[26];
        String val;
    }
}
