package com.hmys.sys.service.impl;

import com.hmys.frame.core.dao.BaseDao;
import com.hmys.frame.core.service.BaseServiceImpl;
import com.hmys.sys.dao.UserDao;
import com.hmys.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao getBaseDao() {
        return userDao;
    }
}
