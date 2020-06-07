/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.utility;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class Util {
 
    public static BigDecimal computeDiscount(BigDecimal base, BigDecimal percent) {
        return base.subtract(base.multiply(percent).divide(new BigDecimal(100)));

    }
}
