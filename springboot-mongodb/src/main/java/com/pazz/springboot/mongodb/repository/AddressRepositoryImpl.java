package com.pazz.springboot.mongodb.repository;

import com.pazz.springboot.mongodb.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:04
 * @description:
 */
@Component
public class AddressRepositoryImpl implements AddressRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Address> findAddressesByProvince(String province) {
        Query query = new Query();
        if (null != province && "" != province) {
            query.addCriteria(Criteria.where("province").is(province));
        }
        List<Address> addresses = mongoTemplate.find(query, Address.class);
//        Bson bson = new BsonDocument("province", new BsonString(province));
//        FindIterable iterable = mongoTemplate.getCollection(collectionName).find(bson, Address.class);
//        Address address = (Address) iterable.first();
        return addresses;
    }

    @Override
    public List<Address> findAddressesByProvinceAndCityAndDistrict(String province, String city, String district) {
        List<Address> addresses = new ArrayList<>();
//        Bson bson = new BsonDocument("province", new BsonString(province));
//        ((BsonDocument) bson).put("city", new BsonString(city));
//        ((BsonDocument) bson).put("district", new BsonString(district));
//        MongoCursor cursor = mongoTemplate.getCollection(collectionName).find(bson, Address.class).iterator();
//        while (cursor.hasNext()) {
//            addresses.add((Address) cursor.next());
//        }
        return addresses;
    }
}
