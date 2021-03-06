package com.yin.another.service.impls;

import com.yin.another.service.BaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TCPService  extends BaseService{
    Log logger = LogFactory.getLog(this.getClass());
    @Override
    public void init() {
        if(state.compareAndSet(false, true))
            logger.info("TCP Init...");
        else
            logger.error("TCP already inited.");
    }
}
