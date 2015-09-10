/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.ServidorController;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Aluno;
import modelo.Servidor;
import util.ValidaCampos;

/**
 *
 * @author aluno
 */
public class JFrmServidor extends javax.swing.JFrame {

    private boolean alt =false;
    private int idServidor =0;
    public JFrmServidor(Servidor servidor) {
        initComponents();
        if(servidor !=null){
            preencheCampos(servidor);
        }
        else jTxtNome.requestFocus();
    }
    private void limpacampos(Container container){
        Component components[] = container.getComponents();
        for(Component component : components)
            if(component instanceof JTextField)
                ((JTextField)component).setText(null);
            else if (component instanceof JFormattedTextField)
                ((JFormattedTextField)component).setText(null);
            else if (component instanceof JPasswordField)
                ((JPasswordField)component).setText(null);
        jTxtNome.requestFocus();
    }
    
    private void preencheCampos(Servidor servidor){
        idServidor = servidor.getIdServidor();
        jTxtNome.setText(servidor.getNomeCompleto());
        jTxtCpf.setText(servidor.getCpf());
        jTxtSiape.setText(servidor.getSiape());
        jTxtSala.setText(servidor.getSala());
        jTxtEmail.setText(servidor.getEmail());
        jTxtSenha.setText(servidor.getSenha());
        alt = true;
    }
    
    private boolean validaCampos(){
        String mensagem="";
        boolean c1, c2, c3, c4, c5;
        c1=c2=c3=c4=c5=false;
        boolean retorno=false;
        if(!ValidaCampos.validaAlfabetico(jTxtNome.getText())){
            mensagem += "Nome Invalido !\n";
            retorno = true;
            c1=true;
        }
        if(!ValidaCampos.validaCpf(jTxtCpf.getText())){
            mensagem += "Cpf Invalido !\n";
            retorno = true;
            c2=true;
        }
        if(!ValidaCampos.validaAlfabetico(jTxtSiape.getText())){
            mensagem += "Siape Invalido !\n";
            retorno = true;
            c3=true;
        }
        if(!ValidaCampos.validaAlfaNumerico(jTxtSala.getText())){
            mensagem += "Sala Invalido !\n";
            retorno = true;
            c4=true;
        }
        if(!ValidaCampos.validaEmail(jTxtEmail.getText())){
            mensagem += "E-mail Invalido !\n";
            retorno = true;
            c5=true;
        }
        if(retorno){
            JOptionPane.showMessageDialog(this,mensagem,"Controle de Estoque", JOptionPane.INFORMATION_MESSAGE);
            if(c1)
                jTxtNome.requestFocus();
            else if(c2)
                jTxtCpf.requestFocus();
            else if(c3)
                jTxtSiape.requestFocus();
            else if(c4)
                jTxtSala.requestFocus();
            else if(c5)
                jTxtEmail.requestFocus();
            
        }
        return retorno;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlBotoes = new javax.swing.JPanel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jPnlCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtSiape = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtSala = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtSenha = new javax.swing.JPasswordField();
        jTxtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Servidores");
        setResizable(false);

        jPnlBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2683_32x32.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/6228_32x32.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");
        jBtnSalvar.setEnabled(false);
        jBtnSalvar.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/283_32x32.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.setEnabled(false);
        jBtnExcluir.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2702_32x32.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setEnabled(false);
        jBtnCancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/11292_32x32.png"))); // NOI18N
        jBtnSair.setText("Sair");
        jBtnSair.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout jPnlBotoesLayout = new javax.swing.GroupLayout(jPnlBotoes);
        jPnlBotoes.setLayout(jPnlBotoesLayout);
        jPnlBotoesLayout.setHorizontalGroup(
            jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPnlBotoesLayout.setVerticalGroup(
            jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPnlCampos.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Nome Completo:");

        jTxtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        jLabel2.setText("Cpf:");

        jLabel3.setText("Siape:");

        jLabel4.setText("Sala:");

        jLabel5.setText("E-mail:");

        jLabel6.setText("Senha:");

        try {
            jTxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPnlCamposLayout = new javax.swing.GroupLayout(jPnlCampos);
        jPnlCampos.setLayout(jPnlCamposLayout);
        jPnlCamposLayout.setHorizontalGroup(
            jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtNome))
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPnlCamposLayout.createSequentialGroup()
                                .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtSiape))
                            .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCamposLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(jTxtSala, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCamposLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPnlCamposLayout.setVerticalGroup(
            jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTxtSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        if(!validaCampos()){
            ServidorController ac = new ServidorController();
            int erro = ac.incluir(jTxtNome.getText(), jTxtCpf.getText(), jTxtSenha.getText(), jTxtSiape.getText(),
                    jTxtSala.getText(), jTxtEmail.getText(), 'a');
        }else{
            
        }
       
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        jBtnExcluir.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnSalvar.setEnabled(false);
        jBtnSair.setEnabled(false);
        alt = false;
        limpacampos(jPnlBotoes);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNomeKeyTyped
        if(alt){
            jBtnSalvar.setEnabled(true);
            jBtnCancelar.setEnabled(false);
            jBtnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jTxtNomeKeyTyped

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        if(!validaCampos()){
            ServidorController sc = new ServidorController();
            int erro = sc.alterar(idServidor,jTxtNome.getText(), jTxtCpf.getText(), jTxtSenha.getText(), jTxtSiape.getText(),
                    jTxtSala.getText(), jTxtEmail.getText(), 'a');
            if(erro > -1){
                if(erro == 1062){
                    JOptionPane.showInternalMessageDialog(this, erro);
                }
            }else{
                jBtnSalvar.setEnabled(false);
                jBtnCancelar.setEnabled(false);
                jBtnIncluir.setEnabled(false);
                
            }
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        JOptionPane.showConfirmDialog(this,"asdasda");
        ServidorController sc = new ServidorController();
        int erro = sc.excluir(idServidor);
        if(erro >-1){
            JOptionPane.showConfirmDialog(this,"Erro nro "+erro+
                    "Controle de Estoque ");
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //TODO estou com servidor novo
                new JFrmServidor(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPnlBotoes;
    private javax.swing.JPanel jPnlCampos;
    private javax.swing.JFormattedTextField jTxtCpf;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtSala;
    private javax.swing.JPasswordField jTxtSenha;
    private javax.swing.JTextField jTxtSiape;
    // End of variables declaration//GEN-END:variables
}
