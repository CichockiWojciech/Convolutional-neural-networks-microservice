package pl.services;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.messages.ClassificationTarget;
import pl.messages.Customer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConvolutionalNetworkService {

    private static final int NETWORKS_NUMBER = 5;
    private static final int TIMEOUT = 2000;

    private final RabbitTemplate rabbitTemplate;

    public ConvolutionalNetworkService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private static final String SERVER_EXCHANGE = "server-exchange";
    private static final String SERVER_QUEUE = "server-queue-";
    private static final String CLIENT_QUEUE = "client-queue-";


    public ClassificationTarget classfiy(Customer customer){

        List<String> results = new ArrayList<>();
        String msg = customer.toString();
        // send to all microservices
        for(int i = 0 ; i < NETWORKS_NUMBER; ++i){
            rabbitTemplate.convertAndSend(SERVER_EXCHANGE, SERVER_QUEUE+i, msg);
        }

        //receive results
        for(int i = 0; i < NETWORKS_NUMBER; ++i){
            Message receive = rabbitTemplate.receive(CLIENT_QUEUE+i, TIMEOUT);
            if(receive != null)
                results.add(new String(receive.getBody(), StandardCharsets.UTF_8));
        }

        // aggregate results
        String result = mostCommon(results);
        return new ClassificationTarget(result);
    }

    private String mostCommon(List<String> results){
        Map<Object, Long> occurrences =
                results.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        long max = 0;
        Object mostCommon = "No";
        for(Map.Entry<Object, Long> entry : occurrences.entrySet()){
            Long i = entry.getValue();
            if(i > max){
                max = i;
                mostCommon = entry.getKey();
            }
        }
        return (String) mostCommon;
    }
}
