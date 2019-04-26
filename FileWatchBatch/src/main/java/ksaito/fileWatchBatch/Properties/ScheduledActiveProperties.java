package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
@ConfigurationProperties(prefix = "scheduled.active")
public class ScheduledActiveProperties {

    /** メッセージ：I001 */
    @Value("${batch001}")
    @Qualifier("scheduledActiveBatch001")
    private String scheduledActiveBatch001;

}
