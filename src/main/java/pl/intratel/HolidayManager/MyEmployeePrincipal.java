package pl.intratel.HolidayManager;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.intratel.HolidayManager.entities.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyEmployeePrincipal  implements UserDetails {

    private Employee employee;

    public MyEmployeePrincipal(Employee employee)
    {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority>authorites = Collections.singletonList(new SimpleGrantedAuthority("Employee"));
        return authorites;
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
