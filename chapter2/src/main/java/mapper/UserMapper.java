package mapper;

import entity.SysRole;
import entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 根据用户ID查找用户
    SysUser selectById(Long id);

    // 查询全部用户
    List<SysUser> selectAll();

    // 根据用户ID获取角色信息
    List<SysRole> selectRoleByUserId(Long userId);

    // 新增用户
    // 返回受影响的行数
    int insert(SysUser sysUser);

    // 新增用户:使用useGeneratedKeys方式
    int insert2(SysUser sysUser);

    // 新增用户:使用<selectKey>方式
    int insert3(SysUser sysUser);

    // 根据主键更新
    int updateById(SysUser sysUser);

    // 根据主键删除数据
    int deleteById(Long id);

    // 接口有多个参数:
    // 根据用户id和角色的enabled状态获取用户的角色信息
    // 出现异常:Parameter 'userId' not found.
    // Available parameters are [arg1, arg0, param1, param2]
    // 使用@Param注解解决
    // 占位符#{}的值与@Param()注解中的value值保持一致
    List<SysRole> selectRoleByUserIdAndRoleEnabled(
            @Param("userId") Long userId, @Param("role") SysRole role);
}
