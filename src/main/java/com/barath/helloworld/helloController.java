package com.barath.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class helloController {
         @GetMapping("/")
         public String hello(){
            return "Hello World";
         }
         @GetMapping("/rmk")
         public String rmk(){
            return "it is a bot college";
         }
}
