package test;


import com.mumu.listenner.KQMSGAdapter;
import com.mumu.msg.RE_MSG_AdminChange;
import com.mumu.msg.RE_MSG_Forum;
import com.mumu.msg.RE_MSG_Group;
import com.mumu.msg.RE_MSG_Private;
import com.mumu.webclient.KQWebClient;

/**
 * @ClassName KuQ
 * @Author wxd
 * @Date 2020/3/3
 * @Version 1.0.0
 **/
public class MyQQAdapter extends KQMSGAdapter {
    private KQWebClient kqWebClient;


    MyQQAdapter(KQWebClient kqWebClient) {
        this.kqWebClient = kqWebClient;
    }

    /**
     * 接收私聊消息
     */
    @Override
    public void Re_MSG_Private(RE_MSG_Private msg) {
        System.out.println("接收到私聊信息 from:"+msg.getFromqq()+" \t msg:"+msg.getMsg());
        kqWebClient.sendPrivateMSG(msg.getFromqq(),"你好,接收到了你的消息：" + msg.getMsg());
    }
    @Override
    public void RE_EXAMPLE_MANAGE(RE_MSG_AdminChange msg) {

        System.out.println(msg.getFromGroup()+msg.getAct()+msg.getBeingOperateQQ()+msg.getSendTime()+"aaa"+msg.getSubType());
    }
    @Override
    public void RE_MSG_FORUM(RE_MSG_Forum msg) {
        System.out.println("接收到消息 groupName:"+msg.getFromQQ() + "qq:"+msg.getFromQQ() + "msg:"+msg.getMsg());
    }

    /**
     * 接收群消息
     */
    @Override
    public void RE_MSG_Group(RE_MSG_Group msg) {
        System.out.println("接收到群聊消息 groupName:"+msg.getFromGroup() + "\t qq:"+msg.getFromQQ() + "\t msg:"+msg.getMsg());
        if(msg.getMsg().equals("给爷笑一个"))
        {
            kqWebClient.sendGroupMSG("1095959374","682295985","嘿嘿嘿",true);
        }
        else{
            kqWebClient.sendGroupMSG("1095959374","682295985","小主我有在听哦",true);
        }
    }
}
