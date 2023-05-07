import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            int num = Integer.parseInt(str);
            tree.create(num);
        }
        String postOrder = tree.postOrder(tree.root);
        System.out.println(postOrder);
    }
}

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    void create(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            search(root, data);
        }
    }

    private void search(Node node, int data) {
        if (node.data > data) {
            if (node.leftNode == null) {
                node.leftNode = new Node(data);
            } else search(node.leftNode, data);
        } else {
            if (node.rightNode == null) {
                node.rightNode = new Node(data);
            } else search(node.rightNode, data);
        }
    }

    String postOrder(Node node) {
        String str = "";
        if (node != null) {
            str += postOrder(node.leftNode);
            str += postOrder(node.rightNode);
            str += node.data;
        }
        return str.equals("") ? "" : str + "\n";
    }
}

