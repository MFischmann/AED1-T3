import java.lang.reflect.Array;
import java.util.ArrayList;

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
        System.out.println("A".compareTo("B"));

        RedBlackTreeOfAluno tree = new RedBlackTreeOfAluno();
        tree.add(a1);
        tree.add(new Aluno("Bruno","bruno@gmail.com"));
        tree.add(new Aluno("Carlos","carlos@gmail.com"));
        tree.add(new Aluno("Fernanda","fe@gmail.com"));
        tree.add(new Aluno("Gabriel","gabigol@gmail.com"));
        tree.add(new Aluno("Henrique","henrique@gmail.com"));
        tree.add(new Aluno("Mariana","mari@gmail.com"));
        tree.add(new Aluno("Otavio","ota@gmail.com"));
        
        ArrayList<Aluno> listaChamada = tree.positionsCentral();
        System.out.println("Caminhamento central");
        for (Aluno aluno : listaChamada) {
            System.out.println(aluno.getNome());
        }

        listaChamada = tree.positionsPre();
        System.out.println("\nCaminhamento pre");
        for (Aluno aluno : listaChamada) {
            System.out.println(aluno.getNome());
        }

        listaChamada = tree.positionsPos();
        System.out.println("\nCaminhamento pos");
        for (Aluno aluno : listaChamada) {
            System.out.println(aluno.getNome());
        }

        listaChamada = tree.positionsWidth();
        System.out.println("\nCaminhamento largura");
        for (Aluno aluno : listaChamada) {
            System.out.println(aluno.getNome());
        }
        
        System.out.println("Num elementos arvore: "+tree.size());
        System.out.println("Altura arvore: "+tree.height());
        System.out.println(tree.contains(a1));
        System.out.println(tree.getParent(a1));
        System.out.println(tree.getAlunoFromKey("Henrique"));
        System.out.println(tree.getAlunoFromEmail("fe@gmail.com"));
    }
}