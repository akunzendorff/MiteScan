/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Colmeia;
import static Utils.Constantes.usuarioId;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fatec-dsm2
 */
public class Colmeias extends javax.swing.JFrame {

    /**
     * Creates new form Colmeias
     */
    public Colmeias() {
        initComponents();
        this.setLocationRelativeTo(null); //Tirar do canto
    }

    Colmeia c = new Colmeia();

    public void setNomeColmeia(String nome) {
        lblNomeColmeia.setText("Nome da Colmeia: " + nome);
    }

    public void setCoordenadas(String coordenadas) {
        lblCoordenadas.setText("Coordenadas: " + coordenadas);
    }

    public void setTipoAbelha(String tipo) {
        lblTipoAbelha.setText("Tipo de Abelha: " + tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        btnMiteScan = new javax.swing.JLabel();
        btnHome = new javax.swing.JLabel();
        btnColmeias = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JLabel();
        btnAnalises = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JLabel();
        tituloPagina = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JLabel();
        painelColmeias = new javax.swing.JPanel();
        painelColmeia = new javax.swing.JPanel();
        lblNomeColmeia = new javax.swing.JLabel();
        lblCoordenadas = new javax.swing.JLabel();
        lblTipoAbelha = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        btnEditar = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JLabel();
        fotoColmeia = new javax.swing.JLabel();
        statusColmeia = new javax.swing.JLabel();
        espacoInfos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(255, 201, 11));

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnMiteScan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHome)
                            .addComponent(btnMiteScan)
                            .addComponent(btnColmeias)
                            .addComponent(btnHistorico)
                            .addComponent(btnAnalises)))
                    .addGroup(headerLayout.createSequentialGroup()
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

        tituloPagina.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tituloPagina.setText("Minhas colmeias");

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/adicionar.png"))); // NOI18N
        btnAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarMouseClicked(evt);
            }
        });

        painelColmeias.setBackground(new java.awt.Color(255, 255, 255));
        painelColmeias.setLayout(new javax.swing.BoxLayout(painelColmeias, javax.swing.BoxLayout.Y_AXIS));

        painelColmeia.setBackground(new java.awt.Color(255, 255, 255));
        painelColmeia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNomeColmeia.setText("...");
        lblNomeColmeia.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblNomeColmeiaInputMethodTextChanged(evt);
            }
        });
        lblNomeColmeia.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblNomeColmeiaPropertyChange(evt);
            }
        });

        lblCoordenadas.setText("...");
        lblCoordenadas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblCoordenadasInputMethodTextChanged(evt);
            }
        });
        lblCoordenadas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblCoordenadasPropertyChange(evt);
            }
        });

        lblTipoAbelha.setText("...");
        lblTipoAbelha.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblTipoAbelhaInputMethodTextChanged(evt);
            }
        });
        lblTipoAbelha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblTipoAbelhaPropertyChange(evt);
            }
        });

        lblCidade.setText("...");
        lblCidade.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblCidadeInputMethodTextChanged(evt);
            }
        });
        lblCidade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblCidadePropertyChange(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/canetaEditar.png"))); // NOI18N
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/Lixo.png"))); // NOI18N
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirMouseClicked(evt);
            }
        });

        fotoColmeia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/img-colmeia1.png"))); // NOI18N

        statusColmeia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/estado-segura.png"))); // NOI18N

        espacoInfos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icones/dados-segura.png"))); // NOI18N

        javax.swing.GroupLayout painelColmeiaLayout = new javax.swing.GroupLayout(painelColmeia);
        painelColmeia.setLayout(painelColmeiaLayout);
        painelColmeiaLayout.setHorizontalGroup(
            painelColmeiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelColmeiaLayout.createSequentialGroup()
                .addComponent(fotoColmeia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(painelColmeiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeColmeia)
                    .addComponent(lblTipoAbelha)
                    .addComponent(lblCidade)
                    .addComponent(lblCoordenadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(espacoInfos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusColmeia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelColmeiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        painelColmeiaLayout.setVerticalGroup(
            painelColmeiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoColmeia, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(statusColmeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(espacoInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelColmeiaLayout.createSequentialGroup()
                .addGroup(painelColmeiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelColmeiaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnEditar)
                        .addGap(34, 34, 34)
                        .addComponent(btnExcluir))
                    .addGroup(painelColmeiaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblNomeColmeia)
                        .addGap(27, 27, 27)
                        .addComponent(lblTipoAbelha)
                        .addGap(33, 33, 33)
                        .addComponent(lblCidade)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCoordenadas)
                .addGap(24, 24, 24))
        );

        painelColmeias.add(painelColmeia);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(tituloPagina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionar))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(painelColmeias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(76, 76, 76))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdicionar)
                            .addComponent(tituloPagina))))
                .addGap(44, 44, 44)
                .addComponent(painelColmeias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        FrmColmeia fc = new FrmColmeia();
        fc.setVisible(true);
    }//GEN-LAST:event_btnAdicionarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        EditarColmeia ec = new EditarColmeia();
        ec.setVisible(true);
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        ExcluirColmeia exc = new ExcluirColmeia();
        exc.setVisible(true);
    }//GEN-LAST:event_btnExcluirMouseClicked

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

    private void lblNomeColmeiaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblNomeColmeiaInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_lblNomeColmeiaInputMethodTextChanged

    private void lblTipoAbelhaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblTipoAbelhaInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_lblTipoAbelhaInputMethodTextChanged

    private void lblCidadeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblCidadeInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_lblCidadeInputMethodTextChanged

    private void lblCoordenadasInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblCoordenadasInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_lblCoordenadasInputMethodTextChanged

    private void lblNomeColmeiaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblNomeColmeiaPropertyChange
        // TODO add your handling code here:
