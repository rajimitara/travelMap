package com.travel.world.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
    Logger logger;
    public LogManager(Object obj) {
        this.logger = LoggerFactory.getLogger(obj.getClass());
    }
    public void logInfo(String logMsg){
        logger.info(logMsg);
    }
}
