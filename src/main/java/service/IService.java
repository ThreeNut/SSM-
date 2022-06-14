package service;


import dao.domain.Account;

import java.util.List;

/**
 * service接口
 * @date 2019/11/27 15:54
 */

public interface IService {
    public List<Account> findAll();
}
