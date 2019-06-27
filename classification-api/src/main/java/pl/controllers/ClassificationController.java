package pl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.messages.ClassificationTarget;
import pl.messages.Customer;
import pl.services.ConvolutionalNetworkService;

@RestController
@RequestMapping("classify")
public class ClassificationController {

    @Autowired
    private ConvolutionalNetworkService convolutionalNetworkService;

    @PostMapping
    public ClassificationTarget classify(@RequestBody Customer customer){
        return convolutionalNetworkService.classfiy(customer);
    }
}
