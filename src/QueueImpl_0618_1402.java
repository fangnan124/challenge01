import java.util.ArrayList;
import java.util.List;

public class QueueImpl_0618_1402<T> implements Queue<T> {
    private List<T> list;

    public QueueImpl_0618_1402(List<T> list) {
        this.list = list;
    }

    public Queue<T> enQueue(T t) {
        List<T> newList = new ArrayList<>(list);
        newList.add(t);
        return new QueueImpl_0618_1402<>(newList);
    }

    public Queue<T> deQueue() {
        List<T> newList = new ArrayList<>(list);
        if (!this.isEmpty()) {
            newList.remove(0);
        }
        return new QueueImpl_0618_1402<>(newList);
    }

    public T head() {
        if (this.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
