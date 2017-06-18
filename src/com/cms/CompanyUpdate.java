/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mallika
 */
public class CompanyUpdate extends javax.swing.JFrame {

    private Session session;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection con;
    private String companyId;
    private DefaultTableModel model;
    private String CompanyName;
    private String MailingAddress;

    private String LocationAddress;

    private String TelephoneNo;

    private String EmailAddress;
    private String CurrencySymbol;
    private List<String> companyDetailList;

    private CompanyUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> getCompanyDetailList() {
        return companyDetailList;
    }

    /**
     * Creates new form CompanyUpdate
     */
    public CompanyUpdate(Session session) {
        initComponents();
        this.session = session;
        Action buttonAction = new AbstractAction("Update") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String updateCompanyDetail = "";
                updateCompanyDetail(updateCompanyDetail);
            }
        };

        String key = "Update";

        update.setAction(buttonAction);

        buttonAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);

        update.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), key);

        update.getActionMap().put(key, buttonAction);

    }

    CompanyUpdate(List<String> companyDetailList) {
        this.companyDetailList = companyDetailList;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        txtMailingAddress = new javax.swing.JTextField();
        txtLocationAddress = new javax.swing.JTextField();
        txtTelephoneNo = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        txtCurrencySymbol = new javax.swing.JTextField();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mailing Address:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Location Address:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Company Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Telephone Number:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email Address:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cuurency Symbol:");

        txtCompanyName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });
        txtCompanyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCompanyNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompanyNameKeyTyped(evt);
            }
        });

        txtMailingAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMailingAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMailingAddressKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailingAddressKeyTyped(evt);
            }
        });

        txtLocationAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLocationAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationAddressActionPerformed(evt);
            }
        });
        txtLocationAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocationAddressKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocationAddressKeyTyped(evt);
            }
        });

        txtTelephoneNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelephoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelephoneNoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelephoneNoKeyTyped(evt);
            }
        });

        txtEmailAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmailAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailAddressKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailAddressKeyTyped(evt);
            }
        });

        txtCurrencySymbol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCurrencySymbol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCurrencySymbolKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurrencySymbolKeyTyped(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCurrencySymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMailingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtLocationAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(update)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMailingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLocationAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCurrencySymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(update)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameActionPerformed


    private void txtLocationAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationAddressActionPerformed
    private String updateCompanyDetail(String update) {
        con = Connector.getConnection();
        CompanyName = txtCompanyName.getText();
        MailingAddress = txtMailingAddress.getText();
        LocationAddress = txtLocationAddress.getText();
        TelephoneNo = txtTelephoneNo.getText();
        EmailAddress = txtEmailAddress.getText();
        CurrencySymbol = txtCurrencySymbol.getText();
        List<String> companyDetailList = session.getCompanyDetailList();
        this.companyDetailList = companyDetailList;
        this.companyId = companyDetailList.get(0);

        boolean status = EmailValidation.validateEmail(EmailAddress);

        if (!status) {
            JOptionPane.showMessageDialog(null, "Email not validated");
        } else {
            try {
                String sqlToUpdateCompanyInfo = "UPDATE company SET company_name=?,mailing_address=?,location_address=?, telephone_no=?,"
                        + "email_address=?,currency_symbol=? WHERE company_id=?";
                stmt = con.prepareStatement(sqlToUpdateCompanyInfo);
                stmt.setString(1, CompanyName);
                stmt.setString(2, MailingAddress);
                stmt.setString(3, LocationAddress);
                stmt.setString(4, TelephoneNo);
                stmt.setString(5, EmailAddress);
                stmt.setString(6, CurrencySymbol);
                stmt.setString(7, companyId);
                stmt.executeUpdate();

                Company companyCreateForm = new Company(session);
                Company.txtCompanyCreate.setText(this.CompanyName.toString());
                Company.txtMailingAddressCreate.setText(this.MailingAddress.toString());
                Company.textLocation_AddressCreate.setText(this.LocationAddress.toString());
                Company.txtTelephoneCreate.setText(this.TelephoneNo.toString());
                Company.txtEmailCreate.setText(this.EmailAddress.toString());
                Company.txtCurrencyCreate.setText(this.CurrencySymbol.toString());
                companyCreateForm.setVisible(true);
                this.setVisible(false);

            } catch (SQLException ex) {
                Logger.getLogger(CompanyUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return update;

    }
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String updateCompanyDetail = "";
        updateCompanyDetail(updateCompanyDetail);
    }//GEN-LAST:event_updateActionPerformed

    private void txtCompanyNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyNameKeyTyped
        if (txtCompanyName.getText().length() >= 20) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameKeyTyped

    private void txtMailingAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressKeyTyped

        if (txtMailingAddress.getText().length() >= 30) {
            evt.consume();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtMailingAddressKeyTyped

    private void txtLocationAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocationAddressKeyTyped
        if (txtLocationAddress.getText().length() >= 30) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationAddressKeyTyped

    private void txtTelephoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneNoKeyTyped
        if (txtTelephoneNo.getText().length() >= 15) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelephoneNoKeyTyped

    private void txtEmailAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailAddressKeyTyped

        if (txtEmailAddress.getText().length() >= 30) {
            evt.consume();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtEmailAddressKeyTyped

    private void txtCurrencySymbolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrencySymbolKeyTyped
        if (txtCurrencySymbol.getText().length() >= 15) {
            evt.consume();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtCurrencySymbolKeyTyped

    private void txtCompanyNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMailingAddress.requestFocus();
        }    }//GEN-LAST:event_txtCompanyNameKeyPressed

    private void txtMailingAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtLocationAddress.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingAddressKeyPressed

    private void txtLocationAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocationAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelephoneNo.requestFocus();
        }

    }//GEN-LAST:event_txtLocationAddressKeyPressed

    private void txtTelephoneNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneNoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEmailAddress.requestFocus();
        }    }//GEN-LAST:event_txtTelephoneNoKeyPressed

    private void txtEmailAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCurrencySymbol.requestFocus();
        }    }//GEN-LAST:event_txtEmailAddressKeyPressed

    private void txtCurrencySymbolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrencySymbolKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            update.requestFocus();
        }    }//GEN-LAST:event_txtCurrencySymbolKeyPressed

    private void updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String updateCompanyDetail = "";
            updateCompanyDetail(updateCompanyDetail);
        }    }//GEN-LAST:event_updateKeyPressed

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
            java.util.logging.Logger.getLogger(CompanyUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField txtCompanyName;
    public static javax.swing.JTextField txtCurrencySymbol;
    public static javax.swing.JTextField txtEmailAddress;
    public static javax.swing.JTextField txtLocationAddress;
    public static javax.swing.JTextField txtMailingAddress;
    public static javax.swing.JTextField txtTelephoneNo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}