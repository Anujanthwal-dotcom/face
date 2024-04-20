import java.util.*;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.opencv.*;

// convert string to xml
import org.w3c.dom.Document;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class service {     
            @Autowired
            private MongoTemplate mongoTemplate;
            
            //list of students will be fetched
            public List<student> getAllIds() {
                return mongoTemplate.findAll(student.class,"faceAppData");
            }

            //converting to xml
            private Document convertStringToXMLDocument(String xmlString) {
                //Parser that produces DOM object trees from XML content
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
                //API to obtain DOM Document instance
                DocumentBuilder builder = null;
                try {
                //Create DocumentBuilder with default configuration
                builder = factory.newDocumentBuilder();
            
                //Parse the content to Document object
                Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
                return doc;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    
    
    


        public String[] presentStudents(MultipartFile file){
                    
                    //making a list to store the list
                
                    ArrayList<student> list =new ArrayList<student>();
                    
                    //get all students
                
                    list = getAllIds();

                    ///loop for checking a single student
                    //loop for checking all the student will be in the controller class
                    //how to fetch the xml file from the server


                                    for(student m:list){
                                        
                                                //converting the string containing xml content to xml
                                            
                                                Document data=convertStringToXMLDocument(m.FaceParameters);
                                            
                                                //putting in cascade classifier
                                            
                                                CascadeClassifier facecascade = new CascadeClassifier(data);

                                                Mat image = Imgcodecs.imread(file);

                                                // Convert the image to grayscale (required for face detection)
                                            
                                                Mat gray = new Mat();
                                                Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);

                                                // Detect faces using your custom classifier
                                            
                                                MatOfRect customFaces = new MatOfRect();
                                                customFaceCascade.detectMultiScale(gray, customFaces);

                                                
                                                
                                                //mark the attendence of that particular student


                                                if(customFaces.toArray().length==0){
                                                    continue;
                                                }
                                                else{
                                                    //mark the present
                                                    Arraylist.add(m.name);
                                                }

                                    }

                                    return list;

                }


}


