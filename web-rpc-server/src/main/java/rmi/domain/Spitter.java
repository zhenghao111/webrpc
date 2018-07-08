package rmi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spitter implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

}
