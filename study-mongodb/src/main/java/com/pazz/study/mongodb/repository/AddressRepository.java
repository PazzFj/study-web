package com.pazz.study.mongodb.repository;

import com.pazz.study.mongodb.entity.Address;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:02
 * @description:
 */
public interface AddressRepository {

    /**
     * 根据省，拿地址列表.
     *
     * @param province
     * @return
     */
    @Query(fields = "{'province': 0}")
    List<Address> findAddressesByProvince(String province);

    /**
     * 根据省和省，拿地址列表.
     *
     * @param province
     * @param city
     * @return
     */
    @Query()//fields表示包含的字段
    List<Address> findAddressesByProvinceAndCityAndDistrict(String province, String city, String district);

}
