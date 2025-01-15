package sg.edu.nus.iss.paf_day24_wsA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.paf_day24_wsA.models.Order;
import sg.edu.nus.iss.paf_day24_wsA.services.OrderService;
import sg.edu.nus.iss.paf_day24_wsA.util.OrderUtil;

@Controller
@RequestMapping("")
public class OrderController {
    
    @Autowired
    OrderUtil orderUtil;

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public String showOrderForm() {
        return "order";
    }


    @PostMapping("/order")
    public String processOrder(@RequestParam MultiValueMap<String, String> data, Model model) {

        Order order = orderUtil.createOrder(data);
        System.out.println(order);

        int orderId = orderService.processOrder(order);

        



        model.addAttribute("order", order);
        model.addAttribute("orderId", orderId);

        return "orderOverview";
    }
}
