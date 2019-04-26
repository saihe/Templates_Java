package ksaito.fileWatchBatch.task;

import ksaito.fileWatchBatch.Utilities.ConstantsUtil;
import ksaito.fileWatchBatch.Utilities.SystemUtil;
import ksaito.fileWatchBatch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * バッチクラス
 */
@Component
public class Batch extends BatchBase{

    @Autowired
    private TestService testService;

//    @Scheduled()
    public void batch000(){
    }

    /**
     * Batch001
     */
    @Scheduled(
            initialDelayString = "${scheduled.batch001.delay.initial}"
            , fixedDelayString = "${scheduled.batch001.delay.fixed}"
    )
    public void batch001(){
        SystemUtil.print("起動バッチ：[" + ConstantsUtil.BATCH_001 + "]");
        testService.print();

    }

}

