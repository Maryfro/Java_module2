


public class Node {
    Node left;
    Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    int getVertexNumber(Node node) {
     /*  if (node.left == null && node.right == null) {
            return 1;
        }

       if(node.left == null){ //null pointer exception
           getVertexNumber(node.right);
       }

        if(node.right == null){
            getVertexNumber(node.left);
        }*/
        if (node == null) {
            return 0;
        }
        return getVertexNumber(node.left) + getVertexNumber(node.right) + 1;
    }

    int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
