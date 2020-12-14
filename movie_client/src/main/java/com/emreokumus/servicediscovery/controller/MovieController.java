package com.emreokumus.servicediscovery.controller;

import com.emreokumus.servicediscovery.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String getMovie(Model model){
        try{
            List<ServiceInstance> instances=discoveryClient.getInstances("Movie-Server-Service");
            if(instances!=null && !instances.isEmpty()){
                ServiceInstance serviceInstance=instances.get(0);
                String url=serviceInstance.getUri().toString();
                url=url+"/list";
                RestTemplate restTemplate =new RestTemplate();
                List<Movie> result=restTemplate.getForObject(url,List.class);
                model.addAttribute("result",result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "movie.html";
        }
    }
}
