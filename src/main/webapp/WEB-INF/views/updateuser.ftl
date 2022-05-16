<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
<#include "css/util.css">
<#include "css/main.css">
<#include "css/custom.css">
<#include "images/icons/favicon.ico">
<#include "vendor/bootstrap/css/bootstrap.min.css">
<#include "fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<#include "vendor/animate/animate.css">
<#include "vendor/css-hamburgers/hamburgers.min.css">
<#include "vendor/animsition/css/animsition.min.css">
<#include "vendor/select2/select2.min.css">
<#include "vendor/daterangepicker/daterangepicker.css">
</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet">


</head>
<body class="error">

	<!-- Include the Header file -->
	<#include "header.ftl">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form  p-l-55 p-r-55 p-t-178" name="updateuser"
					action="UpdateUserDetailsController" method="post">
					<span class="login100-form-title"> Update User Profile</span>
					 <input type="hidden" name="userid" <#if name??>value="${name.userid}"></#if>
					<#if validerror??><span class="error">${validerror?join("<br>")}</span></#if>
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter First Name">
						<input class="input100" type="text" name="FirstName"
							id="firstname" Placeholder="Enter your First Name"
						<#if name??>value="${name.firstName}"></#if><#if failuser??>value="${failuser.firstName}"</#if><span id="fnameerror" style="color: red" ></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter Last Name">
						<input class="input100" type="text" name="LastName" id="lastname"
							Placeholder="Enter your Last Name" <#if name??>value="${name.lastName}"></#if><#if failuser??>value="${failuser.firstName}"</#if>
						<span id="lnameerror" style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter username">
						<input class="input100" type="text" name="email" id="email" readonly
							Placeholder="abc@gmail.com" <#if name??>value="${name.email}" ></#if><#if failuser??>value="${failuser.email}"</#if> <span
							id="emailerror" style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter phoneno">
						<input class="input100" type="text" name="PhoneNo" id="phoneno"
							Placeholder="9573412345" <#if name??>value="${name.phoneNo}"></#if><#if failuser??>value="${failuser.phoneNo}"</#if> <span
							id="emailerror" style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter birthdate">
						<input class="input100" type="date" name="Dob"
							id="birthdaydate" <#if name??>value="${name.dob}"></#if><#if failuser??>value="${failuser.dob}"</#if>
					</div>

					<div class="wrap-input100 validate-input m-b-16">
						
							
					<label class="m-l-12" for="customer-gender">Gender : -</label>
					<#if name??>
					 <label for="male" class="gender-size">Male</label> 
					 <input class="m-l-4" type="radio" id="male" name="gender" value="${name.gender}"  <#if name.gender=="male">checked</#if> > <br>
					 <label class="gender-size m-l-85" for="female" >Female</label> 
					 <input class="m-l-4" type="radio" id="female" name="gender" value="${name.gender}"  <#if name.gender=="female">checked</#if> >
					<#else>
					<#if failuser??>
					 <label for="male" class="gender-size">Male</label> 
					 <input class="m-l-4" type="radio" id="male" name="gender" value="${failuser.gender}"  <#if failuser.gender=="male">checked</#if> > <br>
					 <label class="gender-size m-l-85" for="female" >Female</label> 
					 <input class="m-l-4" type="radio" id="female" name="gender" value="${failuser.gender}"  <#if failuser.gender=="female">checked</#if> >
					<#else>
					 <label for="male" class="gender-size">Male</label> 
					 <input class="m-l-4" type="radio" id="male" name="gender" value="male" > <br>
					 <label class="gender-size m-l-85" for="female" >Female</label> 
					 <input class="m-l-4" type="radio" id="female" name="gender" value="female">
					</#if>
					</#if>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter phoneno">
						<input type="text" id="sanswer" class="input100" name="SecurityAnswer"
							Placeholder="Enter your Security Answer" readonly
							<#if name??>value="${name.securityAnswer }"></#if> <span id="serror"
							style="color: red"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="password"
							id="password" <#if name??>value="${name.password }"></#if> <span
							id="perror" style="color: red"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Please enter password">
						<input class="input100" type="password" name="CPassword"
							id="cpassword" <#if name??>value="${name.CPassword }"></#if> <span
							id="cperror" style="color: red"></span>
					</div>



						<div id="main-container" class="content">	
							<#if name.address??>
								<#list name.address as user >
							<div class="row group container-item">
								<div class="col-md-12 m-b-12 m-t-12">
									<input class="input100 AddLineOne" type="text" 
										name="address[${user?index}].AddressLineOne" Placeholder="AddressLine One"
										value="${user.addressLineOne}"required="required"> <span
										class="AddressLineOneError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input class="input100 AddLineTwo" type="text" 
										name="address[${user?index}].AddressLineTwo" Placeholder="AddressLine Two"
										value="${user.addressLineTwo}" required="required"> <span
										class="AddressLineTwoError"></span>
								</div>

								<div class="col-md-12 m-b-12">
									<input type="text"  name="address[${user?index}].pincode" class="input100 pin"
										maxlength="6" Placeholder="Pincode"
										value="${user.pincode}" required="required"> <span class="PinError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input type="text"  class="input100 city" name="address[${user?index}].city"
										maxlength="64" Placeholder="City" value="${user.city}" required="required">
									<span class="CityError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input type="text" class="input100 state" name="address[${user?index}].state"
										maxlength="64" Placeholder="State" value="${user.state}"required="required"><span
										class="StateError"></span>
								</div>
								
								<div class="row">
                                    <div class="col-sm-12 m-b-12">
                                        <div>
                                            <a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
                                        </div>
                                    </div>
                            	</div>
               
							</div>
							</#list>
							<#else>
							<#if failuser?? && failuser.address??>
							<#list failuser.address as user >
							<div class="row group container-item">
								<div class="col-md-12 m-b-12 m-t-12">
									<input class="input100 AddLineOne" type="text" 
										name="address[${user?index}].AddressLineOne" Placeholder="AddressLine One"
										value="${user.addressLineOne}"required="required"> <span
										class="AddressLineOneError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input class="input100 AddLineTwo" type="text" 
										name="address[${user?index}].AddressLineTwo" Placeholder="AddressLine Two"
										value="${user.addressLineTwo}" required="required"> <span
										class="AddressLineTwoError"></span>
								</div>

								<div class="col-md-12 m-b-12">
									<input type="text"  name="address[${user?index}].pincode" class="input100 pin"
										maxlength="6" Placeholder="Pincode"
										value="${user.pincode}" required="required"> <span class="PinError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input type="text"  class="input100 city" name="address[${user?index}].city"
										maxlength="64" Placeholder="City" value="${user.city}" required="required">
									<span class="CityError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input type="text" class="input100 state" name="address[${user?index}].state"
										maxlength="64" Placeholder="State" value="${user.state}"required="required"><span
										class="StateError"></span>
								</div>
								
								<div class="row">
                                    <div class="col-sm-12 m-b-12">
                                        <div>
                                            <a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
                                        </div>
                                    </div>
                            	</div>
							</div>
							</#list>
							<#else>
							<div class="row group container-item">
								<div class="col-md-12 m-b-12 m-t-12">
									<input class="input100 AddLineOne" type="text" 
										name="address[0].AddressLineOne" Placeholder="AddressLine One"
										> <span
										class="AddressLineOneError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input class="input100 AddLineTwo" type="text" 
										name="address[0].AddressLineTwo" Placeholder="AddressLine Two"
										> <span
										class="AddressLineTwoError"></span>
								</div>

								<div class="col-md-12 m-b-12">
									<input type="text"  name="address[0].pincode" class="input100 pin"
										maxlength="6" Placeholder="Pincode"
										> <span class="PinError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input type="text"  class="input100 city" name="address[0].city"
										maxlength="64" Placeholder="City" >
									<span class="CityError"></span>
								</div>
								
								<div class="col-md-12 m-b-12">
									<input type="text" class="input100 state" name="address[0].state"
										maxlength="64" Placeholder="State" ><span
										class="StateError"></span>
								</div>
								
								<div class="row">
                                    <div class="col-sm-12 m-b-12">
                                        <div>
                                            <a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
                                        </div>
                                    </div>
                            	</div>
               
							</div>
				</#if>
							
				</#if>
					</div>
				
					<div class="row">
                         <div class="col-sm-12">
 							<div>
                      			  <a class="btn btn-success btn-sm" id="add-more" href="javascript:;" role="button"><i class="fa fa-plus"></i> Add more address</a>                    
                   		    </div>
                   		 </div>
                    </div>
					<div class="container-login100-form-btn m-b-32 m-t-16">
						<button class="login100-form-btn" style="width: 50%;"
							type="submit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	<#include "vendor/jquery/jquery-3.2.1.min.js">
	<#include "vendor/jquery/jquery.validate.min.js">
	<#include "vendor/animsition/js/animsition.min.js">
	<#include "vendor/bootstrap/js/popper.js">
	<#include "vendor/bootstrap/js/bootstrap.min.js">
	<#include "vendor/select2/select2.min.js">
	<#include "vendor/daterangepicker/moment.min.js">
	<#include "vendor/daterangepicker/daterangepicker.js">
	<#include "vendor/countdowntime/countdowntime.js">
	</script>
	<script><#include "js/UpdateUser.js"></script>
	<script type="text/javascript">
		<#include "js/cloneData.js">
	</script>

	<script type="text/javascript">
		<#include "js/AddressPlugin.js">
	</script>

	<!-- Include the Footer file -->
		<#include "footer.ftl">
</body>
</html>