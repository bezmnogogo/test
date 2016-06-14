package com.totalizator.mvc.modules.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Oleg on 6/12/2015.
 */
public interface IMapperModule {

    <T> T map(Object source, Class<T> destinationClass);

    <T, K> List<T> mapList(List<K> source, Class<T> destinationClass);

    <T, K> List<T> mapCollectionToList(Collection<K> source, Class<T> destinationClass);
}
