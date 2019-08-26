package pl.intratel.HolidayManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.intratel.HolidayManager.entities.Employee;
import pl.intratel.HolidayManager.repository.EmployeeRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Employee employee = employeeRepository.findByEmail(username);
        if (employee == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(employee);
    }
}
