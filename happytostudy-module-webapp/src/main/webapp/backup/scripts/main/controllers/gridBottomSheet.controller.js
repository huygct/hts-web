(function () {
  'use strict';

  angular.module('happyToStudyApp')
    .controller('GridBottomSheetCtrl', ['$scope', '$mdBottomSheet',
      function ($scope, $mdBottomSheet) {

        $scope.addVocabulary = false;

        $scope.items = [
          { name: 'Vocabulary',
            icon: 'vocabulary'
          }
        ];

        $scope.vocabulary = {

        };

        $scope.listItemClick = function($index) {
          //var clickedItem = $scope.items[$index];
          //$mdBottomSheet.hide(clickedItem);
          $scope.addVocabulary = true;
          $scope.action = true;
        };

        $scope.clickButtonCancel = function () {
          $scope.action = false;
          $scope.addVocabulary = false;
          $scope.vocabulary = {};
        };

        $scope.clickButtonAdd = function (vocabulary) {
          console.log(vocabulary);
          $scope.action = false;
          $scope.addVocabulary = false;
          $scope.vocabulary = {};
        }
    }])
    
})();