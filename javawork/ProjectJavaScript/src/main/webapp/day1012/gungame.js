//총 클릭 이벤트
$(function() {
	$(".gun").click(function() {
		//0~11 사이의 난수 값 발생 후 해당 이미지가 있으면 "x번 인형을 맞췄습니다"
		//이미지 사라지고 없는 경우는 "꽝(x번)"
		let idx = parseInt(Math.random() * 12);
		if ($(".sunban img").eq(idx).is(":hidden")) {
			$("#msg").html(`꽝(${idx + 1}번)!!`);
		} else {
			$(".sunban img").eq(idx).hide();
			//$(".sunban img").eq(idx).fadeOut('fast');
			$("#msg").html(`${idx + 1}번째 인형을 맞췄습니다!!`);
		}

		//12개의 인형이 모두 없어지면 "You Win!! Game Over!!"라고 출력
		//hidden 의 갯수 구하기
		let n = $(".sunban img:hidden").length;
		console.log(n);
		if (n == 12) {
			$("#msg").html(`You Win!! Game Over!!`);
		}

		//지폐 클릭 시 모두 초기화하고 해당 지폐는 사라지게 하기
		$(".money img").click(function() {
			$(".sunban img").show();
			$("#msg").html("");

			//$(this).css("display", "none");	//자리 차지를 하지 않음
			$(this).css("visibility","hidden")
		})
	})
})