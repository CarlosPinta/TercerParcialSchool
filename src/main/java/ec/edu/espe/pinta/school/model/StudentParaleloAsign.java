package ec.edu.espe.pinta.school.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "STUDENT_PARALELO_ASIGN")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentParaleloAsign implements Serializable {
    private static final long serialVersionUID = 785744895856L;

    @EmbeddedId
    @NonNull @EqualsAndHashCode.Include private StudentParaleloAsignPK pk;

}
