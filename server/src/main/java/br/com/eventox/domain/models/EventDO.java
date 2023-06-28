package br.com.eventox.domain.models;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDO {

    private Integer id;

    @NotBlank(message = "O campo nome é obrigatório.")
    private String name;

    @NotNull(message = "O campo data é obrigatório.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Calendar date;

    @Min(value = 0, message = "O preço do ingresso deve ser maior ou igual a zero.")
    @NotNull(message = "O campo preço é obrigatório.")
    private Double price;

    private String description;

    @Min(value = 1, message = "A capacidade do evento deve ser maior que zero.")
    @NotNull(message = "O campo capacidade é obrigatório.")
    private Integer capacity;

    private Integer sold = 0;

}
