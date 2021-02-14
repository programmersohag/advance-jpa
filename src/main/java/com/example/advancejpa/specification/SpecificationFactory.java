package com.example.advancejpa.specification;

import com.example.advancejpa.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SpecificationFactory<T> {

    public Specification<T> isEqual(String key, Object arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchCriteria.SearchOperation.EQUALITY, Collections.singletonList(arg)).build();
    }

    public Specification<T> isGreaterThan(String key, Comparable<T> arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchCriteria.SearchOperation.GREATER_THAN, Collections.singletonList(arg)).build();
    }

    public Specification<T> isLike(String key, Object arg) {
        GenericSpecificationsBuilder<T> builder = new GenericSpecificationsBuilder<>();
        return builder.with(key, SearchCriteria.SearchOperation.LIKE, Collections.singletonList(arg)).build();
    }
}
