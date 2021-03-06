package by.it.academy.foodorder.parent.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Long userId;

    @Column
    private String username;

    @Column
    @ManyToMany
    @EqualsAndHashCode.Exclude @ToString.Exclude
    private Set<Role> roles;

    @Column
    private String password;

    private String phoneNumber;

    @Transient
    @Column(name = "password_confirm")
    private String passwordConfirm;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    private Basket basket;
}
