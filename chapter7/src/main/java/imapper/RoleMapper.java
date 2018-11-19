package imapper;

//二级缓存 方式二:在接口中配置

import entity.SysRole;
import org.apache.ibatis.annotations.CacheNamespaceRef;

/**
 * @CacheNamespace( eviction = FifoCache.class,
 * flushInterval = 60000,
 * size = 512,
 * readWrite = true
 * )
 */
// 如果RoleMapper.xml文件中也配置了二级缓存,两者同时存在是会报错
// 此时接口处可以使用@CacheNamespaceRef(RoleMapper.class)引用
@CacheNamespaceRef(RoleMapper.class)
// 或者在RoleMapper.xml文件中使用<cache-ref namespace="imapper.RoleMapper"/>
public interface RoleMapper {
    SysRole selectRoleById(Long id);
}
