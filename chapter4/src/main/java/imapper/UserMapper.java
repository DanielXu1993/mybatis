package imapper;

import entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 根据动态条件查询用户信息
     * 当只输入用户名时根据用户名进行模糊查询
     * 当只输入邮箱时根据邮箱完全匹配
     * 当输入用户名和邮箱时,用上述两个条件进行查询
     */
    List<SysUser> selectByUser(SysUser sysUser);

    // 根据主键选择性更新
    int updateByIdSelective(SysUser sysUser);

    // 插入数据
    int insert(SysUser sysUser);

    // 根据用户id或者用户名查询
    SysUser selectByIdOrUserName(SysUser sysUser);

    /**
     * 根据动态条件查询用户信息
     * 当只输入用户名时根据用户名进行模糊查询
     * 当只输入邮箱时根据邮箱完全匹配
     * 当输入用户名和邮箱时,用上述两个条件进行查询
     */
    List<SysUser> selectByUser2(SysUser sysUser);

    // 根据主键选择性更新
    int updateByIdSelective2(SysUser sysUser);

    // 根据用户id集合查询
    List<SysUser> selectByIdList(List<Long> idList);

    // 批量插入用户信息
    int insertList(List<SysUser> userList);

    // 通过map更新列
    int updateByMap(@Param("updateMap") Map<String, Object> map);
}
