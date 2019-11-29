import java.lang.reflect.Array;
import java.util.ArrayList;

public class RedBlackTreeOfAluno{
    private RBNode root;
    private int count;
    private RBNode nill;

    private static final class RBNode{
        public RBNode father;
        public RBNode left;
        public RBNode right;
        private Aluno element;
        public boolean isBlack;

        public RBNode(Aluno element){
            father = null;
            left = null;
            right = null;
            this.element = element;
            isBlack = false;
        }
    }

    public RedBlackTreeOfAluno(){
        count = 0;
        nill = new RBNode(null);
        root = nill;
    }

    public void add(Aluno aluno){

    }

    public Aluno getParent(Aluno aluno){

    }

    public boolean contains(Aluno aluno){

    }

    public Aluno get(String nome){

    }

    public int height(){

    }

    /**
     * Retorna o numero de elementos contidos na arvore O(1)
     * @return count
     */
    public int size(){
        return count;
    }

    /**
     * Retorna se  a arvore esta vazia O(1)
     * @return true se nao ha elementos, false se houver pelo menos um
     */
    public boolean isEmpty(){
        return count == 0;
    }

    public RedBlackTreeOfAluno clone(){

    }

    public ArrayList<Aluno> positionsPre(){

    }

    public ArrayList<Aluno> positionsPos(){
        
    }

    public ArrayList<Aluno> positionsCentral(){
        
    }

    public ArrayList<Aluno> positionsWidth(){
        
    }
}