package ksaito.FileWatcher.Utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * プロパティ操作クラス
 */
@Component
@Slf4j
public class PropertiesUtil{
    /** プロパティ読み込み時の文字コード */
    private static final Charset PROPERTIES_CHARSETS = StandardCharsets.UTF_8;

    /**
     * コンストラクタ
     */
    public static void loadProperty(Properties prop, Path propertiesPath) {
        try {
            // プロパティ読み込み（UTF-8指定）
            prop.load(Files.newBufferedReader(propertiesPath, PROPERTIES_CHARSETS));

        } catch (IOException e) {
            e.printStackTrace();
            log.error(ConstantsUtil.MESSAGE_UNHANDLED_ERROR, e);
            System.exit(ConstantsUtil.RESULT_CODE_ERROR);

        }

    }

}
