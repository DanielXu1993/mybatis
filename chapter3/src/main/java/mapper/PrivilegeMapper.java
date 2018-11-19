package mapper;

import entity.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

// 除了@Select,@Update,@Insert,@Delete注解外,
// MyBatis还提供了@SelectProvider,@UpdateProvider,@InsertProvider,@DeleteProvider注解
// 它们同样可以实现查询,更新,插入,删除操作
public interface PrivilegeMapper {
    /**
     * Provider的注解中提供了俩个必填的属性type和method.
     * type的配置是一个包含method属性指定方法的类,这个类必须有空的构造器,这个方法的值就是SQL语句.
     * method属性指定的方法的返回值必须是String类型.
     */
    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
