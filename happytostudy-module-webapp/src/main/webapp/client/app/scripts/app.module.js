(function () {
    'use strict';

    angular.module('app.Web', [
        'app.dashboard',
        'app.user'

    ]);

    angular.module('app', [
        'app.core',
        'app.widgets',
        'app.layout',
        'app.Web'
    ]);

})();
