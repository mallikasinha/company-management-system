/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.awt.event.KeyListener;

/**
 *
 * @author Mallika
 */
public class Company extends javax.swing.JFrame {
    
    DefaultTableModel model;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement stmt;
    private Session session;
    private int companyId;
    private String financialYear;

    /**
     * Creates new form Company
     */
    public Company(Session session) {
        this.session = session;
        model = new DefaultTableModel();
        initComponents();
        model.addColumn("Company Id");
        model.addColumn("Company Name");
        model.addColumn("Mailing Address");
        model.addColumn("Location Address");
        model.addColumn("Pan Number");
        model.addColumn("Telephone No");
        model.addColumn("Email Address");
        model.addColumn("Currency Symbol");
        
        model = getCompanyInformation(model);
        
        tableCompanyDetail.setModel(model);
        open.setOpaque(false);
        open.setContentAreaFilled(false);
        open.setBorderPainted(false);
        Action buttonAction = new AbstractAction("Insert") {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                String insert = "";
                insertCompanyDetail(insert);
                
            }
        };
        
        createCompanyButton.setAction(buttonAction);
        
        buttonAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        
        createCompanyButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), createCompanyButton);
        
        createCompanyButton.getActionMap().put(createCompanyButton, buttonAction);
        Action openAction = new AbstractAction("") {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                String open = "";
                passwordForm(open);
                
            }
        };
        
        open.setAction(openAction);
        
        openAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
        
        open.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK), open);
        
        open.getActionMap().put(open, openAction);
        
        //shortcut key for delete
          Action delAction = new AbstractAction("Delete") {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                String delete = "";
                deleteCompanyDetail(delete);
                
            }
        };
        
      delCompanyDetail.setAction(delAction);
        
        buttonAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_D);
        
        delCompanyDetail.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK), delCompanyDetail);
        
        delCompanyDetail.getActionMap().put(delCompanyDetail, delAction);
        
    }

    //
    public DefaultTableModel getCompanyInformation(DefaultTableModel model) {
        
        try {
            con = Connector.getConnection();
            String sql = "SELECT *FROM `company`";
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("company_id"), rs.getString("company_name"), rs.getString("mailing_address"), rs.getString("location_address"), rs.getString("pan_number"), rs.getString("telephone_no"), rs.getString("email_address"), rs.getString("currency_symbol")});
                
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
    
    Company() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompanyDetail = new javax.swing.JTable();
        createCompanyButton = new javax.swing.JButton();
        clearForm = new javax.swing.JButton();
        txtPassword1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCompanyCreate = new javax.swing.JTextField();
        txtMailingAddressCreate = new javax.swing.JTextField();
        textLocation_AddressCreate = new javax.swing.JTextField();
        txtPan = new javax.swing.JTextField();
        txtTelephoneCreate = new javax.swing.JTextField();
        txtEmailCreate = new javax.swing.JTextField();
        txtCurrencyCreate = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        open = new javax.swing.JButton();
        delCompanyDetail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1386, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tableCompanyDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Id", "Company Name ", "Mailing Address  ", "Location Address ", "Pan Number ", "Telephone No ", "Email Address ", "Currency Address ", "Financial Year From", "Entry Date "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCompanyDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCompanyDetailMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableCompanyDetailMousePressed(evt);
            }
        });
        tableCompanyDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableCompanyDetailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableCompanyDetailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableCompanyDetailKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tableCompanyDetail);

        createCompanyButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createCompanyButton.setText("create");
        createCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCompanyButtonActionPerformed(evt);
            }
        });
        createCompanyButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createCompanyButtonKeyPressed(evt);
            }
        });

        clearForm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearForm.setText("clear");
        clearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormActionPerformed(evt);
            }
        });

        txtPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword1.setText("Password:");

        jLabel14.setBackground(new java.awt.Color(0, 153, 204));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("*");

        jLabel15.setBackground(new java.awt.Color(0, 153, 204));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Company name:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Location Address:");

        jLabel17.setBackground(new java.awt.Color(0, 153, 204));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("*");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Mailing Address:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Telephone no:");

        jLabel20.setBackground(new java.awt.Color(0, 153, 204));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("*");

        jLabel21.setBackground(new java.awt.Color(0, 153, 204));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("*");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("PAN number:");

        jLabel23.setBackground(new java.awt.Color(0, 153, 204));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("*");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Email Address:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Currency Symbol:");

        txtCompanyCreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCompanyCreateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompanyCreateKeyTyped(evt);
            }
        });

        txtMailingAddressCreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMailingAddressCreateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMailingAddressCreateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailingAddressCreateKeyTyped(evt);
            }
        });

        textLocation_AddressCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLocation_AddressCreateActionPerformed(evt);
            }
        });
        textLocation_AddressCreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textLocation_AddressCreateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textLocation_AddressCreateKeyTyped(evt);
            }
        });

        txtPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPanActionPerformed(evt);
            }
        });
        txtPan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPanKeyTyped(evt);
            }
        });

        txtTelephoneCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelephoneCreateActionPerformed(evt);
            }
        });
        txtTelephoneCreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelephoneCreateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelephoneCreateKeyTyped(evt);
            }
        });

        txtEmailCreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailCreateKeyPressed(evt);
            }
        });

        txtCurrencyCreate.setText("Rs");
        txtCurrencyCreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCurrencyCreateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurrencyCreateKeyTyped(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        delCompanyDetail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delCompanyDetail.setText("Delete");
        delCompanyDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCompanyDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26)
                                            .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCompanyCreate)
                                    .addComponent(txtMailingAddressCreate)
                                    .addComponent(textLocation_AddressCreate)
                                    .addComponent(txtPan)
                                    .addComponent(txtTelephoneCreate)
                                    .addComponent(txtEmailCreate)
                                    .addComponent(txtCurrencyCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(txtPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(createCompanyButton)
                                .addGap(28, 28, 28)
                                .addComponent(clearForm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(delCompanyDetail)
                                .addGap(18, 18, 18)
                                .addComponent(open)
                                .addGap(49, 49, 49)))
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCompanyCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMailingAddressCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textLocation_AddressCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelephoneCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurrencyCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword1))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createCompanyButton)
                            .addComponent(clearForm)
                            .addComponent(open)
                            .addComponent(delCompanyDetail)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(261, 261, 261)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static java.sql.Timestamp getCurrentTimeStamp() {
        
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
        
    }

    private void createCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCompanyButtonActionPerformed
        String insert = "";
        insertCompanyDetail(insert);

    }//GEN-LAST:event_createCompanyButtonActionPerformed
    
    private String insertCompanyDetail(String insert) {
        int userId = session.getUserId();
        String companyName = txtCompanyCreate.getText();
        String mailingAddress = txtMailingAddressCreate.getText();
        String locationAddress = textLocation_AddressCreate.getText();
        String panNo = txtPan.getText();
        String telephoneNo = txtTelephoneCreate.getText();
        String email = txtEmailCreate.getText();
        String currency = txtCurrencyCreate.getText();
        String financial_year = session.getFinancialYearFrom();
        // String password = ;
        boolean status = EmailValidation.validateEmail(txtEmailCreate.getText());
        
        model.setRowCount(0);
        if (companyName.equals("") || mailingAddress.equals("") || locationAddress.equals("") || panNo.equals("") || telephoneNo.equals("") || currency.equals("")) {
            model = getCompanyInformation(model);
            
            tableCompanyDetail.setModel(model);
            
            JOptionPane.showMessageDialog(null, "please enter all the required field");
        } else if (!status) {
            model = getCompanyInformation(model);
            
            tableCompanyDetail.setModel(model);
            JOptionPane.showMessageDialog(null, "Email not validated");
        } else {
            try {
                con = Connector.getConnection();
                String sqlToSelectCompanyWithSinglePanNo = "SELECT COUNT(*) AS rowcount from company where pan_number=?";
                stmt = con.prepareStatement(sqlToSelectCompanyWithSinglePanNo);
                stmt.setString(1, txtPan.getText());
                rs = stmt.executeQuery();
                
                int rowCount = 0;
                while (rs.next()) {
                    rowCount = rs.getInt("rowcount");
                }
                if (rowCount == 0) {
                    
                    String sqlToInsertIntoCompany = "INSERT INTO `company`" + "(`company_name`,`mailing_address`,`location_address`,`pan_number`,`telephone_no`"
                            + ",`email_address`,`currency_symbol`,`entry_date`,`user_id`,`financial_year`,`password`) values" + "(?,?,?,?,?,?,?,?,?,?,MD5(?))";
                    
                    stmt = con.prepareStatement(sqlToInsertIntoCompany);
                    
                    stmt.setString(1, companyName);
                    stmt.setString(2, mailingAddress);
                    stmt.setString(3, locationAddress);
                    stmt.setString(4, panNo);
                    stmt.setString(5, telephoneNo);
                    stmt.setString(6, email);
                    stmt.setString(7, currency);
                    
                    stmt.setTimestamp(8, getCurrentTimeStamp());
                    stmt.setInt(9, session.getUserId());
                    stmt.setString(10, financial_year);
                    stmt.setString(11, txtPassword.getText());
                    
                    stmt.executeUpdate();
                    model = getCompanyInformation(model);
                    tableCompanyDetail.setModel(model);
                    
                } else {
                    model = getCompanyInformation(model);
                    tableCompanyDetail.setModel(model);
                    JOptionPane.showMessageDialog(null, "Company already created!!!");
                }

                //   } catch (ParseException ex) {
            } catch (SQLException ex) {
                Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return insert;
    }
    private void tableCompanyDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCompanyDetailMouseClicked
        
        int i = tableCompanyDetail.getSelectedRow();
        try {
            
            txtCompanyCreate.setText(model.getValueAt(i, 1).toString());
            txtMailingAddressCreate.setText(model.getValueAt(i, 2).toString());
            textLocation_AddressCreate.setText(model.getValueAt(i, 3).toString());
            txtPan.setText(model.getValueAt(i, 4).toString());
            txtTelephoneCreate.setText(model.getValueAt(i, 5).toString());
            txtEmailCreate.setText(model.getValueAt(i, 6).toString());
            txtCurrencyCreate.setText(model.getValueAt(i, 7).toString());
            
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "error ");
        }
    }//GEN-LAST:event_tableCompanyDetailMouseClicked
    

    private void tableCompanyDetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCompanyDetailKeyPressed
        
        con = Connector.getConnection();
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            
            int index = tableCompanyDetail.getSelectedRow();
            companyId = Integer.parseInt(model.getValueAt(index, 0).toString());
            
            TableModel model = tableCompanyDetail.getModel();
            
            session.setCompanyID(companyId);
            //session.setFinancialYearFrom(financialYear);
            Welcome welcome = new Welcome(session);
            welcome.setVisible(true);
            
        }

    }//GEN-LAST:event_tableCompanyDetailKeyPressed

    private void clearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormActionPerformed
        txtCompanyCreate.setText("");
        txtMailingAddressCreate.setText("");
        textLocation_AddressCreate.setText("");
        txtPan.setText("");
        txtTelephoneCreate.setText("");
        txtEmailCreate.setText("");
        txtCurrencyCreate.setText("");
        

    }//GEN-LAST:event_clearFormActionPerformed

    private void textLocation_AddressCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLocation_AddressCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLocation_AddressCreateActionPerformed

    private void txtPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPanActionPerformed

    private void txtTelephoneCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelephoneCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelephoneCreateActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void tableCompanyDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCompanyDetailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tableCompanyDetailKeyReleased

    private void tableCompanyDetailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCompanyDetailMousePressed

    }//GEN-LAST:event_tableCompanyDetailMousePressed
    private String passwordForm(String passwordForm) {
        con = Connector.getConnection();
        {
            try {
                int i = tableCompanyDetail.getSelectedRow();
                try {
                    txtCompanyCreate.setText(model.getValueAt(i, 1).toString());
                    txtMailingAddressCreate.setText(model.getValueAt(i, 2).toString());
                    textLocation_AddressCreate.setText(model.getValueAt(i, 3).toString());
                    txtPan.setText(model.getValueAt(i, 4).toString());
                    txtTelephoneCreate.setText(model.getValueAt(i, 5).toString());
                    txtEmailCreate.setText(model.getValueAt(i, 6).toString());
                    txtCurrencyCreate.setText(model.getValueAt(i, 7).toString());
                    
                    Object companyId = model.getValueAt(i, 0);
                    Object companyName = model.getValueAt(i, 1);
                    Object companyMaillingAddres = model.getValueAt(i, 2);
                    Object companyLocationAddress = model.getValueAt(i, 3);
                    Object panNumber = model.getValueAt(i, 4);
                    Object telephoneNo = model.getValueAt(i, 5);
                    Object emailAddress = model.getValueAt(i, 6);
                    Object currencySymbol = model.getValueAt(i, 7);
                    
                    List<String> companyDetailList = new ArrayList<String>();
                    String companyIds = Integer.toString((int) companyId);
                    
                    companyDetailList.add((String) companyIds);
                    companyDetailList.add((String) companyName);
                    companyDetailList.add((String) companyMaillingAddres);
                    companyDetailList.add((String) companyLocationAddress);
                    companyDetailList.add((String) panNumber);
                    companyDetailList.add((String) telephoneNo);
                    companyDetailList.add((String) emailAddress);
                    companyDetailList.add((String) currencySymbol);
                    session.setCompanyDetailList(companyDetailList);
                    
                } catch (Exception e) {
                    System.err.println(e);
                }
                
                Password pswd = new Password(session);
                pswd.setVisible(true);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "exception caught");
            }
        }
        return passwordForm;
    }
    private void tableCompanyDetailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCompanyDetailKeyTyped
        

    }//GEN-LAST:event_tableCompanyDetailKeyTyped

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        
        String open = "";
        passwordForm(open);

    }//GEN-LAST:event_openActionPerformed

    private void txtCompanyCreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyCreateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMailingAddressCreate.requestFocus();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyCreateKeyPressed

    private void txtMailingAddressCreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressCreateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            textLocation_AddressCreate.requestFocus();
        }
     }//GEN-LAST:event_txtMailingAddressCreateKeyPressed

    private void textLocation_AddressCreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textLocation_AddressCreateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPan.requestFocus();
        }
     }//GEN-LAST:event_textLocation_AddressCreateKeyPressed

    private void txtPanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelephoneCreate
                    .requestFocus();
        }
     }//GEN-LAST:event_txtPanKeyPressed

    private void txtTelephoneCreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneCreateKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            txtEmailCreate.requestFocus();
        }

     }//GEN-LAST:event_txtTelephoneCreateKeyPressed

    private void txtTelephoneCreateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneCreateKeyTyped
        if (txtTelephoneCreate.getText().length() >= 15) {
            evt.consume();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtTelephoneCreateKeyTyped

    private void txtCompanyCreateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyCreateKeyTyped
        
        if (txtCompanyCreate.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCompanyCreateKeyTyped

    private void txtMailingAddressCreateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressCreateKeyTyped
        if (txtMailingAddressCreate.getText().length() >= 15) {
            evt.consume();
        }    }//GEN-LAST:event_txtMailingAddressCreateKeyTyped

    private void textLocation_AddressCreateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textLocation_AddressCreateKeyTyped
        if (textLocation_AddressCreate.getText().length() >= 30) {
            evt.consume();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_textLocation_AddressCreateKeyTyped

    private void txtPanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPanKeyTyped
        if (txtTelephoneCreate.getText().length() >= 30) {
            evt.consume();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtPanKeyTyped

    private void txtCurrencyCreateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrencyCreateKeyTyped
        
        if (txtCurrencyCreate.getText().length() >= 15) {
            evt.consume();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtCurrencyCreateKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        
        if (txtPassword.getText().length() >= 20) {
            evt.consume();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtMailingAddressCreateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailingAddressCreateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailingAddressCreateKeyReleased

    private void txtEmailCreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailCreateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCurrencyCreate
                    .requestFocus();
        }

    }//GEN-LAST:event_txtEmailCreateKeyPressed

    private void txtCurrencyCreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrencyCreateKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword
                    .requestFocus();
        }
    }//GEN-LAST:event_txtCurrencyCreateKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            createCompanyButton
                    .requestFocus();
        }

    }//GEN-LAST:event_txtPasswordKeyPressed

    private void createCompanyButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createCompanyButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String save = "";
            insertCompanyDetail(save);
        }
    }//GEN-LAST:event_createCompanyButtonKeyPressed
    private String deleteCompanyDetail(String delete) {
        con = Connector.getConnection();
        String panNoD = txtPan.getText();
        
        if (tableCompanyDetail.getSelectedRow() != -1) {
            // remove selected row from the model
            model.removeRow(tableCompanyDetail.getSelectedRow());
            try {
                
                String sql = "Delete from company WHERE pan_number=?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, panNoD);
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "DATABASE DELETED");
                
                tableCompanyDetail.setModel(model);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
        return delete;
    }
    private void delCompanyDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCompanyDetailActionPerformed
        String delete = "";
        deleteCompanyDetail(delete);
// TODO add your handling code here:
    }//GEN-LAST:event_delCompanyDetailActionPerformed

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
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Company.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearForm;
    private javax.swing.JButton createCompanyButton;
    private javax.swing.JButton delCompanyDetail;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton open;
    private javax.swing.JTable tableCompanyDetail;
    public static javax.swing.JTextField textLocation_AddressCreate;
    public static javax.swing.JTextField txtCompanyCreate;
    public static javax.swing.JTextField txtCurrencyCreate;
    public static javax.swing.JTextField txtEmailCreate;
    public static javax.swing.JTextField txtMailingAddressCreate;
    private javax.swing.JTextField txtPan;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtPassword1;
    public static javax.swing.JTextField txtTelephoneCreate;
    // End of variables declaration//GEN-END:variables

}
