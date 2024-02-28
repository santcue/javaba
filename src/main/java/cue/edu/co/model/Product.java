package cue.edu.co.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    private String id;
    private String name;
    private double price;
    private LocalDateTime registrationDate;

}
