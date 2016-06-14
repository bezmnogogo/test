package com.totalizator.mvc.modules;

import com.totalizator.mvc.modules.interfaces.IMapperModule;
import org.apache.commons.lang.ObjectUtils;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Oleg on 6/12/2015.
 */
@Component
public class MapperModule implements IMapperModule {

    private static final ModelMapper MAPPER;

    static {
        MAPPER = new ModelMapper();
    }

    @Override
    public <T> T map(Object source, Class<T> destinationClass) {
        return MAPPER.map(source, destinationClass);
    }

    @Override
    public <T, K> List<T> mapList(List<K> source, Class<T> destinationClass) {
        return source.stream().map(o -> MAPPER.map(o, destinationClass)).collect(Collectors.toList());
    }

    @Override
    public <T, K> List<T> mapCollectionToList(Collection<K> source, Class<T> destinationClass) {
        return source.stream().map(o -> MAPPER.map(o, destinationClass)).collect(Collectors.toList());
    }
}
