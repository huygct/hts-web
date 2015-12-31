(function () {
    'use strict';

    angular
        .module('app.core')
        .factory('coreService', coreService);

    coreService.$inject = ['$http', 'exception'];
    /* @ngInject */
    function coreService($http, exception) {

        var service = {
            getEnv: getEnv,
            getApi: getApi
        };
        return service;


        function getEnv() {
            return $http.get('client/env.json')
                .then(success)
                .catch(fail);

            function success(response) {
                service.env = response.data;
                return response.data;
            }

            function fail(e) {
                return exception.catcher('XHR Failed for getPeople')(e);
            }
        }

        function getApi(api){
            var config = service.env.server;
            return config.protocol + config.address + ':' + config.port + api;
        }
    }
})();
