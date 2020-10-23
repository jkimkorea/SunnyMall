/**
 * 
 */
$(function(){
	//별점 선택시
	$('#star_grade a').click(function(){
		$(this).patent().children('a').removeClass('on');
		$(this).addClass('on').prevAll('a').addClass('on');
		return false;
	});
	//상품 후기 쓰기 클릭시
	$('#btn_write_review').click(function(){
		var rev_score = 0;
		var rev_cont=$('#reviewContent').val();
		var prd_no=$('#prd_no').val();
		
		$('#star_grade a').each(function(i,e){
			if($(this).attr('class')=='on'){
			rev_score += 1;
			}
		});
		if(rev_score==0){
			alert("별점을 선택해주세요.");
			return;
		}else if(rev_cont==""||rev_cont==null){
			alert("리뷰를 적어주세요.")
			return;
		}
		
		$.ajax({
			url:'/review/write',
			type:'post',
			dataType:'text',
			data:{
				rev_score:rev_score,
				rev_cont:rev_cont,
				prd_no:prd_no
				},
			success:function(data){
				alert("리뷰가 작성되었습니다.");
				
			}
		});
	});
});