/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librarium.controller;

import static br.com.librarium.controller.LivroDao.TABELA_LIVRO;
import br.com.librarium.interfaces.DBModel;
import br.com.librarium.model.Exemplar;
import br.com.librarium.model.Livro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno Manha
 */
public class ExemplarDao implements DBModel{
    
    public static final int STATUS_EMPRESTADO = 1;
    public static final int STATUS_LIVRE = 0;
    public static final String TABELA_EXEMPLAR = "exemplar";
    private Connection conn;
    private Exemplar exemplar;
    private Statement stm;
    
    public ExemplarDao(Exemplar exemplar) {
        connect();
        this.exemplar = exemplar;
    }

    @Override
    public boolean editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean remover(int valor) {
      
            String sql = "delete from " + TABELA_EXEMPLAR + " where id_livro = '" + exemplar.getId_livro() + "' and status=0 limit 1";
            System.out.println("SQL "+sql);
            try {
            Statement stm = conn.createStatement();
            for(int i = 0; i < valor; i++) 
            stm.executeUpdate(sql);
            stm.close();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    


    
   
    public boolean reservar() { 
          String sql = "update " + TABELA_EXEMPLAR + " set status = '" + STATUS_EMPRESTADO + "' where status='0' and id_livro = " + exemplar.getId_livro()+ " order by id limit 1";
          
            try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public boolean devolver() { 
          String sql = "update " + TABELA_EXEMPLAR + " set status = '" + STATUS_LIVRE + "' where status='1' and id_livro = " + exemplar.getId_livro()+ " order by id limit 1";
        
         
            try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    
    @Override
    public boolean inserir() {
        String sql = "insert into " + TABELA_EXEMPLAR + " values(null, " + exemplar.getId_livro() + ", " 
                + exemplar.getStatus() + ")";
        
        try {
            stm = conn.createStatement();
            for(int i = 0; i < exemplar.getQuantidade(); i++) 
                stm.executeUpdate(sql);
            
            stm.close();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean adicionar(int q) {
        String sql = "insert into " + TABELA_EXEMPLAR + " values(null, " + exemplar.getId_livro() + ", " 
                + exemplar.getStatus() + ")";
        
        try {
            stm = conn.createStatement();
            for(int i = 0; i < q; i++) 
                stm.executeUpdate(sql);
            
            stm.close();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Object buscar(String clause) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> buscarTodos(String clause) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer countRegisters(String clause) {
        String sql = "select count(id) as count from " + TABELA_EXEMPLAR + " " + clause;
        int count = 0;

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                count = rs.getInt("count");
            }
            
            stm.close();
            rs.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return count;    }

    @Override
    public void connect() {
        try {
            conn = LibrariumDB.getConnection();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
 try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExemplarDao() {
    }
    
}
