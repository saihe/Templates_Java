package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationProperties {

    /** バッチ有効化設定 */
    @Autowired
    private ScheduledActiveProperties scheduledActiveProperties;
    /** スケジュール設定 */
    @Autowired
    private ScheduledProperties scheduledProperties;
    /** 監視対象設定 */
    @Autowired
    private WatchProperties watchProperties;

}
