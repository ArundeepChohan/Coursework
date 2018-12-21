$(document).ready(function()
{
	$("#startAnimation").click(function()
	{
		$("#startAnimation").prop("disabled",true);
		$('header').html('<h1>Terran Story</h1><p>How the Humans faced the creatures known as Zerg</p>');
		$("#wrapper").html('<canvas id = "myCanvas" alt = "TerrainEdit">	 </canvas><div id = "miniMap" alt = "TerrainMap"><canvas id = "map" alt = "TerrainMap"> </canvas></div>');
		$('#myAudio').trigger("play");
		$('#myAudio').prop("currentTime",0);
		
		setTimeout(function()
		{ 
			$('header').fadeOut(5000);
			$('header p').html('The Zerg came in fierce with hordes of Mutalisk, Ultralisk and Zerlings devastating the world of Terran to spread the influence of the Overmind');
			$('h1').html('A clash of two forces');
			$('header').fadeIn(5000);

		},5000);
		
		$('header').fadeOut(5000);
		setTimeout(function()
		{ 
			
			//Link images 
			$("#wrapper").html(
				'<div class="swarm"></div>'
			);
			//Play an animation for 5 seconds of zergs running across
			// <!---Reference:  https://www.moddb.com/mods/project-revolution/images --->
			$(".swarm").append(
				'<img src="Images/zerg.gif">'
			);
		},15000);
		
		setTimeout(function()
		{ 	
			$('header p').html('The zerg have taken over');
			$('h1').html('The Terran have fallen')
			$('header').fadeIn(5000);
			
		},20000);
		
		setTimeout(function()
		{ 
			$('#myAudio').trigger("pause");
			$("#startAnimation").prop("disabled",false);
			// <!---Reference:  Youtube clip https://www.youtube.com/watch?v=MVbeoSPqRs4 --->
			$("#wrapper").html(
				'<iframe src="https://www.youtube.com/embed/MVbeoSPqRs4" frameborder="0" allow="autoplay" encrypted-media allowfullscreen></iframe>'
			);
		}, 20000);
	});
});
