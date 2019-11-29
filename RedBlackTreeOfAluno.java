import java.lang.reflect.Array;
import java.util.ArrayList;

public class RedBlackTreeOfAluno{
    private RBNode root;
    private int count;
    private RBNode nil;

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
            isBlack = false; //inicia vermelho
        }

        public String getKey(){
            return element.getNome();
        }

        public boolean isRed(){
            return !isBlack;
        }
    }

    public RedBlackTreeOfAluno(){
        count = 0;
        nil = new RBNode(null);
        root = nil;
        root.isBlack = true;
    }

    public void add(Aluno aluno){
        RBNode z = new RBNode(element);
        RBNode y = nil;
        RBNode x = root;
        while(x!=nil){
            y = x;
            if(z.getKey().compareTo(x.getKey())<0){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        z.father = y;
        if(y==nil){
            root = z;
        }
        else if(z.getKey().compareTo(y.getKey())<0){
            y.left = z;
        }
        else{
            y.right = z;
        }
        z.left = nil;
        z.right = nil;
        count++; //finaliza posicionamento novo nodo
        addFixer(z);
    }

    private void addFixer(RBNode z){
        RBNode aunt;
        while(z.father.isRed()){ //enquanto pai do nodo analisado for vermelho
            if(z.father==z.father.father.left){
                aunt = z.father.father.right;
                if(aunt.isRed()){
                    z.father.isBlack = true;
                    aunt.isBlack = true;
                    z.father.father.isBlack = false;
                    z = z.father.father;
                }
                else if(z==z.father.right){//triangulo
                    z = z.father;
                    leftRotate(z);
                }
                z.father.isBlack = true;
                z.father.father.isBlack = false;
                rightRotate(z.father.father);
            }
            else{
                aunt = z.father.father.left;
                if(aunt.isRed()){
                    z.father.isBlack = true;
                    aunt.isBlack = true;
                    z.father.father.isBlack = false;
                    z = z.father.father;
                }
                else if(z==z.father.left){
                    z = z.father;
                    rightRotate(z);
                }
                z.father.isBlack = true;
                z.father.father.isBlack = false;
                leftRotate(z.father.father);
            }
        } 
        root.isBlack = true;
    }
    private void leftRotate(RBNode x){
        RBNode y = x.right;
        x.right = y.left;
        if(y.left!=nil){
            y.left.father = x;
        }
        y.father = x.father;
        if(x.father==nil){
            root = y;
        }
        else if(x == x.father.left){
            x.father.left = y;
        }
        else{
            x.father.right = y;
        }
        y.left = x;
        x.father = y;
    }

    private void rightRotate(Node x){
        RBNode y = x.left;
        x.left = y.right;
        if(y.right!=nil){
            y.right.father = x;
        }
        y.father = x.father;
        if(x.father==nil){
            root = y;
        }
        else if(x == x.father.right){
            x.father.right = y;
        }
        else{
            x.father.left = y;
        }
        y.right = x;
        x.father = y;
    }
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