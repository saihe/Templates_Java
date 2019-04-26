package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@PropertySource("file:${properties.path.application}")
@Configuration
@ConfigurationProperties
public class ApplicationProperties {

    /** メッセージ：I001 */
    @Value("${I001}")

    private Map<String, String> message = new HashMap<String, String>();

}
