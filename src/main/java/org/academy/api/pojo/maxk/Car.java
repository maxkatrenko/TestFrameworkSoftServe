package org.academy.api.pojo.maxk;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    private String colour;
    private String model;
    private int maxSpeed;
    private int numberOfDoors;
    private boolean isTransmissionAuto;
}
