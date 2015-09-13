package hotelmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class EmployeeDemographics implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String gender;
    private String race;
    private String home_language;

    private EmployeeDemographics()
    {

    }

    public EmployeeDemographics( Builder builder )
    {
        ID = builder.ID;
        gender = builder.gender;
        race = builder.race;
        home_language = builder.home_language;
    }

    public Long getID()
    {
        return this.ID;
    }
    public String getGender()
    {
        return gender;
    }
    public String getRace()
    {
        return race;
    }
    public String getHomeLanguage()
    {
        return home_language;
    }

    public static class Builder
    {
        private Long ID;
        private String gender;
        private String race;
        private String home_language;

        public Builder( String race )
        {
            this.race = race;
        }
        public Builder ID(Long ID)
        {
            this.ID=ID;
            return this;
        }
        public Builder gender( String value )
        {
            this.gender = value;
            return this;
        }
        public Builder home_language( String value )
        {
            this.home_language = value;
            return this;
        }
        public Builder copy( EmployeeDemographics value )
        {
            this.ID = value.getID();
            this.race = value.getRace();
            this.gender = value.getGender();
            this.home_language = value.getHomeLanguage();
            return this;
        }

        public EmployeeDemographics build()
        {
            return new EmployeeDemographics( this );
        }
    }

    @Override
    public String toString() {
        return "EmployeeDemographics{" +
                "ID=" + ID +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", home_language='" + home_language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDemographics that = (EmployeeDemographics) o;

        if (!ID.equals(that.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}