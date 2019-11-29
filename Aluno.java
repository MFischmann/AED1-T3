import java.util.HashMap;
import java.util.Map;

public class Aluno{
    private String nome;
    private String email;
    private HashMap<String, Double> notas;
    
    public Aluno(String nome, String email){
        this.nome = nome;
        this.email = email;
        notas = new HashMap<>();
    }

    /**
     * @return nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return email do aluno
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email o email para substituir
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adiciona nota para o aluno
     * @param nomeNota chave do mapa
     * @param nota valor obtido pelo aluno
     * @return true se adicionou a nota, false se já existia nota com a chave
     */
    public boolean addNota(String nomeNota, double nota){
        if(notas.containsKey(nomeNota)){
            System.out.println("Nota ja foi adicionada previamente ao sistema.");
            return false;
        }
        notas.put(nomeNota, nota);
        return true;
    }
    /**
     * Muda nota de uma prova/trabalho p aluno
     * @param nomeNota chave da nota
     * @param nota nova nota
     * @return true se troca feita com sucesso, false se nao existia a nota
     */
    public boolean setNota(String nomeNota, double nota){
        if(notas.containsKey(nomeNota)){
            double oldNota = notas.put(nomeNota, nota);
            System.out.println("Nota "+nomeNota+" alterada de "+oldNota+" para "+nota);
            return true;
        }
        System.out.println("Nota nao existe no sistema.");
        return false;
    }

    /**
     * @return nota de uma prova/trabalho
     */
    public double getNota(String nomeNota) {
        if(notas.containsKey(nomeNota)){
            return notas.get(nomeNota);
        }
        else{
            throw new IllegalArgumentException("Nao existe nota para este trabalho/prova.");
        }
    }

    public double getMedia(){
        double somaNota = 0;
        for (Map.Entry<String,Double> entry : notas.entrySet()) {
            Double value = entry.getValue();
            somaNota = somaNota + value;
        }          
        Double notaMedia = somaNota/notas.size();
        return notaMedia;
    }

    public boolean alunoAprovado(){
        return getMedia() >= 7;
    }
}