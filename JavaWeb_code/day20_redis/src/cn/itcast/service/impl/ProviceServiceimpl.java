package cn.itcast.service.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoimpl;
import cn.itcast.domain.Province;
import cn.itcast.jedis.util.JedisPoolUtils;
import cn.itcast.service.ProviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProviceServiceimpl implements ProviceService {
    private ProvinceDao dao = new ProvinceDaoimpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findJedis() {
        //1.先从redis查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_s = jedis.get("province");

        if(province_s==null || province_s.length()==0){
            System.out.println("redis没有数据，查询数据库..");

            List<Province> list = dao.findAll();

            //把list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_s = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将Jedis数据存入redis
            jedis.set("province",province_s);
            //归还连接
            jedis.close();

        }
        return province_s;
    }
}
