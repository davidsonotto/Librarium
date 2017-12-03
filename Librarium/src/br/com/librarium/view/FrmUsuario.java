/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librarium.view;

import br.com.librarium.controller.UsuarioDao;
import br.com.librarium.interfaces.Verificacao;
import br.com.librarium.model.Funcionario;
import br.com.librarium.model.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Vinícius Brás de Oliveira
 */
public class FrmUsuario extends javax.swing.JFrame implements Verificacao {

    /**
     * Creates new form FrmPrincipal
     */
    private Usuario supervisor;
    private int action;
    public static final int ACTION_INSERT = 1;
    public static final int ACTION_UPDATE = 2;
    private FrmControleUsuario controle;
    private Funcionario funcionario;

    public FrmUsuario() {
        initComponents();
    }
    
    // Construtor chamado para inserir novos usuários
    public FrmUsuario(FrmControleUsuario controle) {
        initComponents();
        setLocationRelativeTo(null);
        action = ACTION_INSERT;
        this.controle = controle;
        btn_excluir.setVisible(false);
    }
    
    // Construtor chamado para editar ou excluir usuários
    public FrmUsuario(Usuario supervisor, FrmControleUsuario controle) {
        this.supervisor = supervisor;
        initComponents();
        setLocationRelativeTo(null);
        action = ACTION_UPDATE;
        preencherCampos();
        this.funcionario = new Funcionario();
        this.funcionario.setMatricula(supervisor.getMatricula());
        this.controle = controle;
    }

    private void preencherCampos() {
        lbl_funcionario.setText(supervisor.getNome());
        txt_login.setText(supervisor.getLogin());
        txt_senha.setText(supervisor.getSenha());
    }

    @Override
    public boolean validarCampos() {
        char[] pass = txt_senha.getPassword();
        if (funcionario != null && !txt_login.getText().equals("") && !senhaToString(pass).equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        lbl_funcionario.setText(funcionario.getNome());
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
        jPanel2 = new javax.swing.JPanel();
        txt_login = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_funcionario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JPanel();
        lbl_cancel = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JPanel();
        lbl_entrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(237, 250, 251));

        jPanel2.setBackground(new java.awt.Color(237, 250, 251));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(227, 6, 19));
        jLabel3.setText("Login");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(227, 6, 19));
        jLabel4.setText("Senha");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(227, 6, 19));
        jLabel10.setText("Funcionário");

        lbl_funcionario.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_funcionario.setForeground(new java.awt.Color(51, 51, 51));
        lbl_funcionario.setText("<Clique para selecionar um funcionário>");
        lbl_funcionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_funcionarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_login, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_login)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuário");

        btn_salvar.setBackground(new java.awt.Color(227, 6, 19));
        btn_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salvarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_salvarMouseExited(evt);
            }
        });

        lbl_cancel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_cancel.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cancel.setText("Salvar");

        javax.swing.GroupLayout btn_salvarLayout = new javax.swing.GroupLayout(btn_salvar);
        btn_salvar.setLayout(btn_salvarLayout);
        btn_salvarLayout.setHorizontalGroup(
            btn_salvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        btn_salvarLayout.setVerticalGroup(
            btn_salvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        btn_excluir.setBackground(new java.awt.Color(227, 6, 19));
        btn_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_excluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_excluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_excluirMouseExited(evt);
            }
        });

        lbl_entrar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_entrar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_entrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_entrar.setText("Excluir");

        javax.swing.GroupLayout btn_excluirLayout = new javax.swing.GroupLayout(btn_excluir);
        btn_excluir.setLayout(btn_excluirLayout);
        btn_excluirLayout.setHorizontalGroup(
            btn_excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_entrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        btn_excluirLayout.setVerticalGroup(
            btn_excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_entrar, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_funcionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_funcionarioMouseClicked
        new FrmSelecionarFuncionario(this).setVisible(true);
    }//GEN-LAST:event_lbl_funcionarioMouseClicked

    private void btn_salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseClicked
        if (validarCampos()) {
            if (action == ACTION_INSERT) {
                supervisor = new Usuario();
                supervisor.setLogin(txt_login.getText());
                char[] pass = txt_senha.getPassword();
                supervisor.setSenha(senhaToString(pass));
                supervisor.setMatricula(funcionario.getMatricula());
                UsuarioDao dao = new UsuarioDao(supervisor);
                boolean resultado = dao.inserir();
                if(resultado) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "O login usado já está sendo usado, tente novamente com outro login.");
                }
                controle.setList(dao.buscarTodos("where status_supervisor != 0"));
                dao.closeConnection();
            } else {
                supervisor.setTemp_login(supervisor.getLogin());
                supervisor.setLogin(txt_login.getText());
                char pass[] = txt_senha.getPassword();
                supervisor.setSenha(senhaToString(pass));
                supervisor.setMatricula(funcionario.getMatricula());
                UsuarioDao dao = new UsuarioDao(supervisor);
                boolean resultado = dao.editar();
                if(resultado) {
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "O login usado já está sendo usado, tente novamente com outro login.");
                }
                controle.setList(dao.buscarTodos("where status_supervisor != 0"));
                dao.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos foram preenchidos");
        }
    }//GEN-LAST:event_btn_salvarMouseClicked

    private void btn_salvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseEntered
        // TODO add your handling code here:
        btn_salvar.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_btn_salvarMouseEntered

    private void btn_salvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseExited
        // TODO add your handling code here:
        btn_salvar.setBackground(new Color(227,6,19));
    }//GEN-LAST:event_btn_salvarMouseExited

    private void btn_excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_excluirMouseClicked
        int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuário?");

        if (result == 0) {
            UsuarioDao dao = new UsuarioDao(supervisor);
            dao.excluir();
            controle.setList(dao.buscarTodos("where status_supervisor != 0"));
            dao.closeConnection();
        }
    }//GEN-LAST:event_btn_excluirMouseClicked

    private void btn_excluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_excluirMouseEntered
        btn_salvar.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_btn_excluirMouseEntered

    private void btn_excluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_excluirMouseExited
        btn_salvar.setBackground(new Color(227,6,19));
    }//GEN-LAST:event_btn_excluirMouseExited

    private String senhaToString(char[] pass) {
        String senha = "";

        for (int i = 0; i < pass.length; i++) {
            senha += Character.toString(pass[i]);
        }
        return senha;
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
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_excluir;
    private javax.swing.JPanel btn_salvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_cancel;
    private javax.swing.JLabel lbl_entrar;
    private javax.swing.JLabel lbl_funcionario;
    private javax.swing.JTextField txt_login;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
