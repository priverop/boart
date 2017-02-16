package com.boart;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class index {
 
 @RequestMapping("/")
 @ResponseBody
 String home() {
 return "HolaMundo";
 }
}