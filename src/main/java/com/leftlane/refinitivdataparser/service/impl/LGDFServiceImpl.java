package com.leftlane.refinitivdataparser.service.impl;

import com.leftlane.refinitivdataparser.service.LGDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class LGDFServiceImpl implements LGDFService {

    @Autowired
    DummyService dummyService;
    @Async
    @Override
    public void process() {
        try {
            dummyService.longRunning();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            dummyService.initiateShutdown(0);
        }
    }



}
