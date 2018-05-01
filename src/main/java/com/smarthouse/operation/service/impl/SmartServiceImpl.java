package com.smarthouse.operation.service.impl;

import com.smarthouse.operation.dao.SmartDAO;
import com.smarthouse.operation.dataobject.Smart;
import com.smarthouse.operation.service.SmartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: davidddl
 * @Date: 2018/5/2 01:30
 * @Description:
 */
@Service
public class SmartServiceImpl implements SmartService {

    @Resource
    SmartDAO smartDAO;

    public boolean addSmart(Smart smart) {
        return false;
    }

    public boolean deleteSmart(Smart smart) {
        return false;
    }

    public List<Smart> getSmartList() {
        return smartDAO.getSmartList();
    }

    public List<Smart> getSmartByType(String type) {
        return null;
    }

    public Smart getSmartByID(Integer id) {
        return null;
    }
}
