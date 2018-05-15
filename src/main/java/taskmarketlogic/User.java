package taskmarketlogic;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
	private String martialStatus;

	
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
	public void setMartialStatus(String status) {
        this.martialStatus = status;
    }
	
    public String getMartialStatus() {
        return martialStatus;
    }
}