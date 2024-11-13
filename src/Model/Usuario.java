/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec-dsm2
 */
public class Usuario {
    
    private int codigo;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String acesso;
    
    Conexao con = new Conexao();

    public Usuario() {
        this(0, "", "", "", "", "");
    }

    public Usuario(int codigo, String nome, String email, String login, String senha, String acesso) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.acesso = acesso;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
    
    public void cadastrarUsuario(){
        String sql = "Insert into usuarios (nome, email, login, senha, acesso) values " +
                "('" + getNome() + "','" + getEmail() + "','" + getLogin() + "','" + getSenha() + "', '" + getAcesso() + "' )";
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registrado com sucesso!");  
    }
    
    public ResultSet listarUsuario(){
       ResultSet tabela;
       tabela = null;
        
        String sql= "Select * from usuarios";
        tabela = con.RetornarResultset(sql);
     return tabela;
    }
    
    public void excluirUsuario(){
        String sql;
        sql = "Delete from usuarios where id_usuario = " + getCodigo();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
    }
    
    public void editarUsuario(){
        String sql;
        sql = "Update usuarios set nome = '" + getNome() + "', email = '" + getEmail()
                + "', login = '" + getLogin() + "', senha = '" + getSenha()
                + "', acesso = '" + getAcesso() + "' where id_usuario = " + getCodigo();
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
    }
    
    public ResultSet logar()
      {
          ResultSet tabela;
          tabela = null;

           String sql = "select * from usuarios where email= '" + getEmail() + "' and senha= '" + getSenha() + "' " ;
            tabela= con.RetornarResultset(sql);  
            return tabela;
      }
}
