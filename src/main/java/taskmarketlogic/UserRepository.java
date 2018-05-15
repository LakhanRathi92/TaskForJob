package taskmarketlogic;
 
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
 
}