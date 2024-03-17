import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FaceAppData")
public class student {
    @Id
    public long _Id;
    public String FaceParameters;

    public int year;
    public int age;
}
