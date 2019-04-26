package ksaito.fileWatchBatch.Beans;

import ksaito.fileWatchBatch.Properties.ApplicationProperties;
import ksaito.fileWatchBatch.Properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 各種プロパティ格納クラス
 */
@Component
public class PropertiesBean {
    /** 基底プロパティ */
    @Autowired
    public Properties properties;
    /** 外部定義：アプリケーションプロパティ */
    @Autowired
    public ApplicationProperties applicationProperties;
    /** 外部定義：メッセージプロパティ */
    @Autowired
    public MessageProperties messageProperties;

}
