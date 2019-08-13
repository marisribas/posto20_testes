window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Login = window.blockly.js.blockly.Login || {};

/**
 * Login
 */
window.blockly.js.blockly.Login.abrirCadastro = function() {

  this.cronapi.screen.showModal("modal60105");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Login.fecharCadastro = function() {

  this.cronapi.screen.hideModal("modal60105");
}
