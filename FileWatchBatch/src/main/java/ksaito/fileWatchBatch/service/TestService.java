package ksaito.fileWatchBatch.service;

import ksaito.fileWatchBatch.Properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class TestService {

    private static int printCounter = 0;
    private Properties prop = new Properties();

    public void setProp(Properties prop) {
        this.prop = (Properties)prop.clone();
    }
//    @Autowired
//    private MessageProperties messageProperties;

    public void print(){
        // メッセージ一覧出力
        System.out.println("メッセージ一覧");
//        for(String key: messageProperties.getMessage().keySet()){
//            System.out.println("key：[" + key + "]、value：[" + messageProperties.getMessage().get(key) + "]");
//        }

        System.out.println("[" + (printCounter++) + "]回目のprintをした");
    }
}
