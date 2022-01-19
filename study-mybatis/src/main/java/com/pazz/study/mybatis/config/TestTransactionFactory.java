package com.pazz.study.mybatis.config;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: 彭坚
 * @create: 2019/4/16 9:15
 * @description:
 */
@Component
public class TestTransactionFactory implements TransactionFactory {

    private Properties properties;

    @Override
    public void setProperties(Properties props) {
        System.out.println("properties: " + props);
        properties = props;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public Transaction newTransaction(Connection conn) {
        return null;
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        System.out.println(dataSource.getClass().getSimpleName());
        return null;
    }

}
