package com.olm.operation.service;

import com.olm.operation.dataobject.Server;

import java.util.List;

public interface ServerService {
    public boolean addServer(String ip,String userName,String password);
    public Server getServer(String ip);
    public boolean delete(String ip);
    public List<Server> getServerList();
}
