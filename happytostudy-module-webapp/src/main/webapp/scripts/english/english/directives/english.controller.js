'use strict';

(function () {
  angular.module('EnglishApp')
    .controller('EnglishController', ['mainService', '$routeParams', '$location',
      function (mainService, $routeParams, $location) {
        var vm = this;

        function selectedMenu() {
          var menus = mainService.cache.menus;

          var pathArray = $location.path().split('/');
          // choose menu current and it's children
          for (var i = 0; i < menus.length; i++) {
            if (menus[i].link === ('/' + pathArray[1])) {
              menus[i].selected = true;
              vm.menuEnglish = menus[i].children;
            } else {
              menus[i].selected = false;
            }
          }

          if (pathArray[2]) {
            var url = '#' + $location.path();
            for (var j = 0; j < vm.menuEnglish.length; j++) {
              if (vm.menuEnglish[j].link === url) {
                vm.menuEnglish[j].active = true;
                break;
              }
            }
          }

          // check children
          var nameApp = $routeParams.typeEnglish;

          switch (nameApp) {
            case 'effortEnglish':
              vm.templateUrl = 'scripts/english/effortEnglish/templates/effortEnglish.html';
              break;
            case 'video':
              vm.templateUrl = 'scripts/english/video/templates/videoEnglish.html';
              break;
            default :
              vm.templateUrl = 'scripts/english/effortEnglish/templates/effortEnglish.html';
          }
        }

        selectedMenu();

        vm.chooseTab = chooseTab;
        function chooseTab (tab) {
          var link = tab.link.replace('#', '');
          //console.log('----------- ', link);
          $location.path(link);
        }
      }])

})();
    