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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author Mallika
 */
public class LedgerName {

    private final String ledgerName;
    private final int id;

    public LedgerName(String ledgerName, int id) {
        this.ledgerName = ledgerName;
        this.id = id;
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
