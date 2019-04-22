package ksaito.FileWatcher.Services;

import ksaito.FileWatcher.BaseClass;
import ksaito.FileWatcher.Exceptions.FileControlException;
import ksaito.FileWatcher.Utilities.ConstantsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ファイル操作Serviceクラス
 */
@Service
@Slf4j
public class FileControlService extends BaseClass {

    /**
     * ファイルを移動する処理
     * @param moveForm
     * @param moveTo
     * @throws IOException
     */
    public void move(Path moveForm, Path moveTo) throws FileControlException {
        try {
            // ファイル移動
            Files.move(moveForm, moveTo);

        } catch (IOException e){
            log.error(ConstantsUtil.MESSAGE_E002, e);
            throw new FileControlException(ConstantsUtil.MESSAGE_E002, e);

        }

    }

}

