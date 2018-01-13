package com.hmys.sys.service.impl;

import com.hmys.frame.core.dao.BaseDao;
import com.hmys.frame.core.service.BaseServiceImpl;
import com.hmys.sys.dao.RoleDao;
import com.hmys.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    protected BaseDao getBaseDao() {
        return roleDao;
    }
}
