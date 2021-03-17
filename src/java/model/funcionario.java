
package model;

/**
 *
 * @author amaranta
 */
public class funcionario {
    
    private int id;
    private String nome;
    private String sobrenome;
    private int registro;
    private String senha;
    private String confSenha;

    /**
     * @return the registro
     */
    public int getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    public funcionario(){
        
    }
    public funcionario(int id,String nome,String sobrenome, int registro, String senha,String confSenha){
        
        this.id = id;
        this.nome=nome;
        this.sobrenome= sobrenome;
        this.registro= registro;
        this.senha= senha;
        this.confSenha=confSenha;
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
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the confSenha
     */
    public String getConfSenha() {
        return confSenha;
    }

    /**
     * @param confSenha the confSenha to set
     */
    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }
}
