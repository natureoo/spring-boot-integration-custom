package demo.chenj.service;

import com.alibaba.fastjson.JSONObject;
import demo.chenj.bean.BusinessData;
import demo.chenj.bean.MuleMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * @author chenj
 * @date 2019-10-20 14:44
 * @email 924943578@qq.com
 */

public class ServiceActivatorTwo implements MessageHandler {

    private final static Log logger = LogFactory.getLog(ServiceActivatorTwo.class);

    @Autowired
    @Qualifier("receiverChannel")
    QueueChannel receiverChannel;

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        logger.info("ServiceActivatorTwo 接受参数：" + message.toString());

        MuleMessage<BusinessData> muleMessage = (MuleMessage<BusinessData>)message.getPayload();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","0000");
        jsonObject.put("param", "ServiceActivatorTwo");


        Message<JSONObject> respMessage = MessageBuilder.withPayload(jsonObject).copyHeadersIfAbsent(message.getHeaders()).setHeader("http_statusCode", HttpStatus.OK).build();

        receiverChannel.send(respMessage);
    }


}
