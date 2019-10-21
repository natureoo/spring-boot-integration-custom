package demo.chenj.bean;

import com.alibaba.fastjson.JSON;

import javax.activation.DataHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenj
 * @date 2019-10-20 14:41
 * @email 924943578@qq.com
 */
public class MuleMessage<T> {


    Map<String, Object> inboundProperties = new HashMap<>();

    Map<String, Object> outboundProperties = new HashMap<>();

    T payLoad;

    DataHandler attachments;

    public Map<String, Object> getInboundProperties() {
        return inboundProperties;
    }

    public void setInboundProperties(Map<String, Object> inboundProperties) {
        this.inboundProperties = inboundProperties;
    }

    public Map<String, Object> getOutboundProperties() {
        return outboundProperties;
    }

    public void setOutboundProperties(Map<String, Object> outboundProperties) {
        this.outboundProperties = outboundProperties;
    }

    public T getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }

    public DataHandler getAttachments() {
        return attachments;
    }

    public void setAttachments(DataHandler attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "MuleMessage{" +
                "inboundProperties[" + JSON.toJSONString(inboundProperties) + "]" +
                ", outboundProperties=" + JSON.toJSONString(outboundProperties) +"]" +
                ", payLoad=" +  JSON.toJSONString(payLoad )+ "]" +
                ", attachments=" + JSON.toJSONString(attachments) + "]" +
                '}';
    }
}
