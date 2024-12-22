class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) {
        this.data = data;
    }
}
class CircularDoublyLinkedList {
    private Node head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    // Метод для добавления строки в упорядоченный список
    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            // Если список пуст, добавляем первый элемент
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node current = head;
            // Найти позицию для вставки
            do {
                if (newNode.data.length() < current.data.length() ||
                        (newNode.data.length() == current.data.length() && newNode.data.compareTo(current.data) < 0)) {
                    // Вставляем перед текущим элементом
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;

                    if (current == head) {
                        head = newNode;
                    }
                    return;
                }
                current = current.next;
            } while (current != head);

            // Если не нашли подходящее место, добавляем в конец
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
        }
    }

    // Метод для просмотра списка
    public void display() {
        if (head == null) {
            System.out.println("Список пуст.");
            return;
        }
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != head);
    }
}
public class List {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.add("apple");
        list.add("banana");
        list.add("kiwi");
        list.add("grape");
        list.add("pear");

        System.out.println("Содержимое списка:");
        list.display();

        // Добавление новой строки
        list.add("apricot");

        System.out.println("Содержимое списка после добавления 'apricot':");
        list.display();
    }
}