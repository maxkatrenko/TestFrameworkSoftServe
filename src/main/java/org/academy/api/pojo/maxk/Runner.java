package org.academy.api.pojo.maxk;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Car car1 = Car.builder()
                .model("BMW")
                .colour("black")
                .maxSpeed(340)
                .numberOfDoors(4)
                .isTransmissionAuto(true)
                .build();

        String jsonResult = mapper.writeValueAsString(car1);

        System.out.println(jsonResult);
    }
}
