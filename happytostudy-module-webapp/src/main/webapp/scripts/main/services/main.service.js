/**
 * Created by Huy Nghi on 7/22/2015.
 */
'use strict';

(function () {
  angular.module('happyToStudyApp')
    .service('mainService', ['$q', '$http', 'HTL_CONSTANT', function ($q, $http, HTL_CONSTANT) {
      var self = this;

      self.clickSelectedMenu = clickSelectedMenu();

      self.cache = {
        menus: []
      };

      function start () {
        //var urlGetMenu = HTL_CONSTANT.URL_FULL + 'main/menu/allMenuList';
        //$http.get(urlGetMenu)
        //  .success (function (data) {
        //    for (var i = 0; i < data.length; i++) {
        //      if (data[i].parent === 0) {
        //        self.cache.menus.push(data[i]);
        //      }
        //    }
        //    for (var m = 0; m < self.cache.menus.length; m++) {
        //      self.cache.menus[m].children = [];
        //      self.cache.menus[m].showChildren = false;
        //      for (var j = 0; j < data.length; j++) {
        //        if (self.cache.menus[m].id === data[j].parent) {
        //          self.cache.menus[m].children.push(data[j]);
        //        }
        //      }
        //    }
        //})
        //  .error (function (data) {
        //    throw (Error('Error', data));
        //})
      }

      function clickSelectedMenu () {

      }

      //self.chooseTab = chooseTab;
      //function chooseTab (tab) {
      //  var link = tab.link.replace('#', '');
      //  //console.log('----------- ', link);
      //  $location.path(link);
      //}

      start();

    }])

})();
