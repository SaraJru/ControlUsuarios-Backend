package gt.com.sj.web;

import gt.com.sj.dao.UsuarioDao;
import gt.com.sj.domain.Usuario;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*Permite reconocer esta clase como una clase de Spring, agregandola al contenedor
controller especial en RESTful especificacion
*/

@RestController

@RequestMapping("usuario")//enpoint principal 


//manda info al log (Lombok)
@Slf4j
public class Controlador {
    
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @RequestMapping(value="Mostrar",method=RequestMethod.GET)
    public ResponseEntity <List <Usuario> > MostrarUsuarios(){
        
        List<Usuario> usuarios = usuarioDao.findAll();
        return ResponseEntity.ok(usuarios);
    }
    
    
    
}
