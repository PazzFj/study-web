package com.pazz.springboot.mongodb.service;

import com.pazz.springboot.mongodb.entity.Address;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:32
 * @description:
 */
public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> findAddressesByProvince(String province) {
        return null;
    }

    @Override
    public List<Address> findAddressesByProvinceAndCityAndDistrict(String province, String city, String district) {
        return null;
    }
}
