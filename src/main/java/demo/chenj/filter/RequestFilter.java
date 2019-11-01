package demo.chenj.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

/**
 * @author chenj
 * @date 2019-10-19 20:05
 * @email 924943578@qq.com
 */
public class RequestFilter implements MessageSelector {
    private final static Log logger = LogFactory.getLog(RequestFilter.class);


    public boolean accept(Message<?> message) {
//        MuleMessage muleMessage = message.getPayload();
        logger.info("RequestFilter 接受参数：" + message.toString());
        return true;
    }
}
