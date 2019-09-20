package convert;

import bean.Person;
import bean.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-04T09:16:32+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_65 (Oracle Corporation)"
)
public class PersonConverterImpl implements PersonConverter {

    @Override
    public PersonDTO domain2dto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setBirth( person.getBirthday() );
        if ( person.getBirthday() != null ) {
            personDTO.setBirthDateFormat( new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( person.getBirthday() ) );
        }
        Integer age = personUserAge( person );
        if ( age != null ) {
            personDTO.setAge( age );
        }
        personDTO.setId( person.getId() );
        personDTO.setName( person.getName() );

        return personDTO;
    }

    @Override
    public List<PersonDTO> domain2dto(List<Person> people) {
        if ( people == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( people.size() );
        for ( Person person : people ) {
            list.add( domain2dto( person ) );
        }

        return list;
    }

    private Integer personUserAge(Person person) {
        if ( person == null ) {
            return null;
        }
        User user = person.getUser();
        if ( user == null ) {
            return null;
        }
        Integer age = user.getAge();
        if ( age == null ) {
            return null;
        }
        return age;
    }
}
