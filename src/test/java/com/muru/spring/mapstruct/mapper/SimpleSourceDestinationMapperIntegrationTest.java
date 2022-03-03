package com.muru.spring.mapstruct.mapper;

import com.muru.spring.mapstruct.model.SimpleDestination;
import com.muru.spring.mapstruct.model.SimpleSource;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSourceDestinationMapperIntegrationTest {
    private final SimpleSourceDestinationMapper mapper
            = Mappers.getMapper(SimpleSourceDestinationMapper.class);

    @Test
    public void givenSourceToDestination_whenMaps_thenCorrect() {
        SimpleSource simpleSource = new SimpleSource();
        simpleSource.setName("SourceName");
        simpleSource.setDescription("SourceDescription");
        SimpleDestination destination = mapper.sourceToDestination(simpleSource);

        assertEquals(simpleSource.getName(), destination.getName());
        assertEquals(simpleSource.getDescription(),
                destination.getDescription());
    }

    @Test
    public void givenDestinationToSource_whenMaps_thenCorrect() {
        SimpleDestination destination = new SimpleDestination();
        destination.setName("DestinationName");
        destination.setDescription("DestinationDescription");
        SimpleSource source = mapper.destinationToSource(destination);
        assertEquals(destination.getName(), source.getName());
        assertEquals(destination.getDescription(), source.getDescription());
    }
    @Test
    public void givenSourceListToDestination_whenMaps_thenCorrect() {
        SimpleSource simpleSource = new SimpleSource();
        simpleSource.setName("SourceName");
        simpleSource.setDescription("SourceDescription");
        List<SimpleDestination> destination =
                mapper.sourceListToDestinationList(List.of(simpleSource));
        assertThat(destination).isNotNull();
        assertThat(destination).isNotEmpty();
        assertThat(destination.get(0)).isNotNull();
        assertThat(destination.get(0).getName()).isEqualTo(simpleSource.getName());
        assertThat(destination.get(0).getDescription()).isEqualTo(simpleSource.getDescription());
    }
}
