/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

//import javax.swing.*;
import Acesso.ListagemCandidatosSing;
import Acesso.UsuarioLogado;
import DAO.CandidatoMySqlDAO;
import DAO.CidadeMySqlDAO;
import Enums.EnumComparadorQuery;
import TableModel.CandidatoTableModel;
import business.CamposDeClasse;
import business.Candidato;
import business.Cidade;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import servicos.ThreadAbreArquivo;
import servicos.GerenciaPasta;

/**
 *
 * @author BRUNOSILVA
 */
public class BuscaDeCurriculos extends javax.swing.JFrame {

    public static boolean buscaAvancada = false;
    private Component frame;
    CandidatoTableModel modeloTabela = new CandidatoTableModel();

    /**
     * Creates new form BuscaDeCurriculos
     */
    public BuscaDeCurriculos() {
        initComponents();
        this.setLocationRelativeTo(null);

        cBoxOpcoesBusca1.addItem("Cidade");
        cBoxOpcoesBusca1.addItem("Cargo");
        cBoxOpcoesBusca1.addItem("Escolaridade");
        cBoxOpcoesBusca1.addItem("Estado");

        cBoxOpcoesBusca2.addItem("Cidade");
        cBoxOpcoesBusca2.addItem("Cargo");
        cBoxOpcoesBusca2.addItem("Escolaridade");
        cBoxOpcoesBusca2.addItem("Estado");

        cBoxOpcoesBooleano3.addItem("IGUAL");
        cBoxOpcoesBooleano3.addItem("DIFERENTE DE");

        cBoxOpcoesBooleano4.addItem("IGUAL");
        cBoxOpcoesBooleano4.addItem("DIFERENTE");
        
        cBoxOpcoesBooleano5.addItem("E");
        cBoxOpcoesBooleano5.addItem("OU");
        cBoxOpcoesBooleano5.setVisible(buscaAvancada);

        txtNumInf.setValue(15);
        txtNumSup.setValue(50);

        txtNumInf.setEnabled(false);
        txtNumSup.setEnabled(false);

        jTableCandidatos.setAutoResizeMode(5);

        btnConfigPasta.setToolTipText("Configurar Pasta");
        btnConfigAjuda.setToolTipText("Ajuda");
        btnCadastrarUsuario.setToolTipText("Cadastrar Usuário");
        btnBuscaAvancada.setToolTipText("Busca Avançada");

        // Aqui ele verifica se o usuario logado é um administrador ou não.
        //Se for ele abre o cadastro de usuarios, se não exibe uma mensagem de erro  
        if (!UsuarioLogado.getInstancia().retornaDadosUsuario().getTipoAcesso().getDescricao().equals("Administrador")) {
            btnCadastrarUsuario.setEnabled(false);
        }

        gp_Filtro2.setVisible(buscaAvancada);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfigAjuda = new javax.swing.JButton();
        btnConfigPasta = new javax.swing.JButton();
        txtNumInf = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        txtNumSup = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCandidatos = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        gp_Filtro2 = new javax.swing.JPanel();
        cBoxOpcoesBusca2 = new javax.swing.JComboBox<>();
        txtBusca2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cBoxOpcoesBooleano4 = new javax.swing.JComboBox<>();
        gb_Filtro1 = new javax.swing.JPanel();
        cBoxOpcoesBusca1 = new javax.swing.JComboBox<>();
        txtBusca1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cBoxOpcoesBooleano3 = new javax.swing.JComboBox<>();
        cBoxOpcoesBooleano5 = new javax.swing.JComboBox<>();
        jCheckBoxFaixaEtaria = new javax.swing.JCheckBox();
        btnBuscaAvancada = new javax.swing.JButton();
        btnCadastrarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Pesquisa");
        setMinimumSize(new java.awt.Dimension(850, 845));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfigAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-ajuda-40.png"))); // NOI18N
        btnConfigAjuda.setSelected(true);
        btnConfigAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigAjudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfigAjuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 53, 50));

        btnConfigPasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-automático-50.png"))); // NOI18N
        btnConfigPasta.setSelected(true);
        btnConfigPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigPastaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfigPasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 53, 50));

        txtNumInf.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(txtNumInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 50, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Faixa Etária");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));
        getContentPane().add(txtNumSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 50, -1));

        jTableCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Idade", "Cidade", "Cargo", "Telefone", "Escolaridade", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCandidatos.setMinimumSize(new java.awt.Dimension(130, 84));
        jTableCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCandidatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCandidatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 415, 780, 220));

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-pesquisa-propriedade-40.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        gp_Filtro2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cBoxOpcoesBusca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOpcoesBusca2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Listar por:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Digite sua busca abaixo:");

        cBoxOpcoesBooleano4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOpcoesBooleano4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gp_Filtro2Layout = new javax.swing.GroupLayout(gp_Filtro2);
        gp_Filtro2.setLayout(gp_Filtro2Layout);
        gp_Filtro2Layout.setHorizontalGroup(
            gp_Filtro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gp_Filtro2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gp_Filtro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gp_Filtro2Layout.createSequentialGroup()
                        .addComponent(cBoxOpcoesBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(cBoxOpcoesBooleano4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(gp_Filtro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gp_Filtro2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addComponent(txtBusca2))
                .addContainerGap())
        );
        gp_Filtro2Layout.setVerticalGroup(
            gp_Filtro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gp_Filtro2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gp_Filtro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gp_Filtro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxOpcoesBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxOpcoesBooleano4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(gp_Filtro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        gb_Filtro1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cBoxOpcoesBusca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOpcoesBusca1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Listar por:");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Digite sua busca abaixo:");

        cBoxOpcoesBooleano3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOpcoesBooleano3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gb_Filtro1Layout = new javax.swing.GroupLayout(gb_Filtro1);
        gb_Filtro1.setLayout(gb_Filtro1Layout);
        gb_Filtro1Layout.setHorizontalGroup(
            gb_Filtro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gb_Filtro1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gb_Filtro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gb_Filtro1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gb_Filtro1Layout.createSequentialGroup()
                        .addComponent(cBoxOpcoesBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(cBoxOpcoesBooleano3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(gb_Filtro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        gb_Filtro1Layout.setVerticalGroup(
            gb_Filtro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gb_Filtro1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gb_Filtro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gb_Filtro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxOpcoesBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxOpcoesBooleano3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(gb_Filtro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        cBoxOpcoesBooleano5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOpcoesBooleano5ActionPerformed(evt);
            }
        });
        getContentPane().add(cBoxOpcoesBooleano5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 53, -1));

        jCheckBoxFaixaEtaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFaixaEtariaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxFaixaEtaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        btnBuscaAvancada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-mais-2-matemática-40.png"))); // NOI18N
        btnBuscaAvancada.setSelected(true);
        btnBuscaAvancada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaAvancadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscaAvancada, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 53, 50));

        btnCadastrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-name-tag-40.png"))); // NOI18N
        btnCadastrarUsuario.setSelected(true);
        btnCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 53, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxOpcoesBusca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOpcoesBusca2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cBoxOpcoesBusca2ActionPerformed

    private void btnConfigPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigPastaActionPerformed
        try {
            Configuracao config = new Configuracao(this, true);
            //this.add
            config.setLocationRelativeTo(null);

            config.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BuscaDeCurriculos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnConfigPastaActionPerformed

    private void btnConfigAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigAjudaActionPerformed
        Ajuda ajuda = new Ajuda(this, true);
        //this.add

        ajuda.setLocationRelativeTo(null);

        ajuda.setVisible(true);


    }//GEN-LAST:event_btnConfigAjudaActionPerformed

    private void cBoxOpcoesBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOpcoesBusca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxOpcoesBusca1ActionPerformed

    private void cBoxOpcoesBooleano3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOpcoesBooleano3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxOpcoesBooleano3ActionPerformed

    private void cBoxOpcoesBooleano4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOpcoesBooleano4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxOpcoesBooleano4ActionPerformed

    private void cBoxOpcoesBooleano5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOpcoesBooleano5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxOpcoesBooleano5ActionPerformed

    private void jCheckBoxFaixaEtariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFaixaEtariaActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxFaixaEtaria.isSelected()) {
            txtNumInf.setEnabled(true);
            txtNumSup.setEnabled(true);
        } else {
            txtNumInf.setEnabled(false);
            txtNumSup.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxFaixaEtariaActionPerformed

    private void btnBuscaAvancadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaAvancadaActionPerformed
        buscaAvancada = !buscaAvancada;
        Icon menos = new ImageIcon(getClass().getResource("/icones/icons8-menos-40.png"));
        Icon mais = new ImageIcon(getClass().getResource("/icones/icons8-mais-2-matemática-40.png"));

        if (buscaAvancada) {
            //Colocar imagem de "menos"
            System.out.println("menos");
            {
                btnBuscaAvancada.setIcon(menos);
                btnBuscaAvancada.setToolTipText("Busca Simples");
                cBoxOpcoesBooleano5.setVisible(buscaAvancada);
                gp_Filtro2.setVisible(buscaAvancada);

            }

        } else {
            System.out.println("mais");
            btnBuscaAvancada.setIcon(mais);
            btnBuscaAvancada.setToolTipText("Busca Avançada");
            cBoxOpcoesBooleano5.setVisible(buscaAvancada);
            gp_Filtro2.setVisible(buscaAvancada);
            txtBusca2.setText("");

            //Esconder os objetos
        }
    }//GEN-LAST:event_btnBuscaAvancadaActionPerformed

    private void btnCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarUsuarioActionPerformed

        GerenciarUsuario telaCadastro = new GerenciarUsuario(this, true);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);

    }//GEN-LAST:event_btnCadastrarUsuarioActionPerformed

    /**
     * método para preenche campo de classe para gerar a consultaSQL
     */
    private void preencheFiltro(String opcaoDeCampo, String comparador, String busca,
            CamposDeClasse filtro, ArrayList<CamposDeClasse> lista) throws SQLException {

        if (filtro == null) {
            filtro = new CamposDeClasse();
        }
        //alterado em 30/06/2020
        if (opcaoDeCampo.toLowerCase().equals("cidade")
                || opcaoDeCampo.toLowerCase().equals("estado")) {
            String chave = ".nome";
            opcaoDeCampo = opcaoDeCampo + chave;
        }

        filtro.setNomeChave(opcaoDeCampo);
        filtro.setValorChave(busca);

        //esta parte ele pega do comboBom o 'IGUAL', mas nesse caso do filtro
        //a consulta será através de likes
        if (comparador.equals("IGUAL")) {
            filtro.setComparador(EnumComparadorQuery.LIKE);
        } else {
            filtro.setComparador(EnumComparadorQuery.NOT_LIKE);
        }

        lista.add(filtro);
    }

    private void preencheJtable(ArrayList<Candidato> lista) {
        
        modeloTabela.setLista(lista);
        jTableCandidatos.setModel(modeloTabela);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Não há resultado para pesquisa!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }


    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        String opcaoCampo1 = cBoxOpcoesBusca1.getSelectedItem().toString();
        String compara1 = cBoxOpcoesBooleano3.getSelectedItem().toString();
        String busca1 = txtBusca1.getText();
        String opLogico = cBoxOpcoesBooleano5.getSelectedItem().toString();
        String opcaoCampo2 = cBoxOpcoesBusca2.getSelectedItem().toString();
        String compara2 = cBoxOpcoesBooleano4.getSelectedItem().toString();
        String busca2 = txtBusca2.getText();

        ArrayList<CamposDeClasse> listaDeFiltros = new ArrayList<>();
        CamposDeClasse param = null;
        try {
            if (buscaAvancada) {
                preencheFiltro(opcaoCampo1, compara1, busca1, param, listaDeFiltros);
                param = new CamposDeClasse();
                param.setOperadorLogicoE(false);
                if (opLogico.equals("E")) {
                    param.setOperadorLogicoE(true);
                }
                preencheFiltro(opcaoCampo2, compara2, busca2, param, listaDeFiltros);
            } else {
                preencheFiltro(opcaoCampo1, compara1, busca1, param, listaDeFiltros);
            }

            CandidatoMySqlDAO dao = new CandidatoMySqlDAO();

            String comando = dao.stringSelectTabelaComFiltro(listaDeFiltros);
            if (jCheckBoxFaixaEtaria.isSelected()) {
                Calendar cal = Calendar.getInstance();
                int anoAtual = cal.get(Calendar.YEAR);
                int limiteA = (int) txtNumInf.getValue();
                int limiteB = (int) txtNumSup.getValue();

                int nascInf = anoAtual - limiteB;
                int nascSup = anoAtual - limiteA;
                comando += " and nascimento between " + nascInf + " and " + nascSup + " ;";
            }
            preencheJtable(dao.listagemDeEntidade(comando));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Não há resultado para pesquisa!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            
        }


    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jTableCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCandidatosMouseClicked
        try {

            String caminhoPadrao = GerenciaPasta.PastaDestino().getPath();
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                evt.consume();
                if (jTableCandidatos.getSelectedRow() > -1) {
                    int linhaSelecionada = jTableCandidatos.getSelectedRow();
                    String atributo = jTableCandidatos.getModel().getValueAt(linhaSelecionada, 6).toString();
                    CandidatoMySqlDAO dao = new CandidatoMySqlDAO();
                    String sql = "select * from candidato where " + jTableCandidatos.getColumnName(6) + " = "
                            + "'" + atributo + "' ;";
                    Candidato can = new Candidato();
                    can = dao.consultaGenerica(sql);
                    caminhoPadrao += "\\" + can.getNome_arquivo();
                    //abre o arquivo desejado!!!                   

                    if (new File(caminhoPadrao).exists()) {
                        ThreadAbreArquivo abreArq = new ThreadAbreArquivo();
                        abreArq.start();
                        abreArq.setArquivo(caminhoPadrao);
                        Thread.sleep(2000);
                        if (abreArq.isAlive()) {
                            abreArq.join();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Arquivo não encontrado!",
                                "Atenção", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Não achou nada");
        }

    }//GEN-LAST:event_jTableCandidatosMouseClicked

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
            java.util.logging.Logger.getLogger(BuscaDeCurriculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaDeCurriculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaDeCurriculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaDeCurriculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaDeCurriculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaAvancada;
    private javax.swing.JButton btnCadastrarUsuario;
    private javax.swing.JButton btnConfigAjuda;
    private javax.swing.JButton btnConfigPasta;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cBoxOpcoesBooleano3;
    private javax.swing.JComboBox<String> cBoxOpcoesBooleano4;
    private javax.swing.JComboBox<String> cBoxOpcoesBooleano5;
    private javax.swing.JComboBox<String> cBoxOpcoesBusca1;
    private javax.swing.JComboBox<String> cBoxOpcoesBusca2;
    private javax.swing.JPanel gb_Filtro1;
    private javax.swing.JPanel gp_Filtro2;
    private javax.swing.JCheckBox jCheckBoxFaixaEtaria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCandidatos;
    private javax.swing.JTextField txtBusca1;
    private javax.swing.JTextField txtBusca2;
    private javax.swing.JSpinner txtNumInf;
    private javax.swing.JSpinner txtNumSup;
    // End of variables declaration//GEN-END:variables
}

