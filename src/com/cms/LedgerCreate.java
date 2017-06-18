/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms;

import com.fa.converter.DateConverter;
import com.remittance.constant.RemittanceConstants;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Mallika
 */
public class LedgerCreate extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    private Session session;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement stmt;

    String ledger;

    /**
     * Creates new form LedgerCreateUpdate
     */
    public LedgerCreate(Session session) {
        initComponents();
        this.session = session;
        con = Connector.getConnection();
        rs = null;
        stmt = null;
        model = new DefaultTableModel();
        model.addColumn("Ledger Name");
        model.addColumn("Ledger Group Name");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("PAN No");
        model = getLedgerCreate(model);
        tableLedgerCreate.setModel(model);
        try {
            con = Connector.getConnection();
            String sqlSelectDataForJComboBox = "SELECT ledger_group_id,ledger_group_name FROM ledger_group_name ";
            stmt = con.prepareStatement(sqlSelectDataForJComboBox);//run your query
            rs = stmt.executeQuery();
            int ledgerGroupId;
            String ledgerGroupName = "";
            while (rs.next()) //go through each row that your query returns
            {
                ledgerGroupName = rs.getString("ledger_group_name");
                ledgerGroupId = rs.getInt("ledger_group_id");
                //ledger = Integer.toString(ledgerGroupId);
                //  comboLedgerGroupName.setSelectedIndex(ledgerGroupId);

                comboLedgerGroupName.addItem(new ComboLedgerName(ledgerGroupName, ledgerGroupId));
                //comboLedgerGroupName.setSelectedItem(ledgerGroupId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LedgerCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Action buttonAction = new AbstractAction("Insert") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String insert = "";
                saveLedgerCreate(insert);

            }
        };

        saveButton.setAction(buttonAction);

        buttonAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);

        saveButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), saveButton);

        saveButton.getActionMap().put(saveButton, buttonAction);

    }
