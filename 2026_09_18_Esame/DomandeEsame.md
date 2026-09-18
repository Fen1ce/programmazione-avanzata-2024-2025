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

### Secondo:
- Cos'è un generic?
- Risolto l'albero binario:
  ```java
  public record BinaryTree<T>(T root, BinaryTree<T> left, BinaryTree<T> right) {}
  ```
- Come implementare l'albero binario in modo meno prolisso?
    > Crea un costruttore aggiuntivo per creare "alberi" che sono foglie, ossia in cui left e right sono null. 
    > Essendo un costruttore aggiuntivo DEVE fare uso del costruttore canonico
- Creare un metodo che permetta di restituire le foglie in ordine alfabetico?
  ```java
  public List<T> getLeaves(){
    List<T> leaves = new ArrayList<>();
    if(label == null) 
        return new ArrayList<>();
    }
    if(leftSubTree == null && rightSubTree == null) {
        leaves.add(label);
    } else {
        leaves.add(leftSubTree.getLeaves())
        leaves.add(rightSubTree.getLeaves())
    }
    return leaves;
  }
  ```
- Cos'è il collection framework? Cos'è Collection?
- Scrivere la signature di add() di Collection