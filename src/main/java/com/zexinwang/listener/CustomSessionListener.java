package com.zexinwang.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Zexin.Wang
 * @Date 2017/8/3.
 * @Description
 */
public class CustomSessionListener implements SessionListener {
    private static final Logger LOG = LoggerFactory.getLogger(CustomSessionListener.class);
    @Override
    public void onStart(Session session) {
        LOG.debug("session starts:" + session.getId() );
    }

    @Override
    public void onStop(Session session) {
        LOG.debug("session stops:" + session.getId() );
    }

    @Override
    public void onExpiration(Session session) {
        LOG.debug("session expires:" + session.getId() );
    }
}
