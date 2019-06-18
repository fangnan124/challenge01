import java.util.*;

public final class QueueImpl<T> implements Queue<T> {
    private final int n;
    private final Node first;
    private final Node last;

    private class Node implements Cloneable {
        private T item;
        private Node next;

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public QueueImpl() {
        this(null, null, 0);
    }

//    @SuppressWarnings("unchecked")
//    private QueueImpl(Node first, int n) {
//        if (n > 0) {
//            try {
//                this.first = (Node)first.clone();
//
//                Node preNode = this.first;
//                Node curNode = preNode.next;
//
//                while(curNode != null){
//                    preNode.next = (Node)curNode.clone();
//                    curNode = curNode.next;
//                }
//
//                this.last = preNode;
//                this.n = n;
//            } catch (CloneNotSupportedException e) {
//                e.printStackTrace();
//            }
//        } else {
//            this.first = null;
//            this.last = null;
//            this.n = 0;
//        }
//    }

    private QueueImpl(Node first, Node last, int n) {
        this.first = first;
        this.last = last;
        this.n = n;
    }

    @SuppressWarnings("unchecked")
    public Queue<T> enQueue(T t) {
        int n = this.n + 1;
        Node first = new Node();
        Node last = new Node();

        last.item = t;
        last.next = null;

        if (this.isEmpty()) {
            first = last;
        } else {
            try {
                first = (Node)this.first.clone();

                Node preNode = first;
                Node curNode = preNode.next;

                while(curNode != null){
                    preNode.next = (Node)curNode.clone();
                    curNode = curNode.next;
                }

                preNode.next = last;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return new QueueImpl<>(first, last, n);
    }

    public Queue<T> deQueue() {
        List<T> newList = new ArrayList<>(list);
        if (!this.isEmpty()) {
            newList.remove(0);
        }
        return new QueueImpl<>(newList);
    }

    public T head() {
        if (this.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return n == 0;
    }
}