//to display in the table

    public DefaultTableModel getLedgerCreate(DefaultTableModel model) {

        try {
            con = Connector.getConnection();
            //  ResultSet Rs = stat.executeQuery("select customer.*, item.* from customer inner join item on customer.c_id=item.c_id ");
            String sql = "SELECT ledger_info.*, ledger_group_name.ledger_group_name FROM ledger_info INNER JOIN ledger_group_name ON ledger_info.ledgergroup_id = ledger_group_name.ledger_group_id WHERE ledger_info.company_id='" + session.getCompanyID() + "' OR ledger_info.company_id=0";
            // String sql = "SELECT ledger_info*,ledger_group_name* FROM ledger_info  JOIN ledger_group_name on ledger_info.ledgergroup_id=ledger_group_name.ledger_group_id";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ledger_name"), rs.getString("ledger_group_name"), rs.getString("name"), rs.getString("address"), rs.getString("pan")});
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMailingName = new javax.swing.JTextField();
        txtMailingAddress = new javax.swing.JTextField();
        txtMailingPan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtledgername = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLedgerCreate = new javax.swing.JTable();
        doubleOpeningBalance = new javax.swing.JTextField();
        comboDrCr = new javax.swing.JComboBox<>();
        comboLedgerGroupName = new javax.swing.JComboBox();
        saveButton1 = new javax.swing.JButton();
        clearTable = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ledger Create");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ledger Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ledger Group Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Opening Balance:");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Address:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("PAN No:");

        txtMailingName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMailingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailingNameActionPerformed(evt);
            }
        });
        txtMailingName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMailingNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailingNameKeyTyped(evt);
            }
        });

        txtMailingAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMailingAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailingAddressActionPerformed(evt);
            }
        });
        txtMailingAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMailingAddressKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailingAddressKeyTyped(evt);
            }
        });

        txtMailingPan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMailingPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailingPanActionPerformed(evt);
            }
        });
        txtMailingPan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMailingPanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailingPanKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMailingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMailingName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMailingPan, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMailingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMailingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMailingPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mailling Detail:");

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        saveButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        txtledgername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtledgername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtledgernameActionPerformed(evt);
            }
        });
        txtledgername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtledgernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtledgernameKeyTyped(evt);
            }
        });

        tableLedgerCreate.setAutoCreateRowSorter(true);
        tableLedgerCreate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableLedgerCreate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ledger Name", "Ledger Group", "Name", "Adddress", "PAN No."
            }
        ));
        jScrollPane1.setViewportView(tableLedgerCreate);

        doubleOpeningBalance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doubleOpeningBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleOpeningBalanceActionPerformed(evt);
            }
        });
        doubleOpeningBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                doubleOpeningBalanceKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doubleOpeningBalanceKeyTyped(evt);
            }
        });

        comboDrCr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboDrCr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr", "Cr" }));
        comboDrCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboDrCrKeyPressed(evt);
            }
        });

        comboLedgerGroupName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${ledgerGroupName}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, comboLedgerGroupName, eLProperty, comboLedgerGroupName);
        bindingGroup.addBinding(jComboBoxBinding);

        comboLedgerGroupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLedgerGroupNameActionPerformed(evt);
            }
        });
        comboLedgerGroupName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboLedgerGroupNameKeyPressed(evt);
            }
        });

        saveButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton1.setText("Clear form");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        clearTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearTable.setText("Clear table");
        clearTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(comboLedgerGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(saveButton)))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(saveButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(clearTable))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(doubleOpeningBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboDrCr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtledgername, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtledgername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboLedgerGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(doubleOpeningBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDrCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(saveButton1)
                    .addComponent(clearTable))
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtledgernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtledgernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtledgernameActionPerformed

    private void txtMailingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailingNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingNameActionPerformed

    private void txtMailingAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailingAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingAddressActionPerformed

    private void txtMailingPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailingPanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingPanActionPerformed

    private void doubleOpeningBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleOpeningBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleOpeningBalanceActionPerformed
    private String saveLedgerCreate(String ledgerCreate) {
        con = Connector.getConnection();
        model.setRowCount(0);
        ComboLedgerName comboLedgerName = (ComboLedgerName) comboLedgerGroupName.getSelectedItem();

        String ledgerName = txtledgername.getText();
        int ledgerNameId = comboLedgerName.getId();
        String mailingName = txtMailingName.getText();
        String mailingAddress = txtMailingAddress.getText();
        String mailingPan = txtMailingPan.getText();
        int companyId = session.getCompanyID();
        String financialYear = session.getFinancialYearFrom();
        int userId = session.getUserId();
        String openingBalance = doubleOpeningBalance.getText();
        if (ledgerName.equals("") || ledgerNameId == 0 || mailingName.equals("") || mailingAddress.equals("") || mailingPan.equals("") || openingBalance.equals("")) {
            model = getLedgerCreate(model);

            tableLedgerCreate.setModel(model);

            JOptionPane.showMessageDialog(null, "please enter all the required field");
        } else {

            try {

                String sqlInserIntoLedgerInfo = "INSERT INTO ledger_info (ledger_name,ledgergroup_id,name,address,pan,company_id,financial_year,user_id) VALUES (?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(sqlInserIntoLedgerInfo, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ledgerName);
                stmt.setInt(2, ledgerNameId);
                stmt.setString(3, mailingName);
                stmt.setString(4, mailingAddress);
                stmt.setString(5, mailingPan);
                stmt.setInt(6, companyId);
                stmt.setString(7, financialYear);
                stmt.setInt(8, userId);
                stmt.executeUpdate();

                rs = stmt.getGeneratedKeys();
                int ledgerId = 0;

                if (rs.next()) {
                    ledgerId = rs.getInt(1);

                }
                Float drAmount;
                Float crAmount;

                if ((comboDrCr.getSelectedItem().toString().equals("Dr"))) {
                    drAmount = Float.parseFloat(doubleOpeningBalance.getText());
                    crAmount = 0.0f;

                } else {
                    drAmount = 0.0f;
                    crAmount = Float.parseFloat(doubleOpeningBalance.getText());

                }
                String particular = "Opening Balance";
//                String date = session.getFinancialYearFrom();
//                String year = date.substring(0, 2);
//                String toConvertDDMM = RemittanceConstants.fiscalyearDDMMToConvert;
//                String toConvertDDMMYYYY = toConvertDDMM + RemittanceConstants.fiscalYearInitial + year;
//                String newDateBs = toConvertDDMMYYYY.substring(4, 7) + "-" + toConvertDDMMYYYY.substring(2, 3) + "-" + toConvertDDMMYYYY.substring(0, 1);
//
//                /*
//                Date conversion from BS to AD
//                 */
//                Date ad = null;
//                DateConverter dc = new DateConverter();
//                if (dc.matchFormat(toConvertDDMMYYYY)) {
//                    ad = dc.convertBsToAd(toConvertDDMMYYYY);
//                } else {
//                }
//                java.sql.Date newDateAd = new java.sql.Date(ad.getTime());
                //Date conversion ends here

                String sqlInsertIntoLedger = "INSERT INTO ledger(ledger_id,date_ad,date_bs,particular,dr,cr,balance,dr_cr,company_id,user_id,financial_year)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(sqlInsertIntoLedger);
                stmt.setInt(1, ledgerId);
//               String date = formattedDateAd.getText();
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            java.sql.Date sql = new java.sql.Date(parsed.getTime());
                stmt.setDate(2, null);
                stmt.setString(3, null);
                stmt.setString(4, particular);
                stmt.setFloat(5, drAmount);
                stmt.setFloat(6, crAmount);
                stmt.setFloat(7, Float.parseFloat(doubleOpeningBalance.getText()));//double quantity = Double.parseDouble(quantityTxt.getText());
                stmt.setString(8, comboDrCr.getSelectedItem().toString());
                stmt.setInt(9, session.getCompanyID());
                stmt.setInt(10, session.getUserId());
                stmt.setString(11, session.getFinancialYearFrom());

                stmt.executeUpdate();
                model = getLedgerCreate(model);
                tableLedgerCreate.setModel(model);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        return ledgerCreate;
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        String saveLedgerCreate = "";
        saveLedgerCreate(saveLedgerCreate);
    }//GEN-LAST:event_saveButtonActionPerformed

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }


    private void comboLedgerGroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLedgerGroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLedgerGroupNameActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        txtledgername.setText("");
        txtMailingName.setText("");
        txtMailingAddress.setText("");
        txtMailingPan.setText("");
        doubleOpeningBalance.setText("");
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void clearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableActionPerformed
        DefaultTableModel dm = (DefaultTableModel) tableLedgerCreate.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();        dm.fireTableDataChanged();    }//GEN-LAST:event_clearTableActionPerformed

    private void txtledgernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtledgernameKeyTyped

        if (txtledgername.getText().length() >= 30) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtledgernameKeyTyped

    private void txtMailingNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingNameKeyTyped

        if (txtMailingAddress.getText().length() >= 30) {
            evt.consume();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtMailingNameKeyTyped

    private void txtMailingAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressKeyTyped

        if (txtMailingAddress.getText().length() >= 30) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingAddressKeyTyped

    private void txtMailingPanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingPanKeyTyped

        if (txtMailingAddress.getText().length() >= 30) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingPanKeyTyped

    private void doubleOpeningBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doubleOpeningBalanceKeyTyped

        if (doubleOpeningBalance.getText().length() >= 10) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleOpeningBalanceKeyTyped

    private void txtledgernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtledgernameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comboLedgerGroupName.requestFocus();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtledgernameKeyPressed

    private void comboLedgerGroupNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboLedgerGroupNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMailingName.requestFocus();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_comboLedgerGroupNameKeyPressed

    private void txtMailingNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMailingAddress.requestFocus();
        }    }//GEN-LAST:event_txtMailingNameKeyPressed

    private void txtMailingAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMailingPan.requestFocus();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtMailingAddressKeyPressed

    private void txtMailingPanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingPanKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            doubleOpeningBalance.requestFocus();
        }
    }//GEN-LAST:event_txtMailingPanKeyPressed

    private void doubleOpeningBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doubleOpeningBalanceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comboDrCr.requestFocus();
        }    }//GEN-LAST:event_doubleOpeningBalanceKeyPressed

    private void comboDrCrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboDrCrKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveButton.requestFocus();
        }
    }//GEN-LAST:event_comboDrCrKeyPressed

    private void saveButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String saveLedgerCreate = "";
            saveLedgerCreate(saveLedgerCreate);
        }
    }//GEN-LAST:event_saveButtonKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearTable;
    private javax.swing.JComboBox<String> comboDrCr;
    private javax.swing.JComboBox comboLedgerGroupName;
    private javax.swing.JTextField doubleOpeningBalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveButton1;
    private javax.swing.JTable tableLedgerCreate;
    private javax.swing.JTextField txtMailingAddress;
    private javax.swing.JTextField txtMailingName;
    private javax.swing.JTextField txtMailingPan;
    private javax.swing.JTextField txtledgername;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
