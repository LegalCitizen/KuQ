package test;

import com.alibaba.fastjson.JSONObject;
import com.mumu.webclient.KQWebClient;

import java.net.URI;

/**
 * @ClassName KuQ
 * @Author wxd
 * @Date 2020/3/3
 * @Version 1.0.0
 **/
public class RewriteKQWebClient extends KQWebClient {
    public RewriteKQWebClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void sendPrivateMSG(String qq, String msg) {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
        JSONObject sendMsg = new JSONObject();

        sendMsg.put("act",106);
        sendMsg.put("QQID",qq);
        sendMsg.put("msg",msg);
        super.send(sendMsg.toJSONString());
    }

    @Override
    public void sendGroupMSG(String qq, String groupid, String msg, Boolean isAT) {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
        JSONObject sendMsg = new JSONObject();
        sendMsg.put("act",101);
        sendMsg.put("groupid",groupid);
        sendMsg.put("msg",msg);
        super.send(sendMsg.toJSONString());
    }
}
