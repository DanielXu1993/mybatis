package principle;

import entity.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 为什么Mapper接口没有实现类却能被正常调用呢?
 * 这是因为MyBatis在Mapper接口上使用了动态代理.
 */
public class MyMapperProxy<T> implements InvocationHandler {
    private Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // 针对不同的sql需要调用不同的方法
        // 这里只考虑接口方法没有参数的情况
        List<T> list = sqlSession.selectList(
                //通过接口的全名和当前调用的方法名组合得到一个id
                //这个id就是XML中namespace和具体方法id的组合
                mapperInterface.getCanonicalName() + "." + method.getName());

        return list;
    }

    public static void main(String[] args) throws Exception {
        SqlSession sqlSession =
                new SqlSessionFactoryBuilder()
                        .build(Resources.getResourceAsReader("mybatis-config.xml")).openSession();
        MyMapperProxy proxy = new MyMapperProxy(UserMapper.class, sqlSession);
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{UserMapper.class},
                proxy
        );
        List<SysUser> users = userMapper.selectAll();
    }
}
