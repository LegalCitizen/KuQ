package test;




//import org.slf4j.Logger;

import com.mumu.webclient.KQWebClient;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName KuQ
 * @Author wxd
 * @Date 2020/3/3
 * @Version 1.0.0
 **/
public class KQClient {
//    private static Logger logger = Logger.getLogger(KQClient.class);

    private static KQWebClient kqWebClient;

    public static void runClient(String host){

        try {
            if(kqWebClient == null){
                //连接coolq服务器
                kqWebClient = new RewriteKQWebClient(new URI(host));
            }
            //消息监听适配器
            MyQQAdapter myQQAdapter = new MyQQAdapter(kqWebClient);
            //监听消息
            kqWebClient.addQQMSGListenner(myQQAdapter);
        }catch (Exception e){
            System.err.println("init KQ client fail e:"+e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        KQClient.runClient("wx://localhost:25303");
    }
}
