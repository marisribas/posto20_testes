package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", execute = "Public")
public class Usuario {

public static final int TIMEOUT = 300;

/**
 *
 * @param nomeusu
 * @param senhausu
 * @param emailusu
 * @param confirmasenhausu
 * @return Var
 */
// Usuario
public static Var Incluir(Var nomeusu, Var senhausu, Var emailusu, Var confirmasenhausu) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    if (Var.valueOf(senhausu.equals(confirmasenhausu)).getObjectAsBoolean()) {
        cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),Var.valueOf("password",senhausu),Var.valueOf("name",nomeusu),Var.valueOf("login",emailusu),Var.valueOf("email",emailusu));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Usuário cadastrado! "));
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Senha não confere!"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param foto
 */
// Descreva esta função...
public static void atualizaFotoUsuarioLogado(Var foto) throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update User set picture = :picture where login = :login"),Var.valueOf("picture",foto),Var.valueOf("login",cronapi.util.Operations.getCurrentUserName()));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Imagem alterada com sucesso\n"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterIdUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.login = :login"),Var.valueOf("login",cronapi.util.Operations.getCurrentUserName())), Var.valueOf("this[0].id"));
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterLoginUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var senhausu = Var.VAR_NULL;
   private Var confirmasenhausu = Var.VAR_NULL;
   private Var nomeusu = Var.VAR_NULL;
   private Var emailusu = Var.VAR_NULL;

   public Var call() throws Exception {
    return cronapi.util.Operations.getCurrentUserName();
   }
 }.call();
}

}

