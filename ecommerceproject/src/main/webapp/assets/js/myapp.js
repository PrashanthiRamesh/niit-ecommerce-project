$(function() {
	// Active menu

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');

		break;
	case 'Cart':
		$('#cart').addClass('active');

		break;
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');

		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}
});

// jquery code

var $table = $('#productListTable');

if ($table.length) {

	console.log(window.categoryId);

	var jsonUrl = '';
	if (window.categoryId == '') {
		
		jsonUrl = window.contextRoot + '/json/data/all/products';

	} else {
		
		jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';

	}
	$table.DataTable({
				lengthMenu : [
						[ 5, 10, 15, -1 ],
						[ '5 Products', '10 Products', '15 Products',
								'All Products' ] ],
				pageLength : 5,
				ajax:{
					url: jsonUrl,
					dataSrc: ''
				},
				columns:[
					{
						data: 'code',
						mRender: function(data, type, row){
							return '<img src="'+window.contextRoot+'/resources/img/'+data+'.jpg" class="dataTableImg"/>'
						}
					},
					{
						data: 'name',
						
					},
					{
						data: 'brand',
						
					},
					{
						data: 'unitPrice',
						mRender: function(data, type,row){
							return '&#8377; '+data
						}
					},
					{
						data: 'quantity',
						
					},
					{
						data: 'id',
						bSortable: false,
						mRender: function(data,type,row){
							var str='';
							str+= '<a href ="'+window.contextRoot+'/show/'+data+'/product" <span class="fa fa-eye"></span></a>'
							str+= '<a href ="'+window.contextRoot+'/cart/add/'+data+'/product"<span class="fa fa-shopping-cart"></span></a>'
							return str 
						}
					}
					
				]
			});
}

//dismiss the alert after 3 secs

var $alert=$('.alert');
if($alert.length){
	setTimeout(function(){
		$alert.fadeOut('slow');
	},3000)
}