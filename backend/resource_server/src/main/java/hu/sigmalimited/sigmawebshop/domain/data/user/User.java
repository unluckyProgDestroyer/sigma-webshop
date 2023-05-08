package hu.sigmalimited.sigmawebshop.domain.data.user;

import hu.sigmalimited.sigmawebshop.domain.data.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity(name="users")// Otherwise conflict with SQL USER keyword
@Getter @Setter
public class User implements Serializable {

    @Id
    private String email;
    private String password;
    private boolean enabled;

    private String firstName;
    private String lastName;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRole> roles;

    public List<String> getRoles(){
        return roles.stream().map(UserRole::toString).toList();
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "User{" + "username=" + this.email + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
                + '\'' + ", roles='" + this.roles + '\'' + '}';
    }
}