window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.MeusAbastecimentos = window.blockly.js.blockly.MeusAbastecimentos || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.MeusAbastecimentos.calcularValidar = function() {
 var item, dadosValidos;
  this.cronapi.screen.changeValueOfField("Abastecimento.active.litros", this.cronapi.screen.getValueOfField("Abastecimento.active.valor") / this.cronapi.screen.getValueOfField("Abastecimento.active.precoLitro"));
  this.cronapi.screen.changeValueOfField("Abastecimento.active.KmPorLitro", this.cronapi.screen.getValueOfField("Abastecimento.active.km") / this.cronapi.screen.getValueOfField("Abastecimento.active.litros"));
  if (this.cronapi.screen.getValueOfField("Abastecimento.active.valor") > 1000) {
    this.cronapi.screen.notify('error','Valor do abastecimento muito alto!!');
    this.cronapi.screen.disableComponent("btn_crud_post41107");
    dadosValidos = false;
  } else {
    if (this.cronapi.screen.getValueOfField("Abastecimento.active.litros") > 200) {
      this.cronapi.screen.notify('error','Total de litros abastecido muito alto! Reveja os dados informados!');
      this.cronapi.screen.disableComponent("btn_crud_post41107");
      dadosValidos = false;
    } else {
      this.cronapi.screen.enableComponent("btn_crud_post41107");
      dadosValidos = true;
    }
  }
  return dadosValidos;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.MeusAbastecimentos.confirmar = function() {
 var item, dadosValidos;
  if (this.blockly.js.blockly.MeusAbastecimentos.calcularValidar()) {
    this.cronapi.screen.post("Abastecimento");
  }
}
