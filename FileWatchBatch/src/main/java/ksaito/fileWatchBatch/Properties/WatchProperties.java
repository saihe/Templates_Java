package ksaito.fileWatchBatch.Properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
@ConfigurationProperties(prefix = "watch.target")
public class WatchProperties {

    /** 監視対象ディレクトリパス */
    @Value("${directory.path}")
    @
    private String directoryPath;
    /** 監視対象ディレクトリパス */
    @Value("${file.extension}")
    private String fileExtension;
    /** 監視対象ディレクトリパス */
    @Value("${move.to.directory.path}")
    private String moveToDirectoryPath;

}
