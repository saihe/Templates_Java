package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@PropertySource("file:${properties.path.message}")
@Configuration
@ConfigurationProperties(prefix = "message")
public class MessageProperties {

    /** メッセージ：I001 */
    @Value("${I001}")
    private String i001;
    /** メッセージ：I002 */
    @Value("${I002}")
    private String I002;
    /** メッセージ：I003 */
    private String I003;
    /** メッセージ：I004 */
    private String I004;
    /** メッセージ：I005 */
    private String I005;
    /** メッセージ：I006 */
    private String I006;
    /** メッセージ：E001 */
    private String E001;
    /** メッセージ：E002 */
    private String E002;

    private Map<String, String> message = new HashMap<String, String>();

}
