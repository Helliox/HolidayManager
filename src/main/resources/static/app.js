var app = angular.module('app',[]);


app.controller('EmployeeCRUDCtrl',['$scope','EmployeeCRUDService',
    function ($scope, EmployeeCRUDService){
        $scope.getEmployee = function(){
            var id = $scope.employee.id;
            console.log(id);
            EmployeeCRUDService.getEmployee($scope.employee.id)
                .then(function success(response){
                        $scope.employee = response.data;
                        $scope.employee.id = id;
                        $scope.message='';
                        $scope.errorMessage = '';
                    },
                    function error (response) {
                        $scope.message = '';
                        if(response.status === 404){
                            $scope.errorMessage = 'Employee not found!';
                        }
                        else{
                            $scope.errorMessage = "Error getting employee!"
                        }
                    });
        };
        $scope.addEmployee = function() {
            if ($scope.employee != null && $scope.employee.name && $scope.employee.surname)
            {
                EmployeeCRUDService.addEmployee($scope.employee.name, $scope.employee.surname)
                    .then (function success(response){
                            $scope.message = 'Employee added!';
                            $scope.errorMessage = '';
                        },
                        function error(response){
                            $scope.errorMessage = 'Error adding employee!';
                            $scope.message = '';
                        });
            }
            else{
                $scope.errorMessage = 'PLease enter a name!';
                $scope.message = '';
            }
        }
        $scope.updateEmployee = function() {
            EmployeeCRUDService.updateEmployee($scope.employee.id,$scope.employee.name,$scope.employee.surname)
                .then(function success(response)
                    {
                        $scope.message = "Employee data updated!";
                        $scope.errorMessage = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error updating Employee';
                        $scope.message = '';
                    });
        }
        $scope.deleteEmployee = function(){
            EmployeeCRUDService.deleteEmployee($scope.employee.id)
                .then (function success(response){
                        $scope.message = 'Employee deleted!';
                        $scope.errorMessage = '';
                        $scope.Employee = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error deleting Employee!';
                        $scope.message = '';
                    });
        }
        $scope.getAllEmployees = function(){
            EmployeeCRUDService.getAllEmployees()
                .then(function success(response){
                        $scope.employees = response.data._embedded.employees;
                        $scope.message = '';
                        $scope.errorMessage = '';
                    },
                    function errorMessage(response){
                        $scope.message = '';
                        $scope.errorMessage = 'Error getting employees!';
                    });
        }
    }]);

app.service('EmployeeCRUDService',['$http', function($http){
    this.getEmployee = function getEmployee(employeeId){
        return $http({
            method: 'GET',
            url: 'employees/' + employeeId
        });
    }
    this.addEmployee = function addEmployee(name,surname)
    {
        return $http({
            method:'POST',
            url:'employees',
            data:
            {
                name:name,
                surname:surname
            }
        });
    }
    this.updateEmployee = function updateEmployee(id,name,surname)
    {
        return $http({
            method: 'PATCH',
            url:'employees/' + id,
            data:
            {
                name:name,
                surname:surname
            }
        });
    }
    this.deleteEmployee = function deleteEmployee(id)
    {
        return $http({
            method: 'DELETE',
            url: 'employees/' + id
        });
    }
    this.getAllEmployees = function getAllEmployees()
    {
        return $http({
        method:'GET',
        url:'employees'
    });
    }
}]);

