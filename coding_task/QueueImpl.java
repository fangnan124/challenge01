public final class QueueImpl<T> implements Queue<T> {
    private final int n;
    private final Node head;

    private final class Node implements Cloneable {
        private T item;
        private Node next;

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public QueueImpl() {
        this(null, 0);
    }

    private QueueImpl(Node head, int n) {
        this.head = head;
        this.n = n;
    }

    @SuppressWarnings("unchecked")
    public Queue<T> enQueue(T t) {
        int n = this.n + 1;
        Node head = new Node();
        Node tail = new Node();

        tail.item = t;
        tail.next = null;

        if (this.n == 0) {
            head = tail;
            return new QueueImpl<>(head, 1);
        }

        try {
            Node currentNode = (Node)this.head.clone();
            head = currentNode;

            while(currentNode.next != null){
                Node previousNode = currentNode;
                currentNode = (Node)currentNode.next.clone();
                previousNode.next = currentNode;
            }

            currentNode.next = tail;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return new QueueImpl<>(head, n);
    }

    @SuppressWarnings("unchecked")
    public Queue<T> deQueue() {
        if (this.n <= 1) {
            return new QueueImpl<>(null, 0);
        }

        int n = this.n - 1;
        Node head = new Node();

        try {
            Node currentNode = (Node)this.head.next.clone();
            head = currentNode;

            while(currentNode.next != null){
                Node previousNode = currentNode;
                currentNode = (Node)currentNode.next.clone();
                previousNode.next = currentNode;
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return new QueueImpl<>(head, n);
    }

    public T head() {
        if (this.n == 0) {
            return null;
        }
        return this.head.item;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public String toString() {
        Node currentNode = this.head;
        StringBuilder str = new StringBuilder();

        while(currentNode != null){
            str.append(currentNode.item).append(" ");
            currentNode = currentNode.next;
        }

        str.append("(").append(n).append(")");
        return new String(str);
    }
}
