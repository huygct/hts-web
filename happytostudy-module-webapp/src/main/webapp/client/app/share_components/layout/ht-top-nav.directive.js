(function() {
    'use strict';

    angular
        .module('app.layout')
        .directive('htTopNav', htTopNav);

    /* @ngInject */
    function htTopNav () {
        var directive = {
            bindToController: true,
            controller: TopNavController,
            controllerAs: 'vm',
            restrict: 'EA',
            scope: {
                'navline': '='
            },
            templateUrl: 'client/app/share_components/layout/ht-top-nav.html'
        };

        /* @ngInject */
        function TopNavController() {
            var vm = this;
        }

        return directive;
    }
})();
