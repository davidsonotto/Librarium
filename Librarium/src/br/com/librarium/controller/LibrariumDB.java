/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librarium.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Vinícius Brás de Oliveira
 */
public class LibrariumDB {
    

    
    private static  String DRIVER;
    // Identificação do driver do banco de dados
    private static  String USER ; 
    // Usuário do banco de dados
    private static  String PASSWORD ; 
    // Senha do banco de dados
    private static  String IP;
    // IP do banco de dados
    private static  String DATABASE;
    // Nome do banco de dados
    private static  String PORTA ;
    //Numero da porta
    private static  String STR_CON;
    // Endereço completo da conexão

  public static void carregaBD(){
      String[] banco= new String[5];
      try{
        Scanner in = new Scanner(new FileReader("banco.txt")); 
        int i = 0;
        while (in.hasNextLine()) {            
        String line = in.nextLine();
        banco[i]= line;
        System.out.println(banco[i]);
        i++;
    }
    }catch(FileNotFoundException e){
        JOptionPane.showMessageDialog(null,"Arquivo do banco de dados inexistente.");
    }
    DRIVER = "com.mysql.jdbc.Driver";
    // Identificação do driver do banco de dados
    USER = banco[0]; 
    // Usuário do banco de dados
    PASSWORD = banco[1]; 
    // Senha do banco de dados
    IP = banco[2];
    // IP do banco de dados
    DATABASE = banco[3];
    // Nome do banco de dados
    PORTA = banco[4];
    //Numero da porta
    STR_CON = "jdbc:mysql://" + IP + ":"+PORTA+"/" + DATABASE;
  }
 
    
    public static Connection getConnection() throws SQLException {
        carregaBD();
	Connection conn = null;
	try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            return conn;
	} catch (ClassNotFoundException e) {
            String errorMsg = "Driver não encontrado";
            throw new SQLException(errorMsg, e);
	} catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexão";
            throw new SQLException(errorMsg, e);
	}
    }	
}
