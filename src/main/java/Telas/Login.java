package Telas;

import Utilitarios.Criptografia;
import database.Banco;
import javax.swing.JOptionPane;
import model.usuario;

public class Login extends javax.swing.JFrame {

    private Principal principal;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                confirmarSaida();
            }
        });
    }

    private String telaDestino;

    public void setTelaDestino(String destino) {
        this.telaDestino = destino;
    }

    private void confirmarSaida() {
        int opcao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente voltar para a tela principal?",
                "Confirmar Saída",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcao == JOptionPane.YES_OPTION) {
            this.dispose();
            new Principal().setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Texto = new javax.swing.JLabel();
        Imagem = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        CampoNome = new javax.swing.JTextField();
        Senha = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        Versenha = new javax.swing.JCheckBox();
        Cancelar = new javax.swing.JButton();
        Logar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        Texto.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Texto.setText("Login de Usuario");

        Imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andrei\\Documents\\NetBeansProjects\\Aplication\\src\\main\\java\\Imagens\\User.png")); // NOI18N

        Login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Login.setText("Login:");
        Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginKeyPressed(evt);
            }
        });

        Senha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Senha.setText("Senha:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        Versenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Versenha.setText("Ver senha");
        Versenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VersenhaActionPerformed(evt);
            }
        });
        Versenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VersenhaKeyPressed(evt);
            }
        });

        Cancelar.setBackground(new java.awt.Color(176, 209, 211));
        Cancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        Cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CancelarKeyPressed(evt);
            }
        });

        Logar.setBackground(new java.awt.Color(176, 209, 211));
        Logar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Logar.setText("Logar");
        Logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogarActionPerformed(evt);
            }
        });
        Logar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LogarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Login)
                    .addComponent(Senha)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Versenha))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Texto)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(Logar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(Login)
                        .addGap(6, 6, 6)
                        .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(Senha)
                        .addGap(12, 12, 12)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Versenha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(Imagem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Logar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        confirmarSaida();
    }//GEN-LAST:event_CancelarActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void VersenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VersenhaActionPerformed
        // TODO add your handling code here:
        if (Versenha.isSelected()) {
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_VersenhaActionPerformed

    private void CancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CancelarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            this.dispose();
        }
    }//GEN-LAST:event_CancelarKeyPressed

    private void LogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LogarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            logar();
        }
    }//GEN-LAST:event_LogarKeyPressed

    private void LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            logar();
        }
    }//GEN-LAST:event_LoginKeyPressed

    private void LogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogarActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_LogarActionPerformed

    private void VersenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VersenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            logar();
        }
    }//GEN-LAST:event_VersenhaKeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            logar();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void logar() {
        Criptografia cript = new Criptografia();
        Banco db = new Banco();

        try {
            usuario user = db.Autenticar(
                    CampoNome.getText(),
                    cript.criptografar(jPasswordField1.getPassword())
            );

            if (user == null) {
                JOptionPane.showMessageDialog(this, "Login e/ou senha inválidos.");
                return;
            }

            int permissao = user.getPermissao();
            this.dispose();

            if ("ListarUsuarios".equals(telaDestino)) {
                if (permissao == 1) {
                    new ListarUsuarios(new javax.swing.JFrame(), true).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Apenas administradores podem acessar esta função");
                    new Login().setVisible(true);
                }
            } else if (permissao == 1) {
                new MenuAdministrador(null, true).setVisible(true);
            } else if (permissao == 2) {
                new MenuComum(null, true).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Permissão inválida: " + permissao);
                new Login().setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao logar: " + e.getMessage());
        }
        this.dispose();
    }

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoNome;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton Logar;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel Texto;
    private javax.swing.JCheckBox Versenha;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
