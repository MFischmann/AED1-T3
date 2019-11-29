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

    public int size(){

    }

    public boolean isEmpty(){

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