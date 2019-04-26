package ksaito.FileWatcher.Beans;

import ksaito.FileWatcher.Utilities.ConstantsUtil;
import ksaito.FileWatcher.Utilities.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * プロパティBeanクラス
 */
@Component
@Configuration
@ConfigurationProperties
@Slf4j
public class PropertiesBean {
    /** アプリケーションプロパティ */
    protected Properties applicationProperty;
    /** メッセージプロパティ */
    private Properties messageProperty;

    /**
     * コンストラクタ
     */
    public PropertiesBean() {
        try {
            log.debug("プロパティ読み込み開始");
            // インスタンス作成
            applicationProperty = new Properties();
            messageProperty = new Properties();
            // 基底プロパティの取得
            Properties rootProperties = new Properties();
            rootProperties.load(Files.newInputStream(Paths.get(ClassLoader.getSystemResource("root.properties").toURI())));
            // 基底プロパティから内の外部定義プロパティファイル名を取得
            String applicationPropertyPath = rootProperties.getProperty("file.path.properties.application");
            String messagePropertyPath = rootProperties.getProperty("file.path.properties.message");
            // 外部定義プロパティのロード
            PropertiesUtil.loadProperty(applicationProperty, Paths.get(applicationPropertyPath));
            PropertiesUtil.loadProperty(messageProperty, Paths.get(messagePropertyPath));
            // PID取得
            String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            // プロパティにPIDを設定
            applicationProperty.setProperty("pid", pid);
            log.debug("プロパティ読み込み終了");

        } catch (Exception e) {
            log.error(ConstantsUtil.MESSAGE_PROPERTY_READ_ERROR, e);
            System.exit(ConstantsUtil.RESULT_CODE_ERROR);

        }

    }

    /**
     * メッセージ取得
     * @param messageId
     * @return
     */
    public String getMessage (String messageId) {
        return StringUtils.defaultString(messageProperty.getProperty(messageId));

    }

    /**
     * メッセージ取得
     * @param messageId
     * @return
     */
    public String getMessage (String messageId, Object[] messageArguments) {
        return MessageFormat.format(
            StringUtils.defaultString(
                messageProperty.getProperty(messageId)
            ), messageArguments
        );

    }

}
