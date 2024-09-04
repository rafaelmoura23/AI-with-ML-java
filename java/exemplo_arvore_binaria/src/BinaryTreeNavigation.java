public class BinaryTreeNavigation {
    Node node;
    // Método de travessia em pré-ordem
    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.name + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }


    // Método de travessia em pós-ordem
    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.name + " ");
        }
    }


    // Método de travessia em ordem (in-order)
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.name + " ");
            inOrderTraversal(node.right);
        }
    }
}
