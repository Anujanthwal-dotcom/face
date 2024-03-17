import org.springframework.http.codec.CodecConfigurer.MultipartCodecs;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class controller {
    
    public service Service;
    @PostMapping("/upload")
    public String ImagefromFrontend(@RequestParam("file") MultipartFile multipartFile) {

        ///loop for checking all the student
       
            Service.recognition(multipartFile);
            
        
        return "The attendence will be marked shortly";
    }
    
}
