package dao.accountDao;

import dao.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dao层
 */

public interface IAccountDao {
    @Select("select * from big_data limit 10")
    public List<Account> findAll();
}
