package rest;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.http.HttpResponse;

public class CompletableFutureService {
    public static void main(String[] args) throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost/employees");

        HttpResponse response = (HttpResponse) HttpClientBuilder.create().build().execute(request);

        System.out.println(response);
    }
}
