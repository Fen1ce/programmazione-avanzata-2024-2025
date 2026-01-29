/**
 * Modella una persona con nome e cognome.
 * Nome, cognome o entrambi possono essere lasciati in bianco (stringhe vuote)
 */

public class Person {
    private String nome;
    private String cognome;

    //Constructor
    public Person(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    //Getter & Setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        if (nome.equals("")) {
            return cognome;
        } else if (cognome.equals("")) {
            return nome;
        } else {
            return nome + " " + cognome;
        }
    }
}
