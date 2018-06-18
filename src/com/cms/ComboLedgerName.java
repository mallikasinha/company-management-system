/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms;

/**
 *
 * @author Mallika
 */
public class ComboLedgerName {

    private final String ledgerName;
    private final int id;

    public ComboLedgerName(String ledgerName, int id) {
        this.ledgerName = ledgerName;
        this.id = id;
    }

    ComboLedgerName(int ledgerGroupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getLedgerName() {
        return ledgerName;
    }

    public int getId() {
        return id;

    }

    @Override
    public String toString() {
        return ledgerName;
    }
}
