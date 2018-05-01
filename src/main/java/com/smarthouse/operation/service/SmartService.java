package com.smarthouse.operation.service;

import com.smarthouse.operation.dataobject.Smart;

import java.util.List;

/**
 * @Auther: davidddl
 * @Date: 2018/5/2 01:29
 * @Description:
 */
public interface SmartService {

    boolean addSmart(Smart smart);
    boolean deleteSmart(Smart smart);
    List<Smart> getSmartList();
    List<Smart> getSmartByType(String type);
    Smart getSmartByID(Integer id);
}
