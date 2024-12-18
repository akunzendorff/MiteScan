/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;


/**
 *
 * @author fatec-dsm2
 */
public class ListarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form ListarUsuario
     */
    private static List<Usuario> usuarios = new ArrayList<>();
    private static boolean isOrdered = true;
    
    public ListarUsuario() {
        initComponents();
        jtblUsuarios.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableHeader header = jtblUsuarios.getTableHeader();
                int columnIndex = header.columnAtPoint(evt.getPoint());
                String columnName = header.getColumnModel().getColumn(columnIndex).getHeaderValue().toString();
                
                Boolean porString = null;
                if(columnName.equals("Código")) porString = false;
                else porString = true;
                
                DefaultTableModel tabelaUsuarios = (DefaultTableModel) jtblUsuarios.getModel();
                if (isOrdered) {                    
                    // Desordena a lista
                    quickSort(usuarios, 0, usuarios.size() - 1, isOrdered, porString, columnName);;
                } else {
                    // Ordena a lista pelo ID usando Quick Sort
                    quickSort(usuarios, 0, usuarios.size() - 1, isOrdered, porString, columnName);
                }
                isOrdered = !isOrdered;
                atualizarTabela(tabelaUsuarios);
            }
        });
        this.setLocationRelativeTo(null);
    }
    
    Usuario usu = new Usuario();
    
    public void ObterDados() throws SQLException{
       ResultSet tabela;
       tabela = null;
    
       tabela = usu.listarUsuario();
       
       try{
            usuarios.clear();
            Usuario usuario;
            if (tabela.first()) {
                usuario = new Usuario(
                        tabela.getInt("id_usuario"),
                        tabela.getString("nome"),
                        tabela.getString("email"),
                        tabela.getString("login"),
                        tabela.getString("senha"),
                        tabela.getString("acesso")
                );
                usuarios.add(usuario);
                while(tabela.next()) {         
                    usuario = new Usuario(
                            tabela.getInt("id_usuario"),
                            tabela.getString("nome"),
                            tabela.getString("email"),
                            tabela.getString("login"),
                            tabela.getString("senha"),
                            tabela.getString("acesso")
                    );
                    usuarios.add(usuario);
                }
            }
      } catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a lista de usuarios " + erro) ;    
        }
    }
    
    private static void atualizarTabela(DefaultTableModel tabela) {
        tabela.setRowCount(0); // Limpa os dados antigos
        for (Usuario usuario : usuarios) {
            tabela.addRow(new Object[]{
                    usuario.getCodigo(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getLogin(),
                    usuario.getAcesso()
            });
        }
    }
    
    private static void quickSort(List<Usuario> list, int low, int high, boolean ordem, boolean porString, String coluna) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, ordem, porString, coluna);
            quickSort(list, low, pivotIndex - 1, ordem, porString, coluna);
            quickSort(list, pivotIndex + 1, high, ordem, porString, coluna);
        }
    }
    
    private static int partition(List<Usuario> list, int low, int high, boolean ordem, boolean porString, String coluna) {
        if(porString) {
            String pivot = null;
            if("Nome".equals(coluna)) pivot = list.get(high).getNome();
            if("Email".equals(coluna)) pivot = list.get(high).getEmail();
            if("Acesso".equals(coluna)) pivot = list.get(high).getAcesso();
            if("Login".equals(coluna)) pivot = list.get(high).getLogin();
            
            int i = low - 1;
            for (int j = low; j < high; j++) {
                String chaveComparada = "";
                if(coluna.equals("Nome")) chaveComparada = list.get(j).getNome();
                if(coluna.equals("Email")) chaveComparada = list.get(j).getEmail();
                if(coluna.equals("Acesso")) chaveComparada = list.get(j).getAcesso();
                if(coluna.equals("Login")) chaveComparada = list.get(j).getLogin();
                
                if(ordem) { // se ordem for true, vai ordernar do menor para o maior
                    if (chaveComparada.compareTo(pivot) <= 0) {
                        i++;
                        Collections.swap(list, i, j);
                    }
                } else {
                     if (chaveComparada.compareTo(pivot) >= 0) {
                        i++;
                        Collections.swap(list, i, j);
                    }
                }
            }
            Collections.swap(list, i + 1, high);
            return i + 1;
        }
        else {
            int pivot = list.get(high).getCodigo(); // Pivô é o ID
            int i = low - 1;

            for (int j = low; j < high; j++) {                    
                if(ordem) { // se ordem for true, vai ordernar do menor para o maior
                    if (list.get(j).getCodigo()<= pivot) {
                        i++;
                        Collections.swap(list, i, j);
                    }
                } else {
                    if (list.get(j).getCodigo() >= pivot) { // maior para o menor
                        i++;
                        Collections.swap(list, i, j);
                    }
                }
            }
            Collections.swap(list, i + 1, high);
            return i + 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMiteScan = new javax.swing.JLabel();
        btnHome = new javax.swing.JLabel();
        btnColmeias = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JLabel();
        btnAnalises = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 201, 11));

        btnMiteScan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/mitescan-logo.png"))); // NOI18N
        btnMiteScan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMiteScanMouseClicked(evt);
            }
        });

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/home-menor.png"))); // NOI18N
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });

        btnColmeias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/cadastrar-colmeia-pequeno.png"))); // NOI18N
        btnColmeias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnColmeiasMouseClicked(evt);
            }
        });

        btnHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/historico-menor.png"))); // NOI18N
        btnHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoricoMouseClicked(evt);
            }
        });

        btnAnalises.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/abelha-preta-média.png"))); // NOI18N
        btnAnalises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnalisesMouseClicked(evt);
            }
        });

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/pessoas.png"))); // NOI18N
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnMiteScan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(45, 45, 45)
                .addComponent(btnColmeias)
                .addGap(73, 73, 73)
                .addComponent(btnHistorico)
                .addGap(55, 55, 55)
                .addComponent(btnAnalises)
                .addGap(39, 39, 39)
                .addComponent(btnPerfil)
                .addGap(47, 47, 47))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHome)
                            .addComponent(btnMiteScan)
                            .addComponent(btnColmeias)
                            .addComponent(btnHistorico)
                            .addComponent(btnAnalises)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnPerfil)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/seta.png"))); // NOI18N
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Usuários cadastrados");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jtblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Email", "Login", "Acesso"
            }
        ));
        jtblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMiteScanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiteScanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btnMiteScanMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnColmeiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnColmeiasMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Colmeias c = new Colmeias();
        c.setVisible(true);
    }//GEN-LAST:event_btnColmeiasMouseClicked

    private void btnHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoricoMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Historico hist = new Historico();
        hist.setVisible(true);
    }//GEN-LAST:event_btnHistoricoMouseClicked

    private void btnAnalisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnalisesMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Analisar a = new Analisar();
        a.setVisible(true);
    }//GEN-LAST:event_btnAnalisesMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        FrmUsuario fu = new FrmUsuario();
        fu.setVisible(true);
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void jtblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblUsuariosMouseClicked

    }//GEN-LAST:event_jtblUsuariosMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            DefaultTableModel tabelaUsuarios = (DefaultTableModel) jtblUsuarios.getModel();
            ObterDados();
            atualizarTabela(tabelaUsuarios);
        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAnalises;
    private javax.swing.JLabel btnColmeias;
    private javax.swing.JLabel btnHistorico;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnMiteScan;
    private javax.swing.JLabel btnPerfil;
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblUsuarios;
    // End of variables declaration//GEN-END:variables
}
