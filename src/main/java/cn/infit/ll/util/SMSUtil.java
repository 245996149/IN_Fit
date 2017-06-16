package cn.inphoto.util;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

import static cn.inphoto.util.DirUtil.getInfo;

/**
 * Created by root on 17-4-12.
 */
public class SMSUtil {
    private static String aliyunMNSEndpoint = getInfo("aliyunMNSEndpoint");

    private static String aliyunAccessId = getInfo("aliyunAccessId");

    private static String aliyunAccessKey = getInfo("aliyunAccessKey");

    public static void sendSMS(String code,String phone) {
        /**
         * Step 1. get topic reference
         */
        CloudAccount account = new CloudAccount(aliyunAccessId, aliyunAccessKey, aliyunMNSEndpoint);
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef("sms.topic-cn-hangzhou");
        /**
         * Step 2. set SMS message body ( required )
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. generate SMS message attributes
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 set SMS message sign name
        batchSmsAttributes.setFreeSignName("上海赢秀");
        // 3.2 set SMS message template code
        batchSmsAttributes.setTemplateCode("SMS_61155106");
        // 3.3 set SMS message receiver param (defined in SMS message template)
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("code", code);
        smsReceiverParams.setParam("product", "上海赢秀多媒体科技有限公司IN Photo后台");
        // 3.4 add phone number of receiver (200 receivers at most)
        batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
        //batchSmsAttributes.addSmsReceiver("$YourReceiverPhoneNumber2", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. publish SMS message
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
    }
}
