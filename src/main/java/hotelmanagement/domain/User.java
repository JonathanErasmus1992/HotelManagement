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
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String emailAddress;
    private String password;
    private String recoveryQuestion;
    private String recoveryAnswer;

    private User(){}

    public User( Builder builder )
    {
        ID = builder.ID;
        emailAddress = builder.emailAddress;
        password = builder.password;
        recoveryQuestion = builder.recoveryQuestion;
        recoveryAnswer = builder.recoveryAnswer;
    }
    public Long getID()
    {
        return ID;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public String getPassword()
    {
        return password;
    }
    public String getRecoveryQuestion(){
        return recoveryQuestion;
    }
    public String getRecoveryAnswer(){
        return recoveryAnswer;
    }

    public static class Builder
    {
        private Long ID;
        private String emailAddress;
        private String password;
        private String recoveryQuestion;
        private String recoveryAnswer;

        public Builder( String emailAddress )
        {
            this.emailAddress = emailAddress;
        }
        public Builder ID( Long value )
        {
            this.ID = value;
            return this;
        }
        public Builder password( String value )
        {
            this.password = value;
            return this;
        }
        public Builder recoveryQuestion(String value)
        {
            this.recoveryQuestion = value;
            return this;
        }
        public Builder recoveryAnswer(String value)
        {
            this.recoveryAnswer = value;
            return this;
        }
        public Builder copy( User value )
        {
            this.ID = value.getID();
            this.emailAddress = value.getEmailAddress();
            this.password = value.getPassword();
            this.recoveryQuestion = value.getRecoveryQuestion();
            this.recoveryAnswer = value.getRecoveryAnswer();

            return this;
        }

        public User build()
        {
            return new User( this );
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", recoveryQuestion='" + recoveryQuestion + '\'' +
                ", recoveryAnswer='" + recoveryAnswer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!ID.equals(user.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}