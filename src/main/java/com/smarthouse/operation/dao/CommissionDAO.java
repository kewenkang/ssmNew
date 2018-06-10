package com.smarthouse.operation.dao;


import com.smarthouse.operation.dataobject.Sale;
import com.smarthouse.operation.dataobject.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommissionDAO {
    boolean addSalePerson(User user);
    User getUserByName(String name);
    User getUserById(Integer id);
    List<User> getAllSalePerson();

    boolean makeADeal(Sale sale);

    List<Sale> getAllSales();
    List<Sale> getSalesBySalePerson(Integer id);
    List<Sale> getSalesBySalePersonMonthly(@Param("id") Integer id, @Param("year") Integer year, @Param("month") Integer month);

    boolean permitSalePerson(User user);
    boolean unpermitSalePerson(User user);

}
