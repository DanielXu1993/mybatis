package imapper;

import entity.SysUser;

import java.util.List;

public interface UserMapper {
    // 根据用户id获取用户信息和角色信息
    // 用户和角色是一一对应的的关系
    SysUser selectUserAndRoleById(Long id);

    // 根据用户id获取用户信息和角色信息
    // 使用resultMap配置
    SysUser selectUserAndRoleById2(Long id);

    // association标签的嵌套查询
    SysUser selectUserAndRoleByIdSelect(Long id);

    // 在SysUser中添加List<SysRole>属性
    // 获取所有用户以及对应的所有角色
    // 一个用户可以有多个角色
    List<SysUser> selectAllUserAndRoles();

    // <collection>集合的嵌套查询
    // 通过嵌套查询获取指定用户的信息以及用户的角色和权限信息
    SysUser selectAllUserAndRolesSelect(Long id);
}