//        c.addPropertyChangeListener(new PropertyChangeListener() {;;;
//            public void propertyChange(PropertyChangeEvent evt) {
//                if ("nome".equals(evt.getPropertyName())) {
//                    String nomeColmeia = c.getNome();
//                    lblNomeColmeia2.setText(nomeColmeia);
//                }
//            }
//        });
    }//GEN-LAST:event_lblNomeColmeiaPropertyChange

    private void lblTipoAbelhaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblTipoAbelhaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTipoAbelhaPropertyChange

    private void lblCidadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblCidadePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCidadePropertyChange

    private void lblCoordenadasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblCoordenadasPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCoordenadasPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            c.colmeiasUsuario(usuarioId);
            // Recupera os dados das colmeias para o usuário
            HashMap<String, List<String>> dadosColmeia = c.colmeiasUsuario(usuarioId);

            // Cria uma lista de HashMap<String, String> a partir dos dados do HashMap
            List<HashMap<String, String>> listaColmeias = new ArrayList<>();

            // Verifica se os dados do HashMap não estão vazios
            int size = dadosColmeia.get("nome_colmeia").size();
            for (int i = 0; i < size; i++) {
                // Cria um novo HashMap para armazenar os dados da colmeia para cada iteração
                HashMap<String, String> colmeia = new HashMap<>();
                colmeia.put("nome_colmeia", dadosColmeia.get("nome_colmeia").get(i));
                colmeia.put("localizacao", dadosColmeia.get("localizacao").get(i));
                colmeia.put("nome_abelha", dadosColmeia.get("nome_abelha").get(i));

                // Adiciona o HashMap à lista
                listaColmeias.add(colmeia);
            }
            // Passa a lista de HashMaps para o método preencherPainelComDados
            preencherPainelComColmeias(listaColmeias);

        } catch (SQLException ex) {
            Logger.getLogger(Colmeias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void preencherPainelComColmeias(List<HashMap<String, String>> dadosColmeias) {
// Limpa o painelModelo antes de adicionar novos painéis
        painelColmeias.removeAll();
        System.out.println(dadosColmeias);
        // Itera sobre os dados de cada colmeia

        for (HashMap<String, String> dados : dadosColmeias) {
            // Clona o painelColmeia da interface gráfica (o painel de modelo)
            JPanel painelColmeiaClone = new JPanel();
            painelColmeiaClone = painelColmeia; // Clone do painel existente, reutilizando o painel
            // Reconfigura o painel com os dados da colmeia
            configurarPainelColmeia(painelColmeiaClone, dados);

            // Adiciona o painel configurado ao painelModelo
            painelColmeias.add(painelColmeiaClone);
        }

        // Força o painel a ser atualizado e redesenhado
        painelColmeias.revalidate();
        painelColmeias.repaint();
    }

    private JPanel configurarPainelColmeia(JPanel painelColmeia, HashMap<String, String> dadosColmeia) {
        System.out.println(painelColmeia);
        // Reutilizando os JLabels existentes no painel de colmeia e configurando-os com os dados
        JLabel lblNomeColmeia = (JLabel) painelColmeia.getComponent(1); // Supondo que o primeiro componente seja lblNomeColmeia
        JLabel lblCoordenadas = (JLabel) painelColmeia.getComponent(2); // O segundo é lblCoordenadas
        JLabel lblTipoAbelha = (JLabel) painelColmeia.getComponent(3); // O terceiro é lblTipoAbelha

        // Configurando os dados no painel de colmeia
        lblNomeColmeia.setText(dadosColmeia.get("nome_colmeia"));
        lblCoordenadas.setText(dadosColmeia.get("localizacao"));
        lblTipoAbelha.setText(dadosColmeia.get("nome_abelha"));

        return painelColmeia;
    }

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
            java.util.logging.Logger.getLogger(Colmeias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Colmeias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Colmeias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Colmeias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdicionar;
    private javax.swing.JLabel btnAnalises;
    private javax.swing.JLabel btnColmeias;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnExcluir;
    private javax.swing.JLabel btnHistorico;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnMiteScan;
    private javax.swing.JLabel btnPerfil;
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JLabel espacoInfos;
    private javax.swing.JLabel fotoColmeia;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCoordenadas;
    private javax.swing.JLabel lblNomeColmeia;
    private javax.swing.JLabel lblTipoAbelha;
    private javax.swing.JPanel painelColmeia;
    private javax.swing.JPanel painelColmeias;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JLabel statusColmeia;
    private javax.swing.JLabel tituloPagina;
    // End of variables declaration//GEN-END:variables
}
