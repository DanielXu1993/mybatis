package imapper;

import entity.SysRole;

import java.util.List;

public interface RoleMapper {
    List<SysRole> selectAllRoleAndPrivileges();
}
