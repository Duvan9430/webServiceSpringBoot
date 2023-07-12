package sistemaencuestabackend.model;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "nombre",nullable = false)
    private String name;
    @Column(name = "apellido",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "bloqueo",nullable = false)
    private Integer bloquing;

}
