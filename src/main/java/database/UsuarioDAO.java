package database;
       
import java.util.List;
import model.usuario;

public interface UsuarioDAO {
  
    public abstract void  Cadastrar(usuario user)
            throws Exception;
    
     public abstract List<usuario> Listar()
             throws Exception;
     
     public abstract void Atualizar (usuario user)
             throws Exception;
     
     
     public abstract void Remover (int id)
             throws Exception;
     
     public abstract usuario Autenticar (String email,String senha)
             throws Exception;
          
}
