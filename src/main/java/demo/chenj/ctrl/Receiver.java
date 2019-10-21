package demo.chenj.ctrl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenj
 * @date 2019-10-20 14:44
 * @email 924943578@qq.com
 */

@RestController
public class Receiver {

    @Autowired
    @Qualifier("routeSenderChannel")
    MessageChannel senderChannel;

    @Autowired
    @Qualifier("receiverChannel")
    QueueChannel receiverChannel;

    private final static Log logger = LogFactory.getLog(Receiver.class);


    @RequestMapping(value = "demo", method = RequestMethod.POST)
    public JSONObject demo(@RequestBody JSONObject params, @RequestHeader("route") String route ) {
        System.out.println(params.toJSONString());

        Map<String, Object> map = new HashMap<String, Object>();
        Message<JSONObject> message = MessageBuilder.withPayload(params).setHeader("route", route).build();
        senderChannel.send(message);


        Message<JSONObject> replyMsg = (Message<JSONObject>) receiverChannel.receive(200000);
        logger.info("Receiver返回：" + replyMsg.toString());

        return replyMsg.getPayload();
    }

}
