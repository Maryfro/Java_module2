
import java.util.Map;

public class Balancer {
    //Key is host:port, value is load
    private Map<String, Integer> content;

    public Balancer() {
        LoadReceiver loadReceiver = new LoadReceiver();
        String hostPortAndLoad = loadReceiver.getDataFromServer();
        String[]hostPortLoadParsed = hostPortAndLoad.split(".");
        content.put(hostPortLoadParsed[0], Integer.parseInt(hostPortLoadParsed[1]));
        this.content = findOptimalServer();
    }

    public Map<String, Integer> getContent() {
        return content;
    }

    private Map findOptimalServer() {
        Integer minLoad = content.values().stream().min(Integer::compareTo).orElseThrow();
        return (Map)content
                .entrySet()
                .stream()
                .filter(entry -> minLoad.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

    private void update(){

    }

    private void removeUnused(int millis){

    }



}
