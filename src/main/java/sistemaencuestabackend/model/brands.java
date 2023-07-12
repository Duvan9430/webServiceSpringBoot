package sistemaencuestabackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marcas")
public class brands implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String name;
}
