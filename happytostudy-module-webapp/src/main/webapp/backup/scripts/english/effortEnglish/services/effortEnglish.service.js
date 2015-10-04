/**
 * effortEnglish: menuId = 3
 */

'use strict';

(function () {
  angular.module('EnglishApp')
    .service('effortEnglishService', ['$q', '$http', 'HTL_CONSTANT', function ($q, $http, HTL_CONSTANT) {
      var self = this;

      self.clickSelectedMenu = clickSelectedMenu;
      self.getSubjects = getSubjects;

      self.cache = {
        subjects: {},
        subjectWasSelected: {},
        urlPdf: '',
        urlAudio: '',
        showPdf: true
      };

      function start () {

      }

      function clickSelectedMenu () {

      }

      function getSubjects () {
        var deferred = $q.defer();

        var urlSubjectEffort = HTL_CONSTANT.URL_FULL + 'main/subjects/getSubjectsByMenuId?menuId=3';
        $http.get(urlSubjectEffort)
          .success (function (data) {
            deferred.resolve(data);
            self.cache.subjects = data;
        })
          .error (function (data) {
            deferred.reject(data);
            throw (Error('Error get subject from server', data));
        });

        return deferred.promise;
      }

      start();

    }])

})();
