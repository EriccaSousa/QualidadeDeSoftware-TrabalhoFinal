/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControlConvenio;
import control.ControlPaciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cobranca;
import model.bean.Consulta;
import model.bean.Paciente;
import model.dao.CobrancaDAO;
import model.dao.ConsultaDAO;

/**
 *
 * @author Luiz Oliveira
 */
public class TelaEfetuarPagamento extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadPaciente
     */
    public TelaEfetuarPagamento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableConsulta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        tfVtotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfCobertura = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tfConvenio = new javax.swing.JTextField();
        tfConsulta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNparcela = new javax.swing.JTextField();
        tfVparcela = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nome");

        tableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Consulta", "Nome", "Convenio", "Cobertura", "Valor Total", "N?? Parcelas", "Valor Parcelas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableConsultaMouseClicked(evt);
            }
        });
        tableConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableConsultaKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableConsulta);

        jLabel3.setText("Valor Total");

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Convenio");

        jButton4.setText("Alterar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jButton5.setText("Limpar Tabela");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Consulta");

        jLabel1.setText("Cobertura");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfConsultaActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor Parcela");

        jLabel8.setText("Numeros de  Parcelas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton3))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(130, 130, 130)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tfCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                            .addComponent(tfVtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfVparcela, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNparcela, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNparcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(tfConsulta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfVparcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfVtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableConsultaMouseClicked

        if (tableConsulta.getSelectedRow() != -1) {
            tfConsulta.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 0).toString());
            tfNome.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 1).toString());
            tfConvenio.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 2).toString());
            tfCobertura.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 3).toString());
            tfVtotal.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 4).toString());
            tfNparcela.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 5).toString());
            tfVparcela.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 6).toString());

        }
    }//GEN-LAST:event_tableConsultaMouseClicked

    private void tableConsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableConsultaKeyReleased

        if (tableConsulta.getSelectedRow() != -1) {
            tfConsulta.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 0).toString());
            tfNome.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 1).toString());
            tfConvenio.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 2).toString());
            tfCobertura.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 3).toString());
            tfVtotal.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 4).toString());
            tfNparcela.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 5).toString());
            tfVparcela.setText(tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 6).toString());

        }

    }//GEN-LAST:event_tableConsultaKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ConsultaDAO dao = new ConsultaDAO("mysql");
        List<String> campos = dao.selecionar(Integer.parseInt(tfConsulta.getText()));
        DefaultTableModel dtmConsulta = (DefaultTableModel) tableConsulta.getModel();
        Object[] dados = new Object[4];
        for (int i = 0; i < campos.size(); i++) {
            dados[i] = campos.get(i);
        }
        tableConsulta.setVisible(true);
        dtmConsulta.addRow(dados);
        
        CobrancaDAO dao2 = new CobrancaDAO("mysql");
        Cobranca cob = dao2.selectUm(Integer.parseInt(tfConsulta.getText()));
        dtmConsulta.setValueAt(cob.getValor(), 0, 4);
        dtmConsulta.setValueAt(cob.getNumparcela(), 0, 5);
        dtmConsulta.setValueAt(cob.getParcela(), 0, 6);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

       DefaultTableModel dtmConsulta = (DefaultTableModel) tableConsulta.getModel();
       dtmConsulta.setRowCount(0);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        CobrancaDAO dao = new CobrancaDAO("mysql");
        Cobranca cob = new Cobranca();
        Consulta cons = new Consulta();
        cob.setValor(Double.parseDouble(tfVtotal.getText()));
        cob.setNumparcela(Integer.parseInt(tfNparcela.getText()));
        cob.setParcela(Double.parseDouble(tfVparcela.getText()));
        cons.setCodigo(Integer.parseInt(tfConsulta.getText()));
        cob.setConsulta(cons);
        if (!dao.save(cob)) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a cobran??a.");
        } else {
            DefaultTableModel dtmPacientes = (DefaultTableModel) tableConsulta.getModel();
            Object[] dados = {tfVtotal.getText(), tfNparcela.getText(), tfVparcela.getText()};
            tableConsulta.setVisible(true);
            dtmPacientes.addRow(dados);
            JOptionPane.showMessageDialog(null, "Cobran??a efetuada com sucesso.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        CobrancaDAO dao = new CobrancaDAO("mysql");
        Cobranca cob = new Cobranca();
        cob.setValor(Double.parseDouble(tfVtotal.getText()));
        cob.setNumparcela(Integer.parseInt(tfNparcela.getText()));
        double tparc = cob.getValor() / cob.getNumparcela();
        cob.setParcela(tparc);
        Consulta cons = new Consulta();
        cons.setCodigo(Integer.parseInt(tfConsulta.getText()));
        cob.setConsulta(cons);
        int conscod = Integer.parseInt(tfConsulta.getText());
        tfVparcela.setText(""+tparc);
        if (dao.alterar(cob, conscod)) {
            DefaultTableModel dtmPacientes = (DefaultTableModel) tableConsulta.getModel();
            Object[] dados = {tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 0),tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 1),
                              tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 2),tableConsulta.getValueAt(tableConsulta.getSelectedRow(), 3),
                              tfVtotal.getText(), tfNparcela.getText(), tparc};
            tableConsulta.setVisible(true);
            dtmPacientes.insertRow(tableConsulta.getSelectedRow(), dados);
            dtmPacientes.removeRow(tableConsulta.getSelectedRow() + 1);
            JOptionPane.showMessageDialog(null, "Cobran??a efetuada com sucesso.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tfConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfConsultaActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEfetuarPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableConsulta;
    private javax.swing.JTextField tfCobertura;
    private javax.swing.JTextField tfConsulta;
    private javax.swing.JTextField tfConvenio;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNparcela;
    private javax.swing.JTextField tfVparcela;
    private javax.swing.JTextField tfVtotal;
    // End of variables declaration//GEN-END:variables
}
