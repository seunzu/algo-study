package silver;

import java.io.*;
import java.util.*;

// 트리 순회
class Node {
    char val;
    Node lt, rt;

    public Node(char val) {
        this.val = val;
    }
}

public class boj_1991 {
    static Map<Character, Node> tree = new HashMap<>();
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    static void preOrder(Node root) {
        if (root == null) return;
        pre.append(root.val);
        preOrder(root.lt);
        preOrder(root.rt);
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.lt);
        in.append(root.val);
        inOrder(root.rt);
    }

    static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.lt);
        postOrder(root.rt);
        post.append(root.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);

            tree.putIfAbsent(root, new Node(root));
            Node cur = tree.get(root);

            if (lt != '.') {
                tree.putIfAbsent(lt, new Node(lt));
                cur.lt = tree.get(lt);
            }

            if (rt != '.') {
                tree.putIfAbsent(rt, new Node(rt));
                cur.rt = tree.get(rt);
            }
        }

        Node rootNode = tree.get('A');
        preOrder(rootNode);
        inOrder(rootNode);
        postOrder(rootNode);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
