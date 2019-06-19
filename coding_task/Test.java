public class Test {
    public static void main(String [] args) {
        Queue<String> queue1 = new QueueImpl<>();
        queue1 = queue1.enQueue("a").enQueue("b");
        Queue<String> queue2 = queue1.enQueue("c").enQueue("d");
        System.out.println(queue1.toString());
        System.out.println(queue2.toString());
        queue1 = queue1.deQueue();
        queue2 = queue2.deQueue().deQueue().deQueue().deQueue().deQueue();
        System.out.println(queue1.toString());
        System.out.println(queue2.toString());
        System.out.println(queue2.head());
        System.out.println(queue2.isEmpty());
    }
}
