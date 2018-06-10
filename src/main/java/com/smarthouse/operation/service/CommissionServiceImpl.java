package com.smarthouse.operation.service;

import com.smarthouse.operation.dao.CommissionDAO;
import com.smarthouse.operation.dataobject.Sale;
import com.smarthouse.operation.dataobject.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommissionServiceImpl implements CommissionService {

    @Resource
    CommissionDAO commissionDAO;


    public boolean addSalePerson(User user) {

        return commissionDAO.addSalePerson(user);

    }


    public List<User> getAllSalePerson() {
        return commissionDAO.getAllSalePerson();
    }

    public User getUserByName(String name) {
        return commissionDAO.getUserByName(name);
    }

    public User getUserById(Integer id) {
        return commissionDAO.getUserById(id);
    }

    public boolean makeADeal(Sale sale) {
        return commissionDAO.makeADeal(sale);
    }

    public List<Sale> getAllSales() {
        return commissionDAO.getAllSales();
    }

    public List<Sale> getSalesBySalePerson(Integer id) {
        return commissionDAO.getSalesBySalePerson(id);
    }

    public List<Sale> getSalesBySalePersonMonthly(Integer id, Integer year, Integer month) {
        return commissionDAO.getSalesBySalePersonMonthly(id, year, month);
    }

    public boolean permitSalePerson(User user) {
        return commissionDAO.permitSalePerson(user);
    }

    public boolean unpermitSalePerson(User user) {
        return commissionDAO.unpermitSalePerson(user);
    }
}
