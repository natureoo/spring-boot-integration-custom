package demo.chenj.filter;

import demo.chenj.bean.BusinessData;
import demo.chenj.bean.MuleMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;

/**
 * @author chenj
 * @date 2019-10-19 20:05
 * @email 924943578@qq.com
 */
public class RequestFilter {
    private final static Log logger = LogFactory.getLog(RequestFilter.class);


    public boolean filter(Message<MuleMessage<BusinessData>> message) {
        MuleMessage muleMessage = message.getPayload();
        logger.info("RequestFilter 接受参数：" + muleMessage.toString());
        return true;
    }
}
