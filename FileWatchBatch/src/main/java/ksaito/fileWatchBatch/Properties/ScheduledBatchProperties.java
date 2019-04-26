package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
public class ScheduledBatchProperties {

    /** initialDealy */
    private String initial;
    /** fixedDealy */
    private String fixed;


}
