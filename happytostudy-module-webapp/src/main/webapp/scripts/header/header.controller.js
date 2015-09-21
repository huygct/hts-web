/**
 * Created by Huy Nghi on 9/20/2015.
 */
(function () {
  angular.module('headerApp')

    .controller('HeaderDirectiveController', ['$scope', '$timeout', '$q', '$log', 'headerConstant', '$mdDialog',
      function ($scope, $timeout, $q, $log, headerConstant, $mdDialog) {
        var vm = this;

        /*
         start auto complete
         */
        vm.simulateQuery = false;
        vm.isDisabled    = false;

        // list of `state` value/display objects
        vm.states        = loadAll();
        vm.querySearch   = querySearch;
        vm.selectedItemChange = selectedItemChange;
        vm.searchTextChange   = searchTextChange;

        // ******************************
        // Internal methods
        // ******************************

        /**
         * Search for states... use $timeout to simulate
         * remote dataservice call.
         */
        function querySearch (query) {
          var results = query ? vm.states.filter( createFilterFor(query) ) : vm.states,
            deferred;
          if (vm.simulateQuery) {
            deferred = $q.defer();
            $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
            return deferred.promise;
          } else {
            return results;
          }
        }

        function searchTextChange(text) {
          $log.info('Text changed to ' + text);
        }

        function selectedItemChange(item) {
          $log.info('Item changed to ' + JSON.stringify(item));
        }

        /**
         * Build `states` list of key/value pairs
         */
        function loadAll() {
          var allStates = 'Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware,\
              Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana,\
              Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana,\
              Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina,\
              North Dakota, Ohio, Oklahoma, Oregon, Pennsylvania, Rhode Island, South Carolina,\
              South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington, West Virginia,\
              Wisconsin, Wyoming';

          return allStates.split(/, +/g).map( function (state) {
            return {
              value: state.toLowerCase(),
              display: state
            };
          });
        }

        /**
         * Create filter function for a query string
         */
        function createFilterFor(query) {
          var lowercaseQuery = angular.lowercase(query);

          return function filterFn(state) {
            return (state.value.indexOf(lowercaseQuery) === 0);
          };
        }
        /*
         end auto complete
         */
        /*
        Carousel
         */
        vm.myInterval = 2000;
        vm.noWrapSlides = false;
        var slides = vm.slides = [];
        vm.addSlide = function() {
          var newWidth = 600 + slides.length + 1;
          slides.push({
            image: '//placekitten.com/' + newWidth + '/300',
            text: ['More','Extra','Lots of','Surplus'][slides.length % 4] + ' ' +
            ['Cats', 'Kittys', 'Felines', 'Cutes'][slides.length % 4]
          });
        };
        for (var i=0; i<4; i++) {
          vm.addSlide();
        }

        /*
        my code
         */
        vm.clickButtonLogin = clickButtonLogin;

        function clickButtonLogin($event) {
          $mdDialog.show({
            controller: DialogLoginController,
            templateUrl: 'scripts/main/templates/login.html',
            parent: angular.element(document.body),
            targetEvent: $event,
            clickOutsideToClose: true
          })
            .then(function (answer) {
              $scope.status = 'You said the information was "' + answer + '".';
            }, function () {
              $scope.status = 'You cancelled the dialog.';
            });
        }
    }])

 })();