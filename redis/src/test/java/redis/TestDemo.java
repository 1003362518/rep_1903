package redis;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestDemo {
	
	@Test//�����ַ���key
	public void test(){
		//���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("10.88.10.55");
        jedis.auth("123");
        String val=jedis.set("jjjj", "gfdgdfdfg");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
	}
	
	@Test //����ַ���key��ֵ
	public void test1(){
		//���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("10.88.10.55");
        jedis.auth("123");
        String val=jedis.get("jjjj");
        System.out.println(val);
	}
	
	@Test
	public void test2(){
		//���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("10.88.10.55");
        jedis.auth("123");
        List<String> list=jedis.lrange("list", 0, -1);
        for(String l:list){
        	System.out.println(l);
        }
	}
	
	
	
}
