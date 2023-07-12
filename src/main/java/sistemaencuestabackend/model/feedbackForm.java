package sistemaencuestabackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "formulario_encuesta")
public class feedbackForm implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_documento",nullable = false)
    private Integer documentNumber;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "comentarios",nullable = false,columnDefinition = "TEXT")
    private String comment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_favorita_id",nullable = false)
    private brands favoriteBrand;
    @Column(name = "fecha_respuesta",nullable = false)
    private Date dateResponse;
    @Column(name = "eliminar",nullable = true)
    private Date deleted;

}
