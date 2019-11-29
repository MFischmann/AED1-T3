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
    /**
     * Busca folha para adicionar elemento. O(log(n))
     * @param aluno aluno a ser adicionado
     */
    public void add(Aluno aluno){
        RBNode z = new RBNode(aluno);
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
    /**
     * Rebalanceia a arvore apos a adicao de novo nodo O(log(n))
     * @param z o nodo recentemente adicionado
     */
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

    private void rightRotate(RBNode x){
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
    /**
     * Metodo privado auxiliar para localizar nodo que contem elemento target O(log(n))
     * @param aux Nodo a ser pesquisado
     * @param target elemento a ser localizado
     * @return o Nodo que contem o elemento ou null se nao localizar
     */
    private RBNode searchNodeRef(RBNode aux, Aluno target){
        RBNode result = null;
        if(aux !=nil){
            if(aux.element.equals(target)){
                result = aux;
            }
            else if(aux.getKey().compareTo(target.getNome())<0){
                result = searchNodeRef(aux.left, target);
            }
            else{
                result = searchNodeRef(aux.right, target);
            }
        }
        return result;
    }
    /**
     * Busca elemento dentro do nodo pai de um elemento escolhido O(log(n))
     * @param aluno elemento escolhido
     * @return Aluno de nodo pai de aluno ou null se elemento aluno nao encontrado ou raiz
     */
    public Aluno getParent(Aluno aluno){
        RBNode aux = searchNodeRef(root, aluno);
        if(aux!=null && aux.father!=null){
            return aux.father.element;
        }
        return null;
    }
    /**
     * Metodo para ver se Aluno aluno esta dentro da arvore
     * @param aluno a ser procurado
     * @return true se estiver contido, false se nao
     */
    public boolean contains(Aluno aluno){
        if(searchNodeRef(root, aluno)!=null){
            return true;
        }
            return false;
    }

    public Aluno get(String nome){
        //TODO
    }
    /**
     * Retorna a altura da arvore. Deve chamar um metodo auxiliar recursivo.
     * @return altura da arvore
     */
    public int height(){
        int h;
        if(root == null){
            h = -1;
        }
        else{
            h = heightAux(root)-1;
        }
        return h;
    }

    private int heightAux(RBNode aux){
        int hAuxL = 0;
        int hAuxR = 0;
        if(aux.left != nil){
            hAuxL = heightAux(aux.left);
        }
        if(aux.right != nil){
            hAuxR = heightAux(aux.right);
        }

        if(hAuxL > hAuxR){
            return 1 + hAuxL;
        }
        return 1 + hAuxR;
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
        //TODO
    }
    /**
     * Retorna lista de elementos atraves de caminhamento pre-ordenado O(n)
     * @return lista com Alunos
     */
    public ArrayList<Aluno> positionsPre(){
        ArrayList<Aluno> lst = new ArrayList<>();
        positionsPreAux(root, lst);
        return lst;
    }

    private void positionsPreAux(RBNode n, ArrayList<Aluno> lst){
        if(n!=nil){
            lst.add(n.element);
            positionsPreAux(n.left, lst);
            positionsPreAux(n.right, lst);
        }
    }
    /**
     * Retorna lista de elementos atraves de caminhamento pos-ordenado O(n)
     * @return lista com Alunos
     */
    public ArrayList<Aluno> positionsPos(){
        ArrayList<Aluno> lst = new ArrayList<>();
        positionsPosAux(root, lst);
        return lst;
    }
    private void positionsPosAux(RBNode n, ArrayList<Aluno> lst){
        if(n!=nil){
            positionsPosAux(n.left, lst);
            positionsPosAux(n.right, lst);
            lst.add(n.element);
        }
    }

    /**
     * Retorna lista de elementos atraves de caminhamento central O(n)
     * @return lista com Alunos
     */
    public ArrayList<Aluno> positionsCentral(){
        ArrayList<Aluno> lst = new ArrayList<>();
        positionsCentralAux(root, lst);
        return lst;
    }
    private void positionsCentralAux(RBNode n, ArrayList<Aluno> lst){
        if(n!=nil){
            positionsCentralAux(n.left, lst);
            lst.add(n.element);
            positionsCentralAux(n.right, lst);
        }
    }
    public ArrayList<Aluno> positionsWidth(){
        //TODO
    }
}