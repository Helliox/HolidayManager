package pl.intratel.HolidayManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.intratel.HolidayManager.entities.Employee;
import pl.intratel.HolidayManager.repository.EmployeeRepository;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService()
    {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(String email)
    {
        Employee employee = employeeRepository.findByEmail(email);
        if(employee == null)
        {
            throw new UsernameNotFoundException(email);
        }
        return new MyEmployeePrincipal(employee);
    }
}
