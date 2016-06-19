package com.totalizator.web.modules.interfaces;

import java.util.Collection;
import java.util.List;


public interface IMapperModule {

    <T> T map(Object source, Class<T> destinationClass);

    <T, K> List<T> mapList(List<K> source, Class<T> destinationClass);

    <T, K> List<T> mapCollectionToList(Collection<K> source, Class<T> destinationClass);
}
