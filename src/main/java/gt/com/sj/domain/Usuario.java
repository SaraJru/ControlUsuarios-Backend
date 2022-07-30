package gt.com.sj.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String username;
   
    private String password;
    
    private Integer status = 1;
}
