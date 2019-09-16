package ru.smdesign.test.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;
import ru.smdesign.test.service.WebServiceAdapter;
import ru.smdesign.test.soap.function.GetProductByNameRequest;
import ru.smdesign.test.soap.function.GetProductByNameResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;

@Endpoint
public class ProductEndpoint {

        private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

        @Autowired
        private WebServiceAdapter webServiceAdapter;

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByNameRequest")
        @ResponsePayload
        public GetProductByNameResponse getProductByNameResponse(
                @RequestPayload GetProductByNameRequest request) {
                GetProductByNameResponse response = new GetProductByNameResponse();
                final String uri = "http://localhost:8080/springrestexample/employees";

                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

                ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);


                response.setProduct(webServiceAdapter.findByName(request).get(0));
                return response;
        }

}