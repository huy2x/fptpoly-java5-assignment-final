var starClicked = false;

$(function () {

    $('.star').click(function () {
        $(this).children('.selected').addClass('is-animated');
        $(this).children('.selected').addClass('pulse');

        var target = this;

        setTimeout(function () {
            $(target).children('.selected').removeClass('is-animated');
            $(target).children('.selected').removeClass('pulse');
        }, 1000);

        starClicked = true;
    })

    $('.half').click(function () {
        if (starClicked)    setHalfStarState(this);
        $(this).closest('.rating').find('.js-score').text($(this).data('value'));
        $(this).closest('.rating').data('vote', $(this).data('value'));
        calculateAverage();
    })

    $('.full').click(function () {
        if (starClicked)    setFullStarState(this);
        $(this).closest('.rating').find('.js-score').text($(this).data('value'));
        $(this).closest('.rating').data('vote', $(this).data('value'));
        calculateAverage();
    })

    $('.half').hover(function () {
        if (!starClicked)   setHalfStarState(this)
    })

    $('.full').hover(function () {
        if (!starClicked)   setFullStarState(this)
    })
    
    
    
    
    // Load star rating on load page
	var ratingValue = parseFloat($('.rating').data('vote'));
	var starsSelected = Math.floor(ratingValue);
	var hasHalfStar = (ratingValue % 1) !== 0;

	$('.star').each(function (index) {
		if (index <= starsSelected) {
			setFullStarState($(this).children('.full'));
		} else if (index === starsSelected + 1 && hasHalfStar) {
			setHalfStarState($(this).children('.half'));
		}
	});

	$('.rating').find('.js-score').text(ratingValue);

})

function updateStarState(target) {
    $(target).parent().prevAll().addClass('animate');
    $(target).parent().prevAll().children().addClass('star-colour');

    $(target).parent().nextAll().removeClass('animate');
    $(target).parent().nextAll().children().removeClass('star-colour');
}

function setHalfStarState(target) {
    $(target).addClass('star-colour');
    $(target).siblings('.full').removeClass('star-colour');
    updateStarState(target)
}

function setFullStarState(target) {
    $(target).addClass('star-colour');
    $(target).parent().addClass('animate');
    $(target).siblings('.half').addClass('star-colour');
    updateStarState(target)
}

function calculateAverage() {
    var average = 0
    $('.rating').each(function () {
        average += $(this).data('vote')
    })
    
    $.ajax({
		type: "POST",
		url: window.location.href.split('?')[0],
		data: "Sao=" + average,
		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	})
	.done(function(){new bootstrap.Toast(document.getElementById('ToastSC')).show()})
	.fail(function(){new bootstrap.Toast(document.getElementById('ToastER')).show()});
}