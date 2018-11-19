package imapper;

import entity.SysUser;

public interface UserMapper {
    SysUser selectById(Long id);
}
