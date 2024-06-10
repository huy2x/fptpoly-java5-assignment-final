var app = angular.module("MyApp", []);
app.controller("MyCtrl", function($scope, $http) {


    // Code to change theme of website using:
    //  Boostrap theme support dark and light theme, 
    //  AngularJS to change the value,
    //  LocalStorage to store the value.
    $scope.Theme = localStorage.getItem("UserThemeSetting")
    $scope.ChangeTheme = function() {
        $scope.Theme = $scope.Theme == 'dark' ? 'light' : 'dark'
        localStorage.setItem("UserThemeSetting", $scope.Theme)
    }



    // Code to change background image on diffirent time:
    $scope.ListBGImage = [
        "https://images4.alphacoders.com/966/966314.jpg", //06:00
        "https://images7.alphacoders.com/116/1164604.png", //07:00
        "https://images3.alphacoders.com/126/1269904.png", //08:00
        "https://images.alphacoders.com/113/1130469.png", //09:00
        "https://images2.alphacoders.com/111/1114362.png", //13:00
        "https://images7.alphacoders.com/106/1063355.png", //15:00
        "https://images.alphacoders.com/124/1248273.png", //17:00
        "https://images8.alphacoders.com/939/939716.png", //18:00
        "https://images5.alphacoders.com/116/1168050.png", //19:00
        "https://images6.alphacoders.com/124/1243346.png", //20:00
        "https://artfiles.alphacoders.com/155/155890.png" //23:00
    ]

    $scope.getImageOnTime = function() {
        var time = new Date().getHours()
        if ($scope.Theme == null) {
            if (time >= 06 && time < 17) $scope.Theme = 'light';
            else $scope.Theme = 'dark';
        }
        if (time >= 23 || time < 06) return $scope.ListBGImage[10];
        if (time >= 20 && time < 24) return $scope.ListBGImage[9];
        if (time >= 19 && time < 20) return $scope.ListBGImage[8];
        if (time >= 18 && time < 19) return $scope.ListBGImage[7];
        if (time >= 17 && time < 18) return $scope.ListBGImage[6];
        if (time >= 15 && time < 17) return $scope.ListBGImage[5];
        if (time >= 13 && time < 15) return $scope.ListBGImage[4];
        if (time >= 09 && time < 13) return $scope.ListBGImage[3];
        if (time >= 08 && time < 09) return $scope.ListBGImage[2];
        if (time >= 07 && time < 08) return $scope.ListBGImage[1];
        if (time >= 06 && time < 07) return $scope.ListBGImage[0];
        else return $scope.ListBGImage[3];
    }



    // Code validation form Bootstrap
    $scope.Validation = function() {
        const forms = document.querySelectorAll('.needs-validation');

        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                    var formName = form.getAttribute('name'); //Code to show Toast on only ExamForm
                    if (formName != null && formName != "ExamForm" && formName != "formSU" && formName != "formRP") new bootstrap.Toast(document.getElementById('Toast')).show();
                }
                form.classList.add('was-validated')
            }, false)
        })
    }



    // Code to validation selected answer of sentences
    $scope.CheckSentence = function() {
        var form = document.forms["ExamForm"];
        form.addEventListener('submit', event => {
            var sens = form.getElementsByClassName("accordion-item");
            var mark = 100.0;
            var senMark = (mark / sens.length).toFixed(2);
            console.log("Mark of each Sententces : " + senMark)

            Array.from(sens).forEach(sen => {
                var isSelect = false;
                var senHeader = sen.getElementsByTagName("button")[0]
                Array.from(sen.getElementsByTagName("input")).forEach(ans => {
                    if (ans.checked) isSelect = true;
                })
                if (isSelect) {
                    senHeader.classList.remove("bg-danger");
                    senHeader.classList.add("bg-success");
                } else {
                    senHeader.classList.add("bg-danger");
                    mark = (mark - senMark).toFixed(2);
                }
            })
            var finalMark = mark + "%";
            for (let i = 1; i <= 2; i++) {
                var divMark = document.getElementById("Mark" + i);
                divMark.removeAttribute("style");
                divMark.style.width = finalMark;
                divMark.innerHTML = finalMark;
            }
            console.log('Total process: ' + finalMark);
        })
    }
	
	
	$scope.Ratting = function(descrip){
		$http({
			method: 'POST',
			url: window.location.href.split('?')[0],
			data: "Descrip=" + descrip,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(
			function successCallback(){new bootstrap.Toast(document.getElementById('ToastSC')).show()}, 
			function errorCallback()  {new bootstrap.Toast(document.getElementById('ToastER')).show()}
    	);
	}
	
	
	$scope.sendEmail = false;
	$scope.SendMail = function(email){
		$http({
			method: 'POST',
			url: window.location.href.split('?')[0] + "/SendEmail",
			data: "email=" + email,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(
			function successCallback(){new bootstrap.Toast(document.getElementById('ToastSC')).show(); $scope.sendEmail = false;}, 
			function errorCallback()  {new bootstrap.Toast(document.getElementById('ToastER')).show(); $scope.sendEmail = false;}
    	);
	}


});



// Code to process link with parameter
function updateQueryStringParameter(url, key, value) {
    var re = new RegExp("([?&])" + key + "=.*?(&|$)", "i");
    var separator = url.indexOf('?') !== -1 ? "&" : "?";

    if (url.match(re)) return url.replace(re, '$1' + key + "=" + value + '$2');
    else return url + separator + key + "=" + value;
}

function handleClick(link) {
	var url = link.getAttribute('href');
	var currentPage = window.location.href;
    var params = url.split('?')[1];

    if (params) {
		var keyValue = params.split('=');
		var key = keyValue[0];
		var value = keyValue[1];
		currentPage = updateQueryStringParameter(currentPage, key, value);
    }

    link.setAttribute('href', currentPage);
}



// Code to get Youtube Thumnail link
function checkYT(img) {
    if (img.naturalWidth === 120 && img.naturalHeight === 90 && !img.src.includes("hqdefault")) {
        img.src = img.src.replace("maxresdefault", "hqdefault");
    }
}