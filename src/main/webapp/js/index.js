configureDateSelection();
		loadPlays();

		$(document).ready(function() {
			$('#playsTable').DataTable({
				title : "Plays",
				pageLength : 100,
				columns : [ {
					"title" : "Inning",
					"data" : "inning"
				}, {
					"title" : "Top/Bottom",
					"data" : "topbot"
				}, {
					"title" : "Description",
					"data" : "des"
				}, {
					"title" : "Home Score",
					"data" : "home_score"
				}, {
					"title" : "Away Score",
					"data" : "away_score"
				}

				]
			});
		});
		function configureDateSelection() {
			var dateSel = new Array();
			var date = document.querySelector("#dateSelect");

			var dates = JSON.parse(document.querySelector("#dates").value);
			for (var i = 0; i < dates.length; i++) {
				var opt = document.createElement('option');
				opt.value = dates[i];
				var count = i + 1;
				opt.innerHTML = dates[i] + ": Game " + count;
				date.appendChild(opt);
			}
			$(date).attr("setvalue", dates[0]);
		}
		function configureGameInfo(plays) {
			var divHTeam = document.getElementById('homeTeam');
			divHTeam.innerHTML = plays[0].home_team;			
			var divHScore = document.getElementById('homeScore');
			divHScore.innerHTML = plays[plays.length - 1].home_score;
			var divATeam = document.getElementById('awayTeam');
			divATeam.innerHTML = plays[0].away_team;
			var divAScore = document.getElementById('awayScore');
			divAScore.innerHTML = plays[plays.length - 1].away_score;

			var divVenue = document.getElementById('divVenue');
			divVenue.innerHTML = plays[0].venue;

			var divWeather = document.getElementById('divWeather');
			divWeather.innerHTML = plays[0].temp + "&deg;F "
					+ plays[0].condition;

			var divWind = document.getElementById('divWind');
			divWind.innerHTML = "Wind: " + plays[0].wind;
			
			if(plays[0].home_team == "TEX"){
				document.getElementById('sfHome').style.display= "none";
				document.getElementById("texAway").style.display="none";
				document.getElementById('texHome').style.display= "block";
				document.getElementById("sfAway").style.display="block";
			}else{
				document.getElementById('texHome').style.display= "none";
				document.getElementById("sfAway").style.display="none";
				document.getElementById('sfHome').style.display= "block";
				document.getElementById("texAway").style.display="block";
			}

		}
		function configureTable(plays) {
			$('#playsTable').DataTable().clear().draw();
			$('#playsTable').dataTable().fnAddData(plays);
		}

		function createTable() {
			var playTable = document.querySelector("#playsTable");
			if (playTable != undefined && playTable != null) {
				playTable.remove();
			}

			var tblDiv = document.querySelector("#tableDiv");

			playTable = document.createElement("table");
			$(playTable).attr("id", "playTable")
			tblDiv.appendChild(playTable);

		}
		function loadPlays() {
			var date = document.querySelector("#dateSelect").value;
			getPlays(date);

		}
		function getPlays(date) {
			$.ajax({
				type : "GET",
				url : "/plays/" + date,
				success : function(data) {
					configureTable(data);
					configureGameInfo(data);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}