/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.utility.Util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer calculateBillAmount(Customer customer) {
        JSONObject customerSlabJson = new JSONObject();
        try (InputStream is = getClass().getResourceAsStream("/discount/" + customer.getType() + ".xml");
                Reader fileReader = new InputStreamReader(is);
                BufferedReader bufReader = new BufferedReader(fileReader);) {
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }
            String xml2String = sb.toString();
            customerSlabJson = XML.toJSONObject(xml2String);
        } catch (IOException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        BigDecimal billAmount = calculateBillAmount(customer.getPurchaseAmount(), customerSlabJson.getJSONArray("slab"), 0);
        customer.setBillAmount(billAmount);
        return customer;
    }

    private BigDecimal calculateBillAmount(BigDecimal amount, JSONArray slabs, int index) {
        JSONObject slab = slabs.getJSONObject(index);
        if (slab.getInt("range") != -1 && amount.compareTo(slab.getBigDecimal("range")) > 0) {
            amount = Util.computeDiscount(slab.getBigDecimal("range"), slab.getBigDecimal("discount")).add(calculateBillAmount(amount.subtract(slab.getBigDecimal("range")), slabs, index + 1));
        } else {
            amount = Util.computeDiscount(amount, slab.getBigDecimal("discount"));
        }
        return amount;
    }

}
