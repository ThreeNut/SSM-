package service.impl;


import dao.accountDao.IAccountDao;
import dao.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IService;

import java.util.List;


/**
 * service
 * @author ThreeNut
 * @date 2022/6/14 12:33
 */
@Service
public class IServiceImpl implements IService {

    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

}
