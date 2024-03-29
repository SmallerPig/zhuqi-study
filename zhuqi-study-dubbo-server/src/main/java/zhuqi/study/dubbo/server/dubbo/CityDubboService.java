package zhuqi.study.dubbo.server.dubbo;


import zhuqi.study.dubbo.server.domain.City;

/**
 * 城市业务 Dubbo 服务层
 * <p>
 * Created by bysocket on 28/02/2017.
 */
public interface CityDubboService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName
     */
    City findCityByName(String cityName);
}
