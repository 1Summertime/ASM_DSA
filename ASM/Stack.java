package ASM;

class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Ngăn xếp trống");
        }
        T data = top.data;
        top = top.next;
        return data;
    }
}