package zhuqi.study.dubbo.server.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import zhuqi.study.dubbo.server.domain.City;
import zhuqi.study.dubbo.server.dubbo.CityDubboService;

/**
 * 城市业务 Dubbo 服务层实现层
 * <p>
 * Created by bysocket on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {

        return new City(1L, 2L, "温岭", "是我的故乡");
    }
}
