package ksaito.FileWatcher;

import ksaito.FileWatcher.Services.WatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.management.ManagementFactory;
import java.util.Properties;

/**
 * ファイル監視をして処理を行うアプリケーションのメインクラス
 */
@Slf4j
@EnableScheduling
public class Application {

    /**
     * エントリーポイント
     * @param args
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("pid", ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
        // 処理実行
//        log.info(ConstantsUtil.MESSAGE_APPLICATION_START);
        System.exit(new WatchService().run());
//        log.info(ConstantsUtil.MESSAGE_APPLICATION_END);

    }

}
