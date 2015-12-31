(function () {
    'use strict';

    angular
        .module('app.layout')
        .factory('layoutService', ['$state', 'routerHelper', function ($state, routerHelper) {

            var service = {
                page: {},
                breadcrumb: [],
                setBreadcrumb: setBreadcrumb,
                getBreadcrumb: getBreadcrumb
            };

            function setBreadcrumb (breadcrumb) {
                service.breadcrumb.length = 0;

                for (var i = 0; i < breadcrumb.length; i++) {
                    service.breadcrumb.push(breadcrumb[i]);
                }
            }

            function getBreadcrumb () {
                return service.breadcrumb;
            }

            return service;

        }]);

})();
