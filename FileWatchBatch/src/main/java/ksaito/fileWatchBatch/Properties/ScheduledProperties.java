package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
@ConfigurationProperties(prefix = "scheduled.delay")
public class ScheduledProperties {

    /** batch001 */
    @Value("${batch001}")
    @Qualifier("delayBatch001")
//    private ScheduledBatchProperties delayBatch001;
    private String delayBatch001;

}
