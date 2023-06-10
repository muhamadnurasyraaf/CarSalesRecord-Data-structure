public class Node {
    public Car data;
    public Node next;

    public Node(Car c) {
        this.data = c;
        this.next = null;
    }

    public Node(Car c, Node nextNode) {
        this.data = c;
        this.next = nextNode;
    }

    public Car getContestant() {
        return data;
    }

    public Node getLink() {
        return next;
    }
}