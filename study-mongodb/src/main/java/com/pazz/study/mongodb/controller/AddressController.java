package com.pazz.study.mongodb.controller;

import com.pazz.study.mongodb.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/11/26 23:44
 * @description:
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService IAddressService;

    @GetMapping("/findProvince")
    public String findProvince(String province) {
        return IAddressService.findAddressesByProvince(province);
    }


}
