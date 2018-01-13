package com.hmys.sys.service.impl;

import com.hmys.frame.core.dao.BaseDao;
import com.hmys.frame.core.service.BaseServiceImpl;
import com.hmys.sys.dao.ActionDao;
import com.hmys.sys.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl extends BaseServiceImpl implements ActionService {
    @Autowired
    private ActionDao actionDao;

    @Override
    protected BaseDao getBaseDao() {
        return actionDao;
    }
}
