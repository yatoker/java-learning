package com.amadeus.epwr.service.validator;

import com.amadeus.epwr.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeValidator {


    public List<String> validate(Employee emp){
        List<String> errors = new ArrayList<String>();

        if (emp==null) {
            return errors;
        }

        if (emp.getFirstName() == null || emp.getFirstName().isEmpty())
            errors.add("Firstname can not be empty");

        if (emp.getFirstName() != null && emp.getFirstName().length() <2)
            errors.add("Firstname can not be shorter than 2");

        if (emp.getLastName() == null || emp.getLastName().isEmpty())
            errors.add("Lasttname can not be empty");

        if (emp.getEmail() == null || emp.getEmail().isEmpty())
            errors.add("Email can not be empty");

        if (emp.getEmail() != null && !isValidEmailAddress(emp.getEmail())) {
            errors.add("Email is not valid");
        }

        return errors;


    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
