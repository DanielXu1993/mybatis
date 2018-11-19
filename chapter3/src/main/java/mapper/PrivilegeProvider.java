package mapper;

public class PrivilegeProvider {
    public String selectById(final Long id) {
        return "SELECT id,privilege_name privilegeName,privilege_url privilegeUrl" +
                " FROM sys_privilege WHERE id = #{id} ";
    }
}
