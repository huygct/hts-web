'use strict';

(function () {
  angular.module('happyToStudyApp')
    .controller('EntertainmentController', ['mainService', '$routeParams', '$location',
      function (mainService, $routeParams, $location) {

        function selectedMenu() {
          var menus = mainService.cache.menus;
          for (var i = 0; i < menus.length; i++) {
            menus[i].selected = menus[i].link === $location.path();
          }
        }

        selectedMenu();
      }])

})();
