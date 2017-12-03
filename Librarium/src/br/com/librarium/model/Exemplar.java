package br.com.librarium.model;




/**
 *
 * @author Aluno Manha
 */

public class Exemplar  {
    public static final int STATUS_ATIVO = 1;
    public static final int STATUS_INATIVO = 0;
    
   
    private int idEexemplar;
    
    private int status;
    
    private int id_livro;    
    
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 

    public Exemplar() {
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdEexemplar() {
        return idEexemplar;
    }

    public void setIdEexemplar(int idEexemplar) {
        this.idEexemplar = idEexemplar;
    }

    public Exemplar(int id_livro) {
       
        this.id_livro = id_livro;
       
    }
    
}

