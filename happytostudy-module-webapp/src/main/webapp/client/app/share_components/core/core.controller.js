(function () {
    'use strict';

    angular
        .module('app.core')
        .controller('CoreController', CoreController);

    CoreController.$inject = ['logger'];
    /* @ngInject */
    function CoreController(logger) {
        var vm = this;
        vm.title = 'Core';

    }
})();
