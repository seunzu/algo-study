package tree;

import java.io.*;
import java.util.*;

// 트리 순회
class Node {
    char val;
    Node lt, rt;

    public Node(char val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}

public class boj_1991 {
    static Node[] tree = new Node[26];
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void preOrder(Node root) {
        if (root == null) return;
        pre.append(root.val);
        preOrder(root.lt);
        preOrder(root.rt);
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.lt);
        in.append(root.val);
        inOrder(root.rt);
    }

    public static void postOrder(Node root) {
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

            if (tree[root - 'A'] == null) tree[root - 'A'] = new Node(root);
            Node cur = tree[root - 'A'];

            if (lt != '.') {
                tree[lt - 'A'] = new Node(lt);
                cur.lt = tree[lt - 'A'];
            }

            if (rt != '.') {
                tree[rt - 'A'] = new Node(rt);
                cur.rt = tree[rt - 'A'];
            }
        }

        Node rootNode = tree[0];
        preOrder(rootNode);
        inOrder(rootNode);
        postOrder(rootNode);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
