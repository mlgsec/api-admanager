package com.mlgsec.api_admanager.model;

import com.mlgsec.api_admanager.dto.AdvertsRequests;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "adverts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Adverts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;

    public static Adverts of(AdvertsRequests requests) {
        return Adverts.builder()
                .title(requests.title())
                .description(requests.description())
                .build();
    }

    public void update(AdvertsRequests request) {
        this.title = request.title();
        this.description = request.description();
    }

}
