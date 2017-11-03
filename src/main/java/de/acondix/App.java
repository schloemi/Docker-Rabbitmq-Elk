package de.acondix;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import de.acondix.domain.VoteMessage;
import de.acondix.domain.VoteStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

public class App {
    private final static String QUEUE_NAME = "voting";
    private final static String HOST = "127.0.0.1";


    private Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] argv) throws Exception {
        App app = new App();
        app.run();
    }

    private  void run() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(App.HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < 100; i++ ) {
            VoteMessage voteMessage = createMessage();
            channel.queueDeclare(App.QUEUE_NAME, false, false, false, null);
            String voteMessageAsString = mapper.writeValueAsString(voteMessage);
            channel.basicPublish("", App.QUEUE_NAME, null, voteMessageAsString.getBytes());
            logger.debug(" [x] Sent '" + voteMessageAsString  + "'");
        }
        channel.close();
        connection.close();
    }


    private VoteMessage createMessage(){
        VoteMessage voteMessage = new VoteMessage();
        // set a value between 1 and 5
        voteMessage.setValue(ThreadLocalRandom.current().nextInt(1,6));
        // set a value between 10000 and 10010
        voteMessage.setDesignObject(ThreadLocalRandom.current().nextInt(10000,10011));
        voteMessage.setVoteStatus(VoteStatus.randomVoteStatus());
        voteMessage.setIpAddress(new StringBuilder("192.168.100.").append(ThreadLocalRandom.current().nextInt(0,10)).toString());
        voteMessage.setValid(VoteStatus.OK.equals(voteMessage.getVoteStatus()));
        voteMessage.setVotingDate(new Date());
        return voteMessage;
    }
}
