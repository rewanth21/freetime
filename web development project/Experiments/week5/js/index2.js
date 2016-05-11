angular.module('app', []);

angular.module('app').controller("MainController", function(){
    var vm = this;
    vm.title = 'AngularJS Experiment';
    vm.searchInput = '';
    vm.shows = [
        {
            title: 'BMW',
            year: 2011,
            favorite: true
        },
        {
            title: 'RENAULT',
            year: 2010,
            favorite: false
        },
        {
            title: 'PORSCHE',
            year: 2002,
            favorite: true
        },
        {
            title: 'MARUTHI',
            year: 2013,
            favorite: true
        },
        {
            title: 'TATA',
            year: 2005,
            favorite: false
        }
    ];
    vm.orders = [
        {
            id: 1,
            title: 'Year Ascending',
            key: 'year',
            reverse: false
        },
        {
            id: 2,
            title: 'Year Descending',
            key: 'year',
            reverse: true
        },
        {
            id: 3,
            title: 'Title Ascending',
            key: 'title',
            reverse: false
        },
        {
            id: 4,
            title: 'Title Descending',
            key: 'title',
            reverse: true
        }
    ];
    vm.order = vm.orders[0];
    vm.new = {};
    vm.addShow = function() {
        vm.shows.push(vm.new);
        vm.new = {};
    };
});