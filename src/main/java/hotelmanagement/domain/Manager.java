package hotelmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/05.
 */
@Entity
public class Manager implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String manager_id;
    private String manager_title;

    private Manager()
    {

    }

    public Manager( Builder builder )
    {
        ID = builder.ID;
        manager_id = builder.manager_id;
        manager_title = builder.manager_title;
    }

    public Long getID()
    {
        return ID;
    }
    public String getManagerID()
    {
        return manager_id;
    }
    public String getManagerTitle()
    {
        return manager_title;
    }

    public static class Builder
    {
        private Long ID;
        private String manager_id;
        private String manager_title;

        public Builder( String manager_id )
        {
            this.manager_id = manager_id;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder manager_title( String value )
        {
            this.manager_title = value;
            return this;
        }
        public Builder copy( Manager value )
        {
            this.ID = value.getID();
            this.manager_id = value.getManagerID();
            this.manager_title = value.getManagerTitle();

            return this;
        }

        public Manager build()
        {
            return new Manager( this );
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ID=" + ID +
                ", manager_id='" + manager_id + '\'' +
                ", manager_title='" + manager_title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (!ID.equals(manager.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}