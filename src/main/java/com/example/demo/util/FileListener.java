package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author dake malone
 * @date 2023年01月31日 下午 4:31
 */
@Slf4j
@Component
public class FileListener implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
      log.info("listener start");
    }

    @Override
    public void onDirectoryCreate(File file) {
        log.info("directory create"+file.getAbsolutePath());
    }

    @Override
    public void onDirectoryChange(File file) {
        log.info("directory change"+file.getAbsolutePath());
    }

    @Override
    public void onDirectoryDelete(File file) {
        log.info("directory delete"+file.getAbsolutePath());
    }

    @Override
    public void onFileCreate(File file) {
        log.info("file create"+file.getAbsolutePath());
    }

    @Override
    public void onFileChange(File file) {
        log.info("file change"+file.getAbsolutePath());
    }

    @Override
    public void onFileDelete(File file) {
        log.info("file delete"+file.getAbsolutePath());
    }

    @Override
    public void onStop(FileAlterationObserver fileAlterationObserver) {
        log.info("listener stop");
    }
}
