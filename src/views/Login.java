/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Acesso.UsuarioLogado;
import business.Usuario;
import java.awt.Component;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import servicos.ServicoDeMensagens;
import servicos.Validacoes;
import ColetaDados.PDFMain;
import java.io.File;
import static java.lang.Thread.sleep;
import servicos.GerenciaPasta;

/**
 *
 * @author BRUNOSILVA
 */
public class Login extends javax.swing.JFrame {

    private Component frame;

    /**
     * Creates new form TesteLogin
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        painelLogin = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        txtSenha = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        btnLoginConf = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(392, 290));

        lblNome.setText("Nome:");

        lblSenha.setText("Senha:");

        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLoginLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(30, 30, 30)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLoginLayout.createSequentialGroup()
                                .addComponent(lblSenha)
                                .addGap(26, 26, 26)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblSenha))
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
        );

        btnLogar.setText("Entrar");
        btnLogar.setToolTipText("");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        btnLoginConf.setText("Configurações");
        btnLoginConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginConfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lbLogin)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnLogar))
                            .addComponent(btnLoginConf))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lbLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLogar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoginConf)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed

        //JOptionPane.showMessageDialog(frame, "Usuário e ou Senha Inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        Usuario usuEnvio = new Usuario();
        try {
            GerenciaPasta.PastaDestino();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        usuEnvio.setNome(txtUsuario.getText());
        String valor = new String(txtSenha.getPassword());
        //String pastaOrigem;
        File pastaOrigem;
        usuEnvio.setSenha(valor);
        boolean usuarioValido = false;

        try {
            usuarioValido = Validacoes.validaUsuarioSenha(usuEnvio);
            GerenciaPasta.PastaDestino();

            if (usuarioValido) {
                if (UsuarioLogado.getInstancia().isPrimeiroAcesso()) {
                    ServicoDeMensagens.mensagem = "Esse é o primeiro acesso! Favor alterar usuário 'admin' ";
                    JOptionPane.showMessageDialog(frame, ServicoDeMensagens.getMensagem(), "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }

                if (GerenciaPasta.isPastaDestino()) {
                    //Se o usuário for válido pega o caminho configurado e carrega os arquivos no banco

                    btnLogar.setEnabled(false);
                    //LoadingDados barraProgresso = new LoadingDados();

                    pastaOrigem = new File(GerenciaPasta.RetornaCaminhoPasta());
                    //barraProgresso.setArq(pastaOrigem);
                    //barraProgresso.start();

                    if (!pastaOrigem.getPath().equals("") && pastaOrigem.exists()) {

                        PDFMain.CarregarArquivos(pastaOrigem.getPath());

                        /*
                        if(b.isAlive()){
                          b.join(1000);
                        }
                         */
                    } else {
                        JOptionPane.showMessageDialog(frame, "Pasta origem não configurada!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }

                    BuscaDeCurriculos amostra = new BuscaDeCurriculos();
                    dispose();
                    amostra.setVisible(true);

                }

            } else {
                JOptionPane.showMessageDialog(frame, ServicoDeMensagens.getMensagem(), "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } catch (IllegalArgumentException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(frame, "Parâmetro inválido!", "Erro argumento ilegal", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Usuário ou senha de conexão inválido!", "Erro na consulta com banco", JOptionPane.ERROR_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Caminho do arquivo não configurado", "Erro no arquivo", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnLogarActionPerformed

    private void btnLoginConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginConfActionPerformed
        try {
            Configuracao config = new Configuracao(this, true);
            config.setLocationRelativeTo(null);

            config.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BuscaDeCurriculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginConfActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public class LoadingDados extends Thread {

        private String arq;

        public String getArq() {
            return arq;
        }

        public void setArq(String arq) {
            this.arq = arq;
        }

        public void run() {
            try {

                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            int maximo = PDFMain.getLoadMax();
            jProgressBar1.setMaximum(maximo);

            for (int i = 0; i < maximo + 1; i++) {
                try {
                    sleep(50);
                    jProgressBar1.setValue(i);
                    lbLogin.setText("Carregando os arquivos...");

                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            /*
            BuscaDeCurriculos amostra = new BuscaDeCurriculos();
            dispose();
            amostra.setVisible(true); 
             */
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JButton btnLoginConf;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
