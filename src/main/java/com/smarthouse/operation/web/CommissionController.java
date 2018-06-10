package com.smarthouse.operation.web;


import com.smarthouse.operation.SalaryUtil;
import com.smarthouse.operation.dataobject.Sale;
import com.smarthouse.operation.dataobject.Smart;
import com.smarthouse.operation.dataobject.User;
import com.smarthouse.operation.service.CommissionService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/middleware/commission")
public class CommissionController {
    @Resource
    CommissionService commissionService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public void addSalePerson(String username, String password, HttpServletRequest request, HttpServletResponse response)throws Exception{
        JSONObject result = new JSONObject();
        System.out.println(username);
        User user = commissionService.getUserByName(username);
        if (user == null){
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean added = commissionService.addSalePerson(user);
            if (added){
                result.put("success", true);
                result.put("code", 200);
                result.put("result", "register saleperson success.");
            }else{
                result.put("success", true);
                result.put("code", 200);
                result.put("result", "register saleperson failed!");
            }

        }else{
            result.put("success", true);
            result.put("code", 200);
            result.put("result", "username already exists!");
        }

        response.getWriter().print(result);
    }

    @RequestMapping(value = "getAllSalePerson",method = RequestMethod.GET)
    public void getAllSalePerson(HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<User> userList = commissionService.getAllSalePerson();
        JSONObject result = new JSONObject();
        result.put("success", true);
        result.put("code", 200);
        result.put("result", userList);

        response.getWriter().print(result);
    }

    @RequestMapping(value = "makeADeal",method = RequestMethod.POST)
    public String makeADeal(Sale sale, HttpSession session, ModelMap modelMap, HttpServletResponse response)throws Exception{
        System.out.println(sale.toString());
        String username = (String) session.getAttribute("username");
        Integer userId = (Integer) session.getAttribute("userId");
        System.out.println(username+", "+userId);
        User saleperson = commissionService.getUserById(userId);
        sale.setSaleperson(saleperson);

        List<Sale> sales = commissionService.getSalesBySalePersonMonthly(userId, sale.getYear(), sale.getMonth());
        int locks = 0;
        int stocks = 0;
        int barrels = 0;
        for (Sale sale_: sales){
            locks += sale_.getLocksNum();
            stocks += sale_.getStocksNum();
            barrels += sale_.getBarrelsNum();
        }
        locks += sale.getLocksNum();
        stocks += sale.getStocksNum();
        barrels += sale.getBarrelsNum();

        if (locks > 70 || stocks > 80 || barrels > 90){
            modelMap.put("success", false);
            modelMap.put("code", 200);
            modelMap.put("result", "You can only sale at most 70 locks, 80 stocks, and 90 barrels in a month!");
            modelMap.put("user", saleperson);
            modelMap.put("sales", commissionService.getSalesBySalePerson(saleperson.getId()));
        }else{
            boolean added = commissionService.makeADeal(sale);
            if (added){
                modelMap.put("success", true);
                modelMap.put("code", 200);
                modelMap.put("result", "make a deal successfully.");
                modelMap.put("user", saleperson);
                modelMap.put("sales", commissionService.getSalesBySalePerson(saleperson.getId()));
            }else{
                modelMap.put("success", true);
                modelMap.put("code", 200);
                modelMap.put("result", "make a deal failed.");
                modelMap.put("user", saleperson);
                modelMap.put("sales", commissionService.getSalesBySalePerson(saleperson.getId()));
            }
        }
        return "index";

    }

