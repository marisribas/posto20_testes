window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.MeusCarros = window.blockly.js.blockly.MeusCarros || {};

/**
 * MeusCarros
 */
window.blockly.js.blockly.MeusCarros.abrirModalRelatorio = function() {

  this.cronapi.screen.showModal("modal42454");
}

/**
 * MeusCarros
 */
window.blockly.js.blockly.MeusCarros.fecharModalRelatorio = function() {

  this.cronapi.screen.hideModal("modal42454");
}
