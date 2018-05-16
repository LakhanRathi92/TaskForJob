package com.application.job.wordsuggestions;

import com.application.job.wordsuggestions.models.User;
import com.application.job.wordsuggestions.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;



import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT )
public class WordSuggestionsApplicationTests {


    @LocalServerPort
    private int port;

    private String hostname;

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup(){
        hostname = "http://localhost";
    }


    //Basic Test
    @Test
    public void homeTest() throws Exception {
        assertThat(this.restTemplate.getForObject(hostname + ":" + port + "/",
                String.class)).contains("Hello World");
    }

    //Read
    @Test
    public void getUserById() throws Exception{
        User user = new User();
        user = restTemplate.getForObject(hostname+":"+port+"/"+"users/10001",User.class);

        assertThat(user.getFirstName()).isEqualTo("Hamza");
        assertThat(user.getLastName()).isEqualTo("Anwar");
    }

    //Create
    @Test
    public void postUser() throws Exception{

        User testUser = new User();
        testUser.setId(90009);
        testUser.setFirstName("Bob");
        testUser.setLastName("Vegetarian");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity ret = restTemplate.postForEntity(hostname+":"+port+"/"+"user/", testUser, ResponseEntity.class);
        assertThat(ret.getStatusCode().equals(HttpStatus.CREATED));
    }
    //Delete
    @Test
    public void deleteUserById() throws Exception{
        //delete
        restTemplate.delete(hostname+":"+port+"/"+"user/30003", ResponseEntity.class);
        //confirm
        User user = restTemplate.getForObject(hostname+":"+port+"/"+"users/10001",User.class);
        assertThat(user == null);
    }

    @Test
    public void updateUserById() throws Exception{
        //delete
        User testUser = new User();
        testUser.setId(10003);
        testUser.setFirstName("Bob");
        testUser.setLastName("Vegetarian");

        restTemplate.put(hostname+":"+port+"/"+"user/", testUser, ResponseEntity.class);

        //confirmation not required though
        User user = restTemplate.getForObject(hostname+":"+port+"/"+"users/10003",User.class);
        assertThat(user.getId() == testUser.getId() && user.getFirstName().equals("Bob"));
    }



    @Test
    public void getAllUsers(){

//        List<User> allUsers = new ArrayList<>();
        String allUsers = restTemplate.getForObject(hostname+":"+port+"/"+"users/", String.class);
        //confirm
        System.out.println(allUsers);
    }
	


}
