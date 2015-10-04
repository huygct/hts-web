angular
  .module('happyToStudyApp')

  .config(function ($routeProvider) {
    $routeProvider
      .when('/demo', {
        templateUrl: 'scripts/_demo/getAudio/templates/getAudio.html',
        controller: 'GetAudioController',
        controllerAs: 'vm'
      })
  });
