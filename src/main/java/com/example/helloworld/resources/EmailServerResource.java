package com.example.helloworld.resources;

import com.example.helloworld.core.Person;
import com.example.helloworld.db.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.example.helloworld.cu.Test;
import com.example.helloworld.cu.ExecuteShellComand;
import com.example.helloworld.cu.OutputProcessor;

// requried for ui implementation
//import com.example.helloworld.views.PersonView;
//import com.example.helloworld.views.CommandView;
//import javax.ws.rs.PathParam;

@Path("/updateav")
@Produces(MediaType.APPLICATION_JSON)
public class EmailServerResource {

    //private final PersonDAO peopleDAO;

    //public PeopleResource(PersonDAO peopleDAO) {
    //    this.peopleDAO = peopleDAO;
    //}

    //@POST
    //@UnitOfWork
    //public Person createPerson(Person person) {
    //    return peopleDAO.create(person);
    //}

    //@GET
    //@UnitOfWork
    //public List<Person> listPeople() {
    //    return peopleDAO.findAll();
    //}

    @GET
    @UnitOfWork
    public String showSomething() {

        //String id = "1";
        //String content = "ddd";
        Test test = new Test();
        String tt = test.helloMethod("cu -running");

        ExecuteShellComand obj = new ExecuteShellComand();
        OutputProcessor proc = new OutputProcessor();

		String domainName = "google.com";
		
		//in mac oxs
		//String command = "docker exec -it emailserver freshclam";
        //String command = "docker -v";
        //String command = "docker exec -it emailserver chmod +x /agent/init_refresh.sh";
        String command = "docker exec emailserver sh /agent/init_refresh.sh";
        
		//in windows
		//String command = "ping -n 3 " + domainName;
		
        String output = obj.executeCommand(command);
        
        String output2 = obj.getCommandOut("test","command");

        System.out.println(output);
        
        output = proc.refreshClam(output);
       
        //return "Saying{" + "id=" + id + ", content='" + content + '\'' + '}';
        return "{\"id\":1,\"content\":\""+tt+"\",\"output1\":\""+output+"\",\"output2\":\""+output2+"\"}";

        
    }



}
