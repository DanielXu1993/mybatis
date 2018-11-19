package mapper;

import entity.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * MyBatis注解方式就是将SQL语句直接写在接口上(只需要主配置文件).
 * 这种方式的优点是对于需求比较简单的系统效率较高.
 * 缺点是当SQL有变化时都需要重新编译代码,一般情况下不建议使用注解方式.
 * 最基本的注解就是@Select,@Insert,@Update,@Delete
 */
public interface RoleMapper {
    @Select({"select id,role_name roleName,enabled,create_by createBy ," +
            "create_time createTime from sys_role where id = #{id} "})
    SysRole selectById(Long id);


    // XML中的resultMap元素对应@Results,使用这个注解来实现属性映射
    // @Results注解通过id实现与其他方法的共用
    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({"select id,role_name,enabled,create_by, create_time from" +
            " sys_role where id = #{id} "})
    SysRole selectById2(Long id);

    // 通过@ResultMap注解引用上面的@Results注解
    @ResultMap("roleResultMap")
    @Select({"select * from sys_role"})
    List<SysRole> selectAll();

    // 插入数据:不需要返回主键
    @Insert({"insert into sys_role(id,role_name,enabled,create_by,create_time)" +
            "values(#{id},#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    int insert(SysRole sysRole);

    // 插入数据:返回自增主键
    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time)" +
            "values(#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(SysRole sysRole);

    // 插入数据:返回非自增主键
    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time)" +
            "values(#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            resultType = Long.class, before = false)
    int insert3(SysRole sysRole);

}
