package com.pazz.springboot.mongodb.service;

import com.pazz.springboot.mongodb.entity.Address;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:31
 * @description:
 */
public interface AddressService {

    /**
     * 根据省，拿地址列表.
     *
     * @param province
     * @return
     */
    @Query(fields = "{'province': 0}")
    String findAddressesByProvince(String province);

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
