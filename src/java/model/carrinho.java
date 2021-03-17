
package model;
/**
 *
 * @author amaranta
 */
public class carrinho {

   private int id; 
   private String produto;
   private int qntdd;
   private double valor; 
   private String emailCli; 
   private double total;
   
   public carrinho(){
        
    }
    public carrinho(int id, String produto, int qntdd, double valor, String emailCli, double total){
        this.id=id;
        this.produto=produto;
        this.qntdd= qntdd;
        this.valor=valor;
        this.emailCli=emailCli;
    }
    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the qntdd
     */
    public int getQntdd() {
        return qntdd;
    }

    /**
     * @param qntdd the qntdd to set
     */
    public void setQntdd(int qntdd) {
        this.qntdd = qntdd;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the emailCli
     */
    public String getEmailCli() {
        return emailCli;
    }

    /**
     * @param emailCli the emailCli to set
     */
    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }
 
    
}