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

   private Var valor = Var.VAR_NULL;
   private Var km = Var.VAR_NULL;
   private Var custoKm = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km"))).getObjectAsBoolean()) {
        km = Var.valueOf(1);
    } else {
        km = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km"));
    }
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"))).getObjectAsBoolean()) {
        valor = Var.valueOf(0);
    } else {
        valor = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"));
    }
    custoKm = cronapi.math.Operations.divisor(valor,km);
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
   private Var km = Var.VAR_NULL;
   private Var kmPorLitro = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km"))).getObjectAsBoolean()) {
        km = Var.valueOf(0);
    } else {
        km = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km"));
    }
    litros = Var.valueOf(calcLitros(Entidade));
    kmPorLitro = cronapi.math.Operations.divisor(km,litros);
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

   private Var precoLitro = Var.VAR_NULL;
   private Var valor = Var.VAR_NULL;
   private Var litros = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Entidade.getObjectAsString());
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro"))).getObjectAsBoolean()) {
        precoLitro = Var.valueOf(1);
    } else {
        precoLitro = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro"));
    }
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"))).getObjectAsBoolean()) {
        valor = Var.valueOf(0);
    } else {
        valor = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor"));
    }
    litros = cronapi.math.Operations.divisor(valor,precoLitro);
    return litros;
   }
 }.call();
}

}

