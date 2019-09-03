package redis;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestDemo {
	
	@Test//设置字符串key
	public void test(){
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("10.88.10.55");
        jedis.auth("123");
        String val=jedis.set("jjjj", "gfdgdfdfg");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
	}
	
	@Test //获得字符串key的值
	public void test1(){
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("10.88.10.55");
        jedis.auth("123");
        String val=jedis.get("jjjj");
        System.out.println(val);
	}
	
	@Test
	public void test2(){
		//连接本地的 Redis 服务
		Jedis jedis = new Jedis("10.88.10.55");
        jedis.auth("123");
        List<String> list=jedis.lrange("list", 0, -1);
        for(String l:list){
        	System.out.println(l);
        }
	}
	
	
	
}
