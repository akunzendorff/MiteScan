/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Conexao;
import View.Colmeias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec-dsm2
 */
public class Colmeia {
    private int codigo;
    private String nome;
    private String localizacao;
    private String cidade;
    private String tamanho;
    private String tipoAbelha;
    
    Conexao con = new Conexao();

    public Colmeia() {
        this(0, "", "", "", "", "");
    }

    public Colmeia(int codigo, String nome, String localizacao, String cidade, String tamanho, String tipoAbelha) {
        this.codigo = codigo;
        this.nome = nome;
        this.localizacao = localizacao;
        this.cidade = cidade;
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
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
    
    public void cadastrarColmeia(Integer idUsuario) throws SQLException{
        int idAbelha = 0;
        ResultSet rs;
        String sqlIdAbelha = "select * from abelhas where nome = '" + getTipoAbelha() + "'";
        
        rs = con.RetornarResultset(sqlIdAbelha);
        
        if(rs.first()){
            idAbelha = rs.getInt("id_abelha");
        }
        
        String sql = "Insert into colmeias (id_colmeia, nome, localizacao, cidade, tamanho, id_usuario, id_abelha) values " +
                "(" + getCodigo() + ",'" + getNome() + "',' " + getLocalizacao() +"', '" + getCidade() + "', '" + getTamanho() + "', " + idUsuario + ", " + idAbelha + " )";
        
        con.executeSQL(sql); 
    }
    
    public ResultSet listarColmeia(){
       ResultSet tabela;
       tabela = null;
        
        String sql= "Select * from colmeias";
        tabela = con.RetornarResultset(sql);
     return tabela;
    }
    
    public void excluirColmeia(int idColmeia){
        String sqlAnalise = "Delete from analises where id_colmeia = " + idColmeia;
        con.executeSQL(sqlAnalise);
        
        String sql;
        sql = "Delete from colmeias where id_colmeia = " + idColmeia;
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
        
        Colmeias colm = new Colmeias();
        colm.setVisible(true);
    }
    
    public void editarColmeia() throws SQLException{
        int idAbelha = 0;
        ResultSet rs;
        String sqlIdAbelha = "select * from abelhas where nome = '" + getTipoAbelha() + "'";
        
        rs = con.RetornarResultset(sqlIdAbelha);
        
        if(rs.first()){
            idAbelha = rs.getInt("id_abelha");
        }
        
        String sql;
        sql = "Update colmeias set nome = '" + getNome() + "', localizacao = '" + getLocalizacao()
                + "', cidade = '" + getCidade() + "', tamanho = '" + getTamanho()
                + "', id_abelha = '" + idAbelha + "' where id_colmeia = " + getCodigo();
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
    }
    
    public String buscarNome(){
        String sql;
        sql = "select nome from colmeias";
        
        con.executeSQL(sql);
        return "";
    }
       
    public HashMap<String, List<String>> colmeiasUsuario(Integer idUsuario) throws SQLException{
        ResultSet rs;
        String sql = "select \n" +
            "    c.id_usuario,\n" +
            "    c.id_colmeia,\n" +
            "    c.nome as nome_colmeia,\n" +
            "    c.localizacao, \n" +                
            "    c.cidade, \n" +
            "    ab.id_abelha,\n" +
            "    ab.nome as nome_abelha \n" +
            "from \n" +
            "    Colmeias c\n" +
            "join \n" +
            "    Abelhas ab on c.id_abelha = ab.id_abelha\n" +
            "where \n" +
            "    c.id_usuario = " + idUsuario;
        
        rs = con.RetornarResultset(sql);
        
        // Usar uma lista para armazenar múltiplos valores
        HashMap<String, List<String>> dadosColmeia = new HashMap<>();

        // Inicializando listas para cada chave
        dadosColmeia.put("id_colmeia", new ArrayList<>());
        dadosColmeia.put("nome_colmeia", new ArrayList<>());
        dadosColmeia.put("localizacao", new ArrayList<>());
        dadosColmeia.put("cidade", new ArrayList<>());
        dadosColmeia.put("nome_abelha", new ArrayList<>());

        // Verificando se o ResultSet tem dados
        if (rs.first()) {
            // Adicionando cada valor à lista correspondente
            dadosColmeia.get("id_colmeia").add(rs.getString("id_colmeia"));
            dadosColmeia.get("nome_colmeia").add(rs.getString("nome_colmeia"));
            dadosColmeia.get("localizacao").add(rs.getString("localizacao"));
            dadosColmeia.get("cidade").add(rs.getString("cidade"));
            dadosColmeia.get("nome_abelha").add(rs.getString("nome_abelha"));
            
            while(rs.next()){
                dadosColmeia.get("id_colmeia").add(rs.getString("id_colmeia"));
                dadosColmeia.get("nome_colmeia").add(rs.getString("nome_colmeia"));
                dadosColmeia.get("localizacao").add(rs.getString("localizacao"));
                dadosColmeia.get("cidade").add(rs.getString("cidade"));
                dadosColmeia.get("nome_abelha").add(rs.getString("nome_abelha"));
            }
        }
    
        return dadosColmeia;
        
    }
    
    public ArrayList tiposAbelhas() throws SQLException{
        ResultSet rs;
        String sql = "select * from abelhas";
        
        rs = con.RetornarResultset(sql);
        
        ArrayList<String> abelhas = new ArrayList<>();
        
        if(rs.first()){
            abelhas.add(rs.getString("nome"));
            
            while(rs.next()){
                abelhas.add(rs.getString("nome"));
            }
        }
        
        return abelhas;
    }
    
    public ArrayList<String> colmeiasUser(int usuarioId) throws SQLException{
        ResultSet rs;
        String sql = "select \n" +
            "    u.id_usuario,\n" +
            "    c.id_colmeia,\n" +
            "    c.nome as nome_colmeia,\n" +
            "    c.localizacao, \n" +
            "    c.cidade, \n" +
            "    ab.id_abelha,\n" +
            "    ab.nome as nome_abelha \n" +
            "from \n" +
            "    Usuarios u\n" +
            "join \n" +
            "    Colmeias c on u.id_usuario = c.id_usuario\n" +
            "join \n" +
            "    Abelhas ab on c.id_abelha = ab.id_abelha\n" +
            "where \n" +
            "    u.id_usuario = " + usuarioId;
        
        rs = con.RetornarResultset(sql);
        
        ArrayList<String> colmeias = new ArrayList<>();
        
        if(rs.first()){
            colmeias.add(rs.getString("nome_colmeia"));
            
            while(rs.next()){
                colmeias.add(rs.getString("nome_colmeia"));
            }
        }
        
        System.out.println(colmeias);
        
        return colmeias;
    }
    
    public HashMap<String, String> dadosColmeia(int idColmeia) throws SQLException{
        ResultSet rs;
                String sql = "select \n" +
            "    c.id_colmeia,\n" +
            "    c.nome as nome_colmeia,\n" +
            "    c.localizacao, \n" +
            "    c.cidade, \n" +
            "    c.tamanho, \n" +
            "    ab.id_abelha,\n" +
            "    ab.nome as nome_abelha \n" +
            "from \n" +
            "    Colmeias c \n" +
            "join \n" +
            "    Abelhas ab on c.id_abelha = ab.id_abelha\n" +
            "where \n" +
            "    c.id_colmeia = " + idColmeia;
                
        rs = con.RetornarResultset(sql);
        
        HashMap<String, String> dadosColmeia = new HashMap<>();
        if (rs.first()) {
            dadosColmeia.put("id_colmeia", rs.getString("id_colmeia"));
            dadosColmeia.put("nome_colmeia", rs.getString("nome_colmeia"));
            dadosColmeia.put("nome_abelha", rs.getString("nome_abelha"));
            dadosColmeia.put("tamanho", rs.getString("tamanho"));
            dadosColmeia.put("loc_colmeia", rs.getString("localizacao"));
            dadosColmeia.put("cidade", rs.getString("cidade"));
        }
    
        return dadosColmeia;
    }
        
}
