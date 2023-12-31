public class Queue {
    LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(Car elem) {
        list.insertAtBack(elem);
    }

    public Car dequeue() {
        return list.removeFront();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
