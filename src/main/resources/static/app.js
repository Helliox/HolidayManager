var app = angular.module('app',[]);


app.controller('EmployeeCRUDCtrl',['$scope','EmployeeCRUDService',
    function ($scope, EmployeeCRUDService){
        $scope.getEmployee = function(){
            var id = $scope.employee.id_employee;
            EmployeeCRUDService.getEmployee($scope.employee.id_employee)
                .then(function success(response){
                        $scope.employee = response.data;
                        $scope.employee.id_employee = id;
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
       $scope.getEmployeeId = function(id){
            return getIndex(id);
        };
        $scope.addEmployee = function() {
            if ($scope.employee != null && $scope.employee.name && $scope.employee.surname && $scope.employee.email && $scope.employee.manager_status)
            {
                EmployeeCRUDService.addEmployee($scope.employee.name, $scope.employee.surname, $scope.employee.email, $scope.employee.manager_status)
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
                $scope.errorMessage = 'Please enter valid information!';
                $scope.message = '';
            }
        }
        $scope.updateEmployee = function() {
            EmployeeCRUDService.updateEmployee($scope.employee.id_employee,$scope.employee.name,$scope.employee.surname, $scope.employee.email, $scope.employee.manager_status)
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
            EmployeeCRUDService.deleteEmployee($scope.employee.id_employee)
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
                    console.log("success");
                        $scope.employees = response.data._embedded.employees;
                        $scope.message = '';
                        $scope.errorMessage = '';
                    },
                    function errorMessage(response){
                    console.log("error");
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
    this.addEmployee = function addEmployee(name,surname,email,manager_status)
    {
        return $http({
            method:'POST',
            url:'employees',
            data:
            {
                name:name,
                surname:surname,
                email:email,
                manager_status:manager_status
            }
        });
    }
    this.updateEmployee = function updateEmployee(id,name,surname,email,manager_status)
    {
        return $http({
            method: 'PATCH',
            url:'employees/' + id,
            data:
            {
                name:name,
                surname:surname,
                email:email,
                manager_status:manager_status
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

app.controller('ExpertiseCRUDCtrl',['$scope','ExpertiseCRUDService',
    function ($scope, ExpertiseCRUDService){
        $scope.getExpertise = function(){
            var id = $scope.expertise.id_expertise;
            ExpertiseCRUDService.getExpertise($scope.expertise.id_expertise)
                .then(function success(response){
                    $scope.expertise = response.data;
                    $scope.expertise.id_expertise = id;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                    function error (response){
                    $scope.message = '';
                    if(response.status === 404) {
                        $scope.errorMessage = 'Expertise not found!';
                    }
                    else{
                        $scope.message = 'Error getting expertise!'
                    }
                    });
        }
        $scope.addExpertise = function() {
            if ($scope.expertise != null && $scope.expertise.expertise_type)
            {
                ExpertiseCRUDService.addExpertise($scope.expertise.expertise_type)
                    .then (function success(response){
                            $scope.message = 'Expertise added!';
                            $scope.errorMessage = '';
                        },
                        function error(response){
                            $scope.errorMessage = 'Error adding Expertise!';
                            $scope.message = '';
                        });
            }
            else{
                $scope.errorMessage = 'Please enter expertise type!!';
                $scope.message = '';
            }
        }
        $scope.updateExpertise = function() {
            ExpertiseCRUDService.updateExpertise($scope.expertise.id_expertise,$scope.expertise.expertise_type)
                .then(function success(response)
                    {
                        $scope.message = "Expertise data updated!";
                        $scope.errorMessage = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error updating expertise!';
                        $scope.message = '';
                    });
        }
        $scope.deleteExpertise = function(){
            ExpertiseCRUDService.deleteExpertise($scope.expertise.id_expertise)
                .then (function success(response){
                        $scope.message = 'Expertise deleted!';
                        $scope.errorMessage = '';
                        $scope.Employee = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error deleting Expertise!';
                        $scope.message = '';
                    });
        }
        $scope.getAllExpertises = function(){
            ExpertiseCRUDService.getAllExpertises()
                .then(function success(response){
                        $scope.expertise = response.data._embedded.expertise;
                        $scope.message = '';
                        $scope.errorMessage = '';
                    },
                    function errorMessage(response){
                        $scope.message = '';
                        $scope.errorMessage = 'Error getting employees!';
                    });
        }
}]);

app.service('ExpertiseCRUDService',['$http',function($http){
    this.getExpertise = function getExpertise(expertiseId){
        return $http({
            method: 'GET',
            url: 'expertises/' + expertiseId
        });
    }
    this.addExpertise = function addExpertise(expertise_type)
    {
        return $http({
            method:'POST',
            url:'expertises',
            data:
                {
                    expertise_type:expertise_type
                }
        });
    }
    this.updateExpertise = function updateExpertise(id,expertise_type)
    {
        return $http({
            method: 'PATCH',
            url:'expertises/' + id,
            data:
                {
                    expertise_type:expertise_type
                }
        });
    }
    this.deleteExpertise = function deleteExpertise(id)
    {
        return $http({
            method: 'DELETE',
            url: 'expertises/' + id
        });
    }
    this.getAllExpertises = function getAllExpertises() {
        return $http({
            method: 'GET',
            url: 'expertises'
        });
    }
}]);

app.controller('OvertimeCRUDCtrl',['$scope','OvertimeCRUDService',
    function ($scope, OvertimeCRUDService){
        $scope.getOvertime = function(){
            var id = $scope.overtime.id_overtime;
            OvertimeCRUDService.getOvertime($scope.overtime.id_overtime)
                .then(function success(response){
                        $scope.overtime = response.data;
                        $scope.overtime.id_overtime = id;
                        $scope.message = '';
                        $scope.errorMessage = '';
                    },
                    function error (response){
                        $scope.message = '';
                        if(response.status === 404) {
                            $scope.errorMessage = 'Overtime not found!';
                        }
                        else{
                            $scope.message = 'Error getting overtime!'
                        }
                    });
        }
        $scope.addOvertime = function() {
            if ($scope.overtime != null && $scope.overtime.date_start && $scope.overtime.date_end && $scope.overtime.id_employee)
            {
                OvertimeCRUDService.addOvertime($scope.overtime.date_start,$scope.overtime.date_end,$scope.overtime.id_employee)
                    .then (function success(response){
                            $scope.message = 'Overtime added!';
                            $scope.errorMessage = '';
                        },
                        function error(response){
                            $scope.errorMessage = 'Error adding Overtime!';
                            $scope.message = '';
                        });
            }
            else{
                $scope.errorMessage = 'Please enter valid information!';
                $scope.message = '';
            }
        }
        $scope.updateOvertime = function() {
            OvertimeCRUDService.updateOvertime($scope.overtime.id_overtime,$scope.overtime.date_start,$scope.overtime.date_end)
                .then(function success(response)
                    {
                        $scope.message = "Overtime data updated!";
                        $scope.errorMessage = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error updating overtime!';
                        $scope.message = '';
                    });
        }
        $scope.deleteOvertime = function(){
            OvertimeCRUDService.deleteOvertime($scope.overtime.id_overtime)
                .then (function success(response){
                        $scope.message = 'Overtime deleted!';
                        $scope.errorMessage = '';
                        $scope.Employee = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error deleting Overtime!';
                        $scope.message = '';
                    });
        }
    }]);

app.service('OvertimeCRUDService',['$http',function($http){
    this.getOvertime = function getOvertime(overtimeId){
        return $http({
            method: 'GET',
            url: 'overtimes/' + overtimeId
        });
    }
    this.addOvertime = function addOvertime(date_start,date_end,id_employee)
    {
        return $http({
            method:'POST',
            url:'overtimes',
            data:
                {
                    date_start:date_start,
                    date_end:date_end,
                    id_employee:id_employee
                }
        });
    }
    this.updateOvertime = function updateOvertime(id,date_start,date_end)
    {
        return $http({
            method: 'PATCH',
            url:'overtimes/' + id,
            data:
                {
                    date_start:date_start,
                    date_end:date_end,
                }
        });
    }
    this.deleteOvertime = function deleteOvertime(id)
    {
        return $http({
            method: 'DELETE',
            url: 'overtimes/' + id
        });
    }
}]);

app.controller('UsedOvertimeCRUDCtrl',['$scope','UsedOvertimeCRUDService',
    function ($scope, UsedOvertimeCRUDService){
        $scope.getUsedOvertime = function(){
            var id = $scope.overtime.id_overtime;
            UsedOvertimeCRUDService.getUsedOvertime($scope.usedovertime.id_usedovertime)
                .then(function success(response){
                        $scope.usedovertime = response.data;
                        $scope.usedovertime.id_usedovertime = id;
                        $scope.message = '';
                        $scope.errorMessage = '';
                    },
                    function error (response){
                        $scope.message = '';
                        if(response.status === 404) {
                            $scope.errorMessage = 'Overtime not found!';
                        }
                        else{
                            $scope.message = 'Error getting overtime!'
                        }
                    });
        }
        $scope.addUsedOvertime = function() {
            if ($scope.usedovertime != null && $scope.usedovertime.date_start && $scope.usedovertime.date_end && $scope.usedovertime.id_employee)
            {
                UsedOvertimeCRUDService.addOvertime($scope.usedovertime.date_start,$scope.usedovertime.date_end,$scope.usedovertime.id_employee)
                    .then (function success(response){
                            $scope.message = 'Overtime added!';
                            $scope.errorMessage = '';
                        },
                        function error(response){
                            $scope.errorMessage = 'Error adding Overtime!';
                            $scope.message = '';
                        });
            }
            else{
                $scope.errorMessage = 'Please enter valid information!';
                $scope.message = '';
            }
        }
        $scope.updateUsedOvertime = function() {
            UsedOvertimeCRUDService.updateUsedOvertime($scope.usedovertime.id_overtime,$scope.usedovertime.date_start,$scope.usedovertime.date_start,$scope.usedovertime.acceptation)
                .then(function success(response)
                    {
                        $scope.message = "Overtime data updated!";
                        $scope.errorMessage = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error updating overtime!';
                        $scope.message = '';
                    });
        }
        $scope.deleteUsedOvertime = function(){
            UsedOvertimeCRUDService.deleteUsedOvertime($scope.usedovertime.id_usedovertime)
                .then (function success(response){
                        $scope.message = 'Overtime deleted!';
                        $scope.errorMessage = '';
                        $scope.Employee = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error deleting Overtime!';
                        $scope.message = '';
                    });
        }
    }]);

app.service('UsedOvertimeCRUDService',['$http',function($http){
    this.getUsedOvertime = function getUsedOvertime(usedOvertimeId){
        return $http({
            method: 'GET',
            url: 'usedovertimes/' + usedOvertimeId
        });
    }
    this.addUsedOvertime = function addUsedOvertime(date_start,date_end,id_employee)
    {
        return $http({
            method:'POST',
            url:'usedovertimes',
            data:
                {
                    date_start:date_start,
                    date_end:date_end,
                    id_employee:id_employee
                }
        });
    }
    this.updateUsedOvertime = function updateUsedOvertime(id,date_start,date_end,acceptation)
    {
        return $http({
            method: 'PATCH',
            url:'usedovertimes/' + id,
            data:
                {
                    date_start:date_start,
                    date_end:date_end,
                    acceptation:acceptation
                }
        });
    }
    this.deleteUsedOvertime = function deleteUsedOvertime(id)
    {
        return $http({
            method: 'DELETE',
            url: 'usedovertimes/' + id
        });
    }
}]);

app.controller('HolidayCRUDCtrl',['$scope','HolidayCRUDService',
    function ($scope, HolidayCRUDService){
        $scope.HolidayOvertime = function(){
            var id = $scope.holiday.id_holiday;
            HolidayCRUDService.getHoliday($scope.holiday.id_holiday)
                .then(function success(response){
                        $scope.holiday = response.data;
                        $scope.holiday.id_holiday = id;
                        $scope.message = '';
                        $scope.errorMessage = '';
                    },
                    function error (response){
                        $scope.message = '';
                        if(response.status === 404) {
                            $scope.errorMessage = 'Holiday not found!';
                        }
                        else{
                            $scope.message = 'Error getting holiday!'
                        }
                    });
        }
        $scope.addHoliday = function() {
            if ($scope.holiday != null && $scope.holiday.date_start && $scope.holiday.date_end && $scope.holiday.id_employee)
            {
                HolidayCRUDService.addHoliday($scope.holiday.date_start,$scope.holiday.date_end,$scope.holiday.id_employee)
                    .then (function success(response){
                            $scope.message = 'Holiday added!';
                            $scope.errorMessage = '';
                        },
                        function error(response){
                            $scope.errorMessage = 'Error adding Holiday!';
                            $scope.message = '';
                        });
            }
            else{
                $scope.errorMessage = 'Please enter valid information!';
                $scope.message = '';
            }
        }
        $scope.updateHoliday = function() {
            HolidayCRUDService.updateHoliday($scope.holiday.id_overtime,$scope.holiday.date_start,$scope.holiday.date_start,$scope.holiday.acceptation)
                .then(function success(response)
                    {
                        $scope.message = "Holiday data updated!";
                        $scope.errorMessage = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error updating Holiday!';
                        $scope.message = '';
                    });
        }
        $scope.deleteUsedOvertime = function(){
            HolidayCRUDService.deleteHoliday($scope.holiday.id_holiday)
                .then (function success(response){
                        $scope.message = 'Holiday deleted!';
                        $scope.errorMessage = '';
                        $scope.Employee = '';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error deleting Holiday!';
                        $scope.message = '';
                    });
        }
    }]);

app.service('HolidayCRUDService',['$http',function($http){
    this.getHoliday = function getHoliday(holidayId){
        return $http({
            method: 'GET',
            url: 'holidays/' + holidayId
        });
    }
    this.addHoliday = function addHoliday(date_start,date_end,id_employee)
    {
        return $http({
            method:'POST',
            url:'holidays',
            data:
                {
                    date_start:date_start,
                    date_end:date_end,
                    id_employee:id_employee
                }
        });
    }
    this.updateHoliday = function updateHoliday(id,date_start,date_end,acceptation)
    {
        return $http({
            method: 'PATCH',
            url:'holidays/' + id,
            data:
                {
                    date_start:date_start,
                    date_end:date_end,
                    acceptation:acceptation
                }
        });
    }
    this.deleteHoliday = function deleteHoliday(id)
    {
        return $http({
            method: 'DELETE',
            url: 'holidays/' + id
        });
    }
}]);

//JS


function getIndex(id)
{
    return id.substring(32,id.length);
}
