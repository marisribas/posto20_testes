package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Abastecimento {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade
 * @return Var
 */
// Abastecimento
public static Var calcCustoKm(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var custoKm = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("chamou custoKm").getObjectAsString());
    custoKm = Var.valueOf(0);
    if (Var.valueOf(cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"))).negate().getObjectAsBoolean() && cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km"))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {
        custoKm = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor")),cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km")));
    }
    return custoKm;
   }
 }.call();
}

/**
 *
 * @param Entidade
 * @return Var
 */
// Abastecimento
public static Var calcKmPorLitro(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var litros = Var.VAR_NULL;
   private Var kmPorLitro = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("chamou calcKmPorLitro").getObjectAsString());
    System.out.println(Entidade.getObjectAsString());
    kmPorLitro = Var.valueOf(0);
    if (Var.valueOf(cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"))).negate().getObjectAsBoolean() && cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro"))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {
        litros = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor")),cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro")));
        kmPorLitro = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km")),litros);
    }
    return kmPorLitro;
   }
 }.call();
}

/**
 *
 * @param Entidade
 * @return Var
 */
// Abastecimento
public static Var calcLitros(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var litros = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("chamou calcLitros").getObjectAsString());
    litros = Var.valueOf(0);
    if (Var.valueOf(cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"))).negate().getObjectAsBoolean() && cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro"))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {
        litros = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor")),cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro")));
    }
    return litros;
   }
 }.call();
}

}

