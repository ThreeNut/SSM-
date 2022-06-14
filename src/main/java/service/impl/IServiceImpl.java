package service.impl;


import dao.accountDao.IAccountDao;
import dao.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IService;

import java.util.List;


/**
 * service层
 *
 * @date 2019/11/27 15:56
 */
@Service
public class IServiceImpl implements IService {

    @Autowired
    private IAccountDao dao;

    public List<Account> findAll() {
        return dao.findAll();
    }

}
