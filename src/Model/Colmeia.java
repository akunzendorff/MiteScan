/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec-dsm2
 */
public class Colmeia {
    private int codigo;
    private String nome;
    private String locLat;
    private String locLong;
    private String tamanho;
    private String tipoAbelha;
    
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    Conexao con = new Conexao();

    public Colmeia() {
        this(0, "", "", "", "", "");
    }

    public Colmeia(int codigo, String nome, String locLat, String locLong, String tamanho, String tipoAbelha) {
        this.codigo = codigo;
        this.nome = nome;
        this.locLat = locLat;
        this.locLong = locLong;
        this.tamanho = tamanho;
        this.tipoAbelha = tipoAbelha;
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
        String oldNome = this.nome;
        this.nome = nome;
        support.firePropertyChange("nome", oldNome, nome);
    }

    public String getLocLat() {
        return locLat;
    }

    public void setLocLat(String locLat) {
        this.locLat = locLat;
    }

    public String getLocLong() {
        return locLong;
    }

    public void setLocLong(String locLong) {
        this.locLong = locLong;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipoAbelha() {
        return tipoAbelha;
    }

    public void setTipoAbelha(String tipoAbelha) {
        this.tipoAbelha = tipoAbelha;
    }
    
    public void cadastrarColmeia(){
        String sql = "Insert into colmeias (id_colmeia, nome, locLat, locLong, tamanho, id_abelha) values " +
                "(" + getCodigo() + ",'" + getNome() + "','" + getLocLat()
                + "','" + getLocLong() + "','" + getTamanho() + "', " + getTipoAbelha() + " )";
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registrado com sucesso!");  
    }
    
    public ResultSet listarColmeia(){
       ResultSet tabela;
       tabela = null;
        
        String sql= "Select * from colmeias";
        tabela = con.RetornarResultset(sql);
     return tabela;
    }
    
    public void excluirColmeia(){
        String sql;
        sql = "Delete from colmeias where id_colmeia = " + getCodigo();
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
    }
    
    public void editarColmeia(){
        String sql;
        sql = "Update colmeias set nome = '" + getNome() + "', loclat = '" + getLocLat()
                + "', loclong = '" + getLocLong() + "', tamanho = '" + getTamanho()
                + "', id_abelha = " + getTipoAbelha() + " where id_colmeia = " + getCodigo();
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
    }
    
    public String buscarNome(){
        String sql;
        sql = "select nome from colmeias";
        
        con.executeSQL(sql);
        return "";
    }
   
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    
    public ArrayList carregarColmeias(){
       ArrayList<String> colmeias = new ArrayList<>();
        try{
            ResultSet rs;
            String sql = "select nome from colmeias";
            rs = con.RetornarResultset(sql);
            
            if(rs.first()){
                colmeias.add(rs.getString("nome"));
                
                while(rs.next()) colmeias.add(rs.getString("nome"));
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar cidades: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return colmeias;
    }
    
    public HashMap colmeiasUsuario(Integer idUsuario) throws SQLException{
        ResultSet rs;
        String sql = "select \n" +
            "    a.id_analise,\n" +
            "    u.id_usuario,\n" +
            "    c.id_colmeia,\n" +
            "    c.nome as nome_colmeia,\n" +
            "    c.locLat,\n" +
            "    c.locLong,\n" +
            "    ab.id_abelha,\n" +
            "    ab.nome as nome_abelha \n" +
            "from \n" +
            "    Usuarios u\n" +
            "join \n" +
            "    Analises a on u.id_usuario = a.id_usuario\n" +
            "join \n" +
            "    Colmeias c on a.id_colmeia = c.id_colmeia\n" +
            "join \n" +
            "    Abelhas ab on c.id_abelha = ab.id_abelha\n" +
            "where \n" +
            "    u.id_usuario = " + idUsuario;
        
        rs = con.RetornarResultset(sql);
        
        HashMap<String, String> dadosColmeia = new HashMap();
        
        if(rs.first()){
            dadosColmeia.put("nome_colmeia", rs.getString("nome_colmeia"));
            dadosColmeia.put("localizacao", rs.getString("locLat") + rs.getString("locLong"));
            dadosColmeia.put("nome_abelha", rs.getString("nome_abelha"));
            
            while(rs.next()){
                dadosColmeia.put("nome_colmeia", rs.getString("nome_colmeia"));
                dadosColmeia.put("localizacao", rs.getString("locLat") + rs.getString("locLong"));
                dadosColmeia.put("nome_abelha", rs.getString("nome_abelha"));
            }
        } 
        
        System.out.println(dadosColmeia);
        
        return dadosColmeia;
        
    }
    
}
