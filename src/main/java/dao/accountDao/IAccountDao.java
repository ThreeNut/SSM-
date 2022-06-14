package dao.accountDao;

import dao.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dao层
 * @date 2019/11/27 15:57
 */

public interface IAccountDao {
    @Select("select * from big_data limit 10")
    public List<Account> findAll();
}
