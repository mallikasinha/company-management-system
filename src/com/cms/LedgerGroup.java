/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JTextField;
import static org.jdesktop.beansbinding.BeanProperty.create;
import static org.jdesktop.beansbinding.BeanProperty.create;
import static org.jdesktop.beansbinding.BeanProperty.create;
import static org.jdesktop.beansbinding.BeanProperty.create;

/**
 *
 * @author Mallika
 */
public class LedgerGroup extends javax.swing.JInternalFrame {

    private ResultSet resultSetForInnerLoop = null;
    private ResultSet rs = null;
    private ResultSet rsForAffectedList = null;
    private Session session;
    private Connection con = null;
    private PreparedStatement stmtForAffectedList = null;

    private PreparedStatement stmtForInnerLoop = null;
    private PreparedStatement stmt = null;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form LedgerGroup
     */
    public LedgerGroup(Session session) {

        initComponents();

        LedgerGroup();
        this.session = session;
        model.addColumn("Ledger Group Name");
        model.addColumn("Ledger Affected");
        model = getLedgerGroup(model);
        table.setModel(model);

    }

    public DefaultTableModel getLedgerGroup(DefaultTableModel model) {
        model.setRowCount(0);
        try {
            con = Connector.getConnection();
            String sqlToShowInTable = "SELECT * FROM ledger_group_name WHERE company_id=0 OR company_id='" + session.getCompanyID() + "' ORDER BY ledger_group_id DESC";

            stmt = con.prepareStatement(sqlToShowInTable);
            rs = stmt.executeQuery();

            int affectId = 0;
            int ledgerGroupId = 0;
            while (rs.next()) {
                ledgerGroupId = rs.getInt("ledger_group_id");
                String sqlToShowAffectedName = "SELECT ledger_affect.name from ledger_group_affect INNER JOIN ledger_affect on ledger_group_affect.affect_id = ledger_affect.affectId  WHERE ledger_group_affect.ledger_id=" + ledgerGroupId;
                stmtForInnerLoop = con.prepareStatement(sqlToShowAffectedName);
                resultSetForInnerLoop = stmtForInnerLoop.executeQuery();
                String affectedNameList = "";
                int i = 0;
                while (resultSetForInnerLoop.next()) {
                    if (i == 0) {
                        affectedNameList += resultSetForInnerLoop.getString("name");
                        i++;
                    } else {
                        affectedNameList += ", " + resultSetForInnerLoop.getString("name");
                    }

                }

                model.addRow(new Object[]{rs.getString("ledger_group_name"), affectedNameList});

            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
//    private void call(int i) {
//        try {
//            txtLedgerGroupName.setText(model.getValueAt(i, 0).toString());
//            // jledgerAffected.s(model.getValueAt(i, 1).toString());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERRor");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLedgerGroupName = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jledgerAffected = new javax.swing.JList<>();
        jledgerAffected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ledger Group");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ledger Group Name:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ledger Affect:");

        txtLedgerGroupName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLedgerGroupName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLedgerGroupNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLedgerGroupNameKeyTyped(evt);
            }
        });

        create.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        create.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createKeyPressed(evt);
            }
        });

        jledgerAffected.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jledgerAffected.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jledgerAffected.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jledgerAffectedKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jledgerAffected);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLedgerGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtLedgerGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Ledger Group Name", "Ledger Affect"
            }
        ));
        jScrollPane1.setViewportView(table);
        table.getAccessibleContext().setAccessibleParent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void LedgerGroup() {
        con = Connector.getConnection();
        final ArrayList<String> name = new ArrayList<String>();

        DefaultListModel defaultListModel = new DefaultListModel(); //create a new list model
        model.setRowCount(0);
        try {
            String sqlSelectDataForJList = "SELECT affectId,name FROM ledger_affect";
            stmt = con.prepareStatement(sqlSelectDataForJList);//run your query
            rs = stmt.executeQuery();
            while (rs.next()) //go through each row that your query returns
            {
                String itemCode = rs.getString("name");
                defaultListModel.addElement(itemCode); //add each item to the model
                jledgerAffected.setModel(defaultListModel);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private String createLedgerMethod(String createLedger) {
        int index = jledgerAffected.getSelectedIndex();

        if (txtLedgerGroupName.getText() == null || index < 0) {
            JOptionPane.showMessageDialog(null, "please fill the form!!!");

        } else {
            try {

                List<String> arrayData = new ArrayList<>(jledgerAffected.getSelectedValuesList());
                String sqlToSelectCompanyWithSinglePanNo = "SELECT COUNT(*) AS rowcount from ledger_group_name where ledger_group_name=?";
                stmt = con.prepareStatement(sqlToSelectCompanyWithSinglePanNo);
                stmt.setString(1, txtLedgerGroupName.getText());
                rs = stmt.executeQuery();

                int rowCount = 0;
                while (rs.next()) {
                    rowCount = rs.getInt("rowcount");
                }
                if (rowCount == 0) {
                    String sqlToInsertIntoLedgerGroupName = "insert into ledger_group_name (ledger_group_name,company_id,user_id)values(?,?,?)";
                    stmt = con.prepareStatement(sqlToInsertIntoLedgerGroupName, Statement.RETURN_GENERATED_KEYS);
                    stmt.setString(1, txtLedgerGroupName.getText());
                    stmt.setInt(2, session.getCompanyID());
                    stmt.setInt(3, session.getUserId());
                    //  stmt.setDate(4, (java.sql.Date)session.getFinacialYearFrom());

                    stmt.executeUpdate();
                    rs = stmt.getGeneratedKeys();
                    int ledgerGroupId = 0;
                    if (rs.next()) {
                        ledgerGroupId = rs.getInt(1);
                    }
                    for (int i = 0; i < arrayData.size(); i++) {
                        String ledgerAffectName = arrayData.get(i);
                        String sqlToGetTheId = "select * from ledger_affect where name = '" + ledgerAffectName + "'";
                        stmt = con.prepareStatement(sqlToGetTheId);
                        rs = stmt.executeQuery();
                        int affectedId = 0;
                        if (rs.next());
                        {
                            affectedId = rs.getInt("affectId");
                        }
                        String sqlToInsertInLedgerGroupAfect = "insert into ledger_group_affect(ledger_id,affect_id)values(" + ledgerGroupId + "," + affectedId + ")";
                        stmt = con.prepareStatement(sqlToInsertInLedgerGroupAfect);
                        stmt.executeUpdate();
                    }
                    model = getLedgerGroup(model);
                    table.setModel(model);
                }  else {
                    model = getLedgerGroup(model);
                    table.setModel(model);
                    JOptionPane.showMessageDialog(null, "please type the ledger group name!!!");   }
                
            } catch (SQLException ex) {
                Logger.getLogger(LedgerGroup.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtLedgerGroupName.setText("");
        }
        return createLedger;
    }

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        String createLedger = "";
        createLedgerMethod(createLedger);
    }//GEN-LAST:event_createActionPerformed


    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased


    }//GEN-LAST:event_formKeyReleased

    private void txtLedgerGroupNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLedgerGroupNameKeyTyped

        if (txtLedgerGroupName.getText().length() >= 250) {
            evt.consume();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtLedgerGroupNameKeyTyped

    private void txtLedgerGroupNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLedgerGroupNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jledgerAffected.requestFocus();
        }    }//GEN-LAST:event_txtLedgerGroupNameKeyPressed

    private void jledgerAffectedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jledgerAffectedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            create.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jledgerAffectedKeyPressed

    private void createKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String createLedger = "";
            createLedgerMethod(createLedger);

        }    }//GEN-LAST:event_createKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            int i = table.getSelectedRow();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jledgerAffected;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtLedgerGroupName;
    // End of variables declaration//GEN-END:variables
}