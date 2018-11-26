package com.pazz.springboot.mongodb.repository;

import com.mongodb.client.MongoCursor;
import com.pazz.springboot.mongodb.core.MongoLogSender;
import com.pazz.springboot.mongodb.entity.Address;
import com.pazz.springboot.mongodb.entity.LogInfo;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:04
 * @description:
 */
@Component
public class AddressRepositoryImpl implements AddressRepository, MongoRepository<Address, String> {

    @Autowired
    private MongoLogSender mongoLogSender;

    @Autowired
    private MongoTemplate mongoTemplate;

    private String collectionName = Address.class.getName();

    @Override
    public List<Address> findAddressesByProvince(String province) {
        List<Address> addresses = new ArrayList<>();
        Bson bson = new BsonDocument("province", new BsonString(province));
        MongoCursor cursor = mongoTemplate.getCollection(collectionName).find(bson, Address.class).iterator();
        while (cursor.hasNext()) {
            addresses.add((Address) cursor.next());
        }
        return addresses;
    }

    @Override
    public List<Address> findAddressesByProvinceAndCityAndDistrict(String province, String city, String district) {
        List<Address> addresses = new ArrayList<>();
        Bson bson = new BsonDocument("province", new BsonString(province));
        ((BsonDocument) bson).put("city", new BsonString(city));
        ((BsonDocument) bson).put("district", new BsonString(district));
        MongoCursor cursor = mongoTemplate.getCollection(collectionName).find(bson, Address.class).iterator();
        while (cursor.hasNext()) {
            addresses.add((Address) cursor.next());
        }
        return addresses;
    }

    @Override
    public <S extends Address> S save(S s) {
        Document document = MongoLogSender.getDocument(s);
        mongoTemplate.getCollection(collectionName).insertOne(document);
        return null;
    }

    @Override
    public <S extends Address> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Address> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Iterable<Address> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public void deleteAll(Iterable<? extends Address> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Address> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Address> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Address> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Address> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Address> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Address> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Address> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Address> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Address> boolean exists(Example<S> example) {
        return false;
    }
}
