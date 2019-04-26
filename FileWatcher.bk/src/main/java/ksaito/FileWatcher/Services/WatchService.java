package ksaito.FileWatcher.Services;

import ksaito.FileWatcher.BaseClass;
import ksaito.FileWatcher.Exceptions.FileControlException;
import ksaito.FileWatcher.Exceptions.WatchException;
import ksaito.FileWatcher.Utilities.ConstantsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * ファイル監視Serviceクラス
 */
@Service
@Slf4j
public class WatchService extends BaseClass {

    /** ファイル操作Serviceクラス */
    @Autowired
    private FileControlService fileControlService;

    /** 監視対象ディレクトリ */
    private String watchTargetDirectoryPath;
    /** 監視対象ファイル拡張子 */
    private String watchTargetFileExtension;

    public WatchService() {
        this.watchTargetDirectoryPath = applicationProperty.getProperty("watcher.target.directory.path");
        this.watchTargetFileExtension = applicationProperty.getProperty("watcher.target.file.extension");
    }

    /**
     * 実行処理
     * @return
     */
    public int run() {
        int resultCode = ConstantsUtil.RESULT_CODE_NORMAL;
        log.info(getMessage(ConstantsUtil.MESSAGE_I001));

        try {
            // ディレクトリ監視実行
            log.debug(
                "ディレクトリ監視の実行間隔："
                + applicationProperty.getProperty("fixed.delay")
                + "（ミリ秒）"
            );
            log.info(getMessage(ConstantsUtil.MESSAGE_I003, new Object[]{watchTargetDirectoryPath}));
            taskWatch();
            log.info(getMessage(ConstantsUtil.MESSAGE_I004, new Object[]{watchTargetDirectoryPath}));

        } catch (WatchException e) {
            // ログは下位処理内で出力する
            resultCode = ConstantsUtil.RESULT_CODE_ERROR;

        }

        return resultCode;

    }

    /**
     * ディレクトリ監視
     */
//    @Scheduled(fixedDelayString = "${fixed.delay}")
    public void taskWatch() throws WatchException {
        // ファイル移動先パス
        String moveToPath = applicationProperty.getProperty("move.to.directory.path");

        try{
            // 所定のディレクトリ内の全ファイルに対して処理を行う
            for(File tmpFile: Arrays.asList(Paths.get(watchTargetDirectoryPath).toFile().listFiles())) {
                log.debug("検出ファイル：" + tmpFile.getPath() + "、書き込み可能かどうか：" + tmpFile.canWrite());
                if(tmpFile.canWrite()){
                    // ファイルの書き込みが可能の場合、ファイルを移動する
                    log.info(
                        getMessage(
                            ConstantsUtil.MESSAGE_I005
                            , new Object[] {
                                tmpFile.getPath()
                                , moveToPath
                            }
                        )
                    );
                    fileControlService.move(
                        Paths.get(tmpFile.getPath())
                        , Paths.get(moveToPath)
                    );
                    log.info(
                        getMessage(
                            ConstantsUtil.MESSAGE_I006
                            , new Object[] {
                                tmpFile.getPath()
                                , moveToPath
                            }
                        )
                    );

                }

            }

//        } catch (FileControlException e) {
        } catch (Exception e) {
            log.error(getMessage(ConstantsUtil.MESSAGE_E001, new Object[]{watchTargetDirectoryPath}), e);
            throw e;

        }

    }

}
