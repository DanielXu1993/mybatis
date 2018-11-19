package principle;

import entity.SysUser;

import java.util.List;

public interface UserMapper {
    List<SysUser> selectAll();
}
