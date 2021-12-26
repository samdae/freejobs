package project.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class JobAdsController {
    
    private JobAdsService jobAdsService;
    
    @Autowired
    public JobAdsController(JobAdsService jobAdsService){
        this.jobAdsService = jobAdsService;
    }
    
    @GetMapping(path = "test")
    public @ResponseBody String test() {
        return jobAdsService.jobKorea();
    }
    
    @GetMapping(path = "okky")
    public void okky() {
        jobAdsService.okky();
    }
    @GetMapping(path = "saram")
    public void saram() {
        jobAdsService.saramin();
    }
    
    @GetMapping(path = "test/{txt}")
    public @ResponseBody String test(@PathVariable("txt") String txt) {
        System.out.println("in controller pathVariable ==>" + txt);
        return txt;
    }
    
    
    
}

