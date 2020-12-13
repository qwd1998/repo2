package cn.itcast.jedis.test;

import cn.itcast.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.导入Jar包，获取连接
        Jedis jedis = new Jedis("localhost",6379);

        //2.操作
        jedis.set("username","zhangsan");

        //3.关闭连接

        jedis.close();
    }
    @Test
    public void test2(){
        //1.导入Jar包，获取连接 String
        Jedis jedis = new Jedis("localhost",6379);//本机的默认不写


        /*
        1. 存储： set key value

			2. 获取： get key

			3. 删除： del key

         */
        //2.操作
        jedis.set("username","zhangsan");
        jedis.set("password","123");
        jedis.set("age","18");

        String username = jedis.get("username");
        System.out.println(username);

        //3.关闭连接

        jedis.close();
    }
    @Test
    public void test3(){
        //1.导入Jar包，获取连接 Hash
        Jedis jedis = new Jedis("localhost",6379);//本机的默认不写


        /*
        哈希类型 hash
			1. 存储： hset key field value

			2. 获取：
				* hget key field: 获取指定的field对应的值

				* hgetall key：获取所有的field和value

			3. 删除： hdel key field

         */
        //2.操作
        jedis.hset("myhash","username","lisi");
        jedis.hset("myhash","age","18");
        jedis.hset("myhash","gender","男");

        String hget = jedis.hget("myhash", "username");
        System.out.println(hget);

        Map<String, String> map = jedis.hgetAll("myhash");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key+":"+value);

        }

        //3.关闭连接

        jedis.close();
    }
    @Test
    public void test4(){
        //1.导入Jar包，获取连接  列表list
        Jedis jedis = new Jedis("localhost",6379);//本机的默认不写
        /*
        列表类型 list:可以添加一个元素到列表的头部（左边）或者尾部（右边）
			1. 添加：
				1. lpush key value: 将元素加入列表左表
				2. rpush key value：将元素加入列表右边

			2. 获取：
				* lrange key start end ：范围获取

			3. 删除：
				* lpop key： 删除列表最左边的元素，并将元素返回
				* rpop key： 删除列表最右边的元素，并将元素返回
         */
        //2.操作
        jedis.rpush("mylist","username","wangwu");
        jedis.rpush("mylist","age","19");
        jedis.rpush("mylist","gender","nv");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //3.关闭连接

        jedis.close();
    }
    @Test
    public void test5(){
        //1.导入Jar包，获取连接 Set
        Jedis jedis = new Jedis("localhost",6379);//本机的默认不写


        /*
        集合类型 set ： 不允许重复元素
			1. 存储：sadd key value

			2. 获取：smembers key:获取set集合中所有元素

			3. 删除：srem key value:删除set集合中的某个元素

         */
        //2.操作
        jedis.sadd("myset","zhangsan");
        jedis.sadd("myset","123");
        jedis.sadd("myset","18");

        Set<String> set = jedis.smembers("myset");
        System.out.println(set);

        /*
        1. 存储：zadd key score value

			2. 获取：zrange key start end [withscores]

			3. 删除：zrem key value


         */
        jedis.zadd("sortedset ",60,"zhangsan");
        jedis.zadd("sortedset ",70,"123");
        jedis.zadd("sortedset ",80,"18");

        Set<String> zrange = jedis.zrange("sortedset ",0,-1);
        System.out.println(zrange);


        //3.关闭连接

        jedis.close();
    }
    @Test
    public void test7(){
        //0.创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);

        //1.创建jedispool连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("username","wdnmd");
        String username = jedis.get("username");
        System.out.println(username);
        //4.关闭，归还到连接池中
        jedis.close();

    }
    @Test
    public void test8(){
        //通过连接池工具类获取连接
        Jedis jedis = JedisPoolUtils.getJedis();

        //使用
        jedis.set("wd", "wdnmdgm");
        String wd = jedis.get("wd");
        System.out.println(wd);

        jedis.close();

    }
}
