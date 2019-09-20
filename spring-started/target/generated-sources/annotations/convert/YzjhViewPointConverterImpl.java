package convert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-04T09:16:32+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_65 (Oracle Corporation)"
)
public class YzjhViewPointConverterImpl implements YzjhViewPointConverter {

    @Override
    public YzjhViewPointDTO domain2Dto(YzjhViewPoint viewPoint) {
        if ( viewPoint == null ) {
            return null;
        }

        YzjhViewPointDTO yzjhViewPointDTO = new YzjhViewPointDTO();

        yzjhViewPointDTO.setName( viewPoint.getViewPointName() );
        Date startTime = viewPointBatchStartTime( viewPoint );
        if ( startTime != null ) {
            yzjhViewPointDTO.setStartTime( new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( startTime ) );
        }
        Date startTime1 = viewPointBatchStartTime( viewPoint );
        if ( startTime1 != null ) {
            yzjhViewPointDTO.setEndTime( new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( startTime1 ) );
        }

        return yzjhViewPointDTO;
    }

    @Override
    public List<YzjhViewPointDTO> domain2Dto(List<YzjhViewPoint> viewPoints) {
        if ( viewPoints == null ) {
            return null;
        }

        List<YzjhViewPointDTO> list = new ArrayList<YzjhViewPointDTO>( viewPoints.size() );
        for ( YzjhViewPoint yzjhViewPoint : viewPoints ) {
            list.add( domain2Dto( yzjhViewPoint ) );
        }

        return list;
    }

    private Date viewPointBatchStartTime(YzjhViewPoint yzjhViewPoint) {
        if ( yzjhViewPoint == null ) {
            return null;
        }
        YzjhBatch batch = yzjhViewPoint.getBatch();
        if ( batch == null ) {
            return null;
        }
        Date startTime = batch.getStartTime();
        if ( startTime == null ) {
            return null;
        }
        return startTime;
    }
}
