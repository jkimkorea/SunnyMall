<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Handlebar Template --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="subCGListTemplate" type="text/x-handlebars-template">
	{{#each.}}
		<li class ="subCategory"><a href="/product/productList?cg_code={{cg_code}}">{{cg_name}}</a></li>
	{{/each}}

</script>

<%-- 2차 카테고리 템플릿 적용함수 --%>
<script>
	$(document).ready(function(){
		
		$(".mainCategory").on("click", function(){
			var mainCGCode= $(this).val();
			var url = "/product/subCGList/" + mainCGCode;
			
			$.getJSON(url, function(data){
				$(".subCategory").css("display","none");
				$("#mainCategory_"+mainCGCode).css("display","");
				subCGList(data, $("#mainCategory_"+mainCGCode) ,$("#subCGListTemplate"));
			});
		});	
	});

	var subCGList = function(subCGStr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());
		var options = template(subCGStr);

		target.append(options);
	}
</script>

	<body>
        <h1 class="my-4">MENU</h1>
	         <ul class="sidebar-menu" data-widget="tree" style="list-style-type:none;">
		        <c:forEach items="${userCategoryList }" var="list">
		          <li class="treeview mainCategory" value="${list.cg_code}" >
		          	<a href="#" class="list-group-item" >
							<span>${list.cg_name}</span>
		          	</a>
		          	<ul class="treeview-menu" id="mainCategory_${list.cg_code}" style="list-style-type:none;">
		          	
		          	</ul>
		          </li>
		         </c:forEach>
	        </ul>
      </body>
   

