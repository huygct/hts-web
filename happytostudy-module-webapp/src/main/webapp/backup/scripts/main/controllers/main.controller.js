//'use strict';
//
//(function () {
//  angular.module('happyToStudyApp')
//    .controller('MainController', ['$scope', '$mdSidenav', '$mdBottomSheet', '$location', 'mainService', '$mdDialog',
//      function ($scope, $mdSidenav, $mdBottomSheet, $location, mainService, $mdDialog) {
//        var self = this;
//
//        self.wasLogin = false;
//
//        self.showGridBottomSheet = showGridBottomSheet;
//        self.clickButtonLogin = clickButtonLogin;
//
//        self.toggleSidenav = function (menuId) {
//          $mdSidenav(menuId).toggle();
//        };
//
//        self.dataCache = mainService.cache;
//
//        self.setUrl = function (url) {
//          console.log(url);
//        };
//
//        function showGridBottomSheet($event) {
//          $mdBottomSheet.show({
//            templateUrl: 'scripts/main/templates/bottomSheet.html',
//            controller: 'GridBottomSheetCtrl',
//            targetEvent: $event
//          }).then(function (clickedItem) {
//            console.log('click Item: ', clickedItem);
//          });
//        }
//
//        function clickButtonLogin($event) {
//          $mdDialog.show({
//            controller: DialogLoginController,
//            templateUrl: 'scripts/main/templates/login.html',
//            parent: angular.element(document.body),
//            targetEvent: $event,
//            clickOutsideToClose: true
//          })
//            .then(function (answer) {
//              $scope.status = 'You said the information was "' + answer + '".';
//            }, function () {
//              $scope.status = 'You cancelled the dialog.';
//            });
//        }
//      }]);
//
//  DialogLoginController.$inject = ['$scope', '$mdDialog', '$location'];
//  function DialogLoginController($scope, $mdDialog, $location) {
//    var url = "" + $location.$$absUrl;
//    $scope.displayLoginError = (url.indexOf("error") >= 0);
//
//    $scope.changeErrorVariableValue = function(){
//      $scope.displayLoginError = !$scope.displayLoginError;
//    };
//
//    $scope.hide = function () {
//      $mdDialog.hide();
//    };
//
//    $scope.cancel = function () {
//      $mdDialog.cancel();
//    };
//
//    $scope.answer = function (answer) {
//      $mdDialog.hide(answer);
//    };
//
//    $scope.clickButtonOkOnLogin = function (user) {
//      console.log(user);
//      $mdDialog.hide();
//    };
//  }
//
//})();
//