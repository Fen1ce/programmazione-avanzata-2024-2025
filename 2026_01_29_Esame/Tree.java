/**
 * L’albero è solo un riferimento alla radice
 * Tutto il resto si raggiunge da lì.
 * @param <T>
 */

class Tree<T> {
    private Node<T> root;

    Tree(T rootValue) {
        root = new Node<>(rootValue);
    }

    public Node<T> getRoot() {
        return root;
    }
}