package ksaito.fileWatchBatch.Beans;

import ksaito.fileWatchBatch.Properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 各種プロパティ格納クラス
 */
@Component
public class PropertiesBean {
    /** プロパティ */
    @Autowired
    public Properties properties;
    /** メッセージプロパティ */
    @Autowired
    public MessageProperties messageProperties;

}
