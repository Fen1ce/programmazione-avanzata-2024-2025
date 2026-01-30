/**
 * Una classe per modellare la radice di albero.
 * Contiene solo un riferimento al nodo che funge da radice.
 */
class Tree<T> {
    private Node<T> root;

    /**
     * Costruisce un nuovo albero a partire dal nodo {@code rootvalue} che funge da radice.
     *
     * @param rootValue Riferimento al nodo che funge da radice dell'albero.
     */
    Tree(T rootValue) {
        root = new Node<>(rootValue);
    }

    /**
     * Restituisce il riferimento al nodo che funge da radice dell'albero.
     *
     * @return Nodo radice dell'albero.
     */
    public Node<T> getRoot() {
        return root;
    }
}