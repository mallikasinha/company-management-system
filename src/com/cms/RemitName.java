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
public class RemitName {

    private  String remitsName;
    private  int id;


    public RemitName(String remitsName, int id) {
        this.remitsName = remitsName;
        this.id = id;

    }

    public String getRemitName() {
        return remitsName;
    }

    public int getId() {
        return id;

    }

    @Override
    public String toString() {
        return remitsName;
    }
}
