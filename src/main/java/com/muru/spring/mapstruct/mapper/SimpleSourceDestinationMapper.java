package com.muru.spring.mapstruct.mapper;

import com.muru.spring.mapstruct.model.SimpleDestination;
import com.muru.spring.mapstruct.model.SimpleSource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
    List<SimpleDestination> sourceListToDestinationList(List<SimpleSource> sourceList);
}
