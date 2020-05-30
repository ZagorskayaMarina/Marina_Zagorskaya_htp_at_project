package utility;


import application_items.Search;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpCalls {
    //GsonParser gsonParser = new GsonParser();
    public String search(Search c) throws IOException, URISyntaxException{
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(GsonParser.fromGSON(c)));
        HttpResponse response = client.execute(request);

        //System.out.println(EntityUtils.toString(response.getEntity()));
        String responsAsString = EntityUtils.toString(response.getEntity());


        System.out.println(responsAsString);
        return responsAsString;
    }
}
