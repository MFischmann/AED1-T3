public class App{
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Alvaro", "alvaro@bol.com.br");
        a1.addNota("P1", 6);
        a1.addNota("P2", 7);
        a1.addNota("P1", 8);
        System.out.println(a1.getNota("P2"));
        System.out.println(a1.alunoAprovado());
        System.out.println(a1.getMedia());
        a1.setNota("P2", 8);
        System.out.println(a1.getNota("P2"));
        System.out.println(a1.alunoAprovado());
        System.out.println(a1.getMedia());
        System.out.println(a1);
    }
}