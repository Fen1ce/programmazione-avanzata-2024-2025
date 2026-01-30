%%Si erano iscritti sia Bikli e Paola lol%%

Primo esaminando:
- Cos'è Java RE
	> Da definizione di Java RE. Parla poi di JVM e javac. javac sta fuori da JRE
-  Mi può menzionare uno strumento che uno sviluppatore contemporaneo utilizza ma che non sta dentro JDK
	> Parla di IDE. Incalzato *io direi gli strumenti di build automation come Maven o Gradle*
- Cos'è **abstract**
	> Da definizione di **abstract**: keyword per definire classi e metodi astratti. *Io direi "modificatore di visibilità"*. Da menzionare che quando si estende una classe abstract È OBBLIGATORIO effettuare l'override dei metodi abstract
- VERO o FALSO: ogni classe che estende una classe astratta DEVE dare una definizione per tutti i metodi astratti di una classe astratta?
	> FALSO perché se la classe figlia è astratta anch'essa può evitare di ridefinire i metodi astratti
	> Sarebbe stato VERO nel caso di una classe *non-astratta* perché i metodi astratti non hanno corpo e quindi DEVONO essere ridefiniti (*override*)
	
- Chiede di costruire una classe che modella un albero (**Tree**), non per forza binario. I nodi devono essere etichettati con la tipologia prescritta (esempio: ogni nodo deve contenere un oggetto **Person**). La classe deve avere il metodo **costruttore** e il metodo **toString()**.
  Fornito albero: Person alberto -> Person gigi -> Person pino
  
  Modo banale:
  ```
  public record Tree<T>(T label, List<Tree<T>> children)
  ```