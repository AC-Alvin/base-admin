package cn.huanzi.qch.baseadmin;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.junit.Test;

/**
 * @Description:
 * @Author: alvin
 * @Date: 2020/9/1 23:21
 */
public class MemCacheTest {


    @Test
    public void test() throws Exception {
        MemcachedClient client = new XMemcachedClient("memcached2.p2p.gzdai.com", 11211);
        //同步存储value到memcached，缓存超时为1小时，3600秒。
        client.set("key", 3600, "123");
        //从memcached获取key对应的value
        Object someObject = client.get("key");
        System.err.println(someObject);
        //从memcached获取key对应的value,操作超时2秒
        someObject = client.get("key", 2000);
        System.err.println(someObject);
        //更新缓存的超时时间为10秒。
        boolean success = client.touch("key", 10);
        System.err.println(success);
        //删除value
        client.delete("key");

    }
}
