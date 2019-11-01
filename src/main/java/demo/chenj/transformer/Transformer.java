package demo.chenj.transformer;

import com.alibaba.fastjson.JSONObject;
import demo.chenj.bean.BusinessData;
import demo.chenj.bean.MuleMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author chenj
 * @date 2019-10-20 18:40
 * @email 924943578@qq.com
 */
public class Transformer {
    private final static Log logger = LogFactory.getLog(Transformer.class);


    public MuleMessage<BusinessData> transform2MuleMessage(JSONObject jsonObject) {
        logger.info("Transformer 接受参数：" + jsonObject.toString());

        BusinessData businessData = new BusinessData();
        businessData.setId(Integer.valueOf(jsonObject.get("id").toString()));
        businessData.setName(jsonObject.get("name").toString());

        MuleMessage<BusinessData>  muleMessage = new MuleMessage<>();

        muleMessage.setPayLoad(businessData);
        muleMessage.getInboundProperties().put("inProperty", "int");
        muleMessage.getOutboundProperties().put("outProperty","out");


        return muleMessage;
    }



}
