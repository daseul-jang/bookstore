package com.bookstore.backend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderCodeGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        LocalDate localDate = LocalDate.now();
        String formatDate = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int i = 1;
        return formatDate + i++;
    }
}
