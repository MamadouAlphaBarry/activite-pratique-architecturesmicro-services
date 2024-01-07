package enset.sid.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Config {
    /**
     * CustomerLabel="CustomerLabel"
     * customerLabelParam1=346
     * customerLabel=888
     */
   @Value("${CustomerLabel}")
    private String label;
   @Value("${customerLabelParam1}")
    private int param1;
   @Value("${customerLabel}")
   private int param2;

   @GetMapping("/testConfig")
   public Map getCOnfiguration(){
       return  Map.of("label",label,"param1",param1,"param2",param2);
   }


}
