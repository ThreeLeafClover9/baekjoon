import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            list.add(arr);
        }
        tree(list);
    }

    private static void tree(List<String[]> list) {
        Tree tree = new Tree();
        for (String[] arr : list) {
            tree.create(arr[0], arr[1], arr[2]);
        }
        String preOrder = tree.preOrder(tree.root);
        System.out.println(preOrder);
        String inOrder = tree.inOrder(tree.root);
        System.out.println(inOrder);
        String postOrder = tree.postOrder(tree.root);
        System.out.println(postOrder);
    }
}

class Node {
    String data;
    Node leftNode;
    Node rightNode;

    public Node(String data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    void create(String data, String leftData, String rightData) {
        if (root == null) {
            root = new Node(data);
            if (!leftData.equals(".")) root.leftNode = new Node(leftData);
            if (!rightData.equals(".")) root.rightNode = new Node(rightData);
        } else {
            search(root, data, leftData, rightData);
        }
    }

    private void search(Node node, String data, String leftData, String rightData) {
        if (node == null) {
        } else if (node.data.equals(data)) {
            if (!leftData.equals(".")) node.leftNode = new Node(leftData);
            if (!rightData.equals(".")) node.rightNode = new Node(rightData);
        } else {
            search(node.leftNode, data, leftData, rightData);
            search(node.rightNode, data, leftData, rightData);
        }
    }

    String preOrder(Node node) {
        String str = "";
        if (node != null) {
            str += node.data;
            str += preOrder(node.leftNode);
            str += preOrder(node.rightNode);
        }
        return str;
    }

    String inOrder(Node node) {
        String str = "";
        if (node != null) {
            str += inOrder(node.leftNode);
            str += node.data;
            str += inOrder(node.rightNode);
        }
        return str;
    }

    String postOrder(Node node) {
        String str = "";
        if (node != null) {
            str += postOrder(node.leftNode);
            str += postOrder(node.rightNode);
            str += node.data;
        }
        return str;
    }
}

