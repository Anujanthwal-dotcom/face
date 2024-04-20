import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.codec.CodecConfigurer.MultipartCodecs;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class controller {
    
    





    @PostMapping("/upload")
    public String[] ImagefromFrontend(@RequestParam("file") MultipartFile multipartFile) {

        

        ///loop for checking all the student
       
            Service.presentStudents(multipartFile);
            
        
        return presentStudents;
    }
    
}
