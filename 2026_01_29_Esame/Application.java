public class Application {
    public static void main(String[] args) {
        Tree<Person> alberoPersone = new Tree<>(new Person("Alberto", ""));
        System.out.println("The root person is " + alberoPersone.getRoot().getValue());
        alberoPersone.getRoot().addChild(new Node<> (new Person ("Gigi", "")));
        System.out.printf("The child of %s is %s.%n",
                alberoPersone.getRoot().getValue(),
                alberoPersone.getRoot().getChild(0).getValue());
        alberoPersone.getRoot().getChild(0).addChild(new Node<> (new Person ("Pino", "")));
        System.out.printf("The child of %s is %s.%n",
                alberoPersone.getRoot().getChild(0).getValue(),
                alberoPersone.getRoot().getChild(0).getChild(0).getValue());
    }
}
