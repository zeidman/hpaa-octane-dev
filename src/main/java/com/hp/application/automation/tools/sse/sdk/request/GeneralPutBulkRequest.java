package com.hp.application.automation.tools.sse.sdk.request;

import java.util.List;
import java.util.Map;

import com.hp.application.automation.tools.sse.common.RestXmlUtils;
import com.hp.application.automation.tools.sse.sdk.Client;
import com.hp.application.automation.tools.sse.sdk.ResourceAccessLevel;
import com.hp.application.automation.tools.sse.sdk.Response;

/**
 * Created by barush on 03/11/2014.
 */
public abstract class GeneralPutBulkRequest extends GeneralRequest {
    
    protected GeneralPutBulkRequest(Client client) {
        super(client);
    }
    
    protected abstract List<Map<String, String>> getFields();
    
    @Override
    protected Map<String, String> getHeaders() {
        
        return RestXmlUtils.getAppXmlBulkHeaders();
    }
    
    @Override
    protected Response perform() {
        return client.httpPut(
                getUrl(),
                getDataBytes(),
                getHeaders(),
                ResourceAccessLevel.PROTECTED);
    }
    
    private byte[] getDataBytes() {
        
        StringBuilder builder = new StringBuilder("<Entities>");
        for (Map<String, String> values : getFields()) {
            builder.append("<Entity><Fields>");
            for (String key : values.keySet()) {
                builder.append(RestXmlUtils.fieldXml(key, values.get(key)));
            }
            builder.append("</Fields></Entity>");
        }
        
        return builder.append("</Entities>").toString().getBytes();
        
    }
}
