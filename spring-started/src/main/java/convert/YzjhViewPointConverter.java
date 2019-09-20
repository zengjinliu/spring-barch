package convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface YzjhViewPointConverter {

    YzjhViewPointConverter INSTANCE = Mappers.getMapper(YzjhViewPointConverter.class);

    @Mappings({
            @Mapping(source = "viewPointName", target = "name"),
            @Mapping(source = "batch.startTime", target = "startTime",dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "batch.startTime", target = "endTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    YzjhViewPointDTO domain2Dto(YzjhViewPoint viewPoint);

    List<YzjhViewPointDTO> domain2Dto(List<YzjhViewPoint> viewPoints);
}
