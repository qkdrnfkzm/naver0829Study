$(function() {
	//h1.title 을 클릭 시 .music-list slideDown 한다
	$("h1.title").click(function() {
		$("ul.music-list").slideDown();
	})
	//노래 제목을 클릭 시 클릭한 곳의 제목을 얻어서 h1.title에 넣은 후 slideUp한다
	$("ul.music-list li").click(function() {
		//노래 제목
		let title = $(this).text();
		$("h1.title").text(title);

		//class를 얻는다
		let selectClass = $(this).attr("class");
		//적용
		$("#cd").animate({ width: '0' }, 'slow', function() {
			//cd변경
			$("#cd").attr("class", selectClass);
			//너비를 다시 300으로 변경
			$(this).animate({ width: '300px' }, 'slow')
		})

		$("ul.music-list").slideUp('slow');
	})

});