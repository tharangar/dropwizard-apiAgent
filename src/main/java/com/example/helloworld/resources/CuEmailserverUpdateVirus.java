package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.Saying;
import com.example.helloworld.cu.Test;
import com.example.helloworld.core.Template;
import io.dropwizard.jersey.caching.CacheControl;
import io.dropwizard.jersey.params.DateTimeParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Path("/update-emailserver-av")
@Produces(MediaType.APPLICATION_JSON)
public class CuEmailserverUpdateVirus {
    private static final Logger LOGGER = LoggerFactory.getLogger(CuEmailserverUpdateVirus.class);

    private final Template template;
    private final AtomicLong counter;

    public CuEmailserverUpdateVirus(Template template) {
        this.template = template;
        this.counter = new AtomicLong();
    }

    

    @GET
    @Timed(name = "get-requests-timed")
    @Metered(name = "get-requests-metered")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        Test test = new Test();
        String tt = test.helloMethod("hi cu");
        //return new Saying(counter.incrementAndGet(), test.helloMethod("hi cu"));
        //return new Saying(counter.incrementAndGet(), template.render(name));
        return new Saying(counter.incrementAndGet(), tt);
    }

    @POST
    public void receiveHello(@Valid Saying saying) {
        LOGGER.info("Received a saying: {}", saying);
    }

    @GET
    @Path("/date")
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveDate(@QueryParam("date") Optional<DateTimeParam> dateTimeParam) {
        if (dateTimeParam.isPresent()) {
            final DateTimeParam actualDateTimeParam = dateTimeParam.get();
            LOGGER.info("Received a date: {}", actualDateTimeParam);
            return actualDateTimeParam.get().toString();
        } else {
            LOGGER.warn("No received date");
            return null;
        }
    }
}
