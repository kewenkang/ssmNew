package com.smarthouse.operation.dao;

import com.smarthouse.operation.dataobject.Smart;

import java.util.List;

/**
 * @Auther: davidddl
 * @Date: 2018/5/2 01:27
 * @Description:
 */
public interface SmartDAO {

    boolean addSmart(Smart smart);
    boolean deleteSmart(Smart smart);
    List<Smart> getSmartList();
    List<Smart> getSmartByType(String type);
    Smart getSmartByID(Integer id);

}
