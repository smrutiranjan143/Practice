/**
 * Developed by Dillip
 */

$(document).ready(function(){
				$('#country').on('change', function(){
					var countryId = $(this).val();
					$.ajax({
						type: 'GET',
						url: 'http://localhost:9090/Practice/master/getStates/' + countryId,
						success: function(result){
							var result = JSON.parse(result);
							var s= '<option value="">----Select State----</option>';
							for(var i = 0; i < result.length; i++){
								s +='<option value="' + result[i].stateId + '">' + result[i].stateName + '</option>';
							}
							$('#state').html(s)
						}
					});
				});

					$('#state').on('change', function(){
						var stateId = $(this).val();
						$.ajax({
							type: 'GET',
							url: 'http://localhost:9090/Practice/master/getCities/' + stateId,
							success: function(result){
								var result = JSON.parse(result);
								var s= '<option value="">----Select City----</option>';
								for(var i = 0; i < result.length; i++){
									s +='<option value="' + result[i].cityId + '">' + result[i].cityName + '</option>';
								}
								$('#city').html(s)
							}
						});
					});
			});