package com.example.demo.util;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author dake malone
 * @date 2023年01月31日 下午 4:43
 */
@Component
public class FileMonitor {
    private FileAlterationMonitor monitor;

    public FileMonitor(){
        this.monitor = new FileAlterationMonitor(3000);
    }

    public void monitor(String path, FileAlterationListener listener){
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        observer.addListener(listener);
        monitor.addObserver(observer);
    }
    public void start() throws Exception {
        monitor.start();
    }
    public void stop() throws Exception {
        monitor.stop();
    }



    public static void main(String[] args) throws Exception {
        FileMonitor fileMonitor = new FileMonitor();
        fileMonitor.monitor("C:/Users/dakem/Desktop", new FileListener());
        fileMonitor.start();
    }
}
