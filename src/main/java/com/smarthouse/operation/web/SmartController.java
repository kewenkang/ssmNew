package com.smarthouse.operation.web;

import com.smarthouse.operation.dataobject.Smart;
import com.smarthouse.operation.service.SmartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/smart")
public class SmartController {

    @Resource
    private SmartService smartService;

    @RequestMapping(value = "getSmartList",method = RequestMethod.GET)
    public String getSmartList(ModelMap modelMap){
        List<Smart> smartList=smartService.getSmartList();
        modelMap.put("smartList",smartList);
        return "smartList";
    }
}
