package com.leftlane.refinitivdataparser.service.impl;

import com.leftlane.refinitivdataparser.service.LGDFINCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LGDFINCServiceImpl implements LGDFINCService {

    @Autowired
    DummyService dummyService;
    @Async
    @Override
    public void process() {
        try {
            dummyService.longRunning2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            dummyService.initiateShutdown(0);
        }
    }
}
