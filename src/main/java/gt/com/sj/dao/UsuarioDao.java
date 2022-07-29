package gt.com.sj.dao;

import gt.com.sj.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
    
}
