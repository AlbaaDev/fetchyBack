package com.web.fetchyback.interfaces;
import org.mapstruct.Mapper; 

import com.web.fetchyback.models.SimpleDestination;
import com.web.fetchyback.models.SimpleSource;

@Mapper
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}