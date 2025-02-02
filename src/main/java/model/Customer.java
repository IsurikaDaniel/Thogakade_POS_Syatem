package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {
    private String id;
    private String name;
    private String title;
    private String adderess;
    private String age;
    private String number;
    private LocalDate dob;
}
