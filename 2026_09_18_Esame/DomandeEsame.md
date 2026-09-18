### Me: 23
- Modellare un albero binario
    > Rispondo scrivendo un'interfaccia invece del record
- Cos'è un'interfaccia?
- Fare il diagramma oggetti riferimenti dell'albero binario (a, b, (c, a, d)) *dove è (root, left, right)*
- Immagina di istanziare l'albero all'interno di una classe main
  ```java
  BinaryTree<String> newTree = new BinaryTree("a",
    new BinaryTree("b", null, null),
    new BinaryTree("c", new BinaryTree("a", null, null), newBinaryTree("d", null, null)));
  ```
- Cos'è JRE?
- A che versione di Java siamo? Come avviene il rilascio delle versioni Java? Cos'è STL?
- Cos'è hashCode()?

### Secondo: 24 (con il progetto)
- Cos'è un generic?
- Risolto l'albero binario:
  ```java
  public record BinaryTree<T>(T label, BinaryTree<T> leftSubTree, BinaryTree<T> rightSubTree) {}
  ```
  - Come implementare l'albero binario in modo meno prolisso?
    >   Crea un costruttore aggiuntivo per creare "alberi" che sono foglie, ossia in cui left e right sono null. 
        Essendo un costruttore aggiuntivo DEVE fare uso del costruttore canonico
- Creare un metodo che permetta di restituire le foglie in ordine alfabetico?
  ```java
  public List<T> getLeaves(){
    List<T> leaves = new ArrayList<>();
    /* successivamente eliminato perché inutile
    if(label == null){ 
        return new ArrayList<>();
    }
    */
    if(leftSubTree == null && rightSubTree == null) {
        leaves.add(label);
    } else {
        leaves.add(leftSubTree.getLeaves()); //corretto poi in leaves.addAll(...)
        leaves.add(rightSubTree.getLeaves());
    }
    return leaves;
  }
  ```
- Cos'è il collection framework? Cos'è Collection?
- Scrivere la signature di add() di Collection
- Cosa c'è alla "radice" della gerarchia concettuale del collection framework?

### Terzo: 25
- Come ordinare con un ordinamento che non è l'ordinamento naturale?
- Scrivere l'interfaccia Comparator e il metodo compare()
- Scrivere la classe che implementa Comparator e che permetta di comparare alberi binari secondo l'ordinamento lessicografico
  ```java
  public class BinaryTreeComparator<T> implements Comparator<BinaryTree<T>> {
    private final Comparator<T> tComparator;
    public int compare(BinaryTree<T> firstTree, BinaryTree<T> secondTree) {
        //codice che non ho copiato
    }
  }
  ```
- Quali sono i tipi primitivi in Java e la loro dimensione?
- Dimensione massima (ordine di grandezza) dello heap? (*non credo di aver capito bene*)
- Cos'è (*in senso lato*) l'interfaccia Stream<T>? Qualche esempio di metodo di Stream<T>?