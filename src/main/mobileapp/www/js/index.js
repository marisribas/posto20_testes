var device = { 
  init: function() {
    document.addEventListener('deviceready', this.onDeviceReady.bind(this), false);
  },
  onDeviceReady: function() {
    // push notification 
    var firebase = window.FirebasePlugin;
    var hostapp = window.hostApp;
    var device = window.device;
    var build = window.BuildInfo;
    
    // get token firebase
    if (firebase && hostapp && device) {

      firebase.hasPermission((data) => {
        if (data.isEnabled) {
          console.log("Firebase Permission Already Granted");
        } else {
          firebase.grantPermission(() => {
            console.log("Firebase Permission Granted", data.isEnabled);
          }, (error) => {
            console.error("Unable to Grant Firebase Permission", error);
          });
        }
      }, error => {
        console.log("Firebase hasPermission Failed", error);
      });

      var appURL = hostapp + 'device';
      firebase.getToken(function(code) {
        var data  = { id : device.uuid, 
                      appName : build.packageName,
                      appVersion : build.version,
                      platform : device.platform, 
                      platformVersion : device.version,
                      model : device.model, 
                      token : code };
        $.post(appURL, data).done(function(d) {
          console.log('Received Event: devicesend');
        });
      }.bind(this), 
      function(err) {
        console.error(err);
      });
    }
  }
};
device.init();