package com.smarthouse.operation.service;

import com.smarthouse.operation.dataobject.Sale;
import com.smarthouse.operation.dataobject.User;

import java.util.List;


public interface CommissionService {
    boolean addSalePerson(User user);
    List<User> getAllSalePerson();
    User getUserByName(String name);
    User getUserById(Integer id);

    boolean makeADeal(Sale sale);
    List<Sale> getAllSales();
    List<Sale> getSalesBySalePerson(Integer id);
    List<Sale> getSalesBySalePersonMonthly(Integer id, Integer year, Integer month);

    boolean permitSalePerson(User user);
    boolean unpermitSalePerson(User user);
}
