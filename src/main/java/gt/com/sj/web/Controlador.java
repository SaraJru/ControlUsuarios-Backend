package gt.com.sj.web;

import gt.com.sj.dao.UsuarioDao;
import gt.com.sj.domain.Usuario;
import java.util.List;
import java.util.Optional;
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
    
    @RequestMapping(value="{UsuarioId}",method=RequestMethod.GET)
    public ResponseEntity <Usuario> MostrarUsuarioId(@PathVariable("UsuarioId") int usuarioId){
        
        Optional<Usuario> usuario = usuarioDao.findById(usuarioId);
        
        if(usuario.isPresent()){
            
            return ResponseEntity.ok(usuario.get());
        }else{
            return ResponseEntity.notFound().build();
        }
             
    }
    
    @PostMapping(value="Crear")
    public ResponseEntity <Usuario> CrearUsuario(@RequestBody Usuario usuario){
        
        Usuario nuevoUsuario = usuarioDao.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
        
    }
    
    @DeleteMapping(value="Eliminar/{UsuarioId}")
    public ResponseEntity <Void> EliminarUsuario(@PathVariable("UsuarioId") int usuarioId){
        
        usuarioDao.deleteById(usuarioId);
        
        return ResponseEntity.ok(null);
    }
    
    @PatchMapping(value="CambiarStatus")
    public ResponseEntity <Usuario> CambiarStatus(@RequestBody Usuario usuario){
        
        Optional <Usuario> usuarioActualizado = usuarioDao.findById(usuario.getId());
        
        if(usuarioActualizado.isPresent()){
            Usuario actualizarUsuario = usuarioActualizado.get();
            actualizarUsuario.setStatus(usuario.getStatus());
            usuarioDao.save(actualizarUsuario);
            return ResponseEntity.ok(actualizarUsuario);
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }
    
}


