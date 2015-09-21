(function () {
  'use strict';

  angular.module('UIBootstrapApp')
    .controller('UIBootstrapRouterController', ['$routeParams',
      function ($routeParams) {

        var vm = this;

        var nameApp = $routeParams.uiBootstrap;

        switch (nameApp) {
          case 'alert':
            vm.templateUrl = 'scripts/_demo/UIBootstrap/Alert/alert.html';
            break;
          case 'zzz':
            vm.templateUrl = 'xxx.html';
            break;
          default :
            vm.templateUrl = 'scripts/_demo/UIBootstrap/templates/uiBootstrap.html';
        }


      }])
})();