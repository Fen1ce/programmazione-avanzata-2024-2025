import java.util.ArrayList;
import java.util.List;

/**
 * Un nodo contiene nodi dello stesso tipo.
 * È questo che crea l’albero.
 * Ogni figlio è:
 * - radice di un sottoalbero
 * - con la stessa struttura del padre
 * @param <T>
 */

class Node<T> {
    private T value;
    private List<Node<T>> children;

    Node(T value) { //perché il costruttore di Node<T> ha la maiuscola?
        this.value = value;
        this.children = new ArrayList<>();
    }

    void addChild(Node<T> child) {
        children.add(child);
    }

    /*
    Node<T> addChild(T value) {
        Node<T> child = new Node<>(value);
        children.add(child);
        return child;
    }
     */

    T getValue() {
        return value;
    }
    Node<T> getChild(int index) {
        return children.get(index);
    }
}