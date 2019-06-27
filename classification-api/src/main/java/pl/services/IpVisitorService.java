package pl.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IpVisitorService {
    private static final long MAX_VISIT = 4;
    private static final long IN_TIME_MS = 10000;
    private Map<String, Integer> visitors = new ConcurrentHashMap<>();

    @Scheduled(fixedDelay=IN_TIME_MS)
    public void restStats(){
        visitors.clear();
    }

    public void register(String address){
        Integer visitNumber = visitors.getOrDefault(address, 0);
        visitors.put(address, ++visitNumber);
    }

    public boolean gainAccess(String address){
        return visitors.getOrDefault(address, 1) < MAX_VISIT;
    }
}