    @RequestMapping(value = "getSalaryMonthly",method = RequestMethod.POST)
    public String getSalaryMonthly(Integer year, Integer month, ModelMap modelMap, HttpSession session, HttpServletResponse response)throws Exception{

        Integer userId = (Integer) session.getAttribute("userId");
        String username = (String) session.getAttribute("username");
        List<Sale> sales = commissionService.getSalesBySalePersonMonthly(userId, year, month);
        int locks = 0;
        int stocks = 0;
        int barrels = 0;
        for (Sale sale: sales){
            locks += sale.getLocksNum();
            stocks += sale.getStocksNum();
            barrels += sale.getBarrelsNum();
        }
        String msg;
        if (locks >0 && stocks > 0 && barrels > 0){

            int sum = locks * 45 + stocks * 30 + barrels * 25;
            float commission = SalaryUtil.getSalary(sum);
            msg = year + "-" + month + ", you sold locks: " + locks + ", " + "stocks: " + stocks + ", " +"barrels: " + barrels
                    + ". Your sale is " + sum + ", and your commission is " + commission + ".";
        }else{
            msg = year + "-" + month + ", you sold locks: " + locks + ", " + "stocks: " + stocks + ", " +"barrels: " + barrels
                    + ". Beacuse you do not sale a complete rifle, your commission is 0.0.";
        }

        modelMap.put("success", true);
        modelMap.put("code", 200);
        modelMap.put("result", "success.");
        modelMap.put("msg", msg);
        modelMap.put("locks", locks);
        modelMap.put("stocks", stocks);
        modelMap.put("barrels", barrels);

        return "detail";
    }

    @RequestMapping(value = "getUserSalaryMonthly",method = RequestMethod.POST)
    public String getUserSalaryMonthly(Integer id, Integer year, Integer month, ModelMap modelMap, HttpSession session, HttpServletResponse response)throws Exception{

        User saleperson = commissionService.getUserById(id);
        List<Sale> sales = commissionService.getSalesBySalePersonMonthly(id, year, month);
        int locks = 0;
        int stocks = 0;
        int barrels = 0;
        for (Sale sale: sales){
            locks += sale.getLocksNum();
            stocks += sale.getStocksNum();
            barrels += sale.getBarrelsNum();
        }
        String msg;
        if (locks >0 && stocks > 0 && barrels > 0){

            int sum = locks * 45 + stocks * 30 + barrels * 25;
            float commission = SalaryUtil.getSalary(sum);
            msg = year + "-" + month + ", " + saleperson.getUsername() + " sold locks: " + locks + ", " + "stocks: " + stocks + ", " +"barrels: " + barrels
                    + ". His/Her sale is " + sum + ", and his/her commission is " + commission + ".";
        }else{
            msg = year + "-" + month + ", " + saleperson.getUsername() + " sold locks: " + locks + ", " + "stocks: " + stocks + ", " +"barrels: " + barrels
                    + ". Beacuse he/she do not sale a complete rifle, his/her commission is 0.0.";
        }

        modelMap.put("success", true);
        modelMap.put("code", 200);
        modelMap.put("result", "success.");
        modelMap.put("msg", msg);
        modelMap.put("locks", locks);
        modelMap.put("stocks", stocks);
        modelMap.put("barrels", barrels);

        return "detail";
    }


    @RequestMapping(value = "index",method = RequestMethod.POST)
    public String getSmartList(User user, HttpSession session, ModelMap modelMap){
        User u = commissionService.getUserByName(user.getUsername());
        System.out.println(u.toString());
        if (u == null){
            modelMap.put("success", false);
            modelMap.put("code", 200);
            modelMap.put("result", "no such user!");
            return "login";
        }else {
            if (u.getPassword().equals(user.getPassword())){
                session.setAttribute("userId",u.getId());
                session.setAttribute("username",u.getUsername());
                if (u.getType() == 1){
                    //saleperson homepage

                    List<Sale> sales = commissionService.getSalesBySalePerson(u.getId());
                    modelMap.put("success", true);
                    modelMap.put("code", 200);
                    modelMap.put("user", u);
                    modelMap.put("sales", sales);
                    return "index";
                }else{
                    //gunsmith homepage
                    List<User> saleperson = commissionService.getAllSalePerson();
                    List<Sale> sales = commissionService.getAllSales();
                    modelMap.put("success", true);
                    modelMap.put("code", 200);
                    modelMap.put("user", u);
                    modelMap.put("salepersons", saleperson);
                    modelMap.put("sales", sales);
                    return "admin";
                }
            }else{
                modelMap.put("success", false);
                modelMap.put("code", 200);
                modelMap.put("result", "Password is incorrect!");
                return "login";
            }
        }

    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String index(){
        return "login";
    }
}
