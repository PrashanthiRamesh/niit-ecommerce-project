<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<div class="container">

	<!-- Breadcrumb -->

	<div class="row">

		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot }/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>

		</div>
	</div>
</div>

<div class="row">

	<div class="col-xs-12 col-sm-4">

		<div class="thumbnail">

			<img src="${images}/${product.code}.jpg" class="img-thumbnail" />

		</div>
	</div>

	<div class="col-xs-12 col-sm-8">

		<h3>${product.name}</h3>
		<hr />

		<p>${product.description}</p>
		<hr />

		<h4>
			Price:<strong>&#8377;${product.unitPrice}</strong>
		</h4>
		<hr />

		<h6>Quantity: ${product.quantity}</h6>

		<button>
			<a href="${contextRoot}/cart/add/${product.id}/product"><span
				class="fa fa-shopping-cart"></span>Add to Cart</a>
		</button>
		<button>
			<a href="${contextRoot}/show/all/products"><span
				class="fa fa-eye"></span>Back to all Products</a>
		</button>
	</div>


</div>