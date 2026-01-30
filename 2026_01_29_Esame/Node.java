import java.util.ArrayList;
import java.util.List;

/**
 * Una classe per modellare un nodo di un albero contenente un certo valore {@code <T>} a piacere e i riferimenti ai nodi figli.
 * Un nodo contiene nodi dello stesso tipo.
 */
class Node<T> {
    private T value;
    private List<Node<T>> children;

    /**
     * Costruisce un nuovo nodo con il {@code value} fornito come valore.
     *
     * @param value Il valore del nodo. Può essere un tipo primitivo oppure un oggetto.
     */
    Node(T value) { //perché il costruttore di Node<T> ha la maiuscola?
        this.value = value;
        this.children = new ArrayList<>();
    }

    /**
     * Aggiunge il nodo figlio {@code child} al nodo padre sul quale il metodo è stato invocato.
     *
     * @param child Nuovo nodo figlio. Il tipo del valore di questo nodo dovrebbe essere il medesimo di quello del nodo padre.
     */
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

    /**
     * Restituisce il valore del nodo sul quale il metodo è stato invocato.
     *
     * @return Valore del nodo.
     */
    T getValue() {
        return value;
    }

    /**
     * Restituisce l'i-esimo nodo figlio del nodo padre sul quale il metodo è stato invocato.
     *
     * @param index Indice dell'i-esimo nodo figlio.
     * @return I-esimo nodo figlio.
     */
    Node<T> getChild(int index) {
        return children.get(index);
    }
}