package ksaito.fileWatchBatch.task;

import ksaito.fileWatchBatch.Properties.MessageProperties;
import ksaito.fileWatchBatch.Properties.PropertiesPathProperties;
import ksaito.fileWatchBatch.Properties.ScheduledProperties;
import ksaito.fileWatchBatch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;

@Component
public class Batch {

    @Autowired
    private AutowireCapableBeanFactory factory;

    private Properties prop = new Properties();
    private boolean propertiesNonLoadedFlag = true;

    private final String batchId001 = "batch001";
    @Autowired
    private TestService testService;
    @Autowired
    private ScheduledProperties scheduledProperties;
    @Autowired
    private PropertiesPathProperties propertiesPathProperties;

//    public Batch() {
//        try{
//            prop.load(Files.newBufferedReader(Paths.get(applicationProperyPath), StandardCharsets.UTF_8));
//            prop.load(Files.newBufferedReader(Paths.get(loggingProperyPath), StandardCharsets.UTF_8));
//            prop.load(Files.newBufferedReader(Paths.get(messageProperyPath), StandardCharsets.UTF_8));
//
//        } catch (IOException e){
//            e.printStackTrace();
//            System.exit(9);
//        }
//    }

    @Scheduled(
            initialDelayString = "${scheduled.batch001.delay.initial}"
            , fixedDelayString = "${scheduled.batch001.delay.fixed}"
    )
    public void batch000(){
        System.out.println("起動バッチ：[batch000]");
        System.out.println("バッチ起動フラグ一覧");
        for(String key: scheduledProperties.getActive().keySet()){
            System.out.println("key：[" + key + "]、value：[" + scheduledProperties.getActive().get(key) + "]");
        }
        System.out.println("プロパティ一覧");
        for (Enumeration<?> e = prop.propertyNames(); e.hasMoreElements(); ) {
            String propertyName = (String)e.nextElement();
            String propertyValue = prop.getProperty(propertyName);
            System.out.println(propertyName + " = " + propertyValue);
        }
        System.out.println("システムプロパティ一覧");
        for (Enumeration<?> e = System.getProperties().propertyNames(); e.hasMoreElements(); ) {
            String propertyName = (String)e.nextElement();
            String propertyValue = System.getProperties().getProperty(propertyName);
            System.out.println(propertyName + " = " + propertyValue);
        }
        if(propertiesNonLoadedFlag){
            try{
                System.out.println("外部定義プロパティ未ロード");
                // 外部定義プロパティファイルをすべてロード（共通項目があれば上書かれる）
                System.out.println("外部定義ファイルパス一覧");
                for(String key: propertiesPathProperties.getPath().keySet()){
                    System.out.println("key：[" + key + "]、value：[" + propertiesPathProperties.getPath().get(key) + "]");
                    prop.load(Files.newBufferedReader(Paths.get(propertiesPathProperties.getPath().get(key)), StandardCharsets.UTF_8));
                }
                factory.createBean(TestService.class);
                propertiesNonLoadedFlag = false;

            } catch (IOException e){
                e.printStackTrace();
                System.exit(9);
            }
        } else {
            System.out.println("外部定義プロパティロード済");
        }
    }

    @Scheduled(
            initialDelayString = "${scheduled.batch001.delay.initial}"
            , fixedDelayString = "${scheduled.batch001.delay.fixed}"
    )
    public void batch001(){
        System.out.println("起動バッチ：[batch001]");
        System.out.println("有効化フラグ：[" + scheduledProperties.getActive().get(batchId001) + "]");
        testService.print();
    }
}

