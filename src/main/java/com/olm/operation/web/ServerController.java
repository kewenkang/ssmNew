package com.olm.operation.web;

import com.olm.operation.dataobject.Server;
import com.olm.operation.service.ServerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/server")
public class ServerController {

    @Resource
    private ServerService serverService;

    @RequestMapping(value = "/getServerList",method = RequestMethod.GET)
    public String getServerList(ModelMap modelMap){
        List<Server> serverList=serverService.getServerList();
        modelMap.put("serverList",serverList);
        return "serverList";
    }
}
