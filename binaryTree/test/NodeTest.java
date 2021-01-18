import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getVertexNumber_singleRoot() {
        Node node = new Node(null, null);
        assertEquals(1, node.getVertexNumber(node));
    }

    @Test
    void getVertexNumber_RootWithOneLeaf() {
        Node node = new Node(new Node(null, null), null);
        assertEquals(2, node.getVertexNumber(node));
    }

    @Test
    void getVertexNumber_severalVertices() {
        Node nine = new Node(null, null);
        Node eight = new Node(nine, null);
        Node seven = new Node(null, null);
        Node six = new Node(seven, eight);
        Node five = new Node(null, six);
        Node one = new Node(null, null);
        Node three = new Node(null, null);
        Node two = new Node(one, three);
        Node root = new Node(two, five);
        assertEquals(9, root.getVertexNumber(root));
    }

    @Test
    void getVertexNumber_severalVertices1() {
        Node eight = new Node(null, null);
        Node five = new Node(null, null);
        Node seven = new Node(five, eight);
        Node three = new Node(null, null);
        Node four = new Node(null, three);
        Node root = new Node(four, seven);
        assertEquals(6, root.getVertexNumber(root));
    }

    @Test
    void getHeight_singleRoot() {
        Node node = new Node(null, null);
        assertEquals(1, node.getHeight(node));
    }

    @Test
    void getHeight_RootWithOneLeaf() {
        Node node = new Node(new Node(null, null), null);
        assertEquals(2, node.getVertexNumber(node));
    }

    @Test
    void getHeight_severalVertices() {
        Node nine = new Node(null, null);
        Node eight = new Node(nine, null);
        Node seven = new Node(null, null);
        Node six = new Node(seven, eight);
        Node five = new Node(null, six);
        Node one = new Node(null, null);
        Node three = new Node(null, null);
        Node two = new Node(one, three);
        Node root = new Node(two, five);
        assertEquals(5, root.getHeight(root));
    }

    @Test
    void getHeight_severalVertices1() {
        Node eight = new Node(null, null);
        Node five = new Node(null, null);
        Node seven = new Node(five, eight);
        Node three = new Node(null, null);
        Node four = new Node(null, three);
        Node root = new Node(four, seven);
        assertEquals(3, root.getHeight(root));
    }
}
