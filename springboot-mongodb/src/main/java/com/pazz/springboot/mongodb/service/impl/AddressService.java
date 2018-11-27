package com.pazz.springboot.mongodb.service.impl;

import com.pazz.springboot.mongodb.entity.Address;
import com.pazz.springboot.mongodb.repository.AddressRepository;
import com.pazz.springboot.mongodb.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:32
 * @description:
 */
@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public String findAddressesByProvince(String province) {
        StringBuffer buffer = new StringBuffer("[");
        List<Address> addresses = repository.findAddressesByProvince(province);
        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                buffer.append(address.toString() + "  ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public List<Address> findAddressesByProvinceAndCityAndDistrict(String province, String city, String district) {
        return null;
    }
}
